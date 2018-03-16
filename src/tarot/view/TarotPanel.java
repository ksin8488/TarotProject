package tarot.view;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import tarot.controller.TarotController;
import tarot.model.TarotCards;
import tarot.model.Card;
import java.awt.Color;
import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TarotPanel extends JPanel
{
	private List<Card> cardInfo;
	private TarotController appController;
	private JButton tarotButton;
	private JTextArea tarotArea; //Display Tarot Card information
	private JLabel cardOne;
	private JLabel cardTwo;
	private JLabel cardThree;
	private SpringLayout appLayout;
	private JLabel infoLabel; 	//OTHER WAY to display the Tarot Card information
	
	
	/**
	 * Initializes GUI data members and then calls the methods when the app runs
	 * @param appController - checks if the app has run
	 */
	public TarotPanel(TarotController appController)
	{
		super();
		this.appController = appController;
		this.cardInfo = new ArrayList<Card>();
		
		//Initialize GUI data members
		tarotButton = new JButton("Draw Cards");
		tarotArea = new JTextArea(10, 10);	//CAN CHANGE DIMENSIONS
		cardOne = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/Death.png")), JLabel.CENTER);
		cardTwo = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/Death.png")), JLabel.CENTER);
		cardThree = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/Death.png")), JLabel.CENTER);
		appLayout = new SpringLayout();
		
		//Method Calls
		setupPanel();
		setupLayout();
		updateImages();
		setupListeners();
	}
	
	private void updateImages()
	{
		
		String path = "/tarot/view/images/";
		String defaultName = "Death";
		String nameOne = cardInfo.get(0).getCardName();
		String extension = ".png";
		ImageIcon cardImage;	//import image icon
		try
		{
			cardImage = new ImageIcon(getClass().getResource(path + nameOne + extension));
		}
		catch (NullPointerException missingImageFile)
		{
			cardImage = new ImageIcon(getClass().getResource(path + defaultName + extension));
			System.out.println("ERROR. Image File Not Found");
		}
		cardOne.setIcon(cardImage);
		
		String nameTwo = cardInfo.get(1).getCardName();
		try
		{
			cardImage = new ImageIcon(getClass().getResource(path + nameTwo + extension));
		}
		catch (NullPointerException missingImageFile)
		{
			cardImage = new ImageIcon(getClass().getResource(path + defaultName + extension));
			System.out.println("ERROR. Image File Not Found");
		}
		cardTwo.setIcon(cardImage);
		
		String nameThree = cardInfo.get(2).getCardName();
		try
		{
			cardImage = new ImageIcon(getClass().getResource(path + nameThree + extension));
		}
		catch (NullPointerException missingImageFile)
		{
			cardImage = new ImageIcon(getClass().getResource(path + defaultName + extension));
			System.out.println("ERROR. Image File Not Found");
		}
		cardThree.setIcon(cardImage);
	}
	
	/**
	 * Set's the data members and ensures users can't access certain fields
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(tarotButton);
		this.add(tarotArea);
		this.add(cardOne);
		this.add(cardTwo);
		this.add(cardThree);
		tarotArea.setEnabled(false);		//makes it so user can't enable it
		tarotArea.setEditable(false);	//makes it so user can't type into it
	}
	
	/**
	 * Sets up the layout of the windows
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.SOUTH, tarotArea, 0, SpringLayout.SOUTH, this);
	}
	
	/**
	 * Allows the inputs to go and interact with the controller and such
	 */
	private void setupListeners()
	{
		
	}
}
