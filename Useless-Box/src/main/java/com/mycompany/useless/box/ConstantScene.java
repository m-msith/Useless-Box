/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.useless.box;

import javafx.scene.Scene;

/**
 * This class provides information hiding for main scenes. A main scene should only
 * ever be able to communicate the built scene to the world and nothing else of its
 * inner-workings
 * 
 * @author martin
 */
public abstract class ConstantScene {
            
    /**
     * TODO: consider making this a set function where it sets the stage in order to
     * hide the object.
     * 
     * @return a scene that a stage can be set too
     */
    public abstract Scene GetVisibleScene();
}
