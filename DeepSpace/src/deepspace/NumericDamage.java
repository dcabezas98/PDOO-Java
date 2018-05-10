/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class NumericDamage extends Damage{
    
    private int nWeapons;
    
    NumericDamage(int w, int s){
        super(s);
        nWeapons = w;
    }
    
    @Override
    DamageToUI getUIversion(){
        return new NumericDamageToUI(this);
    }
    
    @Override
    NumericDamage copy(){
        return new NumericDamage(nWeapons, getNShields());
    }
    
    public int getNWeapons(){
        return nWeapons;
    }
    
    @Override
    NumericDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
    
        int ns = adjustShields(s); 
        int nw = nWeapons;
        
        if(nWeapons > w.size()){
            nw=w.size();
        }
        
        return new NumericDamage(nw,ns);
    }
    
    @Override
    public void discardWeapon(Weapon w){
        if(nWeapons > 0)
            nWeapons--;
    }
    
    @Override
    public boolean hasNoEffect(){
        return (nWeapons <= 0 && super.hasNoEffect());
    }

    @Override
    public String toString() {
        return "nWeapons = " + nWeapons + "\n" + super.toString();
    }
    
}
