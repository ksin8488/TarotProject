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

public class TarotFourCardSpread extends JPanel
{
	private TarotController appController;
	private JButton drawCardsButton;
	private JButton menuButton;
	private JTextArea cardOneDescription;
	private JTextArea cardTwoDescription;
	private JTextArea cardThreeDescription;
	private JTextArea cardFourDescription;
	private JLabel cardOne;
	private JLabel cardTwo;
	private JLabel cardThree;
	private JLabel cardFour;
	private SpringLayout appLayout;
	private JLabel infoLabel; //May not need
	
	public TarotFourCardSpread(TarotController appController)
	{
		super();
		this.appController = appController;
		
		drawCardsButton = new JButton("Draw Cards");
		menuButton = new JButton("Menu");
		
		cardOneDescription = new JTextArea(7, 8);
		cardOneDescription.setBackground(Color.DARK_GRAY);
		cardOneDescription.setForeground(Color.WHITE);
		
		cardTwoDescription = new JTextArea(7, 8);
		cardTwoDescription.setBackground(Color.DARK_GRAY);
		cardTwoDescription.setForeground(Color.WHITE);
		
		cardThreeDescription = new JTextArea(7, 8);
		cardThreeDescription.setBackground(Color.DARK_GRAY);
		cardThreeDescription.setForeground(Color.WHITE);
		
		cardFourDescription = new JTextArea(7, 8);
		cardFourDescription.setBackground(Color.DARK_GRAY);
		cardFourDescription.setForeground(Color.WHITE);
		
		cardOne = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/ImageNotFound.png")), JLabel.CENTER);
		cardTwo = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/ImageNotFound.png")), JLabel.CENTER);
		cardThree = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/ImageNotFound.png")), JLabel.CENTER);
		cardFour = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/ImageNotFound.png")), JLabel.CENTER);
		appLayout = new SpringLayout();
		
		//Method Calls
		setupPanel();
		setupLayout();
		updateImages();
		updateText();
		setupListeners();
	}
	
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
		
		//Card 4
		String nameFour = appController.getMyCards().getCardInfo().get(3).getCardName();
		try
		{
			cardImage = new ImageIcon(getClass().getResource(path + nameFour + extension));
		}
		catch (NullPointerException missingImageFile)
		{
			cardImage = new ImageIcon(getClass().getResource(path + defaultName + extension));
			System.out.println("ERROR. Image File Not Found");
		}
		cardFour.setIcon(cardImage);	
	}
	
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
		
		cardFourDescription.setText(appController.getMyCards().getCardInfo().get(3).getCardName() + 
				" " + appController.getMyCards().getCardInfo().get(3).getCardOreintation() + 
				"\n" + appController.getMyCards().getCardInfo().get(3).getCardDescription());
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.GRAY);
		this.setLayout(appLayout);
		this.add(drawCardsButton);
		this.add(menuButton);
		this.add(cardOneDescription);
		this.add(cardTwoDescription);
		this.add(cardThreeDescription);
		this.add(cardFourDescription);
		this.add(cardOne);
		this.add(cardTwo);
		this.add(cardThree);
		this.add(cardFour);
		
		
		cardOneDescription.setEnabled(false);
		cardOneDescription.setEditable(false);
		cardOneDescription.setLineWrap(true);
		cardOneDescription.setWrapStyleWord(true);
		
		cardTwoDescription.setEnabled(false);
		cardTwoDescription.setEditable(false);
		cardTwoDescription.setLineWrap(true);
		cardTwoDescription.setWrapStyleWord(true);
		
		cardThreeDescription.setEnabled(false);
		cardThreeDescription.setEditable(false);
		cardThreeDescription.setLineWrap(true);
		cardThreeDescription.setWrapStyleWord(true);
		
		cardFourDescription.setEnabled(false);
		cardFourDescription.setEditable(false);
		cardFourDescription.setLineWrap(true);
		cardFourDescription.setWrapStyleWord(true);
		
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, cardTwoDescription, 270, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, cardThreeDescription, -270, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, cardFourDescription, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, cardOneDescription, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, cardFourDescription, -75, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, cardThreeDescription, -75, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, cardTwoDescription, -75, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, cardOneDescription, -75, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, cardThreeDescription, 0, SpringLayout.NORTH, cardOneDescription);
		appLayout.putConstraint(SpringLayout.NORTH, cardTwoDescription, 0, SpringLayout.NORTH, cardOneDescription);
		appLayout.putConstraint(SpringLayout.WEST, cardTwo, 225, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, cardThree, -225, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, cardFour, 0, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, cardFour, 0, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, cardFour, 0, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, cardThree, 0, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, cardThree, 0, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, cardTwo, 0, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, cardTwo, 0, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, cardOne, 0, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, cardOne, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, cardOne, 0, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, menuButton, 0, SpringLayout.NORTH, drawCardsButton);
		appLayout.putConstraint(SpringLayout.WEST, menuButton, 49, SpringLayout.EAST, drawCardsButton);
		appLayout.putConstraint(SpringLayout.WEST, drawCardsButton, 317, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, drawCardsButton, -10, SpringLayout.SOUTH, this);
	}
	
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

