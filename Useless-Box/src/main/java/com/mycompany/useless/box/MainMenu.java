package com.mycompany.useless.box;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 *
 * MainMenu is the landing scene for the user, it allows the game to be played
 * and for the program to be exited.
 * 
 * @author martin
 */
public class MainMenu extends ConstantScene{
    
    /* There is only one main stage */
    private static MainMenu MM_INST = null;
    private final Scene MM;
    private GameLevel CurrentLevel;
    
    /**
     * Create the MainMenu object that allows the user to start the game or to
     * exit the game.
     */
    private MainMenu(){
        
        StackPane root = new StackPane();        
        
        /* Start Game */
        Button startBtn = new Button();
        startBtn.setText("PLAY");
        startBtn.setOnAction((ActionEvent event) -> {
            /* Start the Game by setting the main game stage, or continue if 
            it exists */
            if(CurrentLevel == null){
                CurrentLevel = new GameLevel();
            }else{
                App.GetPrimaryStage().setScene(CurrentLevel.GetVisibleScene());
            }
            
        });
        
        /* Exit Game */
        Button exitBtn = new Button();
        exitBtn.setText("EXIT");
        exitBtn.setOnAction((ActionEvent event) -> {
            App.GetPrimaryStage().close();
        });
        
        root.getChildren().add(exitBtn);        
        root.getChildren().add(startBtn);
        StackPane.setAlignment(startBtn, Pos.CENTER);
        StackPane.setAlignment(exitBtn, Pos.BOTTOM_CENTER);
        
        MM = new Scene(root, 300, 250);
    }
    
    /**
     * The getter that is responsible for instancing the MainMenu object.
     * @return the MainMenu object
     */
    public static ConstantScene GetMainMenu(){        
        
        if(MM_INST == null){
            MM_INST = new MainMenu();            
        }
                       
        return MM_INST;
    }
    
    /**
     * The way to access the MainMenu Scene
     * @return the scene of the MainMenu 
     */
    @Override
    public Scene GetVisibleScene() {
        return MM;
    }

}
