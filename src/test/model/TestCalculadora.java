package test.model;

import static org.junit.Assert.assertEquals;
import main.model.Calculadora;

import org.junit.*;

public class TestCalculadora
{
	double delta = 0.001;
	
	@Test
	public void testCalculadora()
	{
		Calculadora calc = new Calculadora();
		assertEquals(Calculadora.class, calc.getClass());
	}
}