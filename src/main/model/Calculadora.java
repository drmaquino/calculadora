package main.model;

import java.util.Observable;

import main.model.operaciones.Operacion;
import main.model.operaciones.OperacionFactory;

public class Calculadora extends Observable
{
    private String resultado;
    private String lastResultado;
    private String numBuffer;
    private String signoBuffer;
    private OperacionFactory operacionFactory;

    public Calculadora()
    {
        this.setResultado("0");
        this.signoBuffer = null;
        this.setNumBuffer(null);
        this.operacionFactory = new OperacionFactory();
    }

    public String getResultado()
    {
        return resultado;
    }

    public void setResultado(String resultado)
    {
        this.resultado = resultado;
    }

    public String getNumBuffer()
    {
        return numBuffer;
    }

    public void setNumBuffer(String numBuffer)
    {
        this.numBuffer = numBuffer;
    }

    public void addNumero(String numero)
    {
        this.lastResultado = "0";
        if (this.getNumBuffer() == null)
        {
            this.setNumBuffer("");
        }
        this.setNumBuffer(this.getNumBuffer() + numero);
        setChanged();
        notifyObservers(getNumBuffer());
//        return this.getNumBuffer();
    }

    public void addPunto()
    {
        if (getNumBuffer() == null)
            setNumBuffer("0");
        if (!this.getNumBuffer().contains("."))
        {
            this.setNumBuffer(this.getNumBuffer() + ".");
        }
        setChanged();
        notifyObservers(getNumBuffer());
//        return this.getNumBuffer();
    }

    public void setSigno(String signo)
    {
        if (this.getNumBuffer() == null)
            this.setNumBuffer(this.lastResultado);
        update();
        this.signoBuffer = signo;
//        return this.signoBuffer;
    }

    public void igual()
    {
        update();
        setChanged();
        notifyObservers(getResultado());
//        return this.getResultado();
    }

    public void clear()
    {
        this.setResultado("0");
        this.setNumBuffer(null);
        this.signoBuffer = null;
        setChanged();
        notifyObservers(getResultado());
//        return this.getResultado();
    }

    private void update()
    {
        Operacion operacion;

        if (this.getNumBuffer() != null)
        {
            if (this.signoBuffer != null)
            {
                try
                {
                    Double operando1 = Double.valueOf(this.getResultado());
                    Double operando2 = Double.valueOf(this.getNumBuffer());

                    operacion = this.crearOperacion(this.signoBuffer);
                    operacion.setOperando1(operando1);
                    operacion.setOperando2(operando2);
                    Double tmp = operacion.calcular();
                    if (tmp == null)
                    {
                        this.setResultado("ERROR");
                    } else
                    {
                        this.setResultado(tmp.toString());
                    }
                } catch (Exception e)
                {
                    this.setResultado("");
                }
                this.setNumBuffer(null);
                this.signoBuffer = null;
            } else
            {
                this.setResultado(getNumBuffer());
                this.setNumBuffer(null);
            }
        } else
        {
            if (this.signoBuffer == null)
            {
                this.setResultado("0");
            } else
            {
                // nada
            }
        }

        this.lastResultado = this.getResultado();
//        return this.getResultado();
    }

    private Operacion crearOperacion(String signo)
    {
        return this.operacionFactory.getOperacion(signo);
    }
}