package tarot.view;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tarot.controller.TarotController;

import tarot.view.TarotFrame;
import tarot.view.TarotPanel;


public class TarotCardLayout
{
	JFrame frame = new JFrame("CardLayout demo");
	JPanel panelCont = new JPanel();
	JPanel panelFirst = new JPanel();
	JPanel panelSecond = new JPanel();
	JButton buttonOne = new JButton("Switch to 2nd panel");
	JButton buttonTwo = new JButton("Switch to 1st panel");
	JButton buttonThree = new JButton("Switch to 3 set Draw");
	CardLayout cl = new CardLayout();
	
	public TarotCardLayout()	//constructor for the CardLayout
	{
		panelCont.setLayout(cl);
		
		panelFirst.add(buttonOne);
		panelSecond.add(buttonTwo);
		
		panelCont.add(panelFirst, "1");	//"1" is the identifier
		panelCont.add(panelSecond, "2");
		cl.show(panelCont, "1");
		
		frame.add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		//frame.setContentPane(appPanel);
		frame.setResizable(false);
		frame.setSize(900, 750);	//CAN CHANGE IN THE FUTURE!!!
		frame.setVisible(true);
		
		//Method Calls
		setupLayout();
		setupListeners();
	}
	
	public void setupLayout()
	{
		panelFirst.setBackground(Color.blue);
		panelSecond.setBackground(Color.GREEN);
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
		
	}
	
	public static void main(String[] args)	//Force runs this class only for checking how it works
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TarotCardLayout();
			}
		});
	}
}