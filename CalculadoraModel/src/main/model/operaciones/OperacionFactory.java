package main.model.operaciones;

import java.util.Properties;

public class OperacionFactory
{
    private Properties operaciones;

    public OperacionFactory()
    {
        cargarProperties();
    }

    private void cargarProperties()
    {
        this.operaciones = new Properties();
        try
        {
            operaciones.load(getClass().getResourceAsStream("/main/model/resources/operaciones.properties"));
        }
        catch (Exception e)
        {
            System.out.println("operaciones.properties not loading properly.");
        }
    }

    public Operacion getOperacion(String operacion)
    {
        Operacion nuevaOperacion = null;

        Class operacionClass;
        String operacionPath = operaciones.getProperty(operacion);

        try
        {
            operacionClass = Class.forName(operacionPath);
            nuevaOperacion = (Operacion) operacionClass.newInstance();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return nuevaOperacion;
    }
}
