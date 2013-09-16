import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Level2 extends JPanel {

	//----------------------------------------
	// ATTRIBUTES
	//----------------------------------------
	JButton ok;
	Paddle paddle1;
	int x = 300, y = 600;
	Display2 d2;
	PlayField2 pf2;
	
	//----------------------------------------
	// CONSTRUCTOR
	//----------------------------------------
	public Level2()
	{
		super();
		
		
		
		setLayout(new BorderLayout());
		
		d2 = new Display2();
		pf2 = new PlayField2(d2);
		
		add(d2,"East");
		add(pf2,"Center");
		
		
	}// end constructor
	
	//----------------------------------------
	// METHODS
	//----------------------------------------
	
	
	
}// end class