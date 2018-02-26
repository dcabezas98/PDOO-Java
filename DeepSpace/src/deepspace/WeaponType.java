package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public enum WeaponType {
    
    LASER(2.0f),
    MISSILE(3.0f),
    PLASMA(4.0f);
    
    private float power;
    
    WeaponType(float pow){
        
        power = pow;
    }
    
    float getPower(){
        return power;
    }
}
