import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class enemy2 extends JButton
{
	//--------------------- Attributes
	
	
	public int direction = 2;
	
	int xpos = 530 , ypos = 175 ;
	int bWidth = 35, bHeight= 35;
	
	ImageIcon image;
	int picture = 0;
	
	
	//--------------------- Constructor
	public enemy2()
	{	
		super();
		
		setPicture();
		setBorder(null);  
		setContentAreaFilled(false);
	} // end constructor

	
	//--------------------- Methods
	void setPicture()
	{
		
		image = new ImageIcon("images/enemy1.JPG");
		
		setIcon(image);
		setBounds(xpos,ypos,bWidth,bHeight);
	}// end method setPicture
	
	
	public void move(){
		
		if(direction == 1){
			
			xpos += 1;
			ypos += 1;
			
				if(xpos + bHeight > 794){ // right wall
					direction = 4;
				}
					if(ypos + bHeight > 660){//bottom wall
						direction = 2;
					}
			setLocation(xpos, ypos);
			
		
		}
			
			if(direction == 2){
				
				xpos += 1;
				ypos -= 1;
				if(ypos + bHeight < 16){//top wall
					direction = 1;
				}
					if(xpos + bHeight > 794){ // right wall
						direction = 3;
					}
					
				setLocation(xpos, ypos);
				
				
			}
			
				if(direction == 3){
					
					xpos -= 1;
					ypos -= 1;
					if(ypos + bHeight < 16){//top wall
						direction = 4;
					}
						if(xpos + bHeight < 16){//left wall
							direction = 2;
						}
					setLocation(xpos, ypos);
				}
					if(direction == 4){
						
						xpos -= 1;
						ypos += 1;
						
							if(xpos + bHeight < 16){//left wall
								direction = 1;
							}
							if(ypos + bHeight > 660){//bottom wall
								direction = 3;
							}
							setLocation(xpos, ypos);
					}
	
					
	}

} // end class