package test.model.operaciones;

import static org.junit.Assert.assertEquals;
import main.model.operaciones.Division;
import main.model.operaciones.Multiplicacion;
import main.model.operaciones.Operacion;
import main.model.operaciones.OperacionFactory;
import main.model.operaciones.Resta;
import main.model.operaciones.Suma;

import org.junit.Test;

public class TestOperacionFactory
{
    @Test
    public void testFabricaRecibeUnMasYDevuelveUnaSuma()
    {
        String operacion = "+";
        OperacionFactory of = new OperacionFactory();
        Operacion objetoOperacion = of.getOperacion(operacion);
        assertEquals(Suma.class, objetoOperacion.getClass());
    }
    
    @Test
    public void testFabricaRecibeUnMenosYDevuelveUnaResta()
    {
        String operacion = "-";
        OperacionFactory of = new OperacionFactory();
        Operacion objetoOperacion = of.getOperacion(operacion);
        assertEquals(Resta.class, objetoOperacion.getClass());
    }
    
    @Test
    public void testFabricaRecibeUnaBarraYDevuelveUnaDivision()
    {
        String operacion = "/";
        OperacionFactory of = new OperacionFactory();
        Operacion objetoOperacion = of.getOperacion(operacion);
        assertEquals(Division.class, objetoOperacion.getClass());
    }
    
    @Test
    public void testFabricaRecibeUnAsteriscoYDevuelveUnaMultiplicacion()
    {
        String operacion = "*";
        OperacionFactory of = new OperacionFactory();
        Operacion objetoOperacion = of.getOperacion(operacion);
        assertEquals(Multiplicacion.class, objetoOperacion.getClass());
    }
}
