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
	
	
	/**
	 * Initializes GUI data members and then calls the methods when the app runs
	 * @param appController - checks if the app has run
	 */
	public TarotPanel(TarotController appController)
	{
		super();
		this.appController = appController;
		
		//Initalize GUI data members
	}
	
	/**
	 * Set's the data members and ensures users can't access certain fields
	 */
	private void setupPanel()
	{
		
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
