package main.android;

import java.util.Observable;
import java.util.Observer;

public class DisplayObserver implements Observer
{
    private Object caller;

	public DisplayObserver(Object caller)
    {
    	this.caller = caller;
    }
    
    @Override
    public void update(Observable arg0, Object arg1)
    {
        ((MainActivity) this.caller).updateDisplay(arg1.toString());
    }
}
