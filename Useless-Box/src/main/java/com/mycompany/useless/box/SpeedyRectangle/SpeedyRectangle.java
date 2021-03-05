package com.mycompany.useless.box.SpeedyRectangle;
import javafx.scene.shape.Rectangle;

/**
 * The main unit in the game is a rectangle that moves based on 
 * a chosen direction. This class extends the rectangle class 
 * and provides a way to change its position in a unified 
 * way.
 * @author martin
 */
public abstract class SpeedyRectangle extends Rectangle {
        
    private boolean UP;
    private boolean DOWN;
    private boolean LEFT;
    private boolean RIGHT;
    
    /** Create the rectangle and set all movement controls to false */
    public SpeedyRectangle(){
        
        super();                
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
        
    }        
    
    /** Increment the position of the rectangle based on the 
    state of the directional control variables*/
    public void updatePosition(){
        
        if(RIGHT){
            this.setX(this.getX() + 2);
        }
        
        if(LEFT){
            this.setX(this.getX() - 2);
        }
        
        if(UP){
            this.setY(this.getY() - 2);
        }
        
        if(DOWN){
            this.setY(this.getY() + 2);
        }
        
    }
    
/* SETTERS */    
    
    /** Enable or disable the UP direction control which allows for
     * directional movement
     * @param stat true: enable, false: disable*/
    public void setUp(boolean stat){
        UP = stat;
    }
    
    /** Enable or disable the DOWN direction control which allows for
     * directional movement
     * @param stat true: enable, false: disable */
    public void setDown(boolean stat){
        DOWN = stat;
    }
    
    /** Enable or disable the LEFT direction control which allows for
     * directional movement
     * @param stat true: enable, false: disable */
    public void setLeft(boolean stat){
        LEFT = stat;
    }
    
    /** Enable or disable the RIGHT direction control which allows for
     * directional movement
     * @param stat true: enable, false: disable */
    public void setRight(boolean stat){
        RIGHT = stat;
    }
   
/* GETTERS */    
    
    /**
     * Get the current state of the UP directional control.
     * @return whether movement up is enabled
     */
    public boolean getUp(){
        return UP;
    }
    
    /**
     * Get the current state of the DOWN directional control.
     * @return whether movement down is enabled
     */
    public boolean getDown(){
        return DOWN;
    }
    
    /**
     * Get the current state of the LEFT directional control.
     * @return whether movement left is enabled
     */
    public boolean getLeft(){
        return LEFT;
    }
    
    /**
     * Get the current state of the RIGHT directional control.
     * @return whether movement right is enabled
     */
    public boolean getRight(){
        return RIGHT;
    }
}
