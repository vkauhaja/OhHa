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
        
   
    
    public Rivi(){
        int a = 0;
        this.leveys = 4;
        this.rivi = new ArrayList<Integer>();
        Random arpoja = new Random();
        for (int i = 0; i < this.leveys; i++) {
            a = arpoja.nextInt(6);
            this.rivi.add(a);
        }
       
    }
    
    public Rivi (int p0, int p1, int p2, int p3) {
       this.rivi = new ArrayList<Integer>();
       this.rivi.add(p0);
       this.rivi.add(p1);
       this.rivi.add(p2);
       this.rivi.add(p3);
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
