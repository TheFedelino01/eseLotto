/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saccani_federico
 */
public class thCheckNumero1 extends Thread{
     private DatiCondivisi ptrDati;
      private int numero;
      
    public thCheckNumero1(DatiCondivisi ptrDati){
        this.ptrDati=ptrDati;
        this.numero=ptrDati.getPrimoNumero();
    }
    
    @Override
    public void run(){
        int i=0;
        CRuota attuale;
        
        while(i<ptrDati.getDaGenerare()){
            
            try {
               ptrDati.generatoPrimo().acquire();
           } catch (InterruptedException ex) {
               Logger.getLogger(thCheckNumero1.class.getName()).log(Level.SEVERE, null, ex);
           }
            attuale =ptrDati.getElement(i);
            
           if(attuale.ePresente(numero)){
               attuale.addAmbiPresenti();//Dico che ho trovato un ambo
           }
           
           i++;
           ptrDati.contatoPrimo().release();
        }
         
        
        
        
    }
}
