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
    private Loot loot;
    private Damage damage;
    
    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        name = n;
        ammoPower = a;
        shieldPower = s;
        loot = new Loot(l);
        damage = new Damage(d);
    }
    
    EnemyStarShip(EnemyStarShip e){
        this(e.name, e.ammoPower, e.shieldPower, e.loot, e.damage);
    }
    
    EnemyToUI getUIversion(){
        return new EnemyToUI(this);
    }
    
    public float fire(){
        return ammoPower;
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
        return shieldPower;
    }
    
    public ShotResult receiveShot(float shot){
        if(shieldPower < shot)
            return ShotResult.DONOTRESIST;
        
        else return ShotResult.RESIST;
    }
    
    public String toString(){
        return "Name: " + name + "\nAmmoPower: " + ammoPower + "\nShieldPower: "
               + shieldPower + "\nLoot:\n" + loot.toString() + "\nDamage:\n" + damage.toString();
    }
}
