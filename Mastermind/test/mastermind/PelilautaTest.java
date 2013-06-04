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
public class PelilautaTest {
    
    public PelilautaTest() {
    }
    Pelilauta pelilauta;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelilauta = new Pelilauta(6, 4, 1);
    }
    
    @After
    public void tearDown() {
    }

   

    @Test
    public void testArvottuRivi() {
        
    }

   
    @Test
    public void testLisaaRivi() {
       
    }
    @Test
    public void testTulokset1(){
        String testi = pelilauta.arvottuRivi();
        assertEquals("40" ,pelilauta.tulokset(testi));
    }
    public void testTulokset2(){
        String testi = pelilauta.satunnainen();
        assertFalse(pelilauta.tulokset(testi).contains("5"));
    }
    public void testTulokset3(){
        String testi = pelilauta.satunnainen();
        assertTrue(pelilauta.tulokset(testi).length() == 2);
    }
}
