package deepspace;

import java.util.Random;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
class Dice {
    
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    private final float EXTRAEFFICIENCY;
    private Random generator;
    
    Dice(){
        NHANGARSPROB = 0.25f;
        NSHIELDSPROB = 0.25f;
        NWEAPONSPROB = 0.33f;
        FIRSTSHOTPROB = 0.5f;
        EXTRAEFFICIENCY= 0.8f;
        generator = new Random();
    }
    
    int initWithNHangars(){
        
        float x=generator.nextFloat();
        
        if(x<NHANGARSPROB){
            return 0;
        } else{
            return 1;
        }
    }
    
    int initWithNWeapons(){
        
        float x = generator.nextFloat();
        
        if (x<NWEAPONSPROB){
            return 1;
        } else if (NWEAPONSPROB <= x && x< NWEAPONSPROB*2){
            return 2;
        }else{
            return 3;
        }
    }
    
    int initWithNShields(){
        
        float x = generator.nextFloat();
        
        if(x<NSHIELDSPROB){
            return 0;
        } else {
            return 1;
        }
    }
    
    int whoStarts(int nPlayers){
        return generator.nextInt(nPlayers);
    }
    
    GameCharacter firstShot(){
        float x = generator.nextFloat();
        
        if (x<FIRSTSHOTPROB){
            return GameCharacter.SPACESTATION;
        } else {
            return GameCharacter.ENEMYSTARSHIP;
        }
    }
    
    boolean spaceStationMoves(float speed){
        float x = generator.nextFloat();
        
        return x<speed;
    }
    
    boolean extraEfficiency(){
        float x = generator.nextFloat();
        
        return x < EXTRAEFFICIENCY;    
    }
        
    @Override
    public String toString(){
        return "NHANGARSPROB = " + NHANGARSPROB + "\nNSHIELDSPROB = " + NSHIELDSPROB + "\nNWEAPONSPROB = " + NWEAPONSPROB + "\nFIRSTSHOTPROB = " + FIRSTSHOTPROB +"\nEXTRAEFFICIENCY" + EXTRAEFFICIENCY;
    }
}
