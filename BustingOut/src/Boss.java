
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Boss extends JButton
{
	//--------------------- Attributes
	
	
	public int direction = 2;
	
	int xpos = 100 , ypos = 100 ;
	int bWidth = 190, bHeight= 312;
	
	ImageIcon image;
	int picture = 0;
	
	
	//--------------------- Constructor
	public Boss()
	{	
		super();
		
		setPicture();
		setBorder(null);  
		setContentAreaFilled(true);
	} // end constructor

	
	//--------------------- Methods
	void setPicture()
	{
		
		image = new ImageIcon("images/boss.JPG");
		
		setIcon(image);
		setBounds(xpos,ypos,bWidth,bHeight);
	}// end method setPicture
	
	
	public void move(){
		
		if(direction == 1){
			
			xpos += 1;
			ypos += 1;
			
				if(xpos + bHeight > 1000){ // right wall
					direction = 4;
				}
					if(ypos + bHeight > 550){//bottom wall
						direction = 2;
					}
			setLocation(xpos, ypos);
			
		
		}
			
			if(direction == 2){
				
				xpos += 1;
				ypos -= 1;
				if(ypos + bHeight < 350){//top wall
					direction = 1;
				}
					if(xpos + bHeight > 1000){ // right wall
						direction = 3;
					}
					
				setLocation(xpos, ypos);
				
				
			}
			
				if(direction == 3){
					
					xpos -= 1;
					ypos -= 1;
					if(ypos + bHeight < 350){//top wall
						direction = 4;
					}
						if(xpos + bHeight < 400){//left wall
							direction = 2;
						}
					setLocation(xpos, ypos);
				}
					if(direction == 4){
						
						xpos -= 1;
						ypos += 1;
						
							if(xpos + bHeight < 400){//left wall
								direction = 1;
							}
							if(ypos + bHeight > 550){//bottom wall
								direction = 3;
							}
							setLocation(xpos, ypos);
					}
	
					
	}

} // end class