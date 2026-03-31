package calcolatrice_scrum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAutomatizzatoCalcolatrice {

    private Calcolatrice calc;
  
    @BeforeEach
    public void setUp() {
        calc = new Calcolatrice();
    }

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
}
