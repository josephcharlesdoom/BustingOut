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

public class PlayField2 extends JPanel implements  ActionListener, KeyListener 
{
	//--------------------- Attributes
	Random gen = new Random();
	Ball ball1;
	enemy enemy1,enemy2;
	Paddle pad1;
	Bricks brick1;
	JButton life;
	
	Bricks[][] brickwall = new Bricks[15][13];
	
	int brickNum = 1;
	
	Level2 l2;								//create variable for gp
	Level3 l3; 
	
	Display2 display;
	PlayField2 pf2;
	
	int delay = 10;
	Timer tim;
	int countBall = 5;
	
	java.applet.AudioClip clip, bounce;

	static int x = 350;
	static int y = 600;
	
	static int ex = 100;
	static int ey = 20;
	
	int bx = 2, by = 90;
	
	

	//--------------------- Constructor
	public PlayField2(Display2 informedDisplay)
	{
		super();
		
		try
	 	{
	 		// create the clip that will played later
	 		// You can play files type: .au, .aif, .mid, .rmf, and .wav.
	 		// this method doesn't play wma or mp3 files.
			clip = java.applet.Applet.newAudioClip(new java.net.URL("file:sounds/crunchy.wav"));
			bounce = java.applet.Applet.newAudioClip(new java.net.URL("file:sounds/bounce.wav"));
			
	 	}
      catch(Exception xx) {xx.printStackTrace();}
		
		display = informedDisplay;
		setLayout(null);
		setBackground(Color.blue);
		
		enemy1 = new enemy();
		add(enemy1);
		enemy1.setBounds(100, 20, 35, 35);
		
		enemy2 = new enemy();
		add(enemy2);
		enemy2.setBounds(700, 20, 35, 35);
		
		ball1 = new Ball();
		add(ball1);
		
		tim = new Timer(delay, this);
		
		pad1 = new Paddle();
		add(pad1);
		pad1.setBounds(x,y,70,15); 
		pad1.addKeyListener(this);
	
		
		
		for(int r = 0; r < 15; r++)
		{
			bx = 2;
			for(int c = 0; c < 13; c++)
			{
				brickwall[r][c] = new Bricks();
				brickwall[r][c].setBounds(bx,by,60,27);
				add(brickwall[r][c]);
				bx += 60;
			}
			by += 27;
		}

		remove(brickwall[2][0]);
		remove(brickwall[2][1]);
		remove(brickwall[2][2]);
		remove(brickwall[2][3]);
		remove(brickwall[2][4]);
		remove(brickwall[2][8]);
		remove(brickwall[2][9]);
		remove(brickwall[2][10]);
		remove(brickwall[2][11]);
		remove(brickwall[2][12]);

		remove(brickwall[3][0]);
		remove(brickwall[3][1]);
		remove(brickwall[3][2]);
		remove(brickwall[3][3]);
		remove(brickwall[3][4]);
		remove(brickwall[3][8]);
		remove(brickwall[3][9]);
		remove(brickwall[3][10]);
		remove(brickwall[3][11]);
		remove(brickwall[3][12]);
		
		remove(brickwall[4][0]);
		remove(brickwall[4][1]);
		remove(brickwall[4][2]);
		remove(brickwall[4][3]);
		remove(brickwall[4][4]);
		remove(brickwall[4][8]);
		remove(brickwall[4][9]);
		remove(brickwall[4][10]);
		remove(brickwall[4][11]);
		remove(brickwall[4][12]);
		
		remove(brickwall[5][0]);
		remove(brickwall[5][1]);
		remove(brickwall[5][2]);
		remove(brickwall[5][3]);
		remove(brickwall[5][4]);
		remove(brickwall[5][8]);
		remove(brickwall[5][9]);
		remove(brickwall[5][10]);
		remove(brickwall[5][11]);
		remove(brickwall[5][12]);
		
		remove(brickwall[6][0]);
		remove(brickwall[6][1]);
		remove(brickwall[6][2]);
		remove(brickwall[6][3]);
		remove(brickwall[6][4]);
		remove(brickwall[6][8]);
		remove(brickwall[6][9]);
		remove(brickwall[6][10]);
		remove(brickwall[6][11]);
		remove(brickwall[6][12]);
		
		remove(brickwall[7][0]);
		remove(brickwall[7][1]);
		remove(brickwall[7][2]);
		remove(brickwall[7][3]);
		remove(brickwall[7][4]);
		remove(brickwall[7][8]);
		remove(brickwall[7][9]);
		remove(brickwall[7][10]);
		remove(brickwall[7][11]);
		remove(brickwall[7][12]);
		
		remove(brickwall[8][0]);
		remove(brickwall[8][1]);
		remove(brickwall[8][2]);
		remove(brickwall[8][3]);
		remove(brickwall[8][4]);
		remove(brickwall[8][8]);
		remove(brickwall[8][9]);
		remove(brickwall[8][10]);
		remove(brickwall[8][11]);
		remove(brickwall[8][12]);
		
		remove(brickwall[9][0]);
		remove(brickwall[9][1]);
		remove(brickwall[9][2]);
		remove(brickwall[9][3]);
		remove(brickwall[9][4]);
		remove(brickwall[9][8]);
		remove(brickwall[9][9]);
		remove(brickwall[9][10]);
		remove(brickwall[9][11]);
		remove(brickwall[9][12]);
		
		remove(brickwall[10][0]);
		remove(brickwall[10][1]);
		remove(brickwall[10][2]);
		remove(brickwall[10][3]);
		remove(brickwall[10][4]);
		remove(brickwall[10][8]);
		remove(brickwall[10][9]);
		remove(brickwall[10][10]);
		remove(brickwall[10][11]);
		remove(brickwall[10][12]);
		
		remove(brickwall[11][0]);
		remove(brickwall[11][1]);
		remove(brickwall[11][2]);
		remove(brickwall[11][3]);
		remove(brickwall[11][4]);
		remove(brickwall[11][8]);
		remove(brickwall[11][9]);
		remove(brickwall[11][10]);
		remove(brickwall[11][11]);
		remove(brickwall[11][12]);
		
		remove(brickwall[12][0]);
		remove(brickwall[12][1]);
		remove(brickwall[12][2]);
		remove(brickwall[12][3]);
		remove(brickwall[12][4]);
		remove(brickwall[12][8]);
		remove(brickwall[12][9]);
		remove(brickwall[12][10]);
		remove(brickwall[12][11]);
		remove(brickwall[12][12]);
		
		remove(brickwall[13][0]);
		remove(brickwall[13][1]);
		remove(brickwall[13][2]);
		remove(brickwall[13][3]);
		remove(brickwall[13][4]);
		remove(brickwall[13][8]);
		remove(brickwall[13][9]);
		remove(brickwall[13][10]);
		remove(brickwall[13][11]);
		remove(brickwall[13][12]);
		
		remove(brickwall[14][0]);
		remove(brickwall[14][1]);
		remove(brickwall[14][2]);
		remove(brickwall[14][3]);
		remove(brickwall[14][4]);
		remove(brickwall[14][8]);
		remove(brickwall[14][9]);
		remove(brickwall[14][10]);
		remove(brickwall[14][11]);
		remove(brickwall[14][12]);
		
		
		
		
		
	} // end constructor
	
