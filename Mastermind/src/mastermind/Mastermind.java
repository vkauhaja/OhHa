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
public class Mastermind {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner llukija = new Scanner(System.in);
        System.out.println("Tervetuloa pelaamaan Mastermindia.");
        int d = -1;
        int a = -1;
        int b = -1;
        int c = -1;
        while (true) {
            d = vaikeusaste();
            a = yritykset();
            c = rivinPituus();
            b = vaihtoehdot();
            if (d == 0 && b < c) {
                System.out.println("Helpotetussa versiossa eri numerovaihtoehtoja tulee olla vähintään rivin pituuden verran.");
            } else {
                break;
            }
        }
        Peli uusiPeli = new Peli(a, c, b, d);
        uusiPeli.pelaa();
        
    }
    public static int vaikeusaste(){
        Scanner llukija = new Scanner(System.in);
        int d = -1;
        while (true) {
            System.out.println("Valitse vaikeusaste (0 = helpotettu, jossa kukin arvo toistuu rivissä vain kerran, 1 = normaali).");
            String w = llukija.nextLine();
            if (vaikeusasteKorrekti(w)) {
                d = Integer.parseInt(w);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return d;
    }
    public static int yritykset(){
        Scanner llukija = new Scanner(System.in);
        int a = 0;
        while (true) {
            System.out.println("Valitse kuinka monta yritystä haluat (1-20).");
            String x = llukija.nextLine();
            if (yrityksetKorrekti(x)) {
                a = Integer.parseInt(x);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return a;
    }
    public static int vaihtoehdot(){
        Scanner llukija = new Scanner(System.in);
        int b = 0;
        while (true) {
            System.out.println("Valitse kuinka monta mahdollista arvoa arvattavalla numerolla on (2-10),");
            String y = llukija.nextLine();
            if (vaihtoehdotKorrekti(y)) {
                b = Integer.parseInt(y);
                break;
            } else {
                System.out.println("Virheellinen arvo.");
            }
        }
        return b;
    }
    public static int rivinPituus(){
        Scanner llukija = new Scanner(System.in);
        int c = 0;
        while (true) {
            System.out.println("Valitse kuinka monta numeroa yhdessä rivissä on (2-9).");
            String z = llukija.nextLine();
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
}