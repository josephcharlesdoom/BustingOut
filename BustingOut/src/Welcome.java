
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome extends JPanel {

	//----------------------------------------
	// ATTRIBUTES
	//----------------------------------------
	JButton option;
	JButton instruct;
	JButton play;
	JButton quit;
	JLabel title;
	Display3 d3;
	ImageIcon image1, image2, image3, image4;
	JLabel names;
	
	
	
	//----------------------------------------
	// CONSTRUCTOR
	//----------------------------------------
	public Welcome()
	{
		play = new JButton();
		play.setBounds(700,200,180,60);
		play.setContentAreaFilled(false);
		play.setBorder(null);
		image1 = new ImageIcon("images/button_play.png");
		play.setIcon(image1);
		add(play);
	
		instruct = new JButton();
		instruct.setBounds(700,300,180,60);
		instruct.setContentAreaFilled(false);
		instruct.setBorder(null);
		image2 = new ImageIcon("images/button_info.png");
		instruct.setIcon(image2);
		add(instruct);
		
		option = new JButton();
		option.setBounds(700,400,180,60);
		option.setContentAreaFilled(false);
		option.setBorder(null);
		image3 = new ImageIcon("images/button_options.png");
		option.setIcon(image3);
		add(option);
		
		quit = new JButton();
		quit.setBounds(700,500,180,60);
		quit.setContentAreaFilled(false);
		quit.setBorder(null);
		image4 = new ImageIcon("images/button_quit.png");
		quit.setIcon(image4);
		add(quit);
		
		title = new JLabel("BUSTIN OUT!!!");
		title.setForeground(Color.white);
		title.setBounds(150,-45,600,250);
		Font f1 = new Font("Dialog", Font.PLAIN, 48);
		title.setFont(f1);
		add(title);
		
		names = new JLabel("By: Joseph Ahart");
		names.setForeground(Color.white);
		names.setBounds(45, 505, 1000, 250);
		names.setFont(f1);
		add(names);
		
		
		setLayout(null);
		
	}// end constructor
	
	//----------------------------------------
	// METHODS
	//----------------------------------------
	public void paintComponent (Graphics g)
	 {
	    super.paintComponent(g);
	    Image myImage = Toolkit.getDefaultToolkit().getImage("images/wood.jpg");
	    g.drawImage(myImage, 0, 0, this);
	 }

	
	
}// end class