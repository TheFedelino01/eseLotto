/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.Vector;
import java.util.concurrent.Semaphore;

/**
 *
 * @author saccani_federico
 */
public class DatiCondivisi {
    
    private int daGenerare;
    private Vector ruote;
    
    private Semaphore contatoPrimo;
    private Semaphore generatoPrimo;
    
    private Semaphore contatoSecondo;
    private Semaphore generatoSecondo;
    
    private int primoNumero;
    private int secondoNumero;
    
    public DatiCondivisi(int daGene, int primo, int secondo){
        daGenerare=daGene;
        ruote=new Vector<CRuota>(daGenerare);
        generatoPrimo = new Semaphore(0);
        contatoPrimo = new Semaphore(1);
        
        generatoSecondo = new Semaphore(0);
        contatoSecondo = new Semaphore(1);
        
        primoNumero=primo;
        secondoNumero=secondo;
    }
    
    
    public synchronized void push(CRuota nuova){
        ruote.add(nuova);
    }
    public synchronized String getNumeroDiRuoteVincenti(){
        String ris="";
        CRuota tmp;
        for(Integer i=0; i<daGenerare;i++){
            tmp=(CRuota)ruote.get(i);
            if(tmp.eVincente()==true){
                ris+="Ruota numero: "+(i+1)+"\n";
            }
        }
        return ris;
    }
    
    public synchronized String toString(){
        String ris="";
        CRuota tmp;
        for(int i=0; i<daGenerare;i++){
            tmp=(CRuota)ruote.get(i);
            ris+=tmp.toString();
        }
        return ris;
    }
    
    public synchronized int getPrimoNumero(){
        return primoNumero;
    }
    
    public synchronized int getSecondoNumero(){
        return secondoNumero;
    }
    
    public synchronized CRuota getElement(int pos){
        return (CRuota) ruote.get(pos);
    }
    
    
    public synchronized Semaphore contatoPrimo(){
        return contatoPrimo;
    }
    public synchronized Semaphore generatoPrimo(){
        return generatoPrimo;
    }
    
    public synchronized Semaphore contatoSecondo(){
        return contatoSecondo;
    }
    public synchronized Semaphore generatoSecondo(){
        return generatoSecondo;
    }
    
    public synchronized int getDaGenerare(){
        return daGenerare;
    }
}
