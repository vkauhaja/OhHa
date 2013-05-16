/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.Random;

/**
 *
 * @author vkauhaja
 */
public class Rivi {
    private int leveys;
    private int paikka0;
    private int paikka1;
    private int paikka2;
    private int paikka3;
    private int paikka4;
    private int paikka5;
    private int paikka6;
    private int paikka7;
    
   
    
    public Rivi(){
        this.leveys = 4;
        Random arpoja = new Random();
        paikka0 = arpoja.nextInt(5);
        paikka1 = arpoja.nextInt(5);
        paikka2 = arpoja.nextInt(5);
        paikka3 = arpoja.nextInt(5);
    }
    
    public Rivi (int paikka0, int paikka1, int paikka2, int paikka3) {
        this.paikka0 = paikka0;
        this.paikka1 = paikka1;
        this.paikka2 = paikka2;
        this.paikka3 = paikka3;
    }
    public String toString(){
        return this.paikka0 + " " + this.paikka1 + " " + this.paikka2 + " " + this.paikka3;
    }
}
