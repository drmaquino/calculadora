package main.model.operaciones;

public class Division extends Operacion
{
	@Override
	public Double calcular()
	{
		Double result = null;
		if (operando2 != 0)
		{
			result = this.operando1 / operando2;
		}
		return result;
	}
}
