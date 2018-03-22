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
    
    Loot(int sup, int wea, int shi, int han, int med){
        nSupplies=sup;
        nWeapons=wea;
        nShields=shi;
        nHangars=han;
        nMedals=med;
    }
    
    Loot(Loot l){
        nSupplies=l.nSupplies;
        nWeapons=l.nWeapons;
        nShields=l.nShields;
        nHangars=l.nHangars;
        nMedals=l.nMedals;
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
    
    @Override
    public String toString() {
        return "Loot{" + "nSupplies=" + nSupplies + ", nWeapons=" + nWeapons + ", nShields=" + nShields + ", nHangars=" + nHangars + ", nMedals=" + nMedals + '}';
    }
}
