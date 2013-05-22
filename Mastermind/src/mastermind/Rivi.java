/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author vkauhaja
 */
public class Rivi {
    private int leveys;
    
    private ArrayList<Integer> rivi;
        
   
    
    public Rivi(int leveys, int varienmaara){
        int a = -1;
        this.leveys = leveys;
        this.rivi = new ArrayList<Integer>();
        Random arpoja = new Random();
        for (int i = 0; i < this.leveys; i++) {
            a = arpoja.nextInt(varienmaara);
            this.rivi.add(a);
        }
       
    }
    
    public Rivi (String syote) {
       this.rivi = new ArrayList<Integer>();
       int x = syote.length();
       int y = -1;
        for (int i = 0; i < x; i++) {
            y = Integer.parseInt(syote.charAt(i) + "");
            this.rivi.add(y);
        }
    }
    
    @Override
    public String toString(){
        String a = "";
        for (int i = 0; i < rivi.size(); i++) {
            a = a + this.rivi.get(i) + " ";
        }
        return a;
    }
    
    
}
