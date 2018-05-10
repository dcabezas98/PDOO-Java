package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
class Loot {

    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    private boolean efficient;
    private boolean spaceCity;
    
    Loot(int sup, int wea, int shi, int han, int med){
        nSupplies=sup;
        nWeapons=wea;
        nShields=shi;
        nHangars=han;
        nMedals=med;
        efficient=false;
        spaceCity=false;
    }
    
    Loot(int sup, int wea, int shi, int han, int med, boolean ef, boolean city){
        this(sup,wea,shi,han,med);
        efficient=ef;
        spaceCity=city;
    }
    
    Loot(Loot l){
        this(l.nSupplies, l.nWeapons, l.nShields, l.nHangars, l.nMedals, l.efficient, l.spaceCity);
    }
    
    LootToUI getUIversion(){
        return new LootToUI(this);
    }
    
    public int getNSupplies() {
        return nSupplies;
    }

    public int getNWeapons() {
        return nWeapons;
    }

    public int getNShields() {
        return nShields;
    }

    public int getNHangars() {
        return nHangars;
    }

    public int getNMedals() {
        return nMedals;
    }
    
    public boolean getEfficient(){
        return efficient;
    }
    
    public boolean getSpaceCity(){
        return spaceCity;
    }

    @Override
    public String toString() {
        return "nSupplies=" + nSupplies + "\nnWeapons=" + nWeapons + "\nnShields=" + nShields + "\nnHangars=" + nHangars + "\nnMedals=" + nMedals + "\nefficient=" + efficient + "\nspaceCity=" + spaceCity;
    }
    
    
}
