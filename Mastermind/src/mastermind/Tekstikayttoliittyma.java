/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tekstikäyttöliittymäluokka
 * @author vkauhaja
 */
public class Tekstikayttoliittyma {
    private Pelilauta pelilauta;
    private int pituus;
    private int rivienmaara;
    private int vaihtoehtojenmaara;
    private int vaikeusaste;
    private Scanner lukija;
    
    /**
     * Luokan konstruktori. Saa attribuuttina mm ohjelman ainoan scannerin
     * @param rivienmaara kuinka monta yritystä pelissä on
     * @param pituus rivin pituus
     * @param varienmaara vaihtoehtojen (numeroita tai värejä) määrä
     * @param vaikeusaste helpompi vai normaali peli
     * @param lukija scanner, joka periytyy mainista.
     */
    
    public Tekstikayttoliittyma(int rivienmaara, int pituus, int vaihtoehtojenmaara, int vaikeusaste, Scanner lukija){
        
        this.vaikeusaste = vaikeusaste;
        this.rivienmaara = rivienmaara;
        this.pituus = pituus;
        this.vaihtoehtojenmaara = vaihtoehtojenmaara;
        this.lukija = lukija;
        this.pelilauta = new Pelilauta(this.vaihtoehtojenmaara, this.pituus, this.vaikeusaste);
        
        
        
    }  
    /**
     * Pelimekaniikkaa pyörittävä tekstikäyttöliittymämetodi. Pelin sielu henki ja runko. while-loop pyörii kunnes pelaaja osuu oikeaan tai yritykset loppuvat. Jokaisen rivin jälkeen peli palauttaa tulokset. Metodissa on myös tarkistusmetodi joka varmistaa että käyttäjän antama rivi on oikeaa muotoa, ei vääriä numeroita tai liian paljon.
     */
    public void pelaa(){
        System.out.println("Peli alkaa. Yhdessä rivissä on " + this.pituus + " numeroa, numerot ovat väliltä 0-"+ (this.vaihtoehtojenmaara-1) + " ja sinulla on " + this.rivienmaara + " yritystä arvata oikea rivi. Komennolla \"Luovutan\" voit lopettaa pelin.");
        int i = 0;
       
        
        String syote = "";
        while (true) {
            i++;
            if (loppuikoYritykset(i)) {
                System.out.println("Hävisit pelin, oikea rivi oli " + this.pelilauta.arvottu());
                break;
            } 
            syote = lukija.nextLine();
            if (luovutitko(syote)){
                System.out.println("Luovutit pelin. Oikea rivi oli " + this.pelilauta.arvottu());
                break;
            }
            if (!syoteKorrekti(syote)) {
                System.out.println("Syöte on virheellinen!");
                i--;
            } else {
                this.pelilauta.lisaaRivi(syote);
                if (voititko(syote)) {
                    System.out.println("Onneksi olkoon, " + syote + " oli oikea rivi. Tarvitsit " + i + " yritystä päätelläksesi oikean rivin.");
                    break;
                }
                tulos(syote);
            }
            
            
        } 
    }
    /**
     * Metodi joka mahdollistaa luovuttamisen kesken pelin.
     * @param syote käyttäjän antama rivi
     * @return 
     */
    public boolean luovutitko(String syote){
        if (syote.equals("Luovutan") || syote.equals("luovutan")) { //Jos ei osaa isoja kirjaimia, niin ei väliä.
            return true;
        }
        return false;
    }   
    /**
     * Metodi joka tarkistaa osuiko oikeaan. Tämä metodi kertoo voititko pelin, ja katkaisee pelin samantien. Metodi kutsuu tarkista-metodia ja jos sieltä tulee kaikki oikein-vastaus, metodi palauttaa true.
     * @param syote
     * @return 
     */    
    public boolean voititko(String syote){
        String s = this.pituus + "";
        if (this.pelilauta.tulokset(syote).equals(s +"0")){
            return true;
        }
        return false;
    }   
    /**
     * Tulokset palauttava metodi. Metodi kutsuu pelilauta-luokan tulokset-metodia, joka vertaa käyttäjän syötettä arvottuun riviin. Metodi kertoo kuinka monta osui oikeaan paikkaan, ja kuinka monta oikeaa väriä. if-elset on kieliopillisista syistä. Huomaa että 4 oikeassa paikassa ei ole mahdollista, koska voititko-metodia kysytään ensin.
     * @param syote käyttäjän arvaama rivi
     */  
    public void tulos(String syote){
        String x = this.pelilauta.tulokset(syote);
        String a = "" + x.charAt(0);
        String b = "" + x.charAt(1);
        if(a.equals("1") && b.equals("1")){
            System.out.println(a + " oikea arvo oikealla paikalla, " + b + " oikea arvo väärällä paikalla.");
        } else if (a.equals("1")) {
            System.out.println(a + " oikea arvo oikealla paikalla, " + b + " oikeaa arvoa väärällä paikalla.");
        } else if (b.equals("1")) {
            System.out.println(a + " oikeaa arvoa oikealla paikalla, " + b + " oikea arvo väärällä paikalla.");
        } else {
            System.out.println(a + " oikeaa arvoa oikealla paikalla, " + b + " oikeaa arvoa väärällä paikalla.");
        }
    }   
    
