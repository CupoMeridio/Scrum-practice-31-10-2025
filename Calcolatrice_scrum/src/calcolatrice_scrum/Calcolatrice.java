/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatrice_scrum;

/**
 *
 * @author Mattia Sanzari
 */
public class Calcolatrice {
    
  
   private float risultato ;

    public Calcolatrice() {
        this.risultato = 0.0f;
    }

   
    public float getRisultato() {
        return risultato ;
    }

   
   
   public float somma(float PrimoOperatore, float SecondoOperatore){
       
       this.risultato =  PrimoOperatore + SecondoOperatore;
       return risultato;
   }
   
   
   public float sottrazione(float PrimoOperatore, float SecondoOperatore){
       
       risultato = somma(PrimoOperatore, -SecondoOperatore);
       return risultato;
   }
   
   public float prodotto(float PrimoOperatore, float SecondoOperatore){
       risultato = PrimoOperatore*SecondoOperatore;
       return risultato;
   }
   
   public float divisione (float PrimoOperatore, float SecondoOperatore) {

       if(SecondoOperatore != 0){
           risultato= PrimoOperatore/SecondoOperatore;
       }else{
        throw new IllegalArgumentException ("Non puoi fare divisioni per 0");

       }
       return risultato; 
    }
    
}
