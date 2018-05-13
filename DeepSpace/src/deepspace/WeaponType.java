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
    
    @Override
    public String toString() {
        String res;
        switch (this) {
            case LASER:
                res = "Laser"; 
                break;
            case MISSILE:
                res = "Missile"; 
                break;
            case PLASMA:
                res = "Plasma";
                break;
            default:
                res = "Error";
                break;
        }
        return res;
    }
}
