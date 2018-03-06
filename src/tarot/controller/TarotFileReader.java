package tarot.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TarotFileReader
{
	public static String readFromFile(TarotController app, String filename)
	{
		String contents = "";
		String path = "TarotCardMeanings.txt";
		try
		{
			Scanner fileScanner = new Scanner(new File(path));
			while(fileScanner.hasNextLine())
			{
				String row = fileScanner.nextLine();
				contents += row + "/n";
			}
			fileScanner.close();
		}
		catch(FileNotFoundException error)
		{
			System.out.println("There was an error:" + error.getMessage());
		}
		return contents;
	}
	
	//RANDOMIZE THIS!!!
	public static String readCardType(TarotController app, String filename)
	{
		String cardType = "";
		String path = "TarotCardMeanings.txt";
		try
		{
			Scanner fileScanner = new Scanner(new File(path));
			while(fileScanner.hasNextLine())
			{
				String row = fileScanner.nextLine();
				cardType += row + "/n";
			}
			fileScanner.close();
		}
		catch(FileNotFoundException error)
		{
			System.out.println("There was an error:" + error.getMessage());
		}
		return cardType;
	}
}
