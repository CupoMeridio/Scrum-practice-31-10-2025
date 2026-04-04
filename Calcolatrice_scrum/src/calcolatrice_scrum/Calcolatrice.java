package calcolatrice_scrum;

public class Calcolatrice {

    private float risultato;
    private boolean degree_mode; // if false : radiant mode
    private static final float TRIG_EPSILON = 1e-6f;

    public Calcolatrice() {
        this.risultato = 0.0f;
        this.degree_mode = false;
    }

    public boolean isDegree_mode() {
        return degree_mode;
    }

    public void setDegree_mode(boolean degree_mode) {
        this.degree_mode = degree_mode;
    }

    public float getRisultato() {
        return risultato;
    }

    public float somma(float PrimoOperatore, float SecondoOperatore) {
        this.risultato = PrimoOperatore + SecondoOperatore;
        return risultato;
    }

    public float sottrazione(float PrimoOperatore, float SecondoOperatore) {
        this.risultato = somma(PrimoOperatore, -SecondoOperatore);
        return risultato;
    }

    public float prodotto(float PrimoOperatore, float SecondoOperatore) {
        this.risultato = PrimoOperatore * SecondoOperatore;
        return risultato;
    }

    public float divisione(float PrimoOperatore, float SecondoOperatore) {
        if (SecondoOperatore != 0) {
            this.risultato = PrimoOperatore / SecondoOperatore;
        } else {
            throw new IllegalArgumentException("Non puoi fare divisioni per 0");

        }
        return risultato;
    }

    public float conversioneDaRadiantiInGradi(float rad) {
        return (float) Math.toDegrees(rad);
    }

    public float conversioneDaGradiInRadianti(float gradi) {
        return (float) Math.toRadians(gradi);
    }

    /*Funzione per la tangente valore in rad return in rad*/
    public float coseno(float valore) {
        this.risultato = normalizzaRisultatoTrigonometico((float) Math.cos(valore));
        return this.risultato;
    }

    /* Funzione per il coseno (scegliendo se il valore è in gradi o radianti) */
    public float coseno(float valore, boolean valoreInGradi) {
        double valoreInRadianti = valoreInGradi ? Math.toRadians(valore) : valore;
        this.risultato = normalizzaRisultatoTrigonometico((float) Math.cos(valoreInRadianti));
        return this.risultato;
    }

    /* Funzione per il seno (valore in radianti) */
    public float seno(float valore) {
        this.risultato = normalizzaRisultatoTrigonometico((float) Math.sin(valore));
        return this.risultato;
    }

    /* Funzione per il seno (scegliendo se il valore è in gradi o radianti) */
    public float seno(float valore, boolean valoreInGradi) {
        double valoreInRadianti = valoreInGradi ? Math.toRadians(valore) : valore;
        this.risultato = normalizzaRisultatoTrigonometico((float) Math.sin(valoreInRadianti));
        return this.risultato;
    }

    /* Funzione per la tangente (valore in radianti) */
    public float tangente(float valore) {
        if (angoloTangenteNonDefinito(valore)) {
            throw new IllegalArgumentException("Tangente non definita per questo angolo");
        }
        this.risultato = normalizzaRisultatoTrigonometico((float) Math.tan(valore));
        return this.risultato;
    }

    /* Funzione per la tangente (scegliendo se il valore è in gradi o radianti) */
    public float tangente(float valore, boolean valoreInGradi) {
        if (valoreInGradi) {
            double valoreInRadianti = Math.toRadians(valore);
            if (angoloTangenteNonDefinito((float) valoreInRadianti)) {
                throw new IllegalArgumentException("Tangente non definita per questo angolo");
            }
            this.risultato = normalizzaRisultatoTrigonometico((float) Math.tan(valoreInRadianti));
        } else {
            this.risultato = this.tangente(valore);
        }
        return this.risultato;
    }

    private boolean angoloTangenteNonDefinito(float valoreRadianti) {
        double distanzaDaSemipi = Math.abs(Math.cos(valoreRadianti));
        return distanzaDaSemipi < 1e-6;
    }

    private float normalizzaRisultatoTrigonometico(float valore) {
        return Math.abs(valore) < TRIG_EPSILON ? 0.0f : valore;
    }
}
