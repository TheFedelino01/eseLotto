/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eselotto;

/**
 *
 * @author saccani_federico
 */
public class EseLotto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        int primo=1,secondo=2;
        int estrazioni=5;
        
        DatiCondivisi dati = new DatiCondivisi(5,primo,secondo);
        
        thGenera genera = new thGenera(dati);
        thCheckNumero1 num1 = new thCheckNumero1(dati);
        thCheckNumero2 num2 = new thCheckNumero2(dati);
        
        num1.start();
        num2.start();
        genera.start();
        
        try{
        genera.join();
        num1.join();
        num2.join();
        }catch( InterruptedException e){}
        
        
        System.out.println("Ruote Vincenti:\n"+ dati.getNumeroDiRuoteVincenti());
        
        System.out.println("Ruote Estratte:\n"+ dati.toString());
    }
    
}
