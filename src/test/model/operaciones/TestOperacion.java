package test.model.operaciones;

import static org.junit.Assert.assertEquals;
import main.model.operaciones.Division;
import main.model.operaciones.Multiplicacion;
import main.model.operaciones.Resta;
import main.model.operaciones.Suma;

import org.junit.Test;

public class TestOperacion
{
    double delta = 0.001;

    @Test
    public void testSumaRecibeDosValoresYDevuelveLaSumaDeLosMismos()
    {
        Suma suma = new Suma();
        suma.setOperando1(1);
        suma.setOperando2(1);
        assertEquals(2, suma.calcular(), delta);
    }

    @Test
    public void testRestaRecibeDosValoresYDevuelveLaRestaDeLosMismos()
    {
        Resta resta = new Resta();
        resta.setOperando1(3);
        resta.setOperando2(1);
        assertEquals(2, resta.calcular(), delta);
    }

    @Test
    public void testMultiplicacionRecibeDosValoresYDevuelveElProductoDeLosMismos()
    {
        Multiplicacion multiplicacion = new Multiplicacion();
        multiplicacion.setOperando1(10);
        multiplicacion.setOperando2(2);
        assertEquals(20, multiplicacion.calcular(), delta);
    }

    @Test
    public void testDivisionRecibeDosValoresYDevuelveLaDivisionDeLosMismos()
    {
        Division division = new Division();
        division.setOperando1(10);
        division.setOperando2(2);
        assertEquals(5, division.calcular(), delta);
    }

    @Test
    public void testDivisionPorCeroDevuelveNull()
    {
        Division division = new Division();
        division.setOperando1(10);
        division.setOperando2(0);
        assertEquals("division por cero no debe devolver un resultado valido",
                null, division.calcular());
    }

}
