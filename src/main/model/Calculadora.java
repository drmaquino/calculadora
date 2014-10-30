/**
 *  Calculadora 1.0
 *  Autores:
 *      Mariano Aquino,
 *      Ezequiel Lansztein,
 *      Ivan Bevivino
 *  
 *  Known bugs:
 *      presionar signos repetidamente realiza la operacion sobre sí mismo, sobre su último valor registrado.  
 */

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
    
    private String getLastResultado()
    {
        return this.lastResultado;
    }

    public String getNumBuffer()
    {
        return numBuffer;
    }

    public String getResultado()
    {
        return resultado;
    }

    private String getSignoBuffer()
    {
        return this.signoBuffer;
    }
    
    private void setLastResultado(String lastResultado)
    {
        this.lastResultado = lastResultado;
    }

    public void setNumBuffer(String numBuffer)
    {
        this.numBuffer = numBuffer;
    }

    public void setResultado(String resultado)
    {
        this.resultado = resultado;
    }

    private void setSignoBuffer(String signoBuffer)
    {
        this.signoBuffer = signoBuffer;
    }
    
    private Operacion getOperacion(String signo)
    {
        return this.operacionFactory.getOperacion(signo);
    }

    public Calculadora()
    {
        this.setResultado("0");
        this.setSignoBuffer(null);
        this.setNumBuffer(null);
        this.operacionFactory = new OperacionFactory();
    }

    public void addNumero(String numero)
    {
        this.setLastResultado("0");
        if (this.getNumBuffer() == null)
        {
            this.setNumBuffer("");
        }
        this.setNumBuffer(this.getNumBuffer() + numero);
        setChanged();
        notifyObservers(getNumBuffer());
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
    }

    public void setSigno(String signo)
    {
        if (this.getNumBuffer() == null)
            this.setNumBuffer(this.getLastResultado());
        update();
        setChanged();
        notifyObservers(getResultado());
        this.setSignoBuffer(signo);
    }

    public void clear()
    {
        this.setResultado("0");
        this.setNumBuffer(null);
        this.setSignoBuffer(null);
        setChanged();
        notifyObservers(getResultado());
    }

    public void igual()
    {
        update();
        setChanged();
        notifyObservers(getResultado());
    }

    private void update()
    {
        Operacion operacion;

        if (this.getNumBuffer() != null)
        {
            if (this.getSignoBuffer() != null)
            {
                try
                {
                    Double operando1 = Double.valueOf(this.getResultado());
                    Double operando2 = Double.valueOf(this.getNumBuffer());

                    operacion = this.getOperacion(this.signoBuffer);
                    operacion.setOperando1(operando1);
                    operacion.setOperando2(operando2);
                    Double tmp = operacion.calcular();
                    if (tmp == null)
                    {
                        this.setResultado("ERROR");
                    }
                    else
                    {
                        this.setResultado(tmp.toString());
                    }
                }
                catch (Exception e)
                {
                    this.setResultado("");
                }
                this.setNumBuffer(null);
                this.setSignoBuffer(null);
            }
            else
            {
                this.setResultado(getNumBuffer());
                this.setNumBuffer(null);
            }
        }
        else
        {
            if (this.signoBuffer == null)
            {
                this.setResultado("0");
            }
            else
            {
                // nada
            }
        }
        this.setLastResultado(this.getResultado());
    }
}