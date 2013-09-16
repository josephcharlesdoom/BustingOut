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

public class PlayField1 extends JPanel implements  ActionListener, KeyListener 
{
	//--------------------- Attributes
	Random gen = new Random();
	Ball ball1;
	enemy enemy1;
	enemy2 enemy22;
	Paddle pad1;
	Bricks brick1;
	JButton win, menu;
	Option o;
	int delay = 13;
	
	java.applet.AudioClip clip, bounce, explode;
	
	Bricks[][] brickwall = new Bricks[7][12];
	
	int brickNum = 1;
	
	Level1 l1;								//create variable for gp
	Level2 l2; 
	
	Display1 display;
	PlayField1 pf1;

	
	Timer tim;
	int countBall = 5;

	static int x = 365;
	static int y = 600;
	
	static int ex = 225;
	static int ey = 175;
	
	int bx = 100, by=100;
	
	int number = new Random().nextInt(7);
	ImageIcon lifePic = new ImageIcon("images/life.ico");

	//--------------------- Constructor
	public PlayField1(Display1 informedDisplay)
	{
		super();
		
		try
	 	{
	 		// create the clip that will played later
	 		// You can play files type: .au, .aif, .mid, .rmf, and .wav.
	 		// this method doesn't play wma or mp3 files.
			clip = java.applet.Applet.newAudioClip(new java.net.URL("file:sounds/crunchy.wav"));
			bounce = java.applet.Applet.newAudioClip(new java.net.URL("file:sounds/bounce.wav"));
			explode = java.applet.Applet.newAudioClip(new java.net.URL("file:sounds/cannon.wav"));
	 	}
      catch(Exception xx) {xx.printStackTrace();}	
		
      	win = new JButton();
		//win.setIcon(winner);
		win.setContentAreaFilled(false);
		win.setBorder(null);
		win.setBounds(10,10,750,550);
		
		menu = new JButton("Back to Menu");
		menu.setBorder(null);
		menu.setBounds(600, 600, 150, 40);
      	
		display = informedDisplay;
		setLayout(null);
		setBackground(Color.blue);
		
		enemy1 = new enemy();
		add(enemy1);
		enemy1.setBounds(225, 175, 35, 35);
		
		enemy22 = new enemy2();
		add(enemy22);
		enemy22.setBounds(530, 175, 35, 35);
		
		ball1 = new Ball();
		add(ball1);
		
		tim = new Timer(delay, this);
		
		pad1 = new Paddle();
		add(pad1);
		pad1.setBounds(x,y,70,15); 
		pad1.addKeyListener(this);
		
		
		
		
		
		//button = new RoundButton("poop");
		//add(button);
		//button.setBounds(400, 400, 30, 30);

		for(int r = 0; r < 7; r++)
		{
			bx = 35;
			for(int c = 0; c < 12; c++)
			{
				brickwall[r][c] = new Bricks();
				brickwall[r][c].setBounds(bx,by,60,27);
				add(brickwall[r][c]);
				bx += 60;
			}
			by += 27;
		}
		
		remove(brickwall[2][2]);
		remove(brickwall[3][2]);
		remove(brickwall[4][2]);
		remove(brickwall[2][3]);
		remove(brickwall[3][3]);
		remove(brickwall[4][3]);
		remove(brickwall[2][4]);
		remove(brickwall[3][4]);
		remove(brickwall[4][4]);
		
		remove(brickwall[2][7]);
		remove(brickwall[3][7]);
		remove(brickwall[4][7]);
		remove(brickwall[2][8]);
		remove(brickwall[3][8]);
		remove(brickwall[4][8]);
		remove(brickwall[2][9]);
		remove(brickwall[3][9]);
		remove(brickwall[4][9]);
		
	} // end constructor
	
	public void paintComponent (Graphics g)
	 {
	    super.paintComponent(g);
	    Image myImage = Toolkit.getDefaultToolkit().getImage("images/level1.jpg");
	    g.drawImage(myImage, 0, 0, this);
	 }





