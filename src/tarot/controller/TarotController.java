package tarot.controller;

import tarot.view.TarotFrame;
import tarot.view.PopupDisplay;
import tarot.model.TarotCards;
import java.util.List;
import java.util.ArrayList;

public class TarotController
{
	private TarotFrame appFrame;
	private PopupDisplay display;
	private TarotCards myCards;
	
	/**
	 * initializes certain values as well as activate them
	 */
	public TarotController()
	{
		display = new PopupDisplay();
		appFrame = new TarotFrame(this);
		myCards = new TarotCards(this);
	}
	
	public void start()
	{
		String fileContents = TarotFileReader.readFromFile(this, "TarotCardMeanings.txt");
		createDeck();
	}
	
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public void createDeck()
	{
		myCards.fillDeck();
		myCards.randomSelector();
	}
}
