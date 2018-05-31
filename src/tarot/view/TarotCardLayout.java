package tarot.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import tarot.controller.TarotController;


public class TarotCardLayout
{
	JFrame frame = new JFrame("Tarot Cards");
	JPanel panelCont = new JPanel();
	JPanel panelFirst = new JPanel();
	//JPanel panelSecond = new JPanel();
	
	JButton TarotPanelButton = new JButton("3 Card Spread");
	JButton TarotOneCardSpreadButton = new JButton("Single Card Spread");
	JButton TarotCrossSpreadButton = new JButton("Cross Spread");
	
	JButton threeDrawPanelReturn = new JButton("Menu");
	CardLayout cl = new CardLayout();
	
	TarotPanel threeDrawPanel;
	TarotOneCardSpread oneDrawPanel;
	TarotCrossSpread fourDrawPanel;
	
	public TarotCardLayout(TarotController appController)	//constructor for the CardLayout
	{
		
		threeDrawPanel = new TarotPanel(appController);
		oneDrawPanel = new TarotOneCardSpread(appController);
		fourDrawPanel = new TarotCrossSpread(appController);
		
		panelCont.setLayout(cl);
		
		panelFirst.add(TarotPanelButton);
		panelFirst.add(TarotOneCardSpreadButton);
		panelFirst.add(TarotCrossSpreadButton);
		
		
		panelCont.add(panelFirst, "1");	//"1" is the identifier
		panelCont.add(threeDrawPanel, "2");
		panelCont.add(oneDrawPanel, "3");
		panelCont.add(fourDrawPanel, "4");
		
		cl.show(panelCont, "1");
		
		frame.add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setSize(900, 750);	//CAN CHANGE IN THE FUTURE!!!
		frame.setVisible(true);
		
		panelFirst.setSize(900, 750);
		
		//Method Calls
		setupLayout();
		setupListeners();
	}
	
	public void setupLayout()
	{
		panelFirst.setBackground(Color.BLUE);	
	}
	
	public void mainMenu()
	{
		frame.getContentPane().removeAll();
		frame.add(panelCont);
	}
	
	public void setupListeners()
	{
		TarotPanelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				cl.show(panelCont, "2");
			}
		});
		
		TarotOneCardSpreadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				cl.show(panelCont, "3");
			}
		});
		
		TarotCrossSpreadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				cl.show(panelCont, "4");
			}
		});
		
	}
	
	
}