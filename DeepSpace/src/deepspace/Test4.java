/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class Test4 {
    
    public static void main(String[] args){
        
        // Creamos estación espacia
          SuppliesPackage sp = new SuppliesPackage(100.0f, 60.0f, 400.0f);
          SpaceStation st = new SpaceStation("Alpha", sp);
//        SpaceStation st2 = new SpaceStation("Gamma", sp);
//        SpaceStation st3 = new SpaceStation("Delta", sp);
//        SpaceStation st4 = new SpaceStation("Epsilon", sp);
//
//        ArrayList<SpaceStation> array = new ArrayList();
//        array.add(st2);
//        array.add(st3);
//        array.add(st4);
//        SpaceCity sc = new SpaceCity(st, array);
        
        //Disparamos y nos protegemos
//        System.out.println("Deberia salir: 400");
//        System.out.println(sc.fire());
//        System.out.println("Deberia salir: 1600");
//        System.out.println(sc.protection());

//        PowerEfficientSpaceStation eff = new PowerEfficientSpaceStation(st);
//        BetaPowerEfficientSpaceStation betaEff = new BetaPowerEfficientSpaceStation(st);
//        
////        System.out.println(eff.fire());
////        
////        for(int k = 0; k < 20; k++)
////            System.out.println(betaEff.fire());
//        
//        PowerEfficientSpaceStation eff2 = new PowerEfficientSpaceStation(eff);
//        BetaPowerEfficientSpaceStation betaEff2 = new BetaPowerEfficientSpaceStation(eff);
//        PowerEfficientSpaceStation eff3 = new PowerEfficientSpaceStation(betaEff);
//        BetaPowerEfficientSpaceStation betaEff3 = new BetaPowerEfficientSpaceStation(betaEff);
//        
//        System.out.println(eff2.fire());
//        for(int k = 0; k < 20; k++)
//            System.out.println(betaEff2.fire());
        
        // Damage d = new NumericDamage(2,3);
        
        ArrayList<WeaponType> wt = new ArrayList();
        wt.add(WeaponType.LASER);
        wt.add(WeaponType.LASER);
        wt.add(WeaponType.MISSILE);
        wt.add(WeaponType.MISSILE);
        wt.add(WeaponType.PLASMA);
        Damage d = new SpecificDamage(wt,3);
        
        Weapon w1 = new Weapon("Espada", WeaponType.LASER,2);
        Weapon w2 = new Weapon("Espada2", WeaponType.LASER,3);
        Weapon w3 = new Weapon("Espada3", WeaponType.MISSILE,1);
        
        st.receiveHangar(new Hangar(4));
        st.receiveWeapon(w1);
        st.receiveWeapon(w2);
        st.receiveWeapon(w3);
        st.mountWeapon(0);
        st.mountWeapon(1);
        st.mountWeapon(0);
        
        st.receiveShieldBooster(new ShieldBooster("Escudo", 3.5f ,4));
        st.mountShieldBooster(0);
        st.receiveShieldBooster(new ShieldBooster("Escudo2", 3.5f ,4));
        st.mountShieldBooster(0);
        st.receiveShieldBooster(new ShieldBooster("Escudo3", 3.5f ,4));
        st.mountShieldBooster(0);
        st.receiveShieldBooster(new ShieldBooster("Escudo4", 3.5f ,4));
        st.mountShieldBooster(0);
        
        System.out.println(d.adjust(st.getWeapons(),st.getShieldBoosters()));
    }
}
