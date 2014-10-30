package main.android;

import main.model.Calculadora;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Calculadora calculadora = new Calculadora();
    private DisplayObserver displayObserver = new DisplayObserver(this);
    private TextView texto;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculadora.addObserver(this.displayObserver);
        texto = (TextView) findViewById(R.id.editTotal);
    }
    
    public void updateDisplay(String text)
    {
    	this.texto.setText(text);
    }

    public void calcNumero1(View v) {
        calculadora.addNumero("1");
    }

    public void calcNumero2(View v) {
        calculadora.addNumero("2");
    }

    public void calcNumero3(View v) {
        calculadora.addNumero("3");
    }

    public void calcNumero4(View v) {
        calculadora.addNumero("4");
    }

    public void calcNumero5(View v) {
        calculadora.addNumero("5");
    }

    public void calcNumero6(View v) {
        calculadora.addNumero("6");
    }

    public void calcNumero7(View v) {
        calculadora.addNumero("7");
    }

    public void calcNumero8(View v) {
        calculadora.addNumero("8");
    }

    public void calcNumero9(View v) {
        calculadora.addNumero("9");
    }

    public void calcNumero0(View v) {
        calculadora.addNumero("0");
    }

    public void calcNumeroDot(View v) {
        calculadora.addPunto();
    }

    public void calcFunctionClear(View v) {
        calculadora.clear();
    }

    public void calcOperacionIgual(View v) {
        calculadora.igual();
    }

    public void calcOperacionSuma(View v) {
        calculadora.setSigno("+");
    }

    public void calcOperacionResta(View v) {
        calculadora.setSigno("-");
    }

    public void calcOperacionMultiplicacion(View v) {
        calculadora.setSigno("*");
    }

    public void calcOperacionDivision(View v) {
        calculadora.setSigno("/");
    }
}
