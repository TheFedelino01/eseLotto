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
public class thGenera extends Thread{
    private DatiCondivisi ptrDati;
    
    public thGenera(DatiCondivisi ptrDati){
        this.ptrDati=ptrDati;
    }
    
    @Override
    public void run(){
       
        int daGenerare = ptrDati.getDaGenerare();
        
        int i=0;
        while(i<daGenerare){
            try {
                ptrDati.contatoPrimo().acquire();//Aspetto che conta il primo e il secondo
                ptrDati.contatoSecondo().acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(thGenera.class.getName()).log(Level.SEVERE, null, ex);
            }
            ptrDati.push(new CRuota());
            ptrDati.getElement(i).genera();//Faccio generare gli elementi
            
            ptrDati.generatoPrimo().release();//Dico che ho generatoPrimo gli elementi e ora li faccio contare
            ptrDati.generatoSecondo().release();//Dico che ho generatoPrimo gli elementi e ora li faccio contare
            i++;
        }
    }
}
