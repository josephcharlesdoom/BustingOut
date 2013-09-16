import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayField3 extends JPanel implements  ActionListener, KeyListener 
{
	//--------------------- Attributes
	Random gen = new Random();
	Ball ball1;
	Boss boss;
	Paddle pad1;
	Bricks brick1;
	JButton win, menu;
	ImageIcon winner; 
	
	java.applet.AudioClip clip, explode;
	
	
	int brickNum = 1;
	
	Level2 l2;								//create variable for gp
	Level3 l3; 
	
	Display3 display;
	PlayField3 pf3;
	
	int delay = 10;
	Timer tim;
	int countBall = 5;

	static int x = 350;
	static int y = 600;
	
	static int ex = 225;
	static int ey = 175;
	
	int bx = 100, by=100;


	//--------------------- Constructor
	public PlayField3(Display3 informedDisplay)
	{
		super();
		
		try
	 	{
	 		// create the clip that will played later
	 		// You can play files type: .au, .aif, .mid, .rmf, and .wav.
	 		// this method doesn't play wma or mp3 files.
			clip = java.applet.Applet.newAudioClip(new java.net.URL("file:sounds/crunchy.wav"));
			explode = java.applet.Applet.newAudioClip(new java.net.URL("file:sounds/cannon.wav"));
	 	}
      catch(Exception xx) {xx.printStackTrace();}	
		
      	winner = new ImageIcon("images/winner.jpg");
      
		display = informedDisplay;
		setLayout(null);
		setBackground(Color.blue);
		
		boss = new Boss();
		add(boss);
		boss.setBounds(100, 100, 190, 312);
		
		win = new JButton();
		win.setIcon(winner);
		win.setContentAreaFilled(false);
		win.setBorder(null);
		win.setBounds(10,10,750,550);
		
		menu = new JButton("Back to Menu");
		menu.setBorder(null);
		menu.setBounds(600, 600, 150, 40);
		
		ball1 = new Ball();
		add(ball1);
		
		tim = new Timer(delay, this);
		
		pad1 = new Paddle();
		add(pad1);
		pad1.setBounds(x,y,70,15); 
		pad1.addKeyListener(this);
		

		
		
		
		
	} // end constructor
	
	public void paintComponent (Graphics g)
	 {
	    super.paintComponent(g);
	    Image myImage = Toolkit.getDefaultToolkit().getImage("images/level3.jpg");
	    g.drawImage(myImage, 0, 0, this);
	 }





	public void actionPerformed(ActionEvent event){//--------------------- Methods	
		
		Object obj = event.getSource();
		
		if(obj == tim)
		{
			ball1.move();
			boss.move();
			
			
			
			if(ball1.direction == 4)
			{
				if( ball1.getBounds().intersects(pad1.getBounds()))
				{
						ball1.direction = 3;
						
				}
					
							if( ball1.getBounds().intersects(boss.getBounds()) && boss.isShowing())
							{
								try
							 	{
							 		clip.play();//play
							 	}
					          catch(Exception xx) {xx.printStackTrace();}
								display.j = display.j + 1;
								display.bossHealth.setValue(display.j);
								display.bossHealth.setString(""+display.j);
								
								if(ball1.getX()<= boss.getX() + boss.getWidth())
								{	// right
									ball1.direction = 1;
									
								}
								else if(ball1.getY() >= boss.getY())
								{	// top
									ball1.direction = 3;
									
								}	
							display.hits ++;// score
							display.jl2.setText("Bricks Hit: " + display.hits);
							brickNum --;
							repaint();
							
							}
						}
					
				
			if(ball1.direction == 1)
			{
				if( ball1.getBounds().intersects(pad1.getBounds()))
				{
					ball1.direction=2;
				}
					
							if( ball1.getBounds().intersects(boss.getBounds()) && boss.isShowing()){
								
								try
							 	{
							 		clip.play();//play
							 	}
					          catch(Exception xx) {xx.printStackTrace();}
								display.j = display.j + 1;
								display.bossHealth.setValue(display.j);
								display.bossHealth.setString(""+display.j);
								
								if(ball1.getX()<= boss.getX()){	// left
									ball1.direction = 4;
									
								}
								else if(ball1.getY() <= boss.getY()){	// top
									ball1.direction = 2;
								
								}	
								
								
								display.hits ++;// score
								display.jl2.setText("Bricks Hit: " + display.hits);
								brickNum --;
								repaint();
								
							}
						}
					
				
					if(ball1.direction == 3){
						
								if( ball1.getBounds().intersects(boss.getBounds()) && boss.isShowing()){
								
									try
								 	{
								 		clip.play();//play
								 	}
						          catch(Exception xx) {xx.printStackTrace();}
									display.j = display.j + 1;
									display.bossHealth.setValue(display.j);
									display.bossHealth.setString(""+display.j);
									
									if(ball1.getX()<= boss.getX() + boss.getWidth()){	// right
										ball1.direction = 2;
										
									}
									else if(ball1.getY() >= boss.getY() + boss.getHeight()){	// bottom
										ball1.direction = 4;
										
									}	
									
									// explosion sound
								
									display.hits ++;// score
									display.jl2.setText("Bricks Hit: " + display.hits);
									brickNum --;
									repaint();
									
								}
							}
						
					
						if(ball1.direction == 2){
							
									if( ball1.getBounds().intersects(boss.getBounds())&& boss.isShowing())
									{
										
										try
									 	{
									 		clip.play();//play
									 	}
							          catch(Exception xx) {xx.printStackTrace();}
										display.j = display.j + 1;
										display.bossHealth.setValue(display.j);
										display.bossHealth.setString(""+display.j);
										
										if(ball1.getX()<= boss.getX()){	// left
											ball1.direction = 3;
											
										}
										else if(ball1.getY() <= boss.getY()+ boss.getHeight()){	// bottom
											ball1.direction = 1;
											
										}	
										
										display.hits ++;// score
										display.jl2.setText("Bricks Hit: " + display.hits);
    									brickNum --;
    									repaint();
										
									}
								}
						
						if(ball1.ypos + ball1.bHeight > 700){//bottom wall
							
							tim.stop();
							ball1.setPicture();
							display.lives--;
							display.jl1.setText("Lives: " + display.lives);
							ball1.xpos=x + 35;
							ball1.ypos=y - 13;
							ball1.setLocation(ball1.xpos, ball1.ypos);
							boss.setLocation(100, 100);
							boss.xpos=ex ;
							boss.ypos=ey ;
							}
						
						if(display.j > 20){
							tim.stop();
							try
						 	{
						 		explode.play();//play
						 	}
				          catch(Exception xx) {xx.printStackTrace();}
							remove(boss);
							remove(ball1);
							add(win);
							add(menu);
							
						}
						
						
							}
							
						}
				
				
			
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void keyPressed(KeyEvent event){
		int key = event.getKeyCode();
		
			if(key == event.VK_A){
				if(x > 8){	
					if (tim.isRunning()){
						x = x - 20;
						
					}
					else{
						x = x - 20;
						
					ball1.xpos = ball1.xpos - 20;
					ball1.setLocation(ball1.xpos, ball1.ypos);
					}
				}
				}
					else if(key == event.VK_D){
						if(x<710){
						if (tim.isRunning()){
							x = x + 20;
						}
						else{
							x = x + 20;
						ball1.xpos = ball1.xpos +20;
						ball1.setLocation(ball1.xpos, ball1.ypos);
						}
					}
					}
			if(key == event.VK_SPACE){
					
				
						{
							tim.start();
						}	
					
				 
				
			}
			
			pad1.setLocation(x,y);

	}
		
	public void keyReleased(KeyEvent event){
		
	}
	
	public void keyTyped(KeyEvent event){
		
	}



}// end class