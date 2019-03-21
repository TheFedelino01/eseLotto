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
    
    public CRuota(){
        elementi=5;
        estrazioni = new Vector<Integer>(elementi);
        this.elementi=elementi;
    }
    
    public void genera(){
        //Genero i numeri per l'estrazione
        Random rn = new Random();
        for(int i=0; i<elementi;i++){
            estrazioni.set(i, rn.nextInt(10));
        }
    }
}
