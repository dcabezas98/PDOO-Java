package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */

import java.util.ArrayList;

abstract class Damage {
    
    private int nShields;
    
    Damage(int s){
        nShields = s;
    }
    
    abstract Damage copy();
    
    abstract DamageToUI getUIversion();
    
    abstract void discardWeapon(Weapon w);
    
    int adjustShields(ArrayList<ShieldBooster> s){        
        if(nShields > s.size())
            return s.size();
        return nShields;
    }
    
    abstract Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s);
        
    public void discardShieldBooster(){
        if(nShields > 0)
            nShields--;
    }
    
    public boolean hasNoEffect(){
        return nShields <= 0;
    }
    
    public int getNShields(){
        return nShields;
    }   

    @Override
    public String toString() {
        return "nShields = " + nShields;
    }
    
}