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
    private Semaphore aspettoCheConta;
    private Semaphore dicoCheHoGenerato;
    
    private int primoNumero;
    private int secondoNumero;
    
    public DatiCondivisi(int daGene, int primo, int secondo){
        daGenerare=daGene;
        ruote=new Vector<CRuota>(daGene);
        dicoCheHoGenerato = new Semaphore(0);
        aspettoCheConta = new Semaphore(1);
        
        primoNumero=primo;
        secondoNumero=secondo;
    }
    
    public int getPrimoNumero(){
        return primoNumero;
    }
    
    public int getSecondoNumero(){
        return secondoNumero;
    }
    
    public CRuota getElement(int pos){
        return (CRuota) ruote.get(pos);
    }
    
    public Semaphore aspettoCheConta(){
        return aspettoCheConta;
    }
    
    public Semaphore dicoCheHoGenerato(){
        return dicoCheHoGenerato;
    }
    
    public int getDaGenerare(){
        return daGenerare;
    }
}
