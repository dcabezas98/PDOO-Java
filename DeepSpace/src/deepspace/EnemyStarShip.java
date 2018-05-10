package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
class EnemyStarShip implements SpaceFighter{
    
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
        damage = d.copy();
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
    
    public String toString(){
        return "Name: " + name + "\nAmmoPower: " + ammoPower + "\nShieldPower: "
               + shieldPower + "\nLoot:\n" + loot.toString() + "\nDamage:\n" + damage.toString();
    }
}
