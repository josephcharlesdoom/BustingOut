import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Paddle extends JButton {

static ImageIcon image;



public Paddle()
{
	super();
	
	setPicture();
	setBorder(null);
	setContentAreaFilled(false);
	
	
}
	void setPicture(){
		
		image = new ImageIcon("images/bat_trippy.png");
		
		setIcon(image);
		
		
	}
	
}
