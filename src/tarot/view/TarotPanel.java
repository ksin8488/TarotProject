package tarot.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import tarot.controller.TarotController;
import java.awt.Color;
import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TarotPanel extends JPanel
{
	private TarotController appController;
	private JButton tarotButton;
	private JTextArea tarotArea; //Display Tarot Card information
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
		tarotButton = new JButton("Draw Cards");
		tarotArea = new JTextArea(10, 25);	//CAN CHANGE DIMENSIONS
		appLayout = new SpringLayout();
		
		//Method Calls
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Set's the data members and ensures users can't access certain fields
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(tarotButton);
		tarotArea.setEnabled(false);		//makes it so user can't enable it
		tarotArea.setEditable(false);	//makes it so user can't type into it
	}
	
	/**
	 * Sets up the layout of the windows
	 */
	private void setupLayout()
	{
		
	}
	
	/**
	 * Allows the inputs to go and interact with the controller and such
	 */
	private void setupListeners()
	{
		
	}
}
