package model;

public class Calculadora
{
    private String displayBuffer;
    private String operationBuffer;
    private String resultBuffer;    
    
    public String getNumberBuffer()
    {
        return displayBuffer;
    }
    public void setNumberBuffer(String numberBuffer)
    {
        this.displayBuffer = numberBuffer;
    }
    public String getOperationBuffer()
    {
        return operationBuffer;
    }
    public void setOperationBuffer(String operationBuffer)
    {
        this.operationBuffer = operationBuffer;
    }
    public String getResultBuffer()
    {
        return resultBuffer;
    }
    public void setResultBuffer(String resultBuffer)
    {
        this.resultBuffer = resultBuffer;
    }
}
