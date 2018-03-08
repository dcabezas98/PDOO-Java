package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */

import java.util.ArrayList;
        
public class Hangar {
    
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
       weapons = (ArrayList<Weapon>) (h.weapons.clone());
       shieldBoosters = (ArrayList<ShieldBooster>) (h.shieldBoosters.clone());
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
    public String toString() {
        return "maxElements=" + maxElements + "\nweapons=" + weapons + "\nshieldBoosters=" + shieldBoosters;
    }
}