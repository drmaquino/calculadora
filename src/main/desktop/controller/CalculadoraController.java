package main.desktop.controller;

import main.desktop.ConsoleObserver;
import main.desktop.DisplayObserver;
import main.desktop.view.CalculadoraView;
import main.model.Calculadora;

import org.eclipse.swt.widgets.Button;

public class CalculadoraController
{
    private Calculadora calculadora;
    private CalculadoraView calculadoraView;
    private DisplayObserver displayObserver;
    private ConsoleObserver consoleObserver;

    public CalculadoraController(CalculadoraView view)
    {
        this.calculadora = new Calculadora();
        this.displayObserver = new DisplayObserver(this);
        this.consoleObserver = new ConsoleObserver();
        this.calculadora.addObserver(displayObserver);
        this.calculadora.addObserver(consoleObserver);
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
                this.calculadora.setSigno(button.getText());
                break;
            case "=":
                this.calculadora.igual();
                break;
            case ".":
                this.calculadora.addPunto();
                break;
            case "CE":
                this.calculadora.clear();
                break;
            default:
                this.calculadora.addNumero(button.getText());
                break;
        }
    }

    public void updateDisplay(String textToDisplay)
    {
        this.calculadoraView.getDisplayText().setText(textToDisplay);
    }
}
