package main.desktop.controller;

import main.desktop.ConsoleObserver;
import main.desktop.DisplayObserver;
import main.desktop.view.CalculadoraView;
import main.model.Calculadora;

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
        this.calculadora.addObserver(displayObserver);
        this.consoleObserver = new ConsoleObserver();
        this.calculadora.addObserver(consoleObserver);        
        this.calculadoraView = view;
    }

    public void callback(String arg)
    {
        switch (arg)
        {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                this.calculadora.addNumero(arg);
                break;
            case ".":
                this.calculadora.addPunto();
                break;
            case "/":
            case "*":
            case "-":
            case "+":
                this.calculadora.setSigno(arg);
                break;
            case "CE":
                this.calculadora.clear();
                break;
            case "=":
                this.calculadora.igual();
                break;
            default:
                this.calculadora.igual();
                break;
                
        }
    }

    public void updateDisplay(String textToDisplay)
    {
        this.calculadoraView.getDisplayText().setText(textToDisplay);
    }
}
