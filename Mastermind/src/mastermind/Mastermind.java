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
        Scanner lukija = new Scanner(System.in);
        System.out.println("Tervetuloa pelaamaan Mastermindia.");
        Attribuutit attribuutit = new Attribuutit(lukija);
        Peli uusiPeli = new Peli(attribuutit.yritystenmaara(), attribuutit.rivi(), attribuutit.varit(), attribuutit.vaikeus(), lukija);
        uusiPeli.pelaa();
        
    }
   
}