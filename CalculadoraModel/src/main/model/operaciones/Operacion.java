package main.model.operaciones;

public abstract class Operacion
{
    double operando1;
    double operando2;

    public void setOperando1(double operando1)
    {
        this.operando1 = operando1;
    }

    public void setOperando2(double operando2)
    {
        this.operando2 = operando2;
    }

    public abstract Double calcular();
}
