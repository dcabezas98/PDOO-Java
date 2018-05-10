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
public class SpaceCity extends SpaceStation{
    
    private ArrayList<SpaceStation> collaborators;
    private SpaceStation base;
    
    SpaceCity(SpaceStation bas, ArrayList<SpaceStation> rest){
        super(bas);
        base = bas;
        collaborators = rest;
    }
    
    public ArrayList<SpaceStation> getCollaborators(){
        return collaborators;
    }
    
    @Override
    public SpaceCityToUI getUIversion(){
        return new SpaceCityToUI(this);
    }
    
    @Override
    public float fire(){
        int suma=0;
        
        for(int i=0; i<collaborators.size(); i++)
            suma+=collaborators.get(i).fire();
    
        return suma + super.fire();
    }
    
    @Override
    public float protection(){
        int suma=0;
        
        for(int i=0; i<collaborators.size(); i++)
            suma+=collaborators.get(i).protection();
    
        return suma + super.protection();
    }
    
    @Override
    public Transformation setLoot(Loot loot){
        super.setLoot(loot);
        
        return Transformation.NOTRANSFORM;
    }
}
