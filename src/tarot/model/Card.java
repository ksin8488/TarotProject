package tarot.model;

import java.util.Random;
import tarot.model.TarotCards;

public class Card
{
	private int cardNumber;
	private String cardType;
	private String cardDescription;
	
	public Card(int cardNumber, String cardType, String cardDescription)
	{
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.cardDescription = cardDescription;
	}
	
	public int getCardNumber()
	{
		return cardNumber;
	}
	
	public String getCardType()
	{
		return cardType;
	}
	
	public String getCardDescription()
	{
		return cardDescription;
	}
}