	public void paintComponent (Graphics g)
	 {
	    super.paintComponent(g);
	    Image myImage = Toolkit.getDefaultToolkit().getImage("images/level2.jpg");
	    g.drawImage(myImage, 0, 0, this);
	 }





	public void actionPerformed(ActionEvent event){//--------------------- Methods	
		
		Object obj = event.getSource();
		
		if(obj == tim)
		{
			ball1.move();
			enemy1.move();
			
			
			
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
					for(int r = 0; r < 15; r++)
					{
						for(int c = 0; c < 13; c++)
						{
							if( ball1.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing())
							{
								try
							 	{
							 		clip.play();//play
							 	}
					          catch(Exception xx) {xx.printStackTrace();}
								if(brickwall[r][c].getIcon().equals("images/stone_life_blue.png")){ 
									life = new JButton();
									//life.setIcon(lifePic);
									life.setBounds(500,0,30,30); 
									add(life);
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
							display.hits ++;// score
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
					for(int r = 0; r < 15; r++)
					{
						for(int c = 0; c < 13; c++)
						{
							if( ball1.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing()){
							
								try
							 	{
							 		clip.play();//play
							 	}
					          catch(Exception xx) {xx.printStackTrace();}
					          
								if(brickwall[r][c].getIcon().equals("images/stone_life_blue.png")){ 
									life = new JButton();
									//life.setIcon(lifePic);
									life.setBounds(500,0,30,30); 
									add(life);
								}
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
						for(int r = 0; r < 15; r++)
						{
							for(int c = 0; c < 13; c++)
							{
								if( ball1.getBounds().intersects(brickwall[r][c].getBounds()) && brickwall[r][c].isShowing()){
									
									try
								 	{
								 		clip.play();//play
								 	}
						          catch(Exception xx) {xx.printStackTrace();}
									
									if(brickwall[r][c].getIcon().equals("images/stone_life_blue.png")){ 
										life = new JButton();
										//life.setIcon(lifePic);
										life.setBounds(500,0,30,30); 
										add(life);
									}
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
							for(int r = 0; r < 15; r++)
							{
								for(int c = 0; c < 13; c++)
								{
									if( ball1.getBounds().intersects(brickwall[r][c].getBounds())&& brickwall[r][c].isShowing())
									{
										try
									 	{
									 		clip.play();//play
									 	}
							          catch(Exception xx) {xx.printStackTrace();}
									
										if(ball1.getX()<= brickwall[r][c].getX()){	// left
											ball1.direction = 3;
										
										}
										else if(ball1.getY() <= brickwall[r][c].getY()+brickwall[r][c].getHeight()){	// bottom
											ball1.direction = 1;
											
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
					enemy1.setLocation(100, 20);
					enemy1.xpos=ex ;
					enemy1.ypos=ey ;
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
				enemy1.setLocation(100, 20);
				enemy1.xpos=ex ;
				enemy1.ypos=ey ;
				
				}
			for(int r = 0; r < 15; r++)
			{
				for(int c = 0; c < 13; c++)
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
					enemy1.setLocation(100, 20);
					enemy1.xpos=ex ;
					enemy1.ypos=ey ;
					}
				
				for(int r = 0; r < 15; r++)
				{
					for(int c = 0; c < 13; c++)
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
					for(int r = 0; r < 15; r++)
					{
						for(int c = 0; c < 13; c++)
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
						for(int r = 0; r < 15; r++)
						{
							for(int c = 0; c < 13; c++)
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