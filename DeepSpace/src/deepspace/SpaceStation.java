
package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class SpaceStation {
    
    private final int MAXFUEL = 100; //ES ABSTRACTO
    private final double SHIELDLOSSPERUNITSHOT=0.1; //ES ABSTRACTO
    
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    
    private void assignFuelValue(float f){
        fuelUnits = f;
    }
    
    private void cleanPendingDamage(){
        throw new UnsupportedOperationException();
    }
    
    SpaceStation(String n, SuppliesPackage supplies){
        name = n;
        ammoPower = supplies.getAmmoPower();
        fuelUnits = supplies.getFuelUnits();
        shieldPower = supplies.getShieldPower();
        //nMedals=0;
    }
    
    public void cleanUpMountedItems(){
        throw new UnsupportedOperationException();
    }
    
    public void discardHangar(){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBoosterInHangar(int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardWeapon (int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardWeaponInHangar(int i){
        throw new UnsupportedOperationException();
    }
    
    public float fire(){
        throw new UnsupportedOperationException();
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

    public int getnMedals() {
        return nMedals;
    }

    public float getShieldPower() {
        return shieldPower;
    }
    
    public Hangar getHangar(){
        throw new UnsupportedOperationException();
    }
    
    public Damage getPendingDamage(){
        throw new UnsupportedOperationException();
    }
    
    public ShieldBooster[] getShieldBoosters(){
        throw new UnsupportedOperationException();
    }
    
    public float getSpeed(){
        throw new UnsupportedOperationException();
    }
    
    public SpaceStationToUI getUIveersion(){
        throw new UnsupportedOperationException();
    }
    
    public Weapon[] getWeapons(){
        throw new UnsupportedOperationException();
    }
    
    public void mountShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    
    public void mountWeapon(int i){
        throw new UnsupportedOperationException();
    }
    
    public void move(){
        throw new UnsupportedOperationException();
    }
    
    public float protection(){
        throw new UnsupportedOperationException();
    }
    
    public void recieveHangar(Hangar h){
        throw new UnsupportedOperationException();
    }
    
    public boolean recieveShieldBooster(ShieldBooster s){
        throw new UnsupportedOperationException();
    }
    
    public ShotResult receiveShot(float shot){
        throw new UnsupportedOperationException();
    }
    
    public void receiveSupplies(SuppliesPackage s){
        throw new UnsupportedOperationException();
    }
    
    public boolean receiveWeapon(Weapon w){
        throw new UnsupportedOperationException();
    }
    
    public void setLoot(Loot loot){
        throw new UnsupportedOperationException();
    }
    
    public void setPendingDamage(Damage d){
        throw new UnsupportedOperationException();
    }
    
    public boolean validState(){
        throw new UnsupportedOperationException();
    }
    
    public String toString(){
        return "AmmoPower: " + ammoPower + "\nFuelUnits: " + fuelUnits + "\nName: " + name + "\nMedals: " + nMedals + "\nShieldPower: " + shieldPower;
    }
}
