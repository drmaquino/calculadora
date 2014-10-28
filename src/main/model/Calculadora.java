package main.model;

import java.util.Observable;

import main.model.operaciones.Operacion;
import main.model.operaciones.OperacionFactory;

public class Calculadora extends Observable
{
    private double resultado;
    private String operacion_buffer;
    private Double num_buffer;
    private OperacionFactory operacionFactory;

    public Calculadora()
    {
        this.resultado = 0;
        this.operacion_buffer = null;
        this.num_buffer = null;
        this.operacionFactory = new OperacionFactory();
    }

    public Double addNumero(double numero)
    {
        if (this.num_buffer == null)
        {
            this.num_buffer = numero;
        }
        else
        {
            this.num_buffer *= 10;
            this.num_buffer += numero;
        }
        return this.num_buffer;
    }

    public String setOperacion(String operacion)
    {
        update();
        this.operacion_buffer = operacion;
        return this.operacion_buffer;
    }

    public Double igual()
    {
        update();
        return getResultado();
    }

    public Double clear()
    {
        this.resultado = 0D;
        this.num_buffer = null;
        this.operacion_buffer = null;
        return resultado;
    }

    public double getResultado()
    {
        return this.resultado;
    }

    private Double update()
    {
        Operacion operacion;

        if (this.num_buffer != null)
        {
            if (this.operacion_buffer != null)
            {
                operacion = this.crearOperacion(this.operacion_buffer);
                operacion.setOperando1(this.resultado);
                operacion.setOperando2(this.num_buffer);
                this.resultado = operacion.calcular();
                this.num_buffer = null;
                this.operacion_buffer = null;
            } else
            {
                this.resultado = num_buffer;
                this.num_buffer = null;
            }
        } else
        {
            if (this.operacion_buffer == null)
            {
                this.resultado = 0D;
                // this.num_buffer = null; //?
            } else
            {
                // nada?
            }
        }
        return this.resultado;
    }

    private Operacion crearOperacion(String signo)
    {
        return this.operacionFactory.getOperacion(signo);
    }

}