	public void actionPerformed(ActionEvent event){//--------------------- Methods	
		
		Object obj = event.getSource();
		
		
		if(obj == tim)
		{
			ball1.move();
			enemy1.move();
			enemy22.move();
			
			
			
			if(ball1.direction == 4)
			{
				if( ball1.getBounds().intersects(pad1.getBounds()))
				{
						ball1.direction = 3;	
						try
					 	{
					 		bounce.play();//play
					 	}
			          catch(Exception xx) {xx.printStackTrace();}
						
				}
					for(int r = 0; r < 7; r++)
					{
						for(int c = 0; c < 12; c++)
						{
							if( ball1.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing())
							{
								try
							 	{
							 		clip.play();//play
							 	}
					          catch(Exception xx) {xx.printStackTrace();}
								if(brickwall[r][c].getIcon().equals("images/stone_life_blue.png")){ 
								
									//add(life);
									//life.setIcon(lifePic);
									//life.setBounds(brickwall[r][c].getX(),brickwall[r][c].getY(),30,30); 
									
								}
								if(ball1.getX()>= brickwall[r][c].getX() + brickwall[r][c].getWidth())
								{	// right
									ball1.direction = 2;
									System.out.println(ball1.direction);
								}
								else if(ball1.getY() <= brickwall[r][c].getY())
								{	// top
									ball1.direction = 3;
									System.out.println(ball1.direction);
								}	
							
							remove(brickwall[r][c]);
							Control.Hits ++;// score
							display.hits ++;
							display.jl2.setText("Bricks Hit: " + display.hits);
							brickNum --;
							repaint();
							
							}
						}
					}
				}
			if(ball1.direction == 1)
			{
				if( ball1.getBounds().intersects(pad1.getBounds()))
				{
					ball1.direction=2;
					try
				 	{
				 		bounce.play();//play
				 	}
		          catch(Exception xx) {xx.printStackTrace();}
				
				}
					for(int r = 0; r < 7; r++)
					{
						for(int c = 0; c < 12; c++)
						{
							if( ball1.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing()){
							
								try
							 	{
							 		clip.play();//play
							 	}
					          catch(Exception xx) {xx.printStackTrace();}
								
								if(ball1.getX()<= brickwall[r][c].getX()){	// left
									ball1.direction = 4;
									System.out.println(ball1.direction);
								}
								else if(ball1.getY() <= brickwall[r][c].getY()){	// top
									ball1.direction = 2;
									System.out.println(ball1.direction);
								}	
								
								// explosion sound
								remove(brickwall[r][c]);
								display.hits ++;// score
								display.jl2.setText("Bricks Hit: " + display.hits);
								brickNum --;
								repaint();
								
							}
						}
					}
				}
					if(ball1.direction == 3){
						for(int r = 0; r < 7; r++)
						{
							for(int c = 0; c < 12; c++)
							{
								if( ball1.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing()){
									
									try
								 	{
								 		clip.play();//play
								 	}
						          catch(Exception xx) {xx.printStackTrace();}
									
									
									if(ball1.getX()>= brickwall[r][c].getX() + brickwall[r][c].getWidth()){	// right
										ball1.direction = 2;
										System.out.println(ball1.direction);
										
									}
									else if(ball1.getY() <= brickwall[r][c].getY() + brickwall[r][c].getHeight()){	// bottom
										ball1.direction = 4;
										System.out.println(ball1.direction);
									}	
									
									// explosion sound
									remove(brickwall[r][c]);
									display.hits ++;// score
									display.jl2.setText("Bricks Hit: " + display.hits);
									brickNum --;
									repaint();
									
								}
							}
						}
						if( ball1.getBounds().intersects(enemy1.getBounds())&& enemy1.isShowing()){
							remove(enemy1);
							repaint();
						}
					}
						if(ball1.direction == 2){
							for(int r = 0; r < 7; r++)
							{
								for(int c = 0; c < 12; c++)
								{
									if( ball1.getBounds().intersects(brickwall[r][c].getBounds())&& brickwall[r][c].isShowing())
									{
										try
									 	{
									 		clip.play();//play
									 	}
							          catch(Exception xx) {xx.printStackTrace();}
										
										
										//if(brickwall[r][c].getIcon(images/stone_skull_yellow.png)){
										// explosion sound
										if(ball1.getX()<= brickwall[r][c].getX()){	// left
											ball1.direction = 3;
											System.out.println(ball1.direction);
										}
										else if(ball1.getY() <= brickwall[r][c].getY()+brickwall[r][c].getHeight()){	// bottom
											ball1.direction = 1;
											System.out.println(ball1.direction);
										}	
										remove(brickwall[r][c]);
										display.hits ++;// score
										display.jl2.setText("Bricks Hit: " + display.hits);
    									brickNum --;
    									repaint();
										
									}
								}
							}
							if( ball1.getBounds().intersects(enemy1.getBounds())&& enemy1.isShowing()){
								remove(enemy1);
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
					enemy1.setLocation(225, 175);
					enemy1.xpos=ex ;
					enemy1.ypos=ey ;
					}
				if(display.lives <= 0){
					tim.stop();
					try
				 	{
				 		explode.play();//play
				 	}
		          catch(Exception xx) {xx.printStackTrace();}
					
					remove(ball1);
					add(win);
					add(menu);
			
				}
				}
			
		
		
		
		
		
		
		
		
		
		
		
		if(enemy1.direction == 4)
		{
			
			if( enemy1.getBounds().intersects(pad1.getBounds()) )
			{
				tim.stop();
				ball1.setPicture();
				display.lives--;
				display.jl1.setText("Lives: " + display.lives);
				ball1.xpos=x + 35;
				ball1.ypos=y - 13;
				ball1.setLocation(ball1.xpos, ball1.ypos);
				enemy1.setLocation(225, 175);
				enemy1.xpos=ex ;
				enemy1.ypos=ey ;
				
				}
			for(int r = 0; r < 7; r++)
			{
				for(int c = 0; c < 12; c++)
				{
					if( enemy1.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing()){
							
						System.out.println(enemy1.getY() + " " + brickwall[r][c].getY() + " "+ enemy1.direction);
						if(enemy1.getX()>= brickwall[r][c].getX() + brickwall[r][c].getWidth()){	// right
							enemy1.direction = 2;
							
						}
						else if(enemy1.getY() <= brickwall[r][c].getY()){	// top
							enemy1.direction = 3;
							
						}
						
					}
				}
			}
		}
			if(enemy1.direction == 1){
				
				if( enemy1.getBounds().intersects(pad1.getBounds()) )
				{
					
					tim.stop();
					ball1.setPicture();
					display.lives--;
					display.jl1.setText("Lives: " + display.lives);
					ball1.xpos=x + 35;
					ball1.ypos=y - 13;
					ball1.setLocation(ball1.xpos, ball1.ypos);
					enemy1.setLocation(225, 175);
					enemy1.xpos=ex ;
					enemy1.ypos=ey ;
					}
				
				for(int r = 0; r < 7; r++)
				{
					for(int c = 0; c < 12; c++)
					{
						if( enemy1.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing()){
							System.out.println(enemy1.getY() + " " + brickwall[r][c].getY() + " "+ enemy1.direction);
							if(enemy1.getX()<= brickwall[r][c].getX()){	// left
								enemy1.direction = 4;
								
							}
							else if(enemy1.getY() <= brickwall[r][c].getY()){	// top
								enemy1.direction = 2;
								
							}	
							
						}
					}
				}
			}
				if(enemy1.direction == 3){
					for(int r = 0; r < 7; r++)
					{
						for(int c = 0; c < 12; c++)
						{
							if( enemy1.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing()){
								System.out.println(enemy1.getY() + " " + brickwall[r][c].getY() + " "+ enemy1.direction);
								if(enemy1.getX() >= brickwall[r][c].getX() + brickwall[r][c].getWidth()){	// right
									enemy1.direction = 2;
								
								}
								else if(enemy1.getY() >= brickwall[r][c].getY() + brickwall[r][c].getHeight()){	// bottom
									enemy1.direction = 4;
									
								}	
								
								
								
							}
						}
					}
				}
					if(enemy1.direction == 2){
						for(int r = 0; r < 7; r++)
						{
							for(int c = 0; c < 12; c++)
							{
								if( enemy1.getBounds().intersects(brickwall[r][c].getBounds())&& brickwall[r][c].isShowing())
								{
									System.out.println(enemy1.getY() + " " + brickwall[r][c].getY() + " "+ enemy1.direction);
									if(enemy1.getX()<= brickwall[r][c].getX()){	// left
										enemy1.direction = 3;
									
									}
									else if(enemy1.getY() >= brickwall[r][c].getY()+brickwall[r][c].getHeight()){	// bottom
										enemy1.direction = 1;
									
									}
								}
							}
							
					}
					
					}
					
					
					
					
					
					if(enemy22.direction == 4)
					{
						
						if( enemy22.getBounds().intersects(pad1.getBounds()) )
						{
							tim.stop();
							ball1.setPicture();
							display.lives--;
							display.jl1.setText("Lives: " + display.lives);
							ball1.xpos=x + 35;
							ball1.ypos=y - 13;
							ball1.setLocation(ball1.xpos, ball1.ypos);
							enemy22.setLocation(225, 175);
							enemy22.xpos=ex ;
							enemy22.ypos=ey ;
							
							}
						for(int r = 0; r < 7; r++)
						{
							for(int c = 0; c < 12; c++)
							{
								if( enemy22.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing()){
										
									
									if(enemy22.getX()>= brickwall[r][c].getX() + brickwall[r][c].getWidth()){	// right
										enemy22.direction = 2;
										
									}
									else if(enemy22.getY() <= brickwall[r][c].getY()){	// top
										enemy22.direction = 3;
										
									}
									
								}
							}
						}
					}
						if(enemy22.direction == 1){
							
							if( enemy22.getBounds().intersects(pad1.getBounds()) )
							{
								
								tim.stop();
								ball1.setPicture();
								display.lives--;
								display.jl1.setText("Lives: " + display.lives);
								ball1.xpos=x + 35;
								ball1.ypos=y - 13;
								ball1.setLocation(ball1.xpos, ball1.ypos);
								enemy22.setLocation(225, 175);
								enemy22.xpos=ex ;
								enemy22.ypos=ey ;
								}
							
							for(int r = 0; r < 7; r++)
							{
								for(int c = 0; c < 12; c++)
								{
									if( enemy22.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing()){
										
										if(enemy22.getX()<= brickwall[r][c].getX()){	// left
											enemy22.direction = 4;
											
										}
										else if(enemy22.getY() <= brickwall[r][c].getY()){	// top
											enemy22.direction = 2;
											
										}	
										
									}
								}
							}
						}
							if(enemy22.direction == 3){
								for(int r = 0; r < 7; r++)
								{
									for(int c = 0; c < 12; c++)
									{
										if( enemy22.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing()){
											
											if(enemy22.getX() >= brickwall[r][c].getX() + brickwall[r][c].getWidth()){	// right
												enemy22.direction = 2;
											
											}
											else if(enemy22.getY() >= brickwall[r][c].getY() + brickwall[r][c].getHeight()){	// bottom
												enemy22.direction = 4;
												
											}	
											
											
											
										}
									}
								}
							}
								if(enemy22.direction == 2){
									for(int r = 0; r < 7; r++)
									{
										for(int c = 0; c < 12; c++)
										{
											if( enemy22.getBounds().intersects(brickwall[r][c].getBounds())&& brickwall[r][c].isShowing())
											{
												
												if(enemy22.getX()<= brickwall[r][c].getX()){	// left
													enemy22.direction = 3;
												
												}
												else if(enemy1.getY() >= brickwall[r][c].getY()+brickwall[r][c].getHeight()){	// bottom
													enemy22.direction = 1;
												
												}
											}
										}
										
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