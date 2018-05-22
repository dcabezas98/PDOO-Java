
package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */

import java.util.ArrayList;

class SpaceStation implements SpaceFighter {
    
    private static final int MAXFUEL = 100; 
    private static final double SHIELDLOSSPERUNITSHOT=0.1; 
    
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;
    private Damage pendingDamage;
    
    private void assignFuelValue(float f){
        fuelUnits = 0;
        if(f<=MAXFUEL && f>0)
            fuelUnits = f;
        else
            fuelUnits = MAXFUEL; 
    }
    
    private void cleanPendingDamage(){
        if(pendingDamage != null && pendingDamage.hasNoEffect())
            pendingDamage=null;
    }
    
    SpaceStation(String n, SuppliesPackage supplies){
        name = n;
        ammoPower = supplies.getAmmoPower();
        assignFuelValue(supplies.getFuelUnits());
        shieldPower = supplies.getShieldPower();
        nMedals=0;
        weapons = new ArrayList<>();
        shieldBoosters = new ArrayList<>();
        hangar = null;
        pendingDamage = null;
    }
    
    SpaceStation(SpaceStation station){
        this(station.name, new SuppliesPackage(station.ammoPower, station.fuelUnits, station.shieldPower));
        nMedals = station.nMedals;
        weapons = new ArrayList(station.weapons);
        shieldBoosters = new ArrayList(station.shieldBoosters);
        hangar=null;
        if (station.hangar != null)
            hangar = new Hangar(station.hangar);
        pendingDamage = null;
        if(station.pendingDamage != null)
            pendingDamage = station.pendingDamage.copy();
    }
    
    public void cleanUpMountedItems(){        
        weapons.removeIf(x-> x.getUses()<=0);
        shieldBoosters.removeIf(x-> x.getUses()<=0);
    }
    
    public void discardHangar(){
        hangar=null;
    }
    
    public void discardShieldBooster(int i){
        
        if(i>=0 && i<shieldBoosters.size()){
            shieldBoosters.remove(i);
            if(pendingDamage!=null){
                pendingDamage.discardShieldBooster();
                cleanPendingDamage();
            }
        }
    }
    
    public void discardShieldBoosterInHangar(int i){
        if(hangar!=null)
            hangar.removeShieldBooster(i);
    }
    
    public void discardWeapon (int i){
        
        if(i>=0 && i<weapons.size()){
            Weapon w=weapons.remove(i);
            if(pendingDamage!=null){
                pendingDamage.discardWeapon(w);
                cleanPendingDamage();
            }
        }
    }
    
    public void discardWeaponInHangar(int i){
        if(hangar!=null)
            hangar.removeWeapon(i);
    }
    
    @Override
    public float fire(){
        int size = weapons.size();
        int factor=1;
        
        for(int i=0; i<size; i++)
            factor*=weapons.get(i).useIt();
        
        return factor*ammoPower;
    }

    public float getAmmoPower() {
        return ammoPower;
    }

    public float getFuelUnits() {
        return fuelUnits;
    }

    public String getName() {
        return name;
    }

    public int getNMedals() {
        return nMedals;
    }

    public float getShieldPower() {
        return shieldPower;
    }
    
    public Hangar getHangar(){
        return hangar;
    }
    
    public Damage getPendingDamage(){
        return pendingDamage;
    }
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    
    public float getSpeed(){
        return (fuelUnits/MAXFUEL);
    }
    
    SpaceStationToUI getUIversion(){
        return new SpaceStationToUI(this);
    }
    
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    
    public void mountShieldBooster(int i){
        if(hangar != null){
            ShieldBooster s = hangar.removeShieldBooster(i);
            if(s!=null)
                shieldBoosters.add(s);
        }
    }
    
    public void mountWeapon(int i){
        if(hangar != null){
            Weapon w = hangar.removeWeapon(i);
            if(w!=null)
                weapons.add(w);
        }
    }
    
    public void move(){
        fuelUnits -= getSpeed()*fuelUnits;
    }
    
    @Override
    public float protection(){
        int factor=1;
        int size=shieldBoosters.size();
        
        for(int i=0; i<size; i++)
            factor*=shieldBoosters.get(i).useIt();
        
        return shieldPower*factor;
    }
    
    public void receiveHangar(Hangar h){
        if(hangar==null)
            hangar = h;
    }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        if(hangar!=null)
            return hangar.addShieldBooster(s);
        return false;
    }
    
    @Override
    public ShotResult receiveShot(float shot){
        float myProtection=protection();
        
        if(myProtection>=shot){
            shieldPower-=SHIELDLOSSPERUNITSHOT*shot;
            shieldPower=Math.max(0.0f,shieldPower);
            return ShotResult.RESIST;
        }
        
        shieldPower=0.0f;
        return ShotResult.DONOTRESIST;
    }
    
    public void receiveSupplies(SuppliesPackage s){
        ammoPower += s.getAmmoPower();
        fuelUnits += s.getFuelUnits();
        shieldPower += s.getShieldPower();
        if(fuelUnits > MAXFUEL)
            fuelUnits = MAXFUEL;
    }
    
    public boolean receiveWeapon(Weapon w){
        if(hangar!=null)
            return hangar.addWeapon(w);
        return false;
    }
    
    public Transformation setLoot(Loot loot){
        CardDealer dealer= CardDealer.getInstance();
        
        if(loot.getNHangars()>0)
            receiveHangar(dealer.nextHangar());
                
        for(int i=0; i<loot.getNSupplies(); i++)
            receiveSupplies(dealer.nextSuppliesPackage());
                
        for(int i=0; i<loot.getNWeapons(); i++)
            receiveWeapon(dealer.nextWeapon());
                
        for(int i=0; i<loot.getNShields(); i++)
            receiveShieldBooster(dealer.nextShieldBooster());
        
        nMedals+=loot.getNMedals();
        
        if(loot.getSpaceCity())
            return Transformation.SPACECITY;
        else if(loot.getEfficient())
            return Transformation.GETEFFICIENT;
        else
            return Transformation.NOTRANSFORM;
    }
    
    public void setPendingDamage(Damage d){
        pendingDamage= d.adjust(weapons, shieldBoosters);
    }
    
    public boolean validState(){
        cleanPendingDamage();
        if(pendingDamage == null)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "name=" + name + "\nammoPower=" + ammoPower + "\nshieldPower=" + shieldPower + "\nfuelUnits=" + fuelUnits + "\nnMedals=" + nMedals + "\nweapons=" + weapons + "\nshieldBoosters=" + shieldBoosters + "\nhangar=" + hangar + "\npendingDamage=" + pendingDamage;
    }
}
