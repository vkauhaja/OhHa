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
    
    public Peli(int rivienmaara, int leveys, int varienmaara){
        Scanner lukija = new Scanner(System.in);
        
        this.rivienmaara = rivienmaara;
        this.leveys = leveys;
        this.varienmaara = varienmaara;
        this.pelilauta = new Pelilauta(this.varienmaara, this.leveys);
        
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
                this.pelilauta.lisaaRivi(syote);
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
    
}
