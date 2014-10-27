package desktop.controller;

import model.Calculadora;

import org.eclipse.swt.widgets.Button;

public class CalculadoraController
{
    private Calculadora calculadora;

    public CalculadoraController()
    {
        this.calculadora = new Calculadora();
    }
    
    public void callback(Button button)
    {
        switch(button.getText())
        {
            case "/":
            case "*":
            case "-":
            case "+":
                System.out.println(String.format("operacion (%s)", button));
                break;
            case "=":
                System.out.println(String.format("igual (%s)", button));
                break;
            case ".":
                System.out.println(String.format("punto (%s)", button));
                break;
            case "CE":
                System.out.println(String.format("borrar (%s)", button));
                break;
            default:
                System.out.println(String.format("numero (%s)", button));
                break;
        }
    }
    
    public void updateDisplay(){}
}
