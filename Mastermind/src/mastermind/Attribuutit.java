/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.Scanner;

/**
 * Tämä luokka kysyy itse pelin attribuutit pelaajalta. Pelissä on yhteensä 4 muuttujaa, ja kaikkiin voi näin pelaaja vaikuttaa.
 * @author vkauhaja
 */
public class Attribuutit {
    private Scanner lukija;
    private int vaikeusaste;
    private int rivinpituus;
    private int vaihtoehtojenmaara;
    private int yritystenmaara;
    /**
     * Konstruktori, joka saa parametrina koko ohjelman ainoan lukijan. Hyvin riisuttu konstruktori.
     * @param lukija 
     */
     public Attribuutit(Scanner lukija){
        this.lukija = lukija;
        this.rivinpituus = -1;
        this.vaikeusaste = -1;
        this.vaihtoehtojenmaara = -1;
        this.yritystenmaara = -1;
        kysy();
    }
    
    /**
     * Konstruktori testikäyttöä varten.
     */
    public Attribuutit() {
    }
    /**
     * kysy-metodi kysyy pelaajalta attribuutit. while-loop pyörii kunnes käyttäjä on syöttänyt oikeat arvot jokaiseen kohtaan. Sama pätee 4 eri kysymysmetodiin kysy-metodin sisällä. Huomaa myös metodiin sisältyvä tarkistuskysely, jos käyttäjä haluaisi helpossa pelissä rivin jonka pituus olisi n, mutta olisi vain n-1 eri vaihtoehtoa arvolla, peli vaatii uudet arvot.
     */
    private void kysy(){
        while (true) {
            this.vaikeusaste = vaikeusaste();
            this.yritystenmaara = yritystenMaara();
            this.rivinpituus = rivinPituus();
            this.vaihtoehtojenmaara = vaihtoehtojenMaara();
            if (this.vaikeusaste == 0 && this.vaihtoehtojenmaara < this.rivinpituus) {
                System.out.println("Helpotetussa versiossa eri numerovaihtoehtoja tulee olla vähintään rivin pituuden verran.");
            } else {
                break;
            }
        }
    }
    /**
     * Tämä metodi kysyy pelaajalta vaikeusasteen. Sama while-loop-tekniikka kuin edellä (ja 3 seuraavassa).
     * @return 
     */
     public int vaikeusaste(){
        int d = -1;
        while (true) {
            System.out.println("Valitse vaikeusaste (0 = helpotettu, jossa kukin arvo toistuu rivissä vain kerran, 1 = normaali).");
            String w = lukija.nextLine();
            if (syoteKorrekti(w, 1, 1, 0, 1)) {
                d = Integer.parseInt(w);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return d;
    }
     /**
      * Tämä metodi kysyy kuinka monta yritystä pelaajalla on.
      * @return 
      */
    public int yritystenMaara(){
        int a = 0;
        while (true) {
            System.out.println("Valitse kuinka monta yritystä haluat (1-20).");
            String x = lukija.nextLine();
            if (syoteKorrekti(x, 1, 2, 1, 20)) {
                a = Integer.parseInt(x);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return a;
    }
    /**
     * Tämä metodi kysyy käyttäjältä kuinka monta eri väri/numerovaihtoehtoa rivin kullakin jäsenellä on.
     * @return 
     */
    public int vaihtoehtojenMaara(){
       int b = 0;
        while (true) {
            System.out.println("Valitse kuinka monta mahdollista arvoa arvattavalla numerolla on (2-10),");
            String y = lukija.nextLine();
            if (syoteKorrekti(y, 1, 2, 2, 10)) {
                b = Integer.parseInt(y);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return b;
    }
    /**
     * Tämä kysyy taas kuinka pitkä yksi rivi on, kuinka monta tuntematonta rivissä on.
     * @return 
     */
    public int rivinPituus(){
        int c = 0;
        while (true) {
            System.out.println("Valitse kuinka monta numeroa yhdessä rivissä on (2-9).");
            String z = lukija.nextLine();
            if (syoteKorrekti(z, 1, 1, 2, 9)) {
                c = Integer.parseInt(z);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return c;
    }
    /**
     * Metodi jolla testataan onko käyttäjän antama syöte oikean sorttinen, pituus oikea, merkit oikeita ja onko oikeita arvoja.
     * @param syote käyttäjän antama syöte 
     * @param a syötteen pituuden alaraja
     * @param b syötteen pituuden yläraja
     * @param c syötteen arvojen alaraja
     * @param d syötteen arvojen yläraja
     * @return 
     */
    public boolean syoteKorrekti(String syote, int a, int b, int c, int d){
        if (!syotteenPituusOikein(syote, a, b)) {
            return false;
        }
        if (!syotteenMerkitOikein(syote)){
            return false;
        }
        if(!syotteessaOikeitaArvoja(syote, c, d)){
            return false;
        }
        return true;
    }
    
    
    
    /**
     * Tällä metodilla testataan onko käyttäjän antama syöte oikean mittainen. Käyttäjän antamat luvut ovat edellä väliltä 1-20, eli syötteen pituus on 1 tai 2 merkkiä.
     * @param syote käyttäjän antama testattava syöte.
     * @param a a ja b ovat mahdolliset arvot syötteelle. Niissä tapauksissa missä kelpaa vain 1-merkkinen syöte, a = b = 1. Jos kelpaa 2-merkkinen, a = 1 ja b = 2.
     * @param b Lue edellinen.
     * @return 
     */
    public boolean syotteenPituusOikein(String syote, int a, int b){
        if (syote.length() == a || syote.length() ==b) {
            return true;
        }
        return false;
    }
    /**
     * Tällä metodilla testataan onko käyttäjän antamassa syötteessä pelkkiä numeroita, sillä muut merkit eivät luonnollisesti kelpaa vastaukseksi kysymyksiin rivin pituudesta tai yritysten määrästä.
     * @param syote käyttäjän antama testattava syöte.
     * @return 
     */
    public boolean syotteenMerkitOikein(String syote){
        try {
            Integer.parseInt(syote);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    /**
     * Jokaisella parametrilla on rajattu haarukka mihin se saa asettua. Tällä metodilla testataan, että käyttäjän antama luku on oikeassa haarukassa.
     * @param syote käyttäjän antama syöte.
     * @param a haarukan alaraja
     * @param b haarukan yläraja
     * @return 
     */
    public boolean syotteessaOikeitaArvoja(String syote, int a, int b){
        int arvo = Integer.parseInt(syote);
        if (arvo < a || arvo > b){
            return false;
        }
        return true;
    }

    /**
     * Seuraavat 4 metodia palauttavat arvot itse pelin konstruktorille.
     * @return 
     */
    public int rivinPituusInt(){
        return this.rivinpituus;
    }
    public int vaihtoEhtojenMaaraInt(){
        return this.vaihtoehtojenmaara;
    }
    public int vaikeusasteInt(){
        return this.vaikeusaste;
    }
    public int yritystenMaaraInt(){
        return this.yritystenmaara;
    }
}
