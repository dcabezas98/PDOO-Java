package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */

import java.util.ArrayList;
        
public class GameUniverse {
    
    private static final int WIN = 10;
    
    private int currentStationIndex;
    private int turns;
    private Dice dice;
    private GameStateController gameState;
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations;
    
    GameUniverse(){
        gameState = new GameStateController();
        turns = 0;
        dice = new Dice();
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        throw new UnsupportedOperationException();
    }
    
    public CombatResult combat(){
        throw new UnsupportedOperationException();
    }
    
    public void discardHangar(){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.discardHangar();
        }
    }
    
    public void discardShieldBooster(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.discardShieldBooster(i);
        }
    }
    
    public void discardShieldBoosterInHangar(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.discardShieldBoosterInHangar(i);
        }
    }
    
    public void discardWeapon(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.discardWeapon(i);
        }
    }
    
    public void discardWeaponInHangar(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.discardWeaponInHangar(i);
        }
    }

    public GameState getState() {
        return gameState.getState();
    }
        
    public GameUniverseToUI getUIversion(){
        throw new UnsupportedOperationException();
    }
    
    public boolean haveAWinner(){
        return currentStation.getNMedals() >= WIN;
    }
    
    public void init(String[] names){
        throw new UnsupportedOperationException();
    }
    
    public void mountShieldBooster(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.mountShieldBooster(i);
        }
    }
    
    public void mountWeapon(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.mountWeapon(i);
        }
    }
    
    public boolean nextTurn(){
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "GameUniverse{" + "currentStationIndex=" + currentStationIndex + ", turns=" + turns + ", dice=" + dice + ", gameState=" + gameState + ", currentStation=" + currentStation + ", spaceStations=" + spaceStations + '}';
    }
   
}