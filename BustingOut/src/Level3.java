import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Level3 extends JPanel {

	//----------------------------------------
	// ATTRIBUTES
	//----------------------------------------
	JButton ok;
	Paddle paddle1;
	int x = 300, y = 600;
	Display3 d3;
	PlayField3 pf3;
	
	//----------------------------------------
	// CONSTRUCTOR
	//----------------------------------------
	public Level3()
	{
		super();
		
		
		
		setLayout(new BorderLayout());
		
		d3 = new Display3();
		pf3 = new PlayField3(d3);
		
		add(d3,"East");
		add(pf3,"Center");
		
		
	}// end constructor
	
	//----------------------------------------
	// METHODS
	//----------------------------------------
	
	
	
}// end class