package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class GameUniverse {
    
    private final int WIN = 10;
    
    private int currentStationIndex;
    private int turns;
    
    GameUniverse(){
        throw new UnsupportedOperationException();
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        throw new UnsupportedOperationException();
    }
    
    public CombatResult combat(){
        throw new UnsupportedOperationException();
    }
    
    public void discardHangar(){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBoosterInHangar(int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardWeapon(int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardWeaponInHangar(int i){
        throw new UnsupportedOperationException();
    }
    
    public GameState getState(){
        throw new UnsupportedOperationException();
    }
    
    public GameUniverseToUI getUIversion(){
        throw new UnsupportedOperationException();
    }
    
    public boolean haveAWinner(){
        throw new UnsupportedOperationException();
    }
    
    public void init(String[] names){
        throw new UnsupportedOperationException();
    }
    
    public void mountShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    
    public void mountWeapon(int i){
        throw new UnsupportedOperationException();
    }
    
    public boolean nextTurn(){
        throw new UnsupportedOperationException();
    }
    
    public String toString(){
        return "Index: " + currentStationIndex + "\nTurns: " + turns;
    }
}
