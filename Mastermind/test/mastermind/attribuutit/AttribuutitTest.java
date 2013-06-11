/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.attribuutit;

import mastermind.attribuutit.Attribuutit;
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
public class AttribuutitTest {
    
    public AttribuutitTest() {
    }
    Attribuutit att;
    Scanner lukija;
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        att = new Attribuutit();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testOikeitaArvoja1(){
        assertFalse(att.syotteessaOikeitaArvoja("20", 1, 1));
    }@Test
    public void testOikeitaArvoja2(){
        assertTrue(att.syotteessaOikeitaArvoja("10", 1, 111));
    }@Test
    public void testOikeitaArvoja3(){
        assertTrue(att.syotteessaOikeitaArvoja("1", 1, 1));
    }@Test
    public void testOikeitaArvoja4(){
        assertFalse(att.syotteessaOikeitaArvoja("11", 1, 10));
    }@Test
    public void testOikeitaArvoja5(){
        assertTrue(att.syotteessaOikeitaArvoja("19", 1, 20));
    }@Test
    public void testOikeitaArvoja6(){
        assertFalse(att.syotteessaOikeitaArvoja("-2", 1, 10));
    }@Test
    public void testOikeitaArvoja7(){
        assertTrue(att.syotteessaOikeitaArvoja("2", 1, 5));
    }@Test
    public void testOikeitaArvoja8(){
        assertFalse(att.syotteessaOikeitaArvoja("200", 1, 20));
    }
    @Test 
    public void oikeitaMerkkejä1(){
        assertTrue(att.syotteenMerkitOikein("1234"));
    }
     @Test 
    public void oikeitaMerkkejä2(){
        assertFalse(att.syotteenMerkitOikein("lol1234"));
    } @Test 
    public void oikeitaMerkkejä3(){
        assertTrue(att.syotteenMerkitOikein("12322224"));
    } @Test 
    public void oikeitaMerkkejä4(){
        assertFalse(att.syotteenMerkitOikein("yksi"));
    } @Test 
    public void oikeitaMerkkejä5(){
        assertTrue(att.syotteenMerkitOikein("123994"));
    } @Test 
    public void oikeitaMerkkejä6(){
        assertFalse(att.syotteenMerkitOikein("LOLOMG"));
    } @Test 
    public void oikeitaMerkkejä7(){
        assertTrue(att.syotteenMerkitOikein("12314"));
    } @Test 
    public void oikeitaMerkkejä8(){
        assertFalse(att.syotteenMerkitOikein("12jj34"));
    } @Test 
    public void oikeitaMerkkejä9(){
        assertTrue(att.syotteenMerkitOikein("122543634"));
    }
    @Test
    public void pituus1(){
        assertTrue(att.syotteenPituusOikein("lol", 1, 3));
    }
     @Test
    public void pituus2(){
        assertFalse(att.syotteenPituusOikein("gangbang", 7, 3));
    } @Test
    public void pituus3(){
        assertTrue(att.syotteenPituusOikein("ja", 0, 2));
    } @Test
    public void pituus4(){
        assertFalse(att.syotteenPituusOikein("lol", 1, 1));
    } @Test
    public void pituus5(){
        assertTrue(att.syotteenPituusOikein("dilledong", 9, 3));
    } @Test
    public void pituus6(){
        assertFalse(att.syotteenPituusOikein("lol", 1, 2));
    }
    @Test
    public void testKorrekti1(){
        assertTrue(att.syoteKorrekti("20", 1, 2, 1, 20));
    }
     @Test
    public void testKorrekti2(){
        assertFalse(att.syoteKorrekti("0", 1, 2, 1, 20));
    } @Test
    public void testKorrekti3(){
        assertFalse(att.syoteKorrekti("20", 1, 1, 1, 20));
    } @Test
    public void testKorrekti4(){
        assertFalse(att.syoteKorrekti("20", 1, 2, 1, 10));
    }
}
