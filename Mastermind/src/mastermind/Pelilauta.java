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
        this.varienmaara = varienmaara;
        this.peli = new ArrayList<Rivi>();
        this.leveys = leveys;
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
    public Rivi arvottuRiviR(){
        return this.arvottu;
    }
    public String tulokset(String syote){
        int arvo1 = 0;
        int arvo2 = 0;
        Rivi a = new Rivi(syote);
        Rivi b = new Rivi(this.arvottu.klooni());
        int k = this.leveys;
        for (int i = (this.leveys-1); i >= 0 ; i--) {
            if (a.alkio(i) == b.alkio(i)) {
                arvo1++;
                k--;
                a.poista(i);
                b.poista(i);
            }
        }
        for (int i = 0; i < k; i++) {
            if (b.sisaltyy(a.alkio(i))) {
                arvo2++;
            }
        }
        return (arvo1 + "" + arvo2);
    }
    public String arvottu(){
        return this.arvottu.toString();
    }
    
}
