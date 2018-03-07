package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class EnemyStarShip {
    
    private float ammoPower;
    private String name;
    private float shieldPower;
    
    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        throw new UnsupportedOperationException();
    }
    
    EnemyStarShip(EnemyStarShip e){
        ammoPower = e.ammoPower;
        name = e.name;
        shieldPower = e.shieldPower;
    }
    
    EnemyToUI getUIversion(){
        throw new UnsupportedOperationException();
    }
    
    public float fire(){
        throw new UnsupportedOperationException();
    }

    public float getAmmoPower() {
        return ammoPower;
    }

    public String getName() {
        return name;
    }

    public float getShieldPower() {
        return shieldPower;
    }
    
    public Damage getDamage(){
        throw new UnsupportedOperationException();
    }
    
    public Loot getLoot(){
        throw new UnsupportedOperationException();
    }
    
    public float protection(){
        throw new UnsupportedOperationException();
    }
    
    public ShotResult recieveShot(float shot){
        throw new UnsupportedOperationException();
    }
    
    public String toString(){
        return "Name: " + name + "\nAmmoPower: " + ammoPower + "\nShieldPower: " + shieldPower;
    }
}
