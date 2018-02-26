package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class SuppliesPackage {
    
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    SuppliesPackage(float amm, float fue, float shi){
        ammoPower=amm;
        fuelUnits=fue;
        shieldPower=shi;
    }

    SuppliesPackage(SuppliesPackage s){
        ammoPower=s.ammoPower;
        fuelUnits=s.fuelUnits;
        shieldPower=s.shieldPower;
    }
    public float getAmmoPower() {
        return ammoPower;
    }

    public float getFuelUnits() {
        return fuelUnits;
    }

    public float getShieldPower() {
        return shieldPower;
    }
}
