/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vkauhaja
 */
public class PeliTest {
    
    public PeliTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Peli.
     */
    
    
    @Test
    public void loppuukoPeli() {
        Peli testi = new Peli();
        
        assertEquals(true, testi.loppuikoYritykset(11));
        System.out.println("");
    }
}
