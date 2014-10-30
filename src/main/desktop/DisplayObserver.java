package main.desktop;

import java.util.Observable;
import java.util.Observer;

import main.desktop.controller.CalculadoraController;

public class DisplayObserver implements Observer
{
    private CalculadoraController calculadoraController;
    
    public DisplayObserver(CalculadoraController calculadoraController)
    {
        this.calculadoraController = calculadoraController;
    }
    
    @Override
    public void update(Observable arg0, Object arg1)
    {
        this.calculadoraController.updateDisplay(arg1.toString());
    }
}
