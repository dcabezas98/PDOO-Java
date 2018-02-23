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
