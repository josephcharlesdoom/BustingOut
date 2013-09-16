import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class Display3 extends JPanel {



	//----------------------------------------
	// ATTRIBUTES
	//----------------------------------------
	PlayField3 pf3;
	JButton ok, player, stop, go;
	int lives = 3, hits=0;
	PlayField3 play;
	JLabel jl1, jl2, jl3;
	Display1 d1;
	Level1 l1;
	Welcome wp;
	JButton wall, wall2;
	JProgressBar bossHealth;
	int j = 0;
	
	ImageIcon wallPic = new ImageIcon("images/wall.png");
	ImageIcon hulk = new ImageIcon("images/hulk.jpg");
	
	
	
	
	
	//----------------------------------------
	// CONSTRUCTOR
	//----------------------------------------
	public Display3()
	{
		super();
		
		setPreferredSize(new Dimension(350,350));
		
		setBackground(Color.black);
		setLayout(null);
		
		wall = new JButton();
		add(wall);
		wall.setIcon(wallPic);
		wall.setBounds(0,0,20,800); 
		
		wall2 = new JButton();
		add(wall2);
		wall2.setIcon(wallPic);
		wall2.setBounds(330,0,20,800); 
		
		stop = new JButton("Stop music");
		add(stop);
		stop.setBounds(120,300,100,30);
		
		go = new JButton("Play music");
		add(go);
		go.setBounds(120,350,100,30);
		
		bossHealth = new JProgressBar(0, 20);// 500 the maximun number of intervals that th progress bar will show
		bossHealth.setStringPainted(true);
		bossHealth.setString("Boss Health");
		bossHealth.setBounds(30,220,200,40); 
    	add(bossHealth);
		j = 0;
		bossHealth.setValue(j);
		
		
		ok = new JButton();
		add(ok);
		ok.setIcon(hulk);
		ok.setBounds(80,400,190,250);
		
		jl3 = new JLabel("Captain: " + " " + Control.name);
		jl3.setForeground(Color.yellow);
		jl3.setFont(new Font ("Helvetica", Font.PLAIN, 38));
		add(jl3);
		jl3.setBounds(30,10,350,60);
		
		jl1 = new JLabel("Lives: " + lives);
		jl1.setForeground(Color.yellow);
		jl1.setFont(new Font ("Helvetica", Font.PLAIN, 38));
		add(jl1);
		jl1.setBounds(30,80,350,60);
		
		jl2 = new JLabel("Bricks Hit: " + hits);
		jl2.setForeground(Color.yellow);
		jl2.setFont(new Font ("Helvetica", Font.PLAIN, 38));
		add(jl2);
		jl2.setBounds(30,140,350,60);
	}// end constructor
	
	//----------------------------------------
	// METHODS
	//----------------------------------------
	
	
	
}// end class