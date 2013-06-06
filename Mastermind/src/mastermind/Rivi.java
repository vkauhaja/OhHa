/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Tämä luokka pyörittää rivi-olioita. Mastermind tunnetusti koostuu riveistä, jotka tässä tapauksessa ovat ArrayList<Integer>-muotoa.
 * @author vkauhaja
 */
public class Rivi {
    private int pituus;
    
    private ArrayList<Integer> rivi;
        
    /**
     * Arpoja-konstruktori. Tämä konstruktori arpoo rivin pelaajan antamien attribuuttien mukaan. "else"-kohta on helpotettu arpoja joka ei arvo kuin yhden numeron kerran kuhunkin riviin.
     * @param pituus yhden rivin pituus, käyttäjän antama attribuutti
     * @param varienmaara kuinka monta eri väri/numero-vaihtoehtoa kullakin numerolla on.
     * @param vaikeusaste käyttäjän antama vaikeusaste
     */
    
    public Rivi(int pituus, int vaihtoehtojenmaara, int vaikeusaste){
        int a = -1;
        this.pituus = pituus;
        this.rivi = new ArrayList<Integer>();
        Random arpoja = new Random();
        if(vaikeusaste == 1) {
            for (int i = 0; i < this.pituus; i++) {
                a = arpoja.nextInt(vaihtoehtojenmaara);
                this.rivi.add(a);
            }
        } else {
            for (int i = 0; i < this.pituus; i++) {
                a = arpoja.nextInt(vaihtoehtojenmaara);
                if (!this.rivi.contains(a)) {
                    this.rivi.add(a);
                } else {
                    i--;
                }
         }
        
        
        }   
       
    }
   
    
    /**
     * Tämä konstruktori luo uuden rivin käyttäjän antaman syötteen, eli arvaamansa rivin perusteella.
     * @param syote käyttäjän veikkaama rivi.
     */
    public Rivi (String syote) {
       this.rivi = new ArrayList<Integer>();
       int x = syote.length();
       int y = -1;
        for (int i = 0; i < x; i++) {
            y = Integer.parseInt(syote.charAt(i) + "");
            this.rivi.add(y);
        }
    }
    /**
     * toString, joka tuskin paljoa vaatii selittelyä. Palauttaa kysytyn rivin.
     * @return 
     */
    @Override
    public String toString(){
        String a = "";
        for (int i = 0; i < rivi.size(); i++) {
            a = a + this.rivi.get(i) + "";
        }
        return a;
    }
    /**
     * Palauttaa tarkistusmetodia varten tietyn alkion rivistä. 
     * @param indeksi tarkistusmetodin for-loopista syöttämä indeksi.
     * @return 
     */
    public int alkio(int indeksi){
        return this.rivi.get(indeksi);
    }
    /**
     * Tarkistusmetodi poistaa tarkistusrivistä "tärpänneet" alkiot. Tämä metodi suorittaa poiston.
     * @param indeksi tarkistusmetodin for-loopista syöttämä indeksi.
     */
    public void poista(int indeksi){
        this.rivi.remove(indeksi);
    }
    
    /**
     * Metodi joka tarkistaa sisältyykö arvottuun riviin joku tietty numero. for-loopin sisällä tarkastetaan kaikki alkiot jotka eivät osuneet yksi yhteen. Jos tarkastettavaan riviin sisältyy joku alkio x, se poistetaan arvotun rivin kloonista.
     * @param indeksi
     * @return 
     */
    public boolean sisaltyy(int indeksi){
        if (this.rivi.contains(indeksi)) {
            int x = this.rivi.indexOf(indeksi);
            this.rivi.remove(x);
            return true;
        }
        return false;
    }
    
}
