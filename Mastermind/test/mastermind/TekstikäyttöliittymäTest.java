/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
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
public class TekstikäyttöliittymäTest {
    
    public TekstikäyttöliittymäTest() {
    }
    Scanner lukija;
    Tekstikäyttöliittymä peli;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @Before
    public void setUp() {
       // ByteArrayInputStream bais = new ByteArrayInputStream("1\n".getBytes());
       // InputStream old = System.in;
       // System.setIn(bais);
       peli = new Tekstikäyttöliittymä(2, 4, 6, 1, lukija);
       // System.setIn(old);
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testLoppuikoYritykset1() {
        // ByteArrayInputStream bais = new ByteArrayInputStream("1\n".getBytes());
        // InputStream old = System.in;
        // System.setIn(bais);
        boolean expResult = true;
        boolean result = this.peli.loppuikoYritykset(3);
        assertEquals(expResult, result);
        // System.setIn(old);
    }
     @Test
    public void testLoppuikoYritykset2() {
        boolean expResult = false;
        boolean result = this.peli.loppuikoYritykset(0);
        assertEquals(expResult, result);
    }
     @Test
    public void testLoppuikoYritykset3() {
        boolean expResult = false;
        boolean result = this.peli.loppuikoYritykset(1);
        assertEquals(expResult, result);
    }
   
    @Test
    public void testSyoteKorrekti1() {
        String testi = "lol";
        boolean expResult = false;
        boolean result = peli.syoteKorrekti(testi);
        assertEquals(expResult, result);
    }
    @Test
    public void testSyoteKorrekti2() {
        String testi = "1234";
        boolean expResult = true;
        boolean result = peli.syoteKorrekti(testi);
        assertEquals(expResult, result);
    }
    @Test
    public void testSyoteKorrekti3() {
        String testi = "1237";
        boolean expResult = false;
        boolean result = peli.syoteKorrekti(testi);
        assertEquals(expResult, result);
    }

   
    @Test
    public void testSyotteenPituus1() {
       String testi = "1234";
       boolean expResult = true;
       boolean result = peli.syotteenPituus(testi);
       assertEquals(expResult, result);
    }
    @Test
    public void testSyotteenPituus2() {
       String testi = "134";
       boolean expResult = false;
       boolean result = peli.syotteenPituus(testi);
       assertEquals(expResult, result);
    }
    @Test
    public void testSyotteenPituus3() {
       String testi = "123422";
       boolean expResult = false;
       boolean result = peli.syotteenPituus(testi);
       assertEquals(expResult, result);
    }

   
    @Test
    public void testSyotteenMerkit1() {
       String testi = "1234";
       boolean expResult = true;
       boolean result = peli.syotteenMerkit(testi);
       assertEquals(expResult, result);
    }
    @Test
    public void testSyotteenMerkit2() {
       String testi = "lol4";
       boolean expResult = false;
       boolean result = peli.syotteenMerkit(testi);
       assertEquals(expResult, result);
    }
    @Test
    public void testSyotteenMerkit3() {
       String testi = "12q4";
       boolean expResult = false;
       boolean result = peli.syotteenMerkit(testi);
       assertEquals(expResult, result);
    }

 
    @Test
    public void testOikeitaArvoja1() {
       String testi = "1234";
       boolean expResult = true;
       boolean result = peli.oikeitaArvoja(testi);
       assertEquals(expResult, result);
    }
     @Test
    public void testOikeitaArvoja2() {
       String testi = "1238";
       boolean expResult = false;
       boolean result = peli.oikeitaArvoja(testi);
       assertEquals(expResult, result);
    }
      @Test
    public void testOikeitaArvoja3() {
       String testi = "9399";
       boolean expResult = false;
       boolean result = peli.oikeitaArvoja(testi);
       assertEquals(expResult, result);
    }
      
      @Test
      public void testVoititko1(){
        String testi = peli.oikeaRivi();
        assertTrue(peli.voititko(testi));
      }
     @Test
     public void testLuovutitko1(){
         String testi = "luovutan";
         assertTrue(peli.luovutitko(testi));
     }
     @Test
     public void testLuovutitko2(){
         String testi = "Luovutan";
         assertTrue(peli.luovutitko(testi));
     }
     @Test
     public void testLuovutitko3(){
         String testi = "luovutan.";
         assertFalse(peli.luovutitko(testi));
     }
      @Test
     public void testLuovutitko4(){
         String testi = "lol";
         assertFalse(peli.luovutitko(testi));
     }
       @Test
     public void testLuovutitko5(){
         String testi = "Luovutan.";
         assertFalse(peli.luovutitko(testi));
     }
        @Test
     public void testLuovutitko6(){
         String testi = "1234";
         assertFalse(peli.luovutitko(testi));
     }
}
