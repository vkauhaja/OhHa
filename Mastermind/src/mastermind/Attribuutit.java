/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.Scanner;

/**
 *
 * @author vkauhaja
 */
public class Attribuutit {
    private Scanner lukija;
    private int vaikeusaste;
    private int rivinpituus;
    private int varienmaara;
    private int yritystenmaara;
    
    public Attribuutit(Scanner lukija){
        this.lukija = lukija;
        this.rivinpituus = -1;
        this.vaikeusaste = -1;
        this.varienmaara = -1;
        this.yritystenmaara = -1;
        kysy();
        
        
    }
    private void kysy(){
        while (true) {
            this.vaikeusaste = vaikeusaste();
            this.yritystenmaara = yritykset();
            this.rivinpituus = rivinPituus();
            this.varienmaara = vaihtoehdot();
            if (this.vaikeusaste == 0 && this.varienmaara < this.rivinpituus) {
                System.out.println("Helpotetussa versiossa eri numerovaihtoehtoja tulee olla vähintään rivin pituuden verran.");
            } else {
                break;
            }
        }
    }
     public int vaikeusaste(){
        int d = -1;
        while (true) {
            System.out.println("Valitse vaikeusaste (0 = helpotettu, jossa kukin arvo toistuu rivissä vain kerran, 1 = normaali).");
            String w = lukija.nextLine();
            if (vaikeusasteKorrekti(w)) {
                d = Integer.parseInt(w);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return d;
    }
    public int yritykset(){
        int a = 0;
        while (true) {
            System.out.println("Valitse kuinka monta yritystä haluat (1-20).");
            String x = lukija.nextLine();
            if (yrityksetKorrekti(x)) {
                a = Integer.parseInt(x);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return a;
    }
    public int vaihtoehdot(){
       int b = 0;
        while (true) {
            System.out.println("Valitse kuinka monta mahdollista arvoa arvattavalla numerolla on (2-10),");
            String y = lukija.nextLine();
            if (vaihtoehdotKorrekti(y)) {
                b = Integer.parseInt(y);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return b;
    }
    public int rivinPituus(){
        int c = 0;
        while (true) {
            System.out.println("Valitse kuinka monta numeroa yhdessä rivissä on (2-9).");
            String z = lukija.nextLine();
            if (rivinPituusKorrekti(z)) {
                c = Integer.parseInt(z);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return c;
    }
    public static boolean vaikeusasteKorrekti(String syote){
        if (!pituus2(syote)) {
            return false;
        }
        if (!merkitOikein(syote)){
            return false;
        }
        if(!oikeitaArvoja4(syote)){
            return false;
        }
        return true;
    }
    public static boolean yrityksetKorrekti(String syote){
        if (!pituus1(syote)) {
            return false;
        }
        if (!merkitOikein(syote)){
            return false;
        }
        if(!oikeitaArvoja1(syote)){
            return false;
        }
        return true;
    }
    public static boolean vaihtoehdotKorrekti(String syote){
        if (!pituus1(syote)) {
            return false;
        }
        if (!merkitOikein(syote)){
            return false;
        }
        if(!oikeitaArvoja2(syote)){
            return false;
        }
        return true;
    }
    public static boolean rivinPituusKorrekti(String syote){
        if (!pituus2(syote)) {
            return false;
        }
        if (!merkitOikein(syote)){
            return false;
        }
        if(!oikeitaArvoja3(syote)){
            return false;
        }
        return true;
    }
    public static boolean pituus1(String syote){
        if (syote.length() == 2 || syote.length() ==1) {
            return true;
        }
        return false;
    }
    public static boolean pituus2(String syote){
        if (syote.length() ==1) {
            return true;
        }
        return false;
    }
    public static boolean merkitOikein(String syote){
        try {
            Integer.parseInt(syote);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    public static boolean oikeitaArvoja1(String syote){
        int arvo = Integer.parseInt(syote);
        if (arvo < 1 || arvo > 20){
            return false;
        }
        return true;
    }
    public static boolean oikeitaArvoja2(String syote){
        int arvo = Integer.parseInt(syote);
        if (arvo < 2 || arvo > 10){
            return false;
        }
        return true;
    }
    public static boolean oikeitaArvoja3(String syote){
        int arvo = Integer.parseInt(syote);
        if (arvo < 2 || arvo > 9){
            return false;
        }
        return true;
    }
    public static boolean oikeitaArvoja4(String syote){
        int arvo = Integer.parseInt(syote);
        if (arvo < 0 || arvo > 1){
            return false;
        }
        return true;
    }
    
    public int rivi(){
        return this.rivinpituus;
    }
    public int varit(){
        return this.varienmaara;
    }
    public int vaikeus(){
        return this.vaikeusaste;
    }
    public int yritystenmaara(){
        return this.yritystenmaara;
    }
}
