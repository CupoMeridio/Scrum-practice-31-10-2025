/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcolatrice_scrum;

import java.lang.Math;
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
   
   public float conversioneDaRadiantiInGradi(float rad){
       return  (float) Math.toDegrees(rad);
   }
   
   public float conversioneDaGradiInRadianti(float gradi){
       return  (float) Math.toRadians(gradi);
   }
   
   
    /*Funzione per la tangente valore in rad return in rad*/
   public  float coseno(float valore){
   
    return (float) Math.cos(valore);
   }
   
   
   /* Funzione per il coseno (scegliendo se il valore è in gradi o radianti) */
   public float coseno(float valore, boolean valoreInGradi){
       if(valoreInGradi){
           return (float) Math.cos(this.conversioneDaGradiInRadianti(valore));
       } else {
           // Se è già in radianti, uso direttamente il metodo base
           return this.coseno(valore); 
       }
   }
   
   /* Funzione per il seno (valore in radianti) */
   public float seno(float valore){
       return (float) Math.sin(valore);
   }
    
   
   /* Funzione per il seno (scegliendo se il valore è in gradi o radianti) */
   public float seno(float valore, boolean valoreInGradi){
       if(valoreInGradi){
           return (float) Math.sin(this.conversioneDaGradiInRadianti(valore));
       } else {
           // Se è già in radianti, uso direttamente il metodo base
           return this.seno(valore);
       }
   }
   
   
   /* Funzione per la tangente (valore in radianti) */
   public float tangente(float valore){
       return (float) Math.tan(valore);
   }
   
   /* Funzione per la tangente (scegliendo se il valore è in gradi o radianti) */
   public float tangente(float valore, boolean valoreInGradi){
       if (valoreInGradi){
          return (float) Math.tan(this.conversioneDaGradiInRadianti(valore));
       } else {
          // Se è già in radianti, uso direttamente il metodo base
          return this.tangente(valore);
       }
   }
}