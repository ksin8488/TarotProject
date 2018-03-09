package tarot.model;

import tarot.controller.TarotController;
import tarot.controller.TarotFileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.HashMap;

public class Tarot
{
	private TarotController appController;
	private List<String> deckInfo;
	
	public Tarot(TarotController appController)
	{
		this.appController = appController;
		this.deckInfo = new ArrayList<String>();
	}
	
	private void fillDeckInfo()
	{
		String fileText = TarotFileReader.readFromFile(appController, "TarotCardMeanings.txt");
		//deckInfo.add(fileText); //doesn't work try to fix this
		String [] cutDeck = fileText.split("/n");
		
		for(int index = 0; index < cutDeck.length; index++)
		{
			deckInfo.add(cutDeck[index]);	//DO DEBUGGING TO CHECK (have to call fillDeckInfo)
		}
	}
	
}
