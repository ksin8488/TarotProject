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
	JFrame frame = new JFrame("CardLayout demo");
	JPanel panelCont = new JPanel();
	JPanel panelFirst = new JPanel();
	JPanel panelSecond = new JPanel();
	JButton buttonOne = new JButton("Switch to 2nd panel");
	JButton buttonTwo = new JButton("Switch to 1st panel");
	JButton buttonThree = new JButton("Switch to 3 set Draw");
	JButton threeDrawPanelReturn = new JButton("Menu");
	CardLayout cl = new CardLayout();
	TarotPanel threeDrawPanel;
	
	public TarotCardLayout(TarotController appController)	//constructor for the CardLayout
	{
		
		threeDrawPanel = new TarotPanel(appController);
		
		panelCont.setLayout(cl);
		
		panelFirst.add(buttonOne);
		panelFirst.add(buttonThree);
		
		panelCont.add(panelFirst, "1");	//"1" is the identifier
		panelCont.add(threeDrawPanel, "3");
		cl.show(panelCont, "1");
		
		frame.getContentPane().add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setSize(900, 750);	//CAN CHANGE IN THE FUTURE!!!
		frame.setVisible(true);
		
		panelFirst.setSize(900, 750);
		panelSecond.add(buttonTwo);
		panelCont.add(panelSecond, "2");
		panelSecond.setSize(900, 750);
		
		//Method Calls
		setupLayout();
		setupListeners();
	}
	
	public void setupLayout()
	{
		panelFirst.setBackground(Color.blue);
		panelSecond.setBackground(Color.GREEN);
		//Window Layout
		
	}
	
	public void setupListeners()
	{
		buttonOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				cl.show(panelCont, "2");
			}
		});
		
		buttonTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				cl.show(panelCont, "1");
			}
		});
		
		buttonThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent click) {
				cl.show(panelCont, "3");
			}
		});
		
	}
	
	
}