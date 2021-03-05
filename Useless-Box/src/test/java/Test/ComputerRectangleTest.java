package Test;

import com.mycompany.useless.box.SpeedyRectangle.ComputerRectangle;
import static java.lang.Math.abs;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the functionality of the ComputerRectangle and it's controlling AI 
 * @author martin
 */
public class ComputerRectangleTest {
    
    public ComputerRectangle SRtest;
    
    /**
     * Setup a new Computer Rectangle
     */
    @BeforeEach
    public void setUp() {
        SRtest = new ComputerRectangle();
        assertNotNull(SRtest);
        assertNotNull(SRtest.getAI());
        assertFalse(SRtest.getLeft());
        assertFalse(SRtest.getRight());
        assertFalse(SRtest.getUp());
        assertFalse(SRtest.getDown());
    }
    
    /**
     * Destroy created Computer Rectangle
    */
    @AfterEach
    public void tearDown() {
        SRtest = null;
        assertNull(SRtest);
    }
    
    /**
     * Make sure we init with the right values
     */
    @Test
    public void testInitValues(){
        assertEquals(SRtest.getX(), 50);
        assertEquals(SRtest.getY(), 50);
        assertEquals(SRtest.getWidth(), 100);
        assertEquals(SRtest.getHeight(), 50);
        assertEquals(SRtest.getArcWidth(), 20);
        assertEquals(SRtest.getArcHeight(), 20);
        assertEquals(SRtest.getFill(), Color.RED);
    }
    
    /**
     * Ensure that the stopAI command cancels and sets the AI to null
     */
    @Test
    public void testStopAI(){
        
        SRtest.StopAI();
        assertNull(SRtest.getAI());
        
    }
    
    /**
     * Ensure that the start AI will return an AI even if it was stopped/null
     */
    @Test
    public void testStartAI(){
        
        SRtest.StopAI();
        assertNull(SRtest.getAI());
        assertNotNull(SRtest.StartAI());
        assertNotNull(SRtest.getAI());
        
    }
    
    /**
     * Ensure that the AI run command changes the position of the computer 
     * rectangle one iteration
     */
    @Test
    public void testRunAI(){
        
        double origX = SRtest.getX();
        double origY = SRtest.getY();
        SRtest.getAI().run();
        double sumChange = abs(origX - SRtest.getX());
        sumChange += abs(origY - SRtest.getY());
        
        assertEquals(sumChange, 2);
    }
    
    
}
