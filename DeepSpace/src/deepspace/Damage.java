package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */

import java.util.ArrayList;

class Damage {
    
    private int nShields;
    private ArrayList<WeaponType> weapons;
    private int nWeapons;
    
    Damage(int w, int s){
        nWeapons=w;
        nShields= s;
        weapons = new ArrayList<>();
    }
    
    Damage(ArrayList<WeaponType> wl, int s){
        nShields = s;
        weapons = (ArrayList<WeaponType>) (wl.clone());
        nWeapons = weapons.size();
    }
    
    Damage(Damage d){
        nShields= d.nShields;
        nWeapons= d.nWeapons;
        weapons= (ArrayList<WeaponType>) (d.weapons.clone());
    }
    
    DamageToUI getUIversion(){
        return new DamageToUI(this);
    } 
    
    Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        ArrayList copy = (ArrayList<Weapon>) (w.clone());
        Damage aux = new Damage(this);
        int index;
        
        for(WeaponType t: weapons){
            index=arrayContainsType(copy, t);
            if(index==-1){
                aux.weapons.remove(t);
            } else {
                copy.remove(index);
            }
        }
        
        if(s.size()<nShields)
            aux.nShields=s.size();
        
        return aux;
    }
    
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t){
        boolean found = false;
        int index = -1;
        
        for(int i= 0; i<w.size() && !found; i++){
            if(w.get(i).getType() == t){
                found = true;
                index = i;
            }
        }
        return index;
    }
    
    public void discardWeapon(Weapon w){
        if(!weapons.remove(w.getType()) && nWeapons > 0)
            nWeapons--;
    }
    
    public void discardShieldBooster(){
        if(nShields > 0)
            nShields--;
    }
    
    public boolean hasNoEffect(){
        if(nWeapons == 0 && nShields == 0)
            return true;
        else
            return false;
    }
    
    public int getNShields(){
        return nShields;
    }
    
    public int getNWeapons(){
        return nWeapons;
    }
    
    public ArrayList<WeaponType> getWeapons(){
        return weapons;
    }
    
    @Override
    public String toString(){
        return "Shields: " + nShields + "\nWeapons: " + nWeapons + "\nweapons: " + weapons;
    }
}







