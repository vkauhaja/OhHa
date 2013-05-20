/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vkauhaja
 */
public class Pelilauta {
    private int rivit;
    private int nappulat;
    private List<ArrayList<Integer>> peli;
    private Rivi arvottu;
    
    public Pelilauta(int rivit, int nappulat) {
        this.rivit = rivit;
        this.nappulat = nappulat;
        this.peli = new ArrayList<ArrayList<Integer>>();
        
        this.arvottu = new Rivi();
    }
    public String toString(){
        String palautus = "";
        for (ArrayList<Integer> s: this.peli) {
            palautus = palautus + s;
            
        }
        palautus = palautus + this.arvottu.toString();
        return palautus;
    }
    public String arvottuRivi(){
        return this.arvottu.toString();
    }
    public void lisaaRivi(ArrayList<Integer> uusiRivi) {
        this.peli.add(uusiRivi);
    }
    
    
}
