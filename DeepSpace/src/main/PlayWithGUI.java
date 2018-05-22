/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import deepspace.GameUniverse;
import controller.Controller;
import GUI.MainView;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class PlayWithGUI {
    
    public static void main(String[] args) {
        
        GameUniverse gameUniverse = new GameUniverse();
        
        MainView view = new MainView();
        
        Controller controller = new Controller(gameUniverse, view);
        controller.start();
    }
}
