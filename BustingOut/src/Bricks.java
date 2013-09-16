import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Bricks extends JButton {

static ImageIcon image;
int number = new Random().nextInt(7);
int powerup = new Random().nextInt(4);

public Bricks()
{
	super();
	
	setPicture();
	setBorder(null);
	setContentAreaFilled(false);
	
	
}
	void setPicture(){
		
		 if (number == 0){
			 image = new ImageIcon("images/stone_glow_green.png");
				
				setIcon(image);
			}
			else if (number == 1){
				image = new ImageIcon("images/stone_glow_blue.png");
				
				setIcon(image);
			}
		 		else if (number == 2){
		 			image = new ImageIcon("images/stone_glow_orange.png");
		 			
		 			setIcon(image);
		 		}
		 			else if (number == 3){
		 				 image = new ImageIcon("images/stone_glow_purple.png");
		 					
		 					setIcon(image);
		 				}
		 				else if (number == 4){
		 					image = new ImageIcon("images/stone_glow_pink.png");
		 					
		 					setIcon(image);
		 				}
		 			 		else if (number == 5){
		 			 			image = new ImageIcon("images/stone_glow_red.png");
		 			 			
		 			 			setIcon(image);
		 			 		}
		 			 			else if (number == 6){
				 					image = new ImageIcon("images/stone_glow_yellow.png");
				 					
				 					setIcon(image);
				 				}
		 			 			//else if (number == 7){
		 			 				//if (powerup == 0){
		 			 					//image = new ImageIcon("images/stone_skull_yellow.png");
					 					
					 					//setIcon(image);
		 			 				//}
		 			 				//else if (powerup == 1){
		 			 					//image = new ImageIcon("images/stone_life_blue.png");
					 					
					 				//	setIcon(image);
		 			 				//}
		 			 				//else if(powerup == 2){
		 			 					//image = new ImageIcon("images/stone_energy_red.png");
					 					
					 					//setIcon(image);
		 			 		//		}
		 			 			//	else if(powerup == 3){
		 			 				//	image = new ImageIcon("images/stone_nuclear_pink.png");
					 					
					 					//setIcon(image);
		 			 				//}
		 			 			//}
		
	}
	
}