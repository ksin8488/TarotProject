package tarot.controller;

import tarot.view.TarotFrame;
import tarot.view.PopupDisplay;
import tarot.model.TarotCards;
import tarot.view.TarotCardLayout;
import java.util.List;
import java.util.ArrayList;

public class TarotController
{
	private TarotFrame appFrame;
	private PopupDisplay display;
	private TarotCards myCards;
	private TarotCardLayout layout;
	
	/**
	 * initializes certain values as well as activate them
	 */
	public TarotController()
	{
		display = new PopupDisplay();
		myCards = new TarotCards(this);
		layout = new TarotCardLayout(this);
	}
	
	public void start()
	{
		createDeck();
	}
	
	/**
	 * When an error is triggered, it will display error text to the console 
	 * @param error - gets an error from the program when needed
	 */
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	/**
	 * Recreates a deck after clearing arrays out by calling multiple methods
	 */
	public void createDeck()
	{
		int drawSize = 4;
		myCards.clearOldCards();	//clears out the old deck and CardInfo to create new ones
		myCards.fillDeck();		//re-creates a brand new deck
		for(int i = 0; i < drawSize; i++)
		{
			myCards.randomSelector();
		}
	}
	
	/**
	 * Returns the information gained from the cards
	 * @return - returns the info from what's been done
	 */
	public TarotCards getMyCards()
	{
		return myCards;
	}
}
