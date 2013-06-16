/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import mastermind.grafiikka.Grafiikka;
import mastermind.attribuutit.Attribuutit;
import java.util.Scanner;

/**
 *
 * @author vkauhaja
 */
public class Mastermind {
    
    /**
     * Hyvin riisuttu Main. Ensin luodaan koko ohjelman ainoa lukija, sitten kysytään attribuutit, ja luodaan peli. Lisäksi mainissa luonnollisesti käynnistetään peli.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lukija = new Scanner(System.in);
        System.out.println("Tervetuloa pelaamaan Mastermindia.");
        Attribuutit attribuutit = new Attribuutit(lukija);
        Tekstikayttoliittyma uusiPeli = new Tekstikayttoliittyma(attribuutit.getYritystenMaara(), attribuutit.getRivinPituus(), attribuutit.getVaihtoEhtojenMaara(), attribuutit.getVaikeusaste(), lukija);
        
        uusiPeli.pelaa();
        
    }
   
}