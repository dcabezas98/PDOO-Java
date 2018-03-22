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
    
    Damage(int w, int s, ArrayList<WeaponType> wl){
        nWeapons=w;
        nShields=s;
        if(wl!=null)
            weapons=new ArrayList<>(wl);
        else
            weapons=null;
    }
    
    Damage(int w, int s){
        this(w, s, null);
    }
    
    Damage(ArrayList<WeaponType> wl, int s){
        this(-1, s, wl);
    }
    
    Damage(Damage d){
        this(d.nWeapons, d.nShields, d.weapons);
    }
    
    DamageToUI getUIversion(){
        return new DamageToUI(this);
    } 
    
    Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        ArrayList copy = new ArrayList(w);
        int nw=nWeapons, ns=nShields;
        
        if(nWeapons > w.size())
           nw=w.size();
        
        if(nShields > s.size())
            ns=s.size();
        
        Damage aux = new Damage(nw, ns, weapons);
        int index;
        
        if(weapons != null){
            for(WeaponType t: weapons){
                index=arrayContainsType(copy, t);
                if(index==-1)
                    aux.weapons.remove(t);
                else 
                    copy.remove(index);
            }
        }
        
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
        if(weapons == null && nWeapons > 0)
            nWeapons--;
        else
            weapons.remove(w.getType());
    }
    
    public void discardShieldBooster(){
        if(nShields > 0)
            nShields--;
    }
    
    public boolean hasNoEffect(){
        return nShields <= 0 && nWeapons <= 0 && (weapons == null || weapons.isEmpty());
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







