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

public class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation{
    private static final float EXTRAEFFICIENCY=1.2f;
    private Dice dice;
    
    BetaPowerEfficientSpaceStation(SpaceStation station){
        super(station);
        dice = new Dice();
    }
    
    @Override
    public BetaPowerEfficientSpaceStationToUI getUIversion(){
        return new BetaPowerEfficientSpaceStationToUI(this);
    }
    
    @Override
    public float fire(){
        float factor = 1.0f;
        if(dice.extraEfficiency())
            factor = EXTRAEFFICIENCY;
        
        return super.fire()*factor;
    }
}
