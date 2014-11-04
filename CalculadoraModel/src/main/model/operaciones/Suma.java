package main.model.operaciones;

public class Suma extends Operacion
{
	@Override
	public Double calcular()
	{
		return this.operando1 + this.operando2;
	}
}
