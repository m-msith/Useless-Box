package com.mycompany.useless.box;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    /* The static copy of the primary stage */
    private static Stage PrimStage;
    
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        PrimStage = stage;
        
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
    
    public static void main(String[] args) {
        launch();
    }

}