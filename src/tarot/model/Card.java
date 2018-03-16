package tarot.model;

import java.util.Random;
import tarot.model.TarotCards;

public class Card
{
	private int cardNumber;
	private String cardType;
	private String cardDescription;
	private String [] cardFullName;
	private String cardName;
	private String cardOrientation;
	
	public Card(int cardNumber, String cardType, String cardDescription, String [] cardFullName, String cardName, String cardOrientation)
	{
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.cardDescription = cardDescription;
		this.cardFullName = cardFullName;
		this.cardName = cardName;
		this.cardOrientation = cardOrientation;
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
	
	public String [] getCardFullName()
	{
		return cardFullName;
	}
	
	public String getCardName()
	{
		return cardName;
	}
	
	public String getCardOreintation()
	{
		return cardOrientation;
	}
}
