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
import deepspace.HangarToUI;

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
        if(!result)
            view.showNextTurnMessage();
        else
            view.updateView();
        return result;
    }
    
    public CombatResult combat() {
        CombatResult result = gameUniverse.combat();
        view.showResultMessage(result);
        view.updateView();
        return result;
    }
    
    public GameState getState() {
        return gameUniverse.getState();
    }
    
    public void updateView(){
        view.updateView();
    }
    
    public boolean haveAWinner() {
        return gameUniverse.haveAWinner();
    }
    
    public void discardItemsInHangar(ArrayList<Integer> selectedItems){
        HangarToUI h = gameUniverse.getUIversion().getCurrentStation().getHangar();
        if(h != null){
            int w = h.getWeapons().size();
            int pos;

            for(int i = selectedItems.size()-1; i>=0; i--){
                pos = selectedItems.get(i);
                if(pos < w)
                    gameUniverse.discardWeaponInHangar(pos);
                else   
                    gameUniverse.discardShieldBoosterInHangar(pos-w);
            }
        }
    }
    
    public void discardWeapons(ArrayList<Integer> selectedWeapons){
        
        for(int i = selectedWeapons.size()-1; i>=0; i--)
            gameUniverse.discardWeapon(selectedWeapons.get(i)); 
    }
    
    public void discardShieldBoosters(ArrayList<Integer> selectedShields){
        
        for(int i = selectedShields.size()-1; i>=0; i--)
            gameUniverse.discardShieldBooster(selectedShields.get(i)); 
    }
    
    public void discardHangar() {
        gameUniverse.discardHangar();
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
