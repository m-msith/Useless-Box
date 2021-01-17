/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uselessbox;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * UselessBox is a simple game built by Martin Smith using vanilla JavaFX
 * @author Martin J Smith
 */
public class UselessBox extends Application {
    
    /* The static copy of the primary stage */
    private static Stage PrimStage;
    
    /**
    *
    * Want to set up the main scenes that the game uses when the
    * program loads
    *
    * @param primaryStage is the main window of the program
    **/
    @Override
    public void start(Stage primaryStage) {
        
        PrimStage = primaryStage;
        
        ConstantScene ub_mm = MainMenu.GetMainMenu();
        MainGame.GetMainGame();
        
        /* The first display shall be the main menu */ 
        PrimStage.setTitle("Useless Box!");
        PrimStage.setScene(ub_mm.GetVisibleScene());
        PrimStage.show();
    }
        
    /**    
     * Allow the program to easily access the main stage at any given point (for now).
     * 
     * TODO: Make this into a dedicated setmainstage function to hide details maybe
     * 
     * @return the main window of the program, used to switch between different program scenes
     */
    public static Stage GetPrimaryStage(){
        return PrimStage;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
