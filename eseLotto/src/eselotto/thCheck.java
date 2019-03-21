/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

import java.util.Random;

/**
 *
 * @author saccani_federico
 */
public class thCheck extends Thread{
     private DatiCondivisi ptrDati;
      private boolean primoNumero;
      
    public thCheck(DatiCondivisi ptrDati, boolean primoNumero){
        this.ptrDati=ptrDati;
        this.primoNumero=primoNumero;
    }
    
    @Override
    public void run(){
        int numeroDaVerificare;
        if(primoNumero==true){
            numeroDaVerificare=ptrDati.getPrimoNumero();
        }else{
            numeroDaVerificare=ptrDati.getSecondoNumero();
        }
    }
}
