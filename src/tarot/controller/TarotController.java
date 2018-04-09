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
		myCards = new TarotCards(this);
		appFrame = new TarotFrame(this);
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
		myCards.clearOldCards();	//clears out the old deck and CardInfo to create new ones
		myCards.fillDeck();		//re-creates a brand new deck
		myCards.randomSelector();
		myCards.randomSelector();	//Gets the 2nd random card from the deck
		myCards.randomSelector();	//Gets the 3rd random card from the deck
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
