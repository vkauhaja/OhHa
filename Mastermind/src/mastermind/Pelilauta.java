/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import java.util.List;

/**
 * Tässä luokassa luodaan pelilauta, joka on lista rivejä. Luokassa on myös vertailumetodi, joka palauttaa tuloksen, kuinka hyvin käyttäjän antama rivi osui oikeaan. 
 * @author vkauhaja
 */
public class Pelilauta {
    private int rivit;
    private int pituus;
    private int vaihtoehtojenmaara;
    private List<Rivi> peli;
    private Rivi arvottu;
    private int vaikeusaste;
    /**
     * Luokan konstruktori. Saa attribuutteina pelilaudan leveyden, eli yhden rivin sisältämien alkioden määrän, vaikeusasteen ja vaihtoehtojen määrän. Luo siis listan riveistä attribuuttien mukaan
     * @param vaihtoehtojenmaara eri vaihtoehtojen määrä
     * @param pituus rivin pituus, 
     * @param vaikeusaste käyttäjän haluama vaikeusaste
     */
    public Pelilauta(int vaihtoehtojenmaara, int pituus, int vaikeusaste) {
        this.arvottu = new Rivi(pituus, vaihtoehtojenmaara, vaikeusaste);
        this.vaihtoehtojenmaara = vaihtoehtojenmaara;
        this.peli = new ArrayList<Rivi>();
        this.pituus = pituus;
        this.vaikeusaste = vaikeusaste;
    }
    /**
     * Koko pelin, siis kaikki käyttäjän syöttämät rivit + arvottu rivi palauttava metodi. Tällä hetkellä ei missään käytössä, mutta hyödyllinen testikäyttöön, tahi jos haluaa koko pelin tulostusta pelin jälkeen. 
     * @return 
     */
    public String toString(){
        String palautus = "";
        for(Rivi s: this.peli) {
            palautus = palautus + s.toString() + " \n";
        }
        
        palautus = palautus + this.arvottu.toString();
        return palautus;
    }
   
   
   /**
    * Metodi puhtaasti testikäyttöön, tällä metodilla luodaan satunnainen rivi pelilaudan attribuuttien mukaan.
    * @return 
    */
    public String satunnainen(){
        Rivi satunnainen = new Rivi(this.pituus, this.vaihtoehtojenmaara, this.vaikeusaste);
        return satunnainen.toString();
    }
    /**
     * Metodi pelin rivien määrän testausta varten
     * @return 
     */
    public int koko(){
        return this.peli.size();
    }
    /**
     * Tämä metodi lisää pelilautaan käyttäjän syöttämän rivin
     * @param syote käyttäjän veikkaus oikeaksi riviksi
     */
    public void lisaaRivi(String syote) {
        Rivi uusi = new Rivi(syote);
        this.peli.add(uusi);
    }
    /**
     * Metodi joka palauttaa arvotun rivin rivi-muodossa
     * @return 
     */
    public Rivi arvottuRiviR(){
        return this.arvottu;
    }
    /**
     * Pelilogiikan sydän, tarkistusmetodi. Tämä metodi tarkistaa käyttäjän antaman rivin, ja vertaa sitä arvottuun riviin. Metodi palauttaa String-muodossa 2 inttiä, jotka kertovat informaation peli-luokassa.
     * @param syote käyttäjän syöttämä rivi
     * @return 
     */
    public String tulokset(String syote){
        int arvo1 = 0;
        int arvo2 = 0;
        Rivi a = new Rivi(syote);
        Rivi b = new Rivi(this.arvottu.toString());
        int k = this.pituus;
        for (int i = (this.pituus-1); i >= 0 ; i--) {
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
    /**
     * Arvotun rivin stringginä palauttava metodi. 
     * @return 
     */
    public String arvottu(){
        return this.arvottu.toString();
    }
    
    
}
