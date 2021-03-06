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
	private TarotController appController;
	private JButton drawCardsButton;
	private JButton menuButton;
	private JTextArea cardOneDescription; //Display Tarot Card information
	private JTextArea cardTwoDescription;
	private JTextArea cardThreeDescription;
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
		
		//Initialize GUI data members
		drawCardsButton = new JButton("Draw Cards");
		menuButton = new JButton("Menu");
		cardOneDescription = new JTextArea(5, 50);	//CAN CHANGE DIMENSIONS
		cardOneDescription.setBackground(Color.BLACK);	//Sets the background color of the label
		cardOneDescription.setForeground(Color.WHITE);	//Setting the color of the text in the Label
		
		cardTwoDescription = new JTextArea(5, 50);
		cardTwoDescription.setBackground(Color.BLACK);
		cardTwoDescription.setForeground(Color.WHITE);
		
		cardThreeDescription = new JTextArea(5, 50);
		cardThreeDescription.setBackground(Color.BLACK);
		cardThreeDescription.setForeground(Color.WHITE);
		
		cardOne = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/ImageNotFound.png")), JLabel.CENTER);
		cardTwo = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/ImageNotFound.png")), JLabel.CENTER);
		cardThree = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/ImageNotFound.png")), JLabel.CENTER);
		appLayout = new SpringLayout();

		//Method Calls
		setupPanel();
		setupLayout();
		updateImages();
		updateText();
		setupListeners();
	}
		
	/**
	 * Takes the current information from CardInfo and adds them to the various Icons based on which card is which
	 */
	private void updateImages()
	{
		
		String path = "/tarot/view/images/";
		String defaultName = "ImageNotFound";
		String extension = ".png";
		ImageIcon cardImage;	//import image icon
		
		//Card 1
		String nameOne = appController.getMyCards().getCardInfo().get(0).getCardName();
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
		
		//Card 2
		String nameTwo = appController.getMyCards().getCardInfo().get(1).getCardName();
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
		
		//Card 3
		String nameThree = appController.getMyCards().getCardInfo().get(2).getCardName();
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
	 * Adds text from the current information in CardInfo to the textAreas
	 */
	private void updateText()
	{
		cardOneDescription.setText(appController.getMyCards().getCardInfo().get(0).getCardName() + 
				" " + appController.getMyCards().getCardInfo().get(0).getCardOreintation() + 
				"\n"+ appController.getMyCards().getCardInfo().get(0).getCardDescription());

		
		cardTwoDescription.setText(appController.getMyCards().getCardInfo().get(1).getCardName() + 
				" " + appController.getMyCards().getCardInfo().get(1).getCardOreintation() + 
				"\n" + appController.getMyCards().getCardInfo().get(1).getCardDescription());
		
		cardThreeDescription.setText(appController.getMyCards().getCardInfo().get(2).getCardName() + 
				" " + appController.getMyCards().getCardInfo().get(2).getCardOreintation() + 
				"\n" + appController.getMyCards().getCardInfo().get(2).getCardDescription());
	}
	
	/**
	 * Sets/adds the data members and ensures users can't access certain fields
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(drawCardsButton);
		this.add(menuButton);
		this.add(cardOne);
		this.add(cardTwo);
		this.add(cardThree);
		this.add(cardOneDescription);
		this.add(cardTwoDescription);
		this.add(cardThreeDescription);

		
		cardOneDescription.setEnabled(false);		//makes it so user can't enable it
		cardOneDescription.setEditable(false);	//makes it so user can't type into it
		cardTwoDescription.setEnabled(false);
		cardTwoDescription.setEditable(false);
		cardThreeDescription.setEnabled(false);
		cardThreeDescription.setEditable(false);
	}
	
	/**
	 * Sets up the layout of the window and the positions of various objects
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.EAST, cardThree, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, cardTwo, -150, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, cardTwo, 0, SpringLayout.SOUTH, cardOneDescription);
		appLayout.putConstraint(SpringLayout.EAST, cardTwo, 350, SpringLayout.EAST, cardOne);
		appLayout.putConstraint(SpringLayout.SOUTH, cardOneDescription, -25, SpringLayout.NORTH, cardTwoDescription);
		appLayout.putConstraint(SpringLayout.EAST, cardOneDescription, 0, SpringLayout.EAST, cardTwoDescription);
		appLayout.putConstraint(SpringLayout.SOUTH, cardTwoDescription, -20, SpringLayout.NORTH, cardThreeDescription);
		appLayout.putConstraint(SpringLayout.EAST, cardTwoDescription, 0, SpringLayout.EAST, cardThreeDescription);
		appLayout.putConstraint(SpringLayout.EAST, cardThreeDescription, -158, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, menuButton, 9, SpringLayout.SOUTH, cardThreeDescription);
		appLayout.putConstraint(SpringLayout.WEST, menuButton, 488, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, drawCardsButton, 0, SpringLayout.NORTH, menuButton);
		appLayout.putConstraint(SpringLayout.EAST, drawCardsButton, -43, SpringLayout.WEST, menuButton);
		appLayout.putConstraint(SpringLayout.SOUTH, cardThreeDescription, -48, SpringLayout.SOUTH, this);
	}
	
	/**
	 * Allows various things in the window to interact with the program and do things based on actions
	 */
	private void setupListeners()
	{
		drawCardsButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				appController.createDeck();
				updateImages();
				updateText();
			}
		});
		
		menuButton.addActionListener(new ActionListener()	//MAY NOT NEED
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				TarotCardLayout cardLayoutAccess = new TarotCardLayout(appController);
				cardLayoutAccess.mainMenu();
				TarotFrame tarotFrameAccess = new TarotFrame(appController);
				tarotFrameAccess.closeFrame();
			}
		});
	}
}
