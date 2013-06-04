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
public class RiviTest {
    
    public RiviTest() {
    }
    Rivi rivi1;
    Rivi rivi2;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rivi1 = new Rivi(4,6,1);
        rivi2 = new Rivi(4,6,1);
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testToString1() {
       assertTrue(rivi1.toString().length() == 4);
    }
    @Test
    public void testToString2() {
       assertFalse(rivi1.toString().contains("6"));
    }
    @Test
    public void testPoista(){
        rivi2.poista(0);
        assertTrue(rivi2.toString().length() == 3);
    }
}
