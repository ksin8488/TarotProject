package tarot.controller;

import tarot.view.TarotFrame;
import tarot.view.PopupDisplay;
import java.util.List;
import java.util.ArrayList;

public class TarotController
{
	private TarotFrame appFrame;
	private PopupDisplay display;
	
	/**
	 * initializes certain values as well as activate them
	 */
	public TarotController()
	{
		display = new PopupDisplay();
		appFrame = new TarotFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
}
