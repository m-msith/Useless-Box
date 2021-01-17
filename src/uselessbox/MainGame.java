/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uselessbox;

import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This is where the fun begins, aka, the core object that houses the game itself
 * @author martin
 */
class MainGame extends ConstantScene{

    /* Only ever want one instance of the game object */
    private static MainGame MG_INST = null;
    private final Scene MG;
    
    /* Here's where the meat and potatoes of the program is setup*/
    private MainGame(){
        
        Rectangle pad = new Rectangle();
        pad.setX(50);
        pad.setY(50);
        pad.setWidth(200);
        pad.setHeight(100);
        pad.setArcWidth(20);
        pad.setArcHeight(20);
        
        Group groot = new Group();  
        groot.getChildren().add(pad);
        
        MG = new Scene(groot, 300, 250);
        
        MG.setOnKeyPressed((KeyEvent kp) ->{
            
            System.out.println(kp.getCode());
            
            if(kp.getCode() == KeyCode.ESCAPE){
                UselessBox.GetPrimaryStage().setScene(MainMenu.GetMainMenu().GetVisibleScene());
            }
            
            if(kp.getCode() == KeyCode.RIGHT){
                pad.setX(pad.getX() + 2);
            }
            if(kp.getCode() == KeyCode.LEFT){
                pad.setX(pad.getX() - 2);
            }
            if(kp.getCode() == KeyCode.UP){
                pad.setY(pad.getY() - 2);
            }
            if(kp.getCode() == KeyCode.DOWN){
                pad.setY(pad.getY() + 2);
            }
            
        });
    }
    
    /**
     * Return or Instance and Return the only Game Object
     * @return the MainGame instance
     */
    public static ConstantScene GetMainGame() {
                
        if(MG_INST == null){
            MG_INST = new MainGame();
        }
        
        return MG_INST;
    }
    
    /**
     * Access the MainGame's scene
     * @return the scene of the MainGame
     */
    @Override
    public Scene GetVisibleScene() {
        return MG;
    }

    
}
