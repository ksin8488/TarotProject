package tarot.view;

import tarot.controller.TarotController;
import javax.swing.JFrame;

/**
 * Sets and creates the frame for the GUI that the panel will be in
 * @author ksin8488
 *
 */
public class TarotFrame extends JFrame
{
	private TarotController appController;
	private TarotPanel appPanel;
	
	/**
	 * Checks if the app has ran and then loads the setupFrame() to create the frame
	 * @param appController - Looks for the program to run
	 */
	public TarotFrame(TarotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new TarotPanel(appController);
		
		setupFrame();
	}
	
	/**
	 * Constructor sets up the frame and its values/conditions
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Tarot Card Program");
		this.setResizable(false);
		this.setSize(900, 750);	//CAN CHANGE IN THE FUTURE!!!
		this.setVisible(true);
	}
}
