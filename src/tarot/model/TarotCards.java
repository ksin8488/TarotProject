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
 
//import java.util.HashMap;

public class TarotCards
{
	private TarotController appController;
	private List<String> deck;
	private List<Card> cardInfo;
	
	
	public TarotCards(TarotController appController)
	{
		this.appController = appController;
		this.deck = new ArrayList<String>();
		this.cardInfo = new ArrayList<Card>();
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
		int cardIndex = 999999;	//super large number so it's not null but also very strange
		String cardType = "";
		String cardDescription = "";
		Random randomizer = new Random();
		int number = (int)Math.random() * (0 - deck.size() + 1);
		
		if(((2 * number) + 1) % 2 == 1)	//if the random number is odd...
		{
			cardIndex = number;
			cardType = deck.get(number);
			cardDescription = deck.get(number + 1);
			cardInfo.add(new Card(number, cardType, cardDescription));
		}
	}
	
	public void cardImageInfo()
	{
		String [] cardFullName = cardInfo.get(0).getCardType().split(" ");
		String cardName = cardFullName[0];
		String cardOrientation = cardFullName[1];
		
	}
 }

