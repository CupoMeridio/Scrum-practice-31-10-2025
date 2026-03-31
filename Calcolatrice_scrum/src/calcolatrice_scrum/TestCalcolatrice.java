package calcolatrice_scrum;

public class TestCalcolatrice {

    public static void main(String[] args) {
        
        Calcolatrice calc = new Calcolatrice();
        
        System.out.println("Avvio Test Calcolatrice");

        // somma
        float risultatoSomma = calc.somma(5.0f, 3.0f);
        if (risultatoSomma == 8.0f) {
            System.out.println("Test Somma: PASSATO");
        } else {
            System.out.println("Test Somma: FALLITO (Atteso 8.0, Ottenuto " + risultatoSomma + ")");
        }

        // sottrazione
        float risultatoSott = calc.sottrazione(10.0f, 4.0f);
        if (risultatoSott == 6.0f) {
            System.out.println("Test Sottrazione: PASSATO");
        } else {
            System.out.println("Test Sottrazione: FALLITO (Atteso 6.0, Ottenuto " + risultatoSott + ")");
        }

        // prodotto
        float risultatoProd = calc.prodotto(3.0f, 4.0f);
        if (risultatoProd == 12.0f) {
            System.out.println("Test Prodotto: PASSATO");
        } else {
            System.out.println("Test Prodotto: FALLITO (Atteso 12.0, Ottenuto " + risultatoProd + ")");
        }

        // divisione
        float risultatoDiv = calc.divisione(10.0f, 2.0f);
        if (risultatoDiv == 5.0f) {
            System.out.println("Test Divisione: PASSATO");
        } else {
            System.out.println("Test Divisione: FALLITO (Atteso 5.0, Ottenuto " + risultatoDiv + ")");
        }
        
        System.out.println("FINE DEI TEST");
    }
}
