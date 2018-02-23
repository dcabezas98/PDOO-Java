/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author dcabezas
 */
public class SuppliesPackage {
    
    float ammoPower;
    float fuelUnits;
    float shieldPower;
    
    SuppliesPackage(float amm, float fue, float shi){
        ammoPower=amm;
        fuelUnits=fue;
        shieldPower=shi;
    }

    SuppliesPackage(SuppliesPackage original){
        ammoPower=original.ammoPower;
        fuelUnits=original.fuelUnits;
        shieldPower=original.shielPower;
    }
    public float getAmmoPower() {
        return ammoPower;
    }

    public float getFuelUnits() {
        return fuelUnits;
    }

    public float getShielPower() {
        return shielPower;
    }
}
