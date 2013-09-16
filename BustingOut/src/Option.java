
		import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

		public class Option extends JPanel implements ActionListener
		{
		    static JRadioButton easy, medium, hard, chee, trippy, waves;
			
		    JTextField message;
		    JButton back,jb1, jb2, jb3, boom;
		    JLabel jl1, jl2, jl3, diff, padd, fish;
		    Level1 l1;
		    PlayField1 pf1;
		    static int speed;
		    
		    ImageIcon cheePic = new ImageIcon("images/bat_cheetah.png");
		    ImageIcon tripPic = new ImageIcon("images/bat_trippy.png");
		    ImageIcon wavePic = new ImageIcon("images/bat_waves.png");
		    ImageIcon fishPic = new ImageIcon("images/fish.jpg");
		    

			public Option()
			{		
				
		//------------------------------------------------------
		    	message = new JTextField();
		    	
		    	setBackground(Color.red);
				setLayout(null);
				
				boom = new JButton();
				boom.setBounds(100,500,250,140);
				boom.setBorder(null);
				boom.setIcon(fishPic);
				add(boom);
				
				back = new JButton("Back");
				back.setBounds(730,350,150,50);
				add(back);
		    	
		    	JLabel jl1 = new JLabel("Difficulty");
		    	jl1.setFont(new Font ("Helvetica", Font.PLAIN, 38));
		    	jl1.setBounds(730, 50, 300, 50);
		    	
		    	JLabel diff = new JLabel("Harder difficulty increases ball speed and lowers starting lives.");
		    	diff.setFont(new Font ("Helvetica", Font.PLAIN, 18));
		    	diff.setBounds(25, 50, 500, 50);
		    	
		    	JLabel padd = new JLabel("Chooses a different paddle skin.");
		    	padd.setFont(new Font ("Helvetica", Font.PLAIN, 18));
		    	padd.setBounds(125, 150, 500, 50);
		    	
		    	JLabel fish = new JLabel("Click the Disco Fish to rave!");
		    	fish.setFont(new Font ("Helvetica", Font.PLAIN, 38));
		    	fish.setBounds(400, 550, 500, 50);
		    	
			    easy = new JRadioButton("Easy");
			    easy.setFont(new Font ("Helvetica", Font.PLAIN, 22));
			    easy.setBounds(620, 100, 150, 30);
			    
			    medium = new JRadioButton("Medium");
			    medium.setFont(new Font ("Helvetica", Font.PLAIN, 22));
			    medium.setBounds(770,100,150,30);
			    
			    hard = new JRadioButton("Nasty");
			    hard.setFont(new Font ("Helvetica", Font.PLAIN, 22));
			    hard.setBounds(920,100,150,30);
			    ButtonGroup group = new ButtonGroup();
			    
			    easy.setContentAreaFilled(false);
			    medium.setContentAreaFilled(false);
			    hard.setContentAreaFilled(false);
			    
				JLabel jl2 = new JLabel("Paddle Color");
		    	jl2.setFont(new Font ("Helvetica", Font.PLAIN, 38));
		    	jl2.setBounds(705, 150, 300, 50);
		    	
			    chee = new JRadioButton("Cheetah");
			    chee.setFont(new Font ("Helvetica", Font.PLAIN, 22));
			    chee.setBounds(540, 200, 150, 30);
			    jb1 = new JButton();
			    jb1.setIcon(cheePic);
			    jb1.setBorder(null);
			    jb1.setBounds(650, 200, 75, 30);
			    
			    trippy = new JRadioButton("Trippy");
			    trippy.setFont(new Font ("Helvetica", Font.PLAIN, 22));
			    trippy.setBounds(740,200,150,30);
			    jb2 = new JButton();
			    jb2.setIcon(tripPic);
			    jb2.setBorder(null);
			    jb2.setBounds(828, 200, 75, 30);
			    
			    waves = new JRadioButton("Waves");
			    waves.setFont(new Font ("Helvetica", Font.PLAIN, 22));
			    waves.setBounds(915,200,150,30);
			    jb3 = new JButton();
			    jb3.setIcon(wavePic);
			    jb3.setBorder(null);
			    jb3.setBounds(1010, 200, 75, 30);
			    
			    ButtonGroup group2 = new ButtonGroup();
			    
			    easy.setContentAreaFilled(false);
			    medium.setContentAreaFilled(false);
			    hard.setContentAreaFilled(false);
			    chee.setContentAreaFilled(false);
			    jb1.setContentAreaFilled(false);
			    trippy.setContentAreaFilled(false);
			    jb2.setContentAreaFilled(false);
			    waves.setContentAreaFilled(false);
			    jb3.setContentAreaFilled(false);
			    
			    group.add(easy);
			    group.add(medium);
			    group.add(hard);
			    group2.add(chee);
			    group2.add(trippy);
			    group2.add(waves);
		//-------------------------------------------------------	    
		// add components to JPanel		
		//-------------------------------------------------------	    
				add(jl1);
				add(easy);
				add(medium);
				add(hard);
				add(message);
				add(jl2);
				add(chee);
				add(jb1);
				add(trippy);
				add(jb2);
				add(waves);
				add(jb3);
				add(fish);
				add(padd);
				add(diff);
				
		//----------------------------------------------------------------
		// add eventListeners to the radiobutton		
		//-------------------------------------------------------	    
		        easy.addActionListener(this); 
		        medium.addActionListener(this); 
		        hard.addActionListener(this); 
		        chee.addActionListener(this); 
		        trippy.addActionListener(this); 
		        waves.addActionListener(this); 
			}
		//-------------------------------------------------------------------
		// actionPerformed
		// All the events generated by the user interaction with components are captured here.
		    public void actionPerformed(ActionEvent event) 
		    {


		       	 Object obj = event.getSource();
		       	 
		     	 if (obj == easy)
		    	 {
		     		speed = 15;
		     		l1.d1.lives = 15;
		     	 }
		     	 if (obj == medium)
		     	 {
		     	 	speed = 12;
		     	 	l1.d1.lives = 10;
		     	 }
		     	 if (obj == hard)
		     	 {
		     	 	speed = 10;
		     	 	l1.d1.lives = 5;
		     	 }
		     	 
		     	
		    }	
		}
