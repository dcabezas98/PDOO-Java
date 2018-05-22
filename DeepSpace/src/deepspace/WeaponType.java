package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public enum WeaponType {
    
    LASER("Laser",2.0f),
    MISSILE("Missile",3.0f),
    PLASMA("Plasma",4.0f);
    
    private float power;
    private String name;
    
    WeaponType(String nam, float pow){
        name = nam;
        power = pow;
    }
    
    float getPower(){
        return power;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
