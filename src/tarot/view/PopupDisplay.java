package tarot.view;

import javax.swing.JOptionPane;

public class PopupDisplay
{
	private String windowTitle;
	
	public PopupDisplay()
	{
		windowTitle = "Tarot Card Reader";
	}
	
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null,  message, windowTitle, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String collectResponse(String question)
	{
		String answer = "";
		
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE);
		
		return answer;
	}
}
