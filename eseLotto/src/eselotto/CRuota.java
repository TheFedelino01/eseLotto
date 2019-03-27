/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author saccani_federico
 */
public class CRuota {
    private Vector estrazioni;
    private int elementi;
    private int ambiPresenti;
    
    public CRuota(){
        elementi=5;
        estrazioni = new Vector<Integer>(elementi);
        ambiPresenti=0;
    }
    
    public synchronized void addAmbiPresenti(){
        ambiPresenti++;
    }
    
    
    public boolean eVincente(){
        if(ambiPresenti==2){
            return true;
        }
        return false;
    }
    
    public String toString(){
        String ris="";
        for(int i=0; i<elementi;i++){
            ris+=estrazioni.get(i)+",";
        }
        return "{"+ris+"}";
    }
    
    public synchronized void genera(){
        //Genero i numeri per l'estrazione
        Random rn = new Random();
        for(int i=0; i<elementi;i++){
            estrazioni.add(rn.nextInt(10));
        }
    }
    
    
    public synchronized boolean ePresente(int numero){
        boolean ris=false;
        int i=0;
        while( i<estrazioni.size() && ris==false){
            if(estrazioni.elementAt(i).equals(numero)){
                ris=true;
            }else{
                ris=false;
            }
            i++;
        }
        
        return ris;
    }
}
