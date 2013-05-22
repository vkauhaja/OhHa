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
    private int leveys;
    private int varienmaara;
    private List<Rivi> peli;
    private Rivi arvottu;
    
    public Pelilauta(int varienmaara, int leveys) {
        this.arvottu = new Rivi(leveys, varienmaara);
        this.rivit = rivit;
        this.varienmaara = varienmaara;
        this.peli = new ArrayList<Rivi>();
    }
    
    public String toString(){
        String palautus = "";
        for(Rivi s: this.peli) {
            palautus = palautus + s.toString() + " \n";
        }
        
        palautus = palautus + this.arvottu.toString();
        return palautus;
    }
    
    public String arvottuRivi(){
        return this.arvottu.toString();
    }
    
    public void lisaaRivi(String syote) {
        Rivi uusi = new Rivi(syote);
        this.peli.add(uusi);
    }
    
    
}
