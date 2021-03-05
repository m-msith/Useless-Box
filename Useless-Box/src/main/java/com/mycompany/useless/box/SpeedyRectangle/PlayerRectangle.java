package com.mycompany.useless.box.SpeedyRectangle;

import javafx.scene.paint.Color;

/**
 * The Player Rectangle is the one that is controlled by the user via keyboard
 * commands
 * @author martin
 */
public class PlayerRectangle extends SpeedyRectangle{
    
    public PlayerRectangle(){
        super();
        this.setX(50);
        this.setY(50);
        this.setWidth(200);
        this.setHeight(100);
        this.setArcWidth(20);
        this.setArcHeight(20);
        this.setFill(Color.BLUE);
    }
    
}
