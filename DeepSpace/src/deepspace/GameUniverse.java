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
    private EnemyStarShip currentEnemy;
    private ArrayList<SpaceStation> spaceStations;
    private boolean haveSpaceCity;
    private boolean enemyVisible;

    public boolean isEnemyVisible() {
        return enemyVisible;
    }
    
    public void cheatNow(){
        if(currentStation.canCheat() && enemyVisible){
            Loot l = new Loot(2, 2, 3, 1, 0);
            NumericDamage d = new NumericDamage(0,0);
            currentEnemy = new EnemyStarShip("Enemigo saboteado", 0, 0, l, d);
           
            currentStation.cheatNow();
        }
    }
    
    public void spyNow(){
        if(currentStation.canSpy() && currentStation.canCheat()){
            enemyVisible = true;
            currentStation.spyNow();
        }
    }
    
    public GameUniverse(){
        gameState = new GameStateController();
        turns = 0;
        dice = new Dice();
        haveSpaceCity=false;
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        
        boolean enemyWins;
        float fire;
        ShotResult result;
        CombatResult combatResult;
        
        if(dice.firstShot() == GameCharacter.ENEMYSTARSHIP){
            fire = enemy.fire();
            result = station.receiveShot(fire);
            
            if(result == ShotResult.RESIST){
                fire = station.fire();
                result = enemy.receiveShot(fire);
                enemyWins = (result == ShotResult.RESIST);
            }
            else enemyWins = true;
        }
        else{
            fire = station.fire();
            result = enemy.receiveShot(fire);
            enemyWins = (result == ShotResult.RESIST);   
        }
        
        if(enemyWins){
            if(!dice.spaceStationMoves(station.getSpeed())){
                station.setPendingDamage(enemy.getDamage());
                combatResult = CombatResult.ENEMYWINS;
            } else {
                station.move();
                combatResult = CombatResult.STATIONESCAPES;
            }
        }else{
            Transformation trans = station.setLoot(enemy.getLoot());
            combatResult = CombatResult.STATIONWINSANDCONVERTS;
            if(trans == Transformation.GETEFFICIENT)
                makeStationEfficient();
            else if (trans == Transformation.SPACECITY && !haveSpaceCity)
                createSpaceCity();
            else
                combatResult = CombatResult.STATIONWINS;
        }
        
        gameState.next(turns, spaceStations.size());
        
        return combatResult;
    }
    
    private void makeStationEfficient(){
        if(dice.extraEfficiency())
            currentStation = new BetaPowerEfficientSpaceStation(currentStation);            
        else
            currentStation = new PowerEfficientSpaceStation(currentStation);
  
        spaceStations.set(currentStationIndex,currentStation);
    }
    
    private void createSpaceCity(){
        if(!haveSpaceCity){
            ArrayList<SpaceStation> rest = new ArrayList();
            for (SpaceStation t: spaceStations){
                if(t != currentStation)
                    rest.add(t);
            }
            currentStation= new SpaceCity(currentStation, rest);
            spaceStations.set(currentStationIndex,currentStation);
            haveSpaceCity = true;
        }
    }
    
    public CombatResult combat(){
        
        GameState state = gameState.getState();
        
        if((state == GameState.BEFORECOMBAT)||(state == GameState.INIT))
            return combat(currentStation, currentEnemy);
        
        return CombatResult.NOCOMBAT;
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
        return new GameUniverseToUI(currentStation, currentEnemy);
    }
    
    public boolean haveAWinner(){
        return currentStation.getNMedals() >= WIN;
    }
    
    public void init(ArrayList<String> names){
                
        if(gameState.getState() == GameState.CANNOTPLAY){
            spaceStations = new ArrayList<>();
            CardDealer dealer = CardDealer.getInstance();
            
            SuppliesPackage supplies;
            SpaceStation station;
            Loot loot;
            int nh, nw, ns;
            
            for(String name: names){
                supplies = dealer.nextSuppliesPackage();
                station = new SpaceStation(name, supplies);
                
                nh = dice.initWithNHangars();
                nw = dice.initWithNWeapons();
                ns = dice.initWithNShields();
                
                loot = new Loot(0, nw, ns, nh, 0);
                station.setLoot(loot);
                
                spaceStations.add(station);
            }   
            
            currentStationIndex = dice.whoStarts(names.size());
            currentStation = spaceStations.get(currentStationIndex);
            currentEnemy = dealer.nextEnemy();
            
            enemyVisible = false;
            
            gameState.next(turns, spaceStations.size());
        }   
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
        
        GameState state = gameState.getState(); 
        if(state == GameState.AFTERCOMBAT){
            boolean stationState = currentStation.validState();
         
            if(stationState){
                
                enemyVisible = false;
                
                currentStationIndex=(currentStationIndex+1)%spaceStations.size();
                turns++;
                
                currentStation=spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();
            
                CardDealer dealer = CardDealer.getInstance();
                currentEnemy = dealer.nextEnemy();           
                gameState.next(turns, spaceStations.size());
                
                return true;
            }
            return false;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "GameUniverse{" + "currentStationIndex=" + currentStationIndex + ", turns=" + turns + ", dice=" + dice + ", gameState=" + gameState + ", currentStation=" + currentStation + ", spaceStations=" + spaceStations + '}';
    }
   
}