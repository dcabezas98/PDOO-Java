package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */

import java.util.ArrayList;
        
class Hangar implements Copyable<Hangar> {
    
    private int maxElements;
    private  ArrayList<Weapon> weapons;
    private  ArrayList<ShieldBooster> shieldBoosters;
    
    private boolean spaceAvailable(){
        return (weapons.size() + shieldBoosters.size()) < maxElements;
    }
    
    Hangar(int capacity){
        maxElements = capacity;
        weapons = new ArrayList<>();
        shieldBoosters  = new ArrayList<>();
    }
    
    Hangar(Hangar h){
       maxElements = h.maxElements;
       weapons = new ArrayList<>();
       h.weapons.forEach((w) -> {
           weapons.add(new Weapon(w));
        });
       shieldBoosters = new ArrayList<>();
       h.shieldBoosters.forEach((s) -> {
           shieldBoosters.add(new ShieldBooster(s));
        });
    }
    
    HangarToUI getUIversion(){
        return new HangarToUI(this);
    }
    
    public boolean addWeapon(Weapon w){
        if(spaceAvailable()){
            weapons.add(w);
            return true;
        }
        return false;
    }
    
    public boolean addShieldBooster(ShieldBooster s){
        if(spaceAvailable()){
            shieldBoosters.add(s);
            return true;
        }
        return false;
    }
    
    public int getMaxElements(){
        return maxElements;
    }
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    
    public ShieldBooster removeShieldBooster(int s){
        if(0 <= s && s < shieldBoosters.size())
            return shieldBoosters.remove(s);
        
        return null;
    }
    
    public Weapon removeWeapon(int w){
        if(0 <= w && w < weapons.size())
            return weapons.remove(w);
        
        return null;
    }
    
    @Override 
    public Hangar copy(){
        return new Hangar(this);
    }

    @Override
    public String toString() {
        return "Hangar{" + "maxElements=" + maxElements + ", weapons=" + weapons + ", shieldBoosters=" + shieldBoosters + '}';
    }
}