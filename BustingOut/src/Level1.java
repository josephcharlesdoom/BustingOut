import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

public class Level1 extends JPanel {

	//----------------------------------------
	// ATTRIBUTES
	//----------------------------------------
	JButton ok;
	Paddle paddle1;
	int x = 300, y = 600;
	Display1 d1;
	Control c1;
	PlayField1 pf1;
	
	
	//----------------------------------------
	// CONSTRUCTOR
	//----------------------------------------
	public Level1()
	{
		super();
		
		setLayout(new BorderLayout());
		
		d1 = new Display1(c1);
		pf1 = new PlayField1(d1);
		
		add(d1,"East");
		add(pf1,"Center");
		
		
		
	}// end constructor
	
	//----------------------------------------
	// METHODS
	//----------------------------------------
	
	
	
}// end class