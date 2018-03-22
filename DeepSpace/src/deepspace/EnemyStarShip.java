package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
class EnemyStarShip implements Copyable<EnemyStarShip> {
    
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
        return damage;
    }
    
    public Loot getLoot(){
        return loot;
    }
    
    public float protection(){
        return shieldPower;
    }
    
    public ShotResult receiveShot(float shot){
        if(shieldPower < shot)
            return ShotResult.DONOTRESIST;
        
        else return ShotResult.RESIST;
    }
    
    @Override
    public EnemyStarShip copy(){
        return new EnemyStarShip(this);
    }

    @Override
    public String toString() {
        return "EnemyStarShip{" + "ammoPower=" + ammoPower + ", name=" + name + ", shieldPower=" + shieldPower + ", loot=" + loot + ", damage=" + damage + '}';
    }
}
