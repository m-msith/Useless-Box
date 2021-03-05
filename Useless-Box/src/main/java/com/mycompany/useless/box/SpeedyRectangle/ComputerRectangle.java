package com.mycompany.useless.box.SpeedyRectangle;

import java.util.TimerTask;
import javafx.scene.paint.Color;

/**
 * A computer rectangle will have an AI that is responsible for moving it 
 * around and altering its form . It will be smaller than the player rectangle,
 * and will show up in front of the user rectangle, as well as be red.
 * 
 * @author martin
 */
public class ComputerRectangle extends SpeedyRectangle{
    
    /* Computer has an AI, tightly coupled because the AI is the 
    computer rectangle, but, must extend timer task; TODO: may break this 
    apart later, for now it's good enough*/
    private ComputerRectangleAction AI;
    
    /* Create the Computer Rectangle, which is a SpeedyRectangle, but 
    one that is controlled by an AI */
    public ComputerRectangle(){
        
        super();
        this.setFill(Color.RED);
        this.setX(50);
        this.setY(50);
        this.setWidth(100);
        this.setHeight(50);
        this.setArcWidth(20);
        this.setArcHeight(20);
        
        /* Tightly couple the AI to the Speedy Rectangle */
        AI = new ComputerRectangleAction(this);
    }
    
    /**
     * Start the processing task for the rectangle, if it doesn't
     * exist, create it.
     * @return the TimerTask for the AI
     */
    public TimerTask StartAI(){  
        if(AI == null){
            AI = new ComputerRectangleAction(this);
        }
        return AI;
    }
    
    /**
     * Stop processing the AI's behavior and clobber the stopped task.
     */
    public void StopAI(){
        AI.cancel();
        AI = null;
    }
    
    /**
     * Stop processing the AI's behavior and clobber the stopped task.
     * @return the timer task
     */
    public TimerTask getAI(){
        return AI;
    }

    /**
     * The Computer Rectangle Action is only used by the Computer rectangle 
     * and is responsible for the actions of the Computer rectangle as it 
     * is not player controlled.
     */
    private class ComputerRectangleAction extends TimerTask{

        /* Tightly coupled to the ComputerRectangle, as the Action is a 
        further extention of the class. */
        private final SpeedyRectangle SR;
        
        /**
         * In order to affect the rectangle, it must have a reference to 
         * the rectangle
         * @param sr the rectangle that belongs to the AI
         */
        public ComputerRectangleAction(SpeedyRectangle sr) {
            SR = sr;            
        }

        /**
         * Every iteration, choose a random direction and move in that 
         * way.
         */
        @Override
        public void run() {
            
            int dir = (int) (Math.random() * 10);
            dir %= 4;
            
            switch(dir){

                case 0:
                    SR.setRight(true);
                    SR.setUp(false);
                    break;
                case 1:
                    SR.setLeft(true);
                    SR.setDown(false);
                    break;
                case 2:
                    SR.setUp(true);
                    SR.setLeft(false);
                    break;
                case 3:
                    SR.setRight(false);
                    SR.setDown(true);
                    break;
                default:
                    break;
            }
            
            SR.updatePosition();
        }
    }
     
}
