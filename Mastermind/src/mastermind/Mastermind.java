/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.Scanner;

/**
 *
 * @author vkauhaja
 */
public class Mastermind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner llukija = new Scanner(System.in);
        System.out.println("Tervetuloa pelaamaan Mastermindia. Valitse kuinka monta yritystä haluat, kuinka monta arvattavaa numeroa on, sekä kuinka monta eri mahdollista numeroa on rivissä.");
        String maareet = llukija.nextLine();
        
        Peli uusiPeli = new Peli(10, 4, 6);
        uusiPeli.pelaa();
        
    }
    
}