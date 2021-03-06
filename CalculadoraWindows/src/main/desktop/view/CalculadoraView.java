package main.desktop.view;

import java.util.HashMap;
import java.util.Map;

import main.desktop.controller.CalculadoraController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CalculadoraView
{
    private CalculadoraController calculadoraController;
    private Text displayText;

    private static final String[] buttons = new String[]
    { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };

    private static final Map<String, String> buttonsMap = new HashMap<String, String>()
    {
        {
            put("7", "Siete");
            put("8", "Ocho");
            put("9", "Nueve");
            put("/", "Dividir");
            put("4", "Cuatro");
            put("5", "Cinco");
            put("6", "Seis");
            put("*", "Multiplicar");
            put("1", "Uno");
            put("2", "Dos");
            put("3", "Tres");
            put("-", "Restar");
            put("0", "Cero");
            put(".", "Punto");
            put("=", "Igual");
            put("+", "Sumar");
        }
    };

    public Text getDisplayText()
    {
        return displayText;
    }

    public void setDisplayText(Text displayText)
    {
        this.displayText = displayText;
    }

    public CalculadoraView()
    {
        this.calculadoraController = new CalculadoraController(this);
        
        KeyAdapter keyAdapter = new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (buttonsMap.containsKey(String.valueOf(e.character)) || e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    calculadoraController.callback(String.valueOf(e.character));
            }
        };
        
        Display display = new Display();
        Shell shell = new Shell(display, SWT.CLOSE | SWT.TITLE | SWT.MIN);
        shell.setText("Calculadora");
        shell.setSize(300, 200);

        final GridLayout calculatorGridLayout = new GridLayout();
        calculatorGridLayout.marginRight = 5;
        calculatorGridLayout.marginLeft = 5;
        calculatorGridLayout.marginBottom = 5;
        calculatorGridLayout.marginTop = 5;
        calculatorGridLayout.marginWidth = 10;
        calculatorGridLayout.marginHeight = 2;
        calculatorGridLayout.numColumns = 4;
        calculatorGridLayout.verticalSpacing = 2;
        calculatorGridLayout.makeColumnsEqualWidth = true;
        calculatorGridLayout.horizontalSpacing = 2;
        shell.setLayout(calculatorGridLayout);

        displayText = new Text(shell, SWT.RIGHT | SWT.BORDER);
        displayText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
        displayText.setEditable(false);
        displayText.setDoubleClickEnabled(false);
        displayText.setTextLimit(30);
        displayText.setText("0");
        displayText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 3, 1));
        displayText.addKeyListener(keyAdapter);

        final Button ceButton = new Button(shell, SWT.NONE);
        ceButton.setText(String.format("CE"));
        ceButton.setToolTipText("Borrar");
        ceButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
        ceButton.addKeyListener(keyAdapter);
        ceButton.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(final SelectionEvent e)
            {
                calculadoraController.callback(ceButton.getText());
            }
        });

        for (String buttonText : buttons)
        {
            final Button button = new Button(shell, SWT.NONE);
            button.setText(String.format("%s", buttonText));
            button.setToolTipText(buttonsMap.get(buttonText));
            button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
            button.addKeyListener(keyAdapter);
            button.addSelectionListener(new SelectionAdapter()
            {
                public void widgetSelected(final SelectionEvent e)
                {
                    calculadoraController.callback(button.getText());
                }
            });
        }

        shell.open();

        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
            {
                display.sleep();
            }
        }
        display.dispose();
    }
}
