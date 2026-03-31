package calcolatrice_scrum;

import java.util.Scanner;

public class Calcolatrice_scrum {
    public static void main(String[] args) {
        // Creiamo lo scanner per leggere l'input dell'utente e istanziamo la calcolatrice
        Scanner scanner = new Scanner(System.in);
        Calcolatrice calc = new Calcolatrice();

        // Messaggio di benvenuto
       
        System.out.println("  BENVENUTO NELLA CALCOLATRICE SCRUM!   ");
       

        try {
            // Richiesta del primo operando
            System.out.print("Inserisci il primo numero: ");
            float primoOperatore = scanner.nextFloat();

            // Richiesta del secondo operando
            System.out.print("Inserisci il secondo numero: ");
            float secondoOperatore = scanner.nextFloat();

            // Richiesta dell'operazione
            System.out.print("Inserisci l'operazione da eseguire (+, -, *, :): ");
            char operazione = scanner.next().charAt(0);

            float risultatoFinale = 0;
            boolean operazioneValida = true;

            // Selezione dell'operazione tramite switch
            switch (operazione) {
                case '+' -> risultatoFinale = calc.somma(primoOperatore, secondoOperatore);
                case '-' -> risultatoFinale = calc.sottrazione(primoOperatore, secondoOperatore);
                case '*' -> risultatoFinale = calc.prodotto(primoOperatore, secondoOperatore);
                case ':' -> {
                    // Preveniamo la divisione per zero prima di chiamare il metodo
                    if (secondoOperatore == 0) {
                        System.out.println("Errore: Impossibile dividere per zero!");
                        operazioneValida = false;
                    } else {
                        risultatoFinale = calc.divisione(primoOperatore, secondoOperatore);
                    }
                }
                default -> {
                    System.out.println("Errore: Operazione '" + operazione + "' non riconosciuta.");
                    operazioneValida = false;
                }
            }

            // Stampiamo il risultato solo se tutto è andato a buon fine
            if (operazioneValida) {
                
                System.out.println("Il risultato e': " + risultatoFinale);
               
            }

        } catch (Exception e) {
            // Catturiamo l'errore se l'utente inserisce lettere al posto dei numeri
            System.out.println("Errore: Input non valido. Assicurati di inserire dei numeri (usa la virgola per i decimali).");
        } finally {
            // Chiudiamo lo scanner per liberare le risorse
            scanner.close();
        }
    }
}