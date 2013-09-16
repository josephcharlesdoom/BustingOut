import javax.swing.JFrame;


public class MyFrame extends JFrame{

	//----------------------------------------
	// ATTRIBUTES
	//----------------------------------------
	Control controlPanel;
	
	
	//----------------------------------------
	// CONSTRUCTOR
	//----------------------------------------
	public MyFrame(String title)
	{
		super(title);
		setSize(1150, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controlPanel = new Control();		// create an instance of control panel
		
		add(controlPanel, "Center");
		
		setVisible(true);
		
	}// end constructor
	
	//----------------------------------------
	// METHODS
	//----------------------------------------
	
	
	
}// end class
