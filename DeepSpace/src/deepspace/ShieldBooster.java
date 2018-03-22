package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
class ShieldBooster implements Copyable<ShieldBooster> {
    
    private String name;
    private float boost;
    private int uses;
    
    ShieldBooster(String nam, float boo, int use){
        name=nam;
        boost=boo;
        uses=use;
    }
    
    ShieldBooster(ShieldBooster s){
        name=s.name;
        boost=s.boost;
        uses=s.uses;
    }
    
    ShieldToUI getUIversion(){
        return new ShieldToUI(this);
    }
            
    public float getBoost() {
        return boost;
    }

    public int getUses() {
        return uses;
    }
    
    public float useIt(){
    
        if(uses > 0){
            --uses;
            return boost;
        }else{
            return 1.0f;
        }
    }
        
    @Override
    public ShieldBooster copy(){
        return new ShieldBooster(this);
    }

    @Override
    public String toString() {
        return "ShieldBooster{" + "name=" + name + ", boost=" + boost + ", uses=" + uses + '}';
    }
}
