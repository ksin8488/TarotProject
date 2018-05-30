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
		cardOneDescription = new JTextArea(5, 50);
		cardOneDescription.setBackground(Color.BLACK);
		cardOneDescription.setForeground(Color.WHITE);
		
		cardOne = new JLabel("", new ImageIcon(getClass().getResource("/tarot/view/images/ImageNotFound.png")), JLabel.CENTER);
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
		
	}
	
	private void updateText()
	{
		
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.RED);
		this.setLayout(appLayout);
		this.add(drawCardsButton);
		this.add(cardOne);
		this.add(cardOneDescription);
		
		cardOneDescription.setEnabled(false);
		cardOneDescription.setEditable(false);
	}
	
	private void setupLayout()
	{
		
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
				
			}
		});
	}
}
