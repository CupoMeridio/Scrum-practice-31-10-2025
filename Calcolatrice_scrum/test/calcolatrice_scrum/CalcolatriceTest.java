package calcolatrice_scrum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalcolatriceTest {

    private Calcolatrice calc;

    @Before
    public void setUp() {
        // Inizializza una nuova istanza prima di ogni singolo test
        calc = new Calcolatrice();
    }

    // --- TEST OPERAZIONI BASE ---

    @Test
    public void testSomma() {
        assertEquals(5.0f, calc.somma(2.0f, 3.0f), 0.0001f);
    }

    @Test
    public void testSottrazione() {
        assertEquals(1.0f, calc.sottrazione(4.0f, 3.0f), 0.0001f);
    }

    @Test
    public void testProdotto() {
        assertEquals(12.0f, calc.prodotto(3.0f, 4.0f), 0.0001f);
    }

    @Test
    public void testDivisione() {
        assertEquals(2.0f, calc.divisione(10.0f, 5.0f), 0.0001f);
    }

    // In JUnit 4 le eccezioni si testano così:
    @Test(expected = IllegalArgumentException.class)
    public void testDivisionePerZero() {
        calc.divisione(10.0f, 0.0f);
    }

    @Test
    public void testGetRisultato() {
        calc.somma(10.0f, 5.0f);
        assertEquals(15.0f, calc.getRisultato(), 0.0001f);
    }

    // --- TEST FUNZIONI TRIGONOMETRICHE ---

    @Test
    public void testSenoAggiornaRisultato() {
        calc.seno((float) (Math.PI / 2.0));
        assertEquals(1.0f, calc.getRisultato(), 0.0001f);
    }

    @Test
    public void testSenoInGradi() {
        assertEquals(1.0f, calc.seno(90.0f, true), 0.0001f);
    }

    @Test
    public void testCosenoInGradi() {
        assertEquals(1.0f, calc.coseno(0.0f, true), 0.0001f);
    }

    @Test
    public void testCosenoInRadianti() {
        assertEquals(0.0f, calc.coseno((float) (Math.PI / 2.0), false), 0.0001f);
    }

    @Test
    public void testCoseno90GradiNormalizzatoAZero() {
        assertEquals(0.0f, calc.coseno(90.0f, true), 0.0f);
    }

    @Test
    public void testSeno180GradiNormalizzatoAZero() {
        assertEquals(0.0f, calc.seno(180.0f, true), 0.0f);
    }

    @Test
    public void testTangente180GradiNormalizzataAZero() {
        assertEquals(0.0f, calc.tangente(180.0f, true), 0.0f);
    }

    @Test
    public void testSenoAngoloNegativoInGradi() {
        assertEquals(-1.0f, calc.seno(-90.0f, true), 0.0001f);
    }

    @Test
    public void testCosenoAngoloCoterminaleInGradi() {
        assertEquals(0.0f, calc.coseno(450.0f, true), 0.0f);
    }

    @Test
    public void testTangenteAngoloNegativoInGradi() {
        assertEquals(-1.0f, calc.tangente(-45.0f, true), 0.0001f);
    }

    @Test
    public void testCosenoAggiornaRisultato() {
        calc.coseno(60.0f, true);
        assertEquals(0.5f, calc.getRisultato(), 0.0001f);
    }

    @Test
    public void testTangenteAggiornaRisultato() {
        calc.tangente(45.0f, true);
        assertEquals(1.0f, calc.getRisultato(), 0.0001f);
    }

    @Test
    public void testTangenteInRadianti() {
        assertEquals(1.0f, calc.tangente((float) (Math.PI / 4.0), false), 0.0001f);
    }

    // --- TEST ECCEZIONI TANGENTE ---

    @Test(expected = IllegalArgumentException.class)
    public void testTangenteNonDefinitaRadianti() {
        calc.tangente((float) (Math.PI / 2.0), false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTangenteNonDefinitaGradi() {
        calc.tangente(90.0f, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTangenteNonDefinitaGradiCoterminale() {
        calc.tangente(270.0f, true);
    }

    // --- TEST CONVERSIONI E MODALITÀ ---

    @Test
    public void testConversioneDaRadiantiInGradi() {
        assertEquals(180.0f, calc.conversioneDaRadiantiInGradi((float) Math.PI), 0.0001f);
    }

    @Test
    public void testConversioneDaGradiInRadianti() {
        assertEquals((float) Math.PI, calc.conversioneDaGradiInRadianti(180.0f), 0.0001f);
    }

    @Test
    public void testConversioneRoundTripGradiRadianti() {
        float gradiOriginali = 123.456f;
        float radianti = calc.conversioneDaGradiInRadianti(gradiOriginali);
        float gradiRiconvertiti = calc.conversioneDaRadiantiInGradi(radianti);
        assertEquals(gradiOriginali, gradiRiconvertiti, 0.0001f);
    }

    @Test
    public void testSetDegreeMode() {
        calc.setDegree_mode(true);
        assertTrue(calc.isDegree_mode());
    }

    @Test
    public void testDivisioneConValoreNegativo() {
        assertEquals(-2.5f, calc.divisione(-10.0f, 4.0f), 0.0001f);
    }

    @Test
    public void testDivisioneConZeroAlNumeratore() {
        assertEquals(0.0f, calc.divisione(0.0f, 7.0f), 0.0001f);
    }
}
