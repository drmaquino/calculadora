package main.desktop.controller;

import main.desktop.view.CalculadoraView;
import main.model.Calculadora;

import org.eclipse.swt.widgets.Button;

public class CalculadoraController
{
    private Calculadora calculadora;
    private CalculadoraView calculadoraView;

    public CalculadoraController(CalculadoraView view)
    {
        this.calculadora = new Calculadora();
        this.calculadoraView = view;
    }

    public void callback(Button button)
    {
        switch (button.getText())
        {
            case "/":
            case "*":
            case "-":
            case "+":
                updateDisplay(button.getText());
                break;
            case "=":
                updateDisplay(button.getText());
                break;
            case ".":
                updateDisplay(button.getText());
                break;
            case "CE":
                updateDisplay(button.getText());
                break;
            default:
                updateDisplay(button.getText());
                break;
        }
    }

    public void updateDisplay(String arg)
    {
        this.calculadoraView.getDisplayText().setText(arg);
    }
}
