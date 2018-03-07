package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class Hangar {
    
    private int maxElements;
    
    private boolean spaceAvailable(){
        throw new UnsupportedOperationException();
    }
    
    Hangar(int capacity){
        throw new UnsupportedOperationException();
    }
    
    Hangar(Hangar h){
        throw new UnsupportedOperationException();
    }
    
    HangarToUI getUIversion(){
        throw new UnsupportedOperationException();
    }
    
    public boolean addWeapon(Weapon w){
        throw new UnsupportedOperationException();
    }
    
    public boolean addShieldBooster(ShieldBooster s){
        throw new UnsupportedOperationException();
    }
    
    public int getMaxElements(){
        return maxElements;
    }
    
    public ShieldBooster[] getShieldBoosters(){
        throw new UnsupportedOperationException();
    }
    
    public Weapon[] getWeapons(){
        throw new UnsupportedOperationException();
    }
    
    public ShieldBooster removeShieldBooster(int s){
        throw new UnsupportedOperationException();
    }
    
    public Weapon removeWeapon(int w){
        throw new UnsupportedOperationException();
    }
    
    public String toString(){
        return "MaxElements: " + maxElements;
    }
}
