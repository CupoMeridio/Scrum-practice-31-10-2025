package calcolatrice_scrum;

import java.util.Scanner;

public class Calcolatrice_scrum {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Calcolatrice calc = new Calcolatrice();
            boolean termina = true;

            System.out.println("  BENVENUTO NELLA CALCOLATRICE SCRUM!   ");

            while (termina) {
                try {
                    // 1. Richiesta dell'operazione
                    System.out.print("Inserisci l'operazione (+, -, *, :, seno, coseno, tan): ");
                    String operazione = scanner.next().toLowerCase();

                    float risultatoFinale = 0;

                    // Il primo operando serve sempre
                    float valorePrimoOperando = leggiOperando(scanner, "primo", calc);

                    float valoreSecondoOperando = 0.0f;
                    if (!operazione.equals("seno") && !operazione.equals("coseno") && !operazione.equals("tan")) {
                        valoreSecondoOperando = leggiOperando(scanner, "secondo", calc);
                    }

                    switch (operazione) {
                        case "+" -> risultatoFinale = calc.somma(valorePrimoOperando, valoreSecondoOperando);
                        case "-" -> risultatoFinale = calc.sottrazione(valorePrimoOperando, valoreSecondoOperando);
                        case "*" -> risultatoFinale = calc.prodotto(valorePrimoOperando, valoreSecondoOperando);
                        case ":" -> risultatoFinale = calc.divisione(valorePrimoOperando, valoreSecondoOperando);
                        case "seno" -> risultatoFinale = calc.seno(valorePrimoOperando, calc.isDegree_mode());
                        case "coseno" -> risultatoFinale = calc.coseno(valorePrimoOperando, calc.isDegree_mode());
                        case "tan" -> risultatoFinale = calc.tangente(valorePrimoOperando, calc.isDegree_mode());
                        default -> {
                            System.out.println("Errore: Operazione '" + operazione + "' non riconosciuta.");
                            continue;
                        }
                    }

                    System.out.println("Il risultato è: " + risultatoFinale);

                } catch (NumberFormatException e) {
                    System.out.println("Errore: Input non valido. Inserisci un numero o 'res'.");
                } catch (Exception e) {
                    System.out.println("Si è verificato un errore inaspettato: " + e.getMessage());
                }

                System.out.print("\nVuoi continuare? (S/N): ");
                String risposta = scanner.next();
                if (!risposta.equalsIgnoreCase("S")) {
                    termina = false;
                    System.out.println("Arrivederci!");
                }
            }
        }
    }

    private static float leggiOperando(Scanner scanner, String ordine, Calcolatrice calc) {
        while (true) {
            System.out.print("Inserisci il " + ordine + " operando (o 'res'): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("res")) {
                return calc.getRisultato();
            }

            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Errore: '" + input + "' non è un numero valido. Riprova.");
            }
        }
    }
}
