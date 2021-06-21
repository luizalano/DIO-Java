import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    @Test
    public void testSomar(){
        Calculadora calc = new Calculadora();
        int soma = calc.somar("1+1+3+2");
        assertEquals (7, soma);
    }
}
