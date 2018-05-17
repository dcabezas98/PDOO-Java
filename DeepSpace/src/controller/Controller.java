/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.MainView;
import java.util.ArrayList;
import deepspace.GameUniverse;
import deepspace.GameUniverseToUI;
import deepspace.CombatResult;
import deepspace.GameState;

/**
 *
 * @author David Cabezas Berrido
 * @author Patricia Córdoba Hidalgo
 */
public class Controller {
    
    private GameUniverse gameUniverse;
    private MainView view;
    
    public Controller(GameUniverse gU, MainView v) {
        gameUniverse = gU;
        view = v;
        view.setController(this);
    }
    
    public void finish(int i) {
        if (view.confirmExitMessage())
            System.exit(i);
    }
    
    public void start(){
        gameUniverse.init(view.getNames());
        view.updateView();
        view.showView();
    }
    
    public GameUniverseToUI getGameUniverseToUI(){
        return gameUniverse.getUIversion();
    }
    
    public boolean nextTurn() {
        boolean result = gameUniverse.nextTurn();
        view.updateView();
        return result;
    }
    
    public CombatResult combat() {
        CombatResult result = gameUniverse.combat();
        view.updateView();
        return result;
    }
    
    public GameState getState() {
        return gameUniverse.getState();
    }
    
    //
    
    
}
