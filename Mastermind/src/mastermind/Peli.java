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
public class Peli {
    private Pelilauta pelilauta;
    private int rivinpituus;
    private int rivienmaara;
    
    public Peli(){
        this.rivienmaara = 10;
        this.rivinpituus = 4;
        this.pelilauta = new Pelilauta(this.rivienmaara, this.rivinpituus);
        
        int i = 0;
        String syote = "";
        while (true) {
            i++;
            if (loppuikoYritykset(i)) {
                System.out.println("Hävisit pelin, oikea rivi oli " + this.pelilauta.arvottuRivi());
                break;
            }
            
            
            
            
        }
        
    }       
        
    
    @Override
    public String toString(){
        return this.pelilauta.toString();
    }
    public boolean loppuikoYritykset(int maara){
        if (maara <= 10) {
            return false;
            
        }
        return true;
    }
}
