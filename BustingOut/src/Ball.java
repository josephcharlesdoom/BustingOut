import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ball extends JButton
{
	//--------------------- Attributes
	Random generator = new Random();
	int number = 3;
	public int direction = number;
	int ballColor = new Random().nextInt(4);
	
	int xpos = PlayField1.x + 35, ypos = PlayField1.y - 13  ;
	int bWidth = 17, bHeight= 17;
	
	ImageIcon image;
	int picture = 0;
	
	
	//--------------------- Constructor
	public Ball()
	{	
		super();
		
		setPicture();
		setBorder(null);  
		setContentAreaFilled(false);
	} // end constructor

	
	//--------------------- Methods
	void setPicture()
	{
		
		if(ballColor == 0) 
		{
			image = new ImageIcon("images/ball_red.png");
		}
		else if(ballColor == 1) 
		{
			image = new ImageIcon("images/ball_blue.png");
		}
		else if(ballColor == 2) 
		{
			image = new ImageIcon("images/ball_purple.png");
		}
		else if(ballColor == 3) 
		{
			image = new ImageIcon("images/ball_pinball.png");
		}
		
		setIcon(image);
		setBounds(xpos,ypos,bWidth,bHeight);
	}// end method setPicture
	
	
	public void move(){
		
		if(direction == 1){
			
			xpos += 3;
			ypos += 3;
			
				if(xpos + bHeight > 794){ // right wall
					direction = 4;
				}
			setLocation(xpos, ypos);
			
		
		}
			
			if(direction == 2){
				
				xpos += 3;
				ypos -= 3;
				if(ypos + bHeight < 16){//top wall
					direction = 1;
				}
					if(xpos + bHeight > 794){ // right wall
						direction = 3;
					}
					
				setLocation(xpos, ypos);
				
				
			}
			
				if(direction == 3){
					
					xpos -= 3;
					ypos -= 3;
					if(ypos + bHeight < 16){//top wall
						direction = 4;
					}
						if(xpos + bHeight < 16){//left wall
							direction = 2;
						}
					setLocation(xpos, ypos);
				}
					if(direction == 4){
						
						xpos -= 3;
						ypos += 3;
						
							if(xpos + bHeight < 16){//left wall
								direction = 1;
							}
							setLocation(xpos, ypos);
					}
	
					
	}

} // end class