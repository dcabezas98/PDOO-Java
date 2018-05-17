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
    
    public void discardItemsInHangar(ArrayList<Integer> selectedItems){
        int w = gameUniverse.getUIversion().getCurrentStation().getHangar().getWeapons().size();
        int pos;
        
        for(int i = selectedItems.size()-1; i>=0; i--){
            pos = selectedItems.get(i);
            if(pos < w)
                gameUniverse.discardWeaponInHangar(pos);
            else   
                gameUniverse.discardShieldBoosterInHangar(pos-w);
        }
        
        view.updateView();
    }
    
    public void discardWeapons(ArrayList<Integer> selectedWeapons){
        
        for(int i = 0; i < selectedWeapons.size(); i++)
            gameUniverse.discardWeapon(selectedWeapons.get(i));
        
        view.updateView();
    }
    
    public void discardShieldBoosters(ArrayList<Integer> selectedShields){
        
        for(int i = 0; i < selectedShields.size(); i++)
            gameUniverse.discardShieldBooster(selectedShields.get(i));
        
        view.updateView();
    }
    
    public void mountItems(ArrayList<Integer> selectedItems){
        
        int w = gameUniverse.getUIversion().getCurrentStation().getHangar().getWeapons().size();
        int pos;
        
        for(int i = selectedItems.size()-1; i >= 0; i--){
            pos = selectedItems.get(i);
            if(pos < w)
                gameUniverse.mountWeapon(pos);
            else   
                gameUniverse.mountShieldBooster(pos-w);
        } 
        
        view.updateView();
    }
}
