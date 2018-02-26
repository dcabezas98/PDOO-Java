package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class Weapon {
    
    private String name;
    private WeaponType type;
    private int uses;
    
    Weapon(String nam, WeaponType typ, int use){
        name = nam;
        type = typ;
        uses = use;
    }
    
    Weapon(Weapon w){
        name = w.name;
        type = w.type;
        uses = w.uses;
    }

    public WeaponType getType() {
        return type;
    }

    public int getUses() {
        return uses;
    }
    
    public float power(){
        return type.getPower();
    }
    
    public float useIt(){
        
        if (uses > 0){
            uses--;
            return power();
        }
        else
            return 1.0f; 
    }    
}
