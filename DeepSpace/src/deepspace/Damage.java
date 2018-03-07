package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class Damage {
    
    private int nShields;
    private int nWeapons;
    
    Damage(int w, int s){
        nWeapons=w;
        nShields= s;
    }
    
    Damage(WeaponType[] wl, int s){
        throw new UnsupportedOperationException();
    }
    
    Damage(Damage d){
        nShields= d.nShields;
        nWeapons= d.nWeapons;
    }
    
    DamageToUI getUIversion(){
        throw new UnsupportedOperationException();
    } 
    
    private Damage adjust(Weapon[] w, ShieldBooster[] s){
        throw new UnsupportedOperationException();
    }
    
    private int arrayContainsType(Weapon[] w, WeaponType t){
        throw new UnsupportedOperationException();
    }
    
    public void discardWeapon(Weapon w){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBooster(ShieldBooster s){
        throw new UnsupportedOperationException();
    }
    
    public boolean hasNoEffect(){
        throw new UnsupportedOperationException();
    }
    
    public int getNShields(){
        return nShields;
    }
    
    public int getNWeapons(){
        return nWeapons;
    }
    
    public WeaponType[] getWeapons(){
        throw new UnsupportedOperationException();
    }
    
    public String toString(){
        return "Shields: " + nShields + "\nWeapons: " + nWeapons;
    }
}







