package Test;

import com.mycompany.useless.box.SpeedyRectangle.PlayerRectangle;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the rectangle that is controlled by the player.
 * @author marti
 */
public class PlayerRectangleTest {
    
    public PlayerRectangle SRtest;
    
    /**
     * Setup a new Player Rectangle
     */
    @BeforeEach
    public void setUp() {
        SRtest = new PlayerRectangle();
        assertNotNull(SRtest);
        assertFalse(SRtest.getLeft());
        assertFalse(SRtest.getRight());
        assertFalse(SRtest.getUp());
        assertFalse(SRtest.getDown());
    }
    
    /**
     * Cull new Player Rectangle
     */
    @AfterEach
    public void tearDown(){
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
        assertEquals(SRtest.getWidth(), 200);
        assertEquals(SRtest.getHeight(), 100);
        assertEquals(SRtest.getArcWidth(), 20);
        assertEquals(SRtest.getArcHeight(), 20);
        assertEquals(SRtest.getFill(), Color.BLUE);
    }
    
}
