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

public class TarotOneCardSpread extends JPanel
{
	private TarotController appController;
	private JButton drawCardsButton;
	private JButton menuButton;
	private JTextArea cardOneDescription;
	private JLabel cardOne;
	private SpringLayout appLayout;
	private JLabel infoLabel; //May not need
	
	public TarotOneCardSpread(TarotController appController)
	{
		super();
		this.appController = appController;
		
		drawCardsButton = new JButton("Draw Cards");
		menuButton = new JButton("Menu");
		cardOneDescription = new JTextArea(5, 50);
		cardOneDescription.setBackground(Color.BLACK);
		cardOneDescription.setForeground(Color.WHITE);
		
		cardOne = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/ImageNotFound.png")), JLabel.CENTER);
		appLayout = new SpringLayout();
		appLayout.putConstraint(SpringLayout.NORTH, menuButton, 0, SpringLayout.NORTH, drawCardsButton);
		appLayout.putConstraint(SpringLayout.WEST, menuButton, 52, SpringLayout.EAST, drawCardsButton);
		
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
	}
	
	private void updateText()
	{
		cardOneDescription.setText(appController.getMyCards().getCardInfo().get(0).getCardName() + 
				" " + appController.getMyCards().getCardInfo().get(0).getCardOreintation() + 
				"\n"+ appController.getMyCards().getCardInfo().get(0).getCardDescription());

	}
	
	private void setupPanel()
	{
		this.setBackground(Color.RED);
		this.setLayout(appLayout);
		this.add(drawCardsButton);
		this.add(menuButton);
		this.add(cardOneDescription);
		this.add(cardOne);
		
		
		cardOneDescription.setEnabled(false);
		cardOneDescription.setEditable(false);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, drawCardsButton, 317, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, drawCardsButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, cardOne, 256, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, cardOneDescription, 6, SpringLayout.SOUTH, cardOne);
		appLayout.putConstraint(SpringLayout.WEST, cardOneDescription, 144, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, cardOne, 361, SpringLayout.WEST, this);
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
