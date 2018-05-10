/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;
/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */

import java.util.ArrayList;

public class SpecificDamage extends Damage{
    
    private ArrayList<WeaponType> weapons;
    
    SpecificDamage(ArrayList<WeaponType> wl, int s){
        super(s);
        weapons = new ArrayList<>(wl);
    }
    
    @Override
    DamageToUI getUIversion(){
        return new SpecificDamageToUI(this);
    }
    
    @Override
    SpecificDamage copy(){
        return new SpecificDamage(weapons, getNShields());
    }
    
    public ArrayList<WeaponType> getWeapons(){
        return weapons;
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
    
    @Override
    SpecificDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){        
       
        ArrayList<Weapon> copy = new ArrayList<>(w);
        
        int ns = adjustShields(s); 
        SpecificDamage aux = new SpecificDamage(weapons, ns);
        
        int index;
        
        for(WeaponType t: weapons){
            index=arrayContainsType(copy, t);
            if(index==-1)
                aux.weapons.remove(t);
            else
                copy.remove(index);
        }
        
        return aux;
    }
    
    @Override
    public void discardWeapon(Weapon w){
        weapons.remove(w.getType());
    }
    
    @Override
    public boolean hasNoEffect(){
        return (super.hasNoEffect() && weapons.size() <= 0);
    }

    @Override
    public String toString() {
        return "weapons = " + weapons + "\n" +super.toString();
    }
}
