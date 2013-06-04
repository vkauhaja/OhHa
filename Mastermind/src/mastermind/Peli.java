/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vkauhaja
 */
public class Peli {
    private Pelilauta pelilauta;
    private int leveys;
    private int rivienmaara;
    private int varienmaara;
    private int vaikeusaste;
    
    public Peli(int rivienmaara, int leveys, int varienmaara, int vaikeusaste){
        
        this.vaikeusaste = vaikeusaste;
        this.rivienmaara = rivienmaara;
        this.leveys = leveys;
        this.varienmaara = varienmaara;
        this.pelilauta = new Pelilauta(this.varienmaara, this.leveys, this.vaikeusaste);
        
        
        
    }       
    public void pelaa(){
        System.out.println("Peli alkaa. Yhdessä rivissä on " + this.leveys + " numeroa, numerot ovat väliltä 0-"+ (this.varienmaara-1) + " ja sinulla on " + this.rivienmaara + " yritystä arvata oikea rivi.");
        int i = 0;
        Scanner lukija = new Scanner(System.in);
        
        String syote = "";
        while (true) {
            i++;
            if (loppuikoYritykset(i)) {
                System.out.println("Hävisit pelin, oikea rivi oli " + this.pelilauta.arvottuRivi());
                break;
            } 
            syote = lukija.nextLine();
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
       
        
    public boolean voititko(String syote){
        String s = this.leveys + "";
        if (this.pelilauta.tulokset(syote).equals(s +"0")){
            return true;
        }
        return false;
    }   
        
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
    public String toString(){
        return this.pelilauta.toString();
    }
    public boolean loppuikoYritykset(int maara){
        if (maara <= this.rivienmaara) {
            return false;
            
        }
        return true;
    }
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
    public boolean syotteenPituus(String syote) {
        if (syote.length() != this.leveys) {
            return false;
        }
        return true;
    }
    public boolean syotteenMerkit(String syote) {
        try {
            Integer.parseInt(syote);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    public boolean oikeitaArvoja(String syote) {
        int x = -1;
        for (int i = 0; i < syote.length(); i++) {
            x = Integer.parseInt("" + syote.charAt(i));
            if (x < 0 || x >= this.varienmaara) {
                return false;
            }
        }
        return true;
    }
    public boolean maareetKorrekti(String syote) {
        if (!maareenPituus(syote)) {
            return false;
        }
        if (!maareenMerkit(syote)) {
            return false;
        }
        if (!oikeatArvoja(syote)) {
            return false;
        }
        return true;
    }
    public boolean maareenPituus(String syote) {
        if (syote.length() != 3) {
            return false;
        }
        return true;
    }
    public boolean maareenMerkit(String syote) {
        try {
            Integer.parseInt(syote);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    public boolean oikeatArvoja(String syote) {
        int x = syote.charAt(0);
        int y = syote.charAt(1);
        int z = syote.charAt(2);
        if (x < 1 || x > 20){
            return false;
        }
         if (y < 1 || y > 20){
            return false;
        }
         if (z < 1 || z > 20){
            return false;
        }
        return true;
    }
}
