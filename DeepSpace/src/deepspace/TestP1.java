package deepspace;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class TestP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Loot loot = new Loot(3, 2, 3, 1, 2);
        ShieldBooster shieldTable = new ShieldBooster("Table", 3.8f, 2);
        ShieldBooster shieldCopy = new ShieldBooster(shieldTable);
        SuppliesPackage supp = new SuppliesPackage(2.3f, 7.1f, 3.1f);
        SuppliesPackage suppCopy = new SuppliesPackage(supp);
        Weapon laser = new Weapon("Destroyer", WeaponType.LASER, 1);
        Weapon missile = new Weapon("Exploder", WeaponType.MISSILE, 2);
        Weapon plasma = new Weapon("Boom", WeaponType.PLASMA, 3);
        Weapon copy = new Weapon(missile);
        Dice dice = new Dice();
        
        System.out.println("Loot: ");
        System.out.println("Supplies: ");
        System.out.println(loot.getNSupplies());
        System.out.println("Weapons: ");
        System.out.println(loot.getNWeapons());
        System.out.println("Shields: ");  
        System.out.println(loot.getNShields());
        System.out.println("Hangaras: ");
        System.out.println(loot.getNHangars());
        System.out.println("Medals: ");
        System.out.println(loot.getNMedals());
        
        System.out.println("\nShieldBooster: ");
        System.out.println("Boost: ");
        System.out.println(shieldTable.getBoost());
        System.out.println(shieldCopy.getBoost());
        System.out.println("Uses: ");
        System.out.println(shieldTable.getUses());
        System.out.println(shieldCopy.getUses());
        System.out.println("Using it: ");
        System.out.println(shieldTable.useIt());
        System.out.println(shieldTable.useIt());
        System.out.println(shieldTable.useIt());
        System.out.println(shieldTable.useIt());
        System.out.println("Using it (copy): ");
        System.out.println(shieldCopy.useIt());
        System.out.println(shieldCopy.useIt());
        System.out.println(shieldCopy.useIt());
       
        System.out.println("\nSuppliesPackage: ");
        System.out.println("Ammo: ");
        System.out.println(supp.getAmmoPower());
        System.out.println(suppCopy.getAmmoPower());
        System.out.println("Fuel: ");
        System.out.println(supp.getFuelUnits());
        System.out.println(suppCopy.getFuelUnits());
        System.out.println("Shield: ");
        System.out.println(supp.getShieldPower());
        System.out.println(suppCopy.getShieldPower());
        
        System.out.println("\nWeapon: ");
        System.out.println("Type: ");
        System.out.println(laser.getType());
        System.out.println(missile.getType());
        System.out.println(plasma.getType());
        System.out.println(copy.getType());
        System.out.println("Uses: ");
        System.out.println(laser.getUses());
        System.out.println(missile.getUses());
        System.out.println(plasma.getUses());
        System.out.println(copy.getUses());
        System.out.println("Power: ");
        System.out.println(laser.power());
        System.out.println(missile.power());
        System.out.println(plasma.power());
        System.out.println(copy.power());
        System.out.println("Using it: ");
        System.out.println(laser.useIt());
        System.out.println(laser.useIt());
        System.out.println("Using it (missile): ");
        System.out.println(missile.useIt());
        System.out.println(missile.useIt());
        System.out.println(missile.useIt());
        System.out.println("Using it (plasma): ");
        System.out.println(plasma.useIt());
        System.out.println(plasma.useIt());
        System.out.println(plasma.useIt());
        System.out.println(plasma.useIt());
        System.out.println("Using it (copy): ");
        System.out.println(copy.useIt());
        System.out.println(copy.useIt());
        System.out.println(copy.useIt());
        System.out.println(copy.useIt());
        
        System.out.println("\nDice: ");
             
        int h0 = 0, h1 = 0;
        int w1 = 0, w2 = 0, w3 = 0;
        int s0 = 0, s1 = 0;
        int[] players = {0,0,0,0,0};
        int p;
        int station = 0, enemy = 0;
        int moves = 0, doesnotmove = 0;
        
        for(int i = 0; i < 100; i++){
            
            if(dice.initWithNHangars() == 1)
                h1++;
            else h0++;
            
            int w = dice.initWithNWeapons();
            
            switch(w){
                case 1: 
                    w1++;
                    break;
                case 2: 
                    w2++;
                    break;
                case 3:
                    w3++;
                    break;
            }
            
            if(dice.initWithNShields() == 1)
                s1++;
            else s0++;
            
            p = dice.whoStarts(players.length);
            players[p]++;
            
            if(dice.firstShot() == GameCharacter.SPACESTATION)
                station++;
            else enemy++;
            
            if(dice.spaceStationMoves(0.47f))
                moves++;
            else doesnotmove++;
        }
        
        System.out.print("0 Hangars: ");
        System.out.println(h0);
        System.out.print("1 Hangar: ");
        System.out.println(h1);
        System.out.print("0 Shields: ");
        System.out.println(s0);
        System.out.print("1 Shield: ");
        System.out.println(s1);
        System.out.print("1 Weapon: ");
        System.out.println(w1);
        System.out.print("2 Weapons: ");
        System.out.println(w2);
        System.out.print("3 Weapons: ");
        System.out.println(w3);
        System.out.println("WhoStarts: ");
        for(int t: players){
            System.out.println(t);
        }
        System.out.println("FirstShot: ");
        System.out.print("Station: ");
        System.out.println(station);
        System.out.print("Enemy: ");
        System.out.println(enemy);
        System.out.println("Station moves: ");
        System.out.print("Yes: ");
        System.out.println(moves);
        System.out.print("No: ");
        System.out.println(doesnotmove);
    }
}
