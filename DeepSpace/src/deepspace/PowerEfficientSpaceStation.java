/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */

public class PowerEfficientSpaceStation extends SpaceStation{
    
    private static final float EFFICIENCYFACTOR =1.10f;
    
    PowerEfficientSpaceStation(SpaceStation station){
        super(station);
    }
    
    @Override
    public float fire(){
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    @Override
    public PowerEfficientSpaceStationToUI getUIversion(){
        return new PowerEfficientSpaceStationToUI(this);
    }
    @Override
    public float protection(){
        return super.protection()*EFFICIENCYFACTOR;
    }
    
    @Override
    public Transformation setLoot(Loot loot){
        if(super.setLoot(loot)==Transformation.GETEFFICIENT)
            return Transformation.GETEFFICIENT;
        else
            return Transformation.NOTRANSFORM;
    }
}
