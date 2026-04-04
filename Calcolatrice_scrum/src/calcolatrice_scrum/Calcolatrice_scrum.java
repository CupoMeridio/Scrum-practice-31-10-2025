package calcolatrice_scrum;

import java.util.Scanner;

public class Calcolatrice_scrum {
    public static void main(String[] args) {
        try ( // Creiamo lo scanner per leggere l'input dell'utente e istanziamo la calcolatrice
                Scanner scanner = new Scanner(System.in)) {
            Calcolatrice calc = new Calcolatrice();
            boolean termina = true;
            // Messaggio di benvenuto
            System.out.println("  BENVENUTO NELLA CALCOLATRICE SCRUM!   ");
            while (termina) {
                try {
                    
                    // Richiesta dell'operazione
                    System.out.print("Inserisci l'operazione da eseguire (+, -, *, :, seno, coseno, tan): ");
                    String operazione = scanner.next();
                    
                    float risultatoFinale = 0;
                    boolean operazioneValida = true;
                    
                    // Richiesta del primo operando
                    System.out.print("Inserisci il primo operando: ");
                    
                    String primoOperatoreInput = scanner.next(); 
                    float valorePrimoOperando;
                    
                    if (primoOperatoreInput.equalsIgnoreCase("res")) {
                        valorePrimoOperando = calc.getRisultato();
                    } else {
                        try {
                            valorePrimoOperando = Float.parseFloat(primoOperatoreInput);
                        } catch (NumberFormatException e) {
                            System.out.println("Inserisci un operando valido o 'res'");
                            continue;
                        }
                    }
                    
                    float valoreSecondoOperando = 0.0f;
                    if ( (operazione.compareTo("seno") != 0 ) && (operazione.compareTo("coseno") != 0 )
                            && (operazione.compareTo("tan") != 0)){
                        // Richiesta del secondo operando
                        System.out.print("Inserisci il secondo operando: ");
                        String secondoOperatoreInput = scanner.next();
                        
                        if (secondoOperatoreInput.equalsIgnoreCase("res")) {
                            valoreSecondoOperando = calc.getRisultato();
                        } else {
                            try {
                                valoreSecondoOperando = Float.parseFloat(secondoOperatoreInput);
                            } catch (NumberFormatException e) {
                                System.out.println("Inserisci un operando valido o 'res'");
                                continue;
                            }
                        }

                    }
                    // Selezione dell'operazione tramite switch
                    switch (operazione) {
                        case "+" -> risultatoFinale = calc.somma(valorePrimoOperando, valoreSecondoOperando);
                        case "-" -> risultatoFinale = calc.sottrazione(valorePrimoOperando, valoreSecondoOperando);
                        case "*" -> risultatoFinale = calc.prodotto(valorePrimoOperando, valoreSecondoOperando);
                        case ":" -> { risultatoFinale = calc.divisione(valorePrimoOperando, valoreSecondoOperando);}
                        case "seno" -> { risultatoFinale = calc.seno(valorePrimoOperando, calc.isDegree_mode()); }
                        case "coseno" -> { risultatoFinale = calc.coseno(valorePrimoOperando, calc.isDegree_mode());}
                        case "tan" -> { risultatoFinale = calc.tangente(valorePrimoOperando, calc.isDegree_mode());}
                        default -> {
                            System.out.println("Errore: Operazione '" + operazione + "' non riconosciuta.");
                            operazioneValida = false;
                        }
                    }
                    
                    
                    // Stampiamo il risultato solo se tutto è andato a buon fine
                    
                    
                    System.out.println("Il risultato e': " + risultatoFinale);
                    
                    
                } catch (Exception e) {
                    // Catturiamo l'errore se l'utente inserisce lettere al posto dei numeri
                    System.out.println("Errore: Input non valido. Assicurati di inserire dei numeri (usa la virgola per i decimali).");
                }
                
                System.out.print("\nVuoi continuare con i calcoli? (S/N): ");
                char rispostaContinuazione = scanner.next().charAt(0);
                
                // Controlliamo sia la 'S' maiuscola che la 's' minuscola
                if(rispostaContinuazione == 'S' || rispostaContinuazione == 's'){
                    termina = true; // Il ciclo continua
                } else {
                    termina = false; // Il ciclo si ferma
                    System.out.println("Grazie per aver usato la Calcolatrice Scrum. Arrivederci!");
                }
            }
            // Chiudiamo lo scanner per liberare le risorse
        }
    }
}