    @Override
    /**
     * Koko pelin tulostava metodi
     */
    public String toString(){
        return this.pelilauta.toString();
    }
    /**
     * Käyttäjällä on antamansa määrä, max 20, yritystä pelissä. Tämä metodi tarkistaa loppuiko yritykset.
     * @param maara indeksi, joka nousee aina yhdellä kun pelaaja arvaa riviä.
     * @return 
     */
    public boolean loppuikoYritykset(int maara){
        if (maara <= this.rivienmaara) {
            return false;
            
        }
        return true;
    }
    /**
     * Metodi, joka tarkistaa onko käyttäjän arvaaman rivin muoto oikea.
     * @param syote käyttäjän arvaama rivi
     * @return 
     */
    public boolean syoteKorrekti(String syote) {
        if (!syotteenPituus(syote)) {
            return false;
        }
        if (!syotteenMerkit(syote)) {
            return false;
        }
        if (!oikeitaArvoja(syote)) {
            return false;
        }
       
        return true;
    }
    /**
     * Käyttäjä ei saa arvata väärän mittaista riviä. Tämä metodi tarkistaa, että käyttäjän syötteessä on oikea määrä merkkejä
     * @param syote käyttäjän arvaama rivi
     * @return 
     */
    public boolean syotteenPituus(String syote) {
        if (syote.length() != this.pituus) {
            return false;
        }
        return true;
    }
    /**
     * Oikea rivi sisältää pelkkiä numeroita, ja tämä metodi tarkistaa että käyttäjän syöte koostuu vain numeroista.
     * @param syote käyttäjän arvaama rivi
     * @return 
     */
    public boolean syotteenMerkit(String syote) {
        try {
            Integer.parseInt(syote);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    /**
     * Arvattu rivi ei saa sisältää vääriä numeroita. Tämä metodi tarkistaa onko käyttäjän syöttämän rivin numerot oikeassa haarukassa.
     * @param syote käyttäjän arvaama rivi.
     * @return 
     */
    public boolean oikeitaArvoja(String syote) {
        int x = -1;
        for (int i = 0; i < syote.length(); i++) {
            x = Integer.parseInt("" + syote.charAt(i));
            if (x < 0 || x >= this.vaihtoehtojenmaara) {
                return false;
            }
        }
        return true;
    }
    /**
     * Oikean rivin palauttava metodi testikäyttöön
     * @return 
     */
   public String oikeaRivi(){
       return this.pelilauta.arvottu();
   }
}
