/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.useless.box;

import com.mycompany.useless.box.SpeedyRectangle.ComputerRectangle;
import com.mycompany.useless.box.SpeedyRectangle.PlayerRectangle;
import java.util.Timer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This is where the fun begins, aka, the core object that houses the game itself
 * @author martin
 */
class GameLevel extends ConstantScene{

    /* Window */
    private final Scene MG;    
    
    /* Timer for AI and Game events */
    private Timer Game_Timer;
    
    /* User and Computer characters in a level */
    private final ComputerRectangle Computer_Box;
    private final PlayerRectangle Player_Box;
    
    /* Here's where the meat and potatoes of the program is setup*/
    public GameLevel(){
        
        Group groot = new Group();  
        
        /* Instance player and computer */
        Computer_Box = new ComputerRectangle();
        Player_Box = new PlayerRectangle();
        
        groot.getChildren().add(Player_Box);
        groot.getChildren().add(Computer_Box);
        
        MG = new Scene(groot, 300, 250);
        
        MG.setOnKeyPressed((KeyEvent kp) ->{
            
            if(kp.getCode() == KeyCode.ESCAPE){
                App.GetPrimaryStage().setScene(MainMenu.GetMainMenu().GetVisibleScene());
                this.StopAI();
            }
            
            if(kp.getCode() == KeyCode.RIGHT){
                Player_Box.setRight(true);
            }
            if(kp.getCode() == KeyCode.LEFT){
                Player_Box.setLeft(true);
            }
            if(kp.getCode() == KeyCode.UP){
                Player_Box.setUp(true);
            }
            if(kp.getCode() == KeyCode.DOWN){
                Player_Box.setDown(true);
            }
            
            Player_Box.updatePosition();
        });
        
        MG.setOnKeyReleased((KeyEvent kp) -> {            
            
            if(kp.getCode() == KeyCode.RIGHT){
                Player_Box.setRight(false);
            }
            if(kp.getCode() == KeyCode.LEFT){
                Player_Box.setLeft(false);
            }
            if(kp.getCode() == KeyCode.UP){
                Player_Box.setUp(false);
            }
            if(kp.getCode() == KeyCode.DOWN){
                Player_Box.setDown(false);
            }
            
        
        });
        
        
    }
    
    /**
     * Access the GameStage's scene
     * @return the scene of the GameStage
     */
    @Override
    public Scene GetVisibleScene() {        
        StartAI();
        return MG;
    }
    
    /**
     * Create a new timer, schedule any AI tasks. If the AI hasn't been 
     * stopped, call the stop method before creating the new timer and 
     * task scheduling.
     */
    private void StartAI(){
        Game_Timer = new Timer();
        Game_Timer.scheduleAtFixedRate(Computer_Box.StartAI(), 0, 250);
    }
    
    /**
     * Cancel the timer's tasks as well as clobbering the instance so that 
     * it may be started fresh.
     */
    private void StopAI(){
        Computer_Box.StopAI();
        Game_Timer.cancel();
        Game_Timer = null;
    }
    
}
