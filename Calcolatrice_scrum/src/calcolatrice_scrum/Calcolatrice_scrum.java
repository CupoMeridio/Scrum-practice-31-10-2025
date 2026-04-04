package calcolatrice_scrum;

import java.util.Scanner;

public class Calcolatrice_scrum {

    // Definiamo la nostra interfaccia funzionale
    @FunctionalInterface
    public interface OperazioneBinaria {
        float esegui(float op1, float op2);
    }

    @FunctionalInterface
    public interface OperazioneUnaria {
        float esegui(float op1, boolean mod);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Calcolatrice calc = new Calcolatrice();
            boolean termina = true;

            System.out.println("BENVENUTO NELLA CALCOLATRICE SCRUM!");
            System.out.println("Puoi digitare 'res' quando inserisci un operando per riutilizzare l'ultimo risultato.");

            while (termina) {
                try {

                    System.out.print("Inserisci l'operazione (+, -, *, :, /, seno/sin, coseno/cos, tangente/tan): ");
                    String operazione = scanner.next().toLowerCase();

                    float risultatoFinale;

                    OperazioneBinaria operazioneScelta = null;
                    OperazioneUnaria opUnariaScelta = null;
                    boolean operazioneValida = true;

                    switch (operazione) {
                        case "+" -> operazioneScelta = (a, b) -> calc.somma(a, b);
                        case "-" -> operazioneScelta = (a, b) -> calc.sottrazione(a, b);
                        case "*" -> operazioneScelta = (a, b) -> calc.prodotto(a, b);
                        case ":", "/" -> operazioneScelta = (a, b) -> calc.divisione(a, b);
                        case "seno", "sin" -> opUnariaScelta = (a, mod) -> calc.seno(a, mod);
                        case "coseno", "cos" -> opUnariaScelta = (a, mod) -> calc.coseno(a, mod);
                        case "tan", "tangente", "tg" -> opUnariaScelta = (a, mod) -> calc.tangente(a, mod);
                        default -> {
                            System.out.println("Errore: Operazione '" + operazione + "' non riconosciuta.");
                            operazioneValida = false;
                        }
                    }

                    // Se lo switch ha trovato un'operazione valida, eseguiamo la Lambda!
                    if (operazioneValida) {
                        // Chiamiamo il metodo esegui() dell'interfaccia
                        // Il primo operando serve sempre
                        float valorePrimoOperando;
                        float valoreSecondoOperando;

                        if (opUnariaScelta == null) {
                            valorePrimoOperando = leggiOperando(scanner, "primo", calc);
                            valoreSecondoOperando = leggiOperando(scanner, "secondo", calc);
                            risultatoFinale = operazioneScelta.esegui(valorePrimoOperando, valoreSecondoOperando);
                        } else {
                            String modalitaAttuale = descriviModalitaAngolo(calc.isDegree_mode());
                            String modalitaAlternativa = descriviModalitaAngolo(!calc.isDegree_mode());
                            System.out.print("Modalità angolo attuale: " + modalitaAttuale + ". Vuoi passare a " + modalitaAlternativa + "? (S/N) ");
                            String modalita = scanner.next().toLowerCase();
                            if (modalita.equalsIgnoreCase("S")) {
                                calc.setDegree_mode(!calc.isDegree_mode());
                            }
                            System.out.println("Userò " + descriviModalitaAngolo(calc.isDegree_mode()) + " per questo calcolo.");
                            valorePrimoOperando = leggiOperando(scanner, "primo", calc);
                            risultatoFinale = opUnariaScelta.esegui(valorePrimoOperando, calc.isDegree_mode());
                        }

                        System.out.println("Il risultato e': " + risultatoFinale);

                    }

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
            System.out.print("Inserisci il " + ordine + " operando (numero o 'res' = ultimo risultato): ");
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

    private static String descriviModalitaAngolo(boolean degreeMode) {
        return degreeMode ? "gradi" : "radianti";
    }

}
