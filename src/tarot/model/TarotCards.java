package tarot.model;

import tarot.controller.TarotController;
import tarot.controller.TarotFileReader;
import tarot.model.Card;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

import java.util.Random;
import java.awt.*;
 

public class TarotCards
{
	private TarotController appController;
	private List<String> deck;
	private List<Card> cardInfo;
	private int drawSize = 3;
	
	
	public TarotCards(TarotController appController)
	{
		this.appController = appController;
		this.deck = new ArrayList<String>();
		this.cardInfo = new ArrayList<Card>();
		
		//Calling methods
		fillDeck();
		
		for(int index = 0; index < drawSize; index++)
		{
			randomSelector();	//gets called 3 times to get 3 random cards
		}
	
	}
	
	public void fillDeck()
	{
		String fileText = TarotFileReader.readFromFile(appController, "TarotCardMeanings.txt");
		String [] cutDeck = fileText.split("/n");
		
		for(int index = 0; index < cutDeck.length; index++)
		{
			deck.add(cutDeck[index]);	//uses cut deck to split the file and loads them into the array
		}
	}
	
	public void randomSelector()	//MAY NOT HAVE A VOID TYPE IN THE FUTURE
	{
		boolean lookingForCard = true;

		
		while(lookingForCard)
		{
			int cardIndex = 99999;	//super large number so it's not null but also very strange
			String cardType = "";
			String cardDescription = "";

			Random generator = new Random(System.currentTimeMillis());
			
			int number = generator.nextInt(deck.size() - 0) + 1;
			
			if(number % 2 == 0 && number < deck.size())	//if the random number is even...
			{
				deck.size();
				cardIndex = number;
				cardType = deck.get(number);
				cardDescription = deck.get(number + 1);
				String [] cardFullName = cardType.split(" ");
				String cardName = cardFullName[0];
				String cardOrientation = cardFullName[1];
				cardInfo.add(new Card(number, cardType, cardDescription, cardFullName, cardName, cardOrientation));
				deck.remove(number);
				deck.size();
				deck.remove(number + 1);
				deck.size();
				lookingForCard = false;
			}
		}

	}
	
	//Getter to return the cardInfo array
	public List<Card> getCardInfo()
	{
		return cardInfo;
	}

	public void clearOldCards()
	{
		deck.clear();
		cardInfo.clear();
	}

 }

