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
    private int rivinpituus;
    private int rivienmaara;
    private int varienmaara;
    
    public Peli(){
        Scanner lukija = new Scanner(System.in);
        
        this.rivienmaara = 10;
        this.rivinpituus = 4;
        this.varienmaara = 6;
        this.pelilauta = new Pelilauta(this.rivienmaara, this.rivinpituus);
        
        int i = 0;
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
                this.pelilauta.lisaaRivi(uusiRivi(syote));
            }
            
            
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
        if (syote.length() != this.rivinpituus) {
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
        int x = 0;
        for (int i = 0; i < syote.length(); i++) {
            x = Integer.parseInt("" + syote.charAt(i));
            if (x < 0 || x >= this.varienmaara) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<Integer> uusiRivi(String syote) {
        ArrayList<Integer> uusiRivi = new ArrayList<Integer>();
        int x = 0;
        for (int i = 0; i < syote.length(); i++) {
            x = Integer.parseInt("" + syote.charAt(i));
            uusiRivi.add(x);
        }
        return uusiRivi;
        
    }
}
