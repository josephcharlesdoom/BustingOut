import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Instruction extends JPanel {

	//----------------------------------------
	// ATTRIBUTES
	//----------------------------------------
	JButton ok;
	JPanel title;
	JLabel title2, info1, info2, info3, space1, space2, space3;
	
	
	//----------------------------------------
	// CONSTRUCTOR
	//----------------------------------------
	public Instruction()
	{
		setBackground(Color.cyan);
		setLayout(new GridLayout(8,1));
		
		JPanel title = new JPanel();
		Font f1 = new Font("Dialog", Font.BOLD, 56);		
		JLabel title2 = new JLabel("INSTRUCTIONS");
		title.setBackground(Color.cyan);
		title2.setFont(f1);
		title.add(title2);
		add(title);
		
		JLabel space1 = new JLabel();
		add(space1);
		
		JLabel info1 = new JLabel("     Press Spacebar to Begin and Pause Game");
		Font f2 = new Font("Dialog", Font.PLAIN, 18);
		info1.setFont(f2);
		add(info1);
		
		JLabel info2 = new JLabel("     Use the A and D keys to move the paddle left or right");
		info2.setFont(f2);
		add(info2);
		
		JLabel info3 = new JLabel("     Break the Bricks without losing the ball!");
		info3.setFont(f2);
		add(info3);
		
		JLabel space2 = new JLabel("     Click the HULK to move to next level");
		space2.setFont(f2);
		add(space2);
		
		JLabel space3 = new JLabel();
		add(space3);
		
		ok = new JButton("BACK");
		add(ok);
		
		
	}// end constructor
	
	//----------------------------------------
	// METHODS
	//----------------------------------------
	
	
	
}// end class