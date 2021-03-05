package Test;

import com.mycompany.useless.box.SpeedyRectangle.SpeedyRectangle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the abstract Speedy Rectangle class, makes sure to test 
 * the setting/getting of the directional controls and the update position
 * method
 * @author marti
 */
public class SpeedyRectangleTest {
    
    /* Create a concrete instance to test the abstract class*/
    private class TestRectangle extends SpeedyRectangle{}
    
    public SpeedyRectangle SRtest;
    
    /**
     * Create a test instance of the abstract class
     * ensure that the default values are set correctly
     */
    @BeforeEach
    public void setUp() {
        SRtest = new TestRectangle();
        assertNotNull(SRtest);
        assertFalse(SRtest.getLeft());
        assertFalse(SRtest.getRight());
        assertFalse(SRtest.getUp());
        assertFalse(SRtest.getDown());
    }
    
    /**
     * Clear the instance after every test to ensure 
     * nothing from previous runs bothers the current
     */
    @AfterEach
    public void tearDown() {
        SRtest = null;
        assertNull(SRtest);
    }

    /**
     * Ensure that the movement directions can be set to 
     * their appropriate values 
     */
    @Test
    public void testSetMovementDirs(){
        
        SRtest.setLeft(true);
        SRtest.setRight(true);
        SRtest.setUp(true);
        SRtest.setDown(true);
        
        assertTrue(SRtest.getLeft());
        assertTrue(SRtest.getRight());
        assertTrue(SRtest.getUp());
        assertTrue(SRtest.getDown());
        
        SRtest.setLeft(false);
        SRtest.setRight(false);
        SRtest.setUp(false);
        SRtest.setDown(false);
        
        assertFalse(SRtest.getLeft());
        assertFalse(SRtest.getRight());
        assertFalse(SRtest.getUp());
        assertFalse(SRtest.getDown());
        
    }
    
    /**
     * Test left movement
     */
    @Test
    public void testSetMovementLeft(){
    
        double Xlocation = SRtest.getX();
        SRtest.setLeft(true);
        SRtest.updatePosition();
        assertEquals(Xlocation, SRtest.getX() + 2);
        
    }
    
    /**
     * Test right movement
     */
    @Test
    public void testSetMovementRight(){
    
        double Xlocation = SRtest.getX();
        SRtest.setRight(true);
        SRtest.updatePosition();
        assertEquals(Xlocation, SRtest.getX() - 2);
        
    }
    
    /**
     * Test up movement
     */
    @Test
    public void testSetMovementUp(){
    
        double Ylocation = SRtest.getY();
        SRtest.setUp(true);
        SRtest.updatePosition();
        assertEquals(Ylocation, SRtest.getY() + 2);
        
    }
    
    /**
     * Test down movement
     */
    @Test
    public void testSetMovementDown(){
    
        double Ylocation = SRtest.getY();
        SRtest.setDown(true);
        SRtest.updatePosition();
        assertEquals(Ylocation, SRtest.getY() - 2);
        
    }
}
