import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Control extends JPanel implements ActionListener{

	//----------------------------------------
	// ATTRIBUTES
	//----------------------------------------
	Welcome wp;		//create variable for wp
	Option op;			//create variable for op
	Instruction ip;							//create variable for ip
	Level1 l1;								//create variable for gp
	Level2 l2;
	Level3 l3;
	PlayField1 pf1;
	PlayField3 pf3;
	Control c1;
	Display1 d1;
	Display2 d2;
	Display3 d3;
	static int Hits = 0;
	java.applet.AudioClip clip, brother;
	ImageIcon cheePic = new ImageIcon("images/bat_cheetah.png");
    ImageIcon tripPic = new ImageIcon("images/bat_trippy.png");
    ImageIcon wavePic = new ImageIcon("images/bat_waves.png");
    ImageIcon fishPic = new ImageIcon("images/fish.jpg");
	
    static String name= JOptionPane.showInputDialog("enter your name pilot!");
	
	
	//----------------------------------------
	// CONSTRUCTOR
	//----------------------------------------
	public Control()
	{
		setLayout(new BorderLayout());		//set layout
		wp = new Welcome();					//instantiate wp
		op = new Option();					//instantiate op
		ip = new Instruction();				//instantiate ip
		l1 = new Level1();					//instantiate gp
		l2 = new Level2();
		l3 = new Level3();
		d1 = new Display1(c1);
		d2 = new Display2();
		d3 = new Display3();
		
		
		
		
		add(wp);	//add wp to panel
		
		wp.option.addActionListener(this);
		wp.instruct.addActionListener(this);
		wp.play.addActionListener(this);
		wp.quit.addActionListener(this);
		op.back.addActionListener(this);
		ip.ok.addActionListener(this);
		l1.d1.ok.addActionListener(this);
		l1.d1.stop.addActionListener(this);
		l1.d1.go.addActionListener(this);
		l2.d2.stop.addActionListener(this);
		l2.d2.go.addActionListener(this);
		l3.d3.stop.addActionListener(this);
		l3.d3.go.addActionListener(this);
		l2.d2.ok.addActionListener(this);
		l3.d3.ok.addActionListener(this);
		l3.pf3.menu.addActionListener(this);
		op.boom.addActionListener(this);
		op.easy.addActionListener(this);
		op.medium.addActionListener(this);
		op.hard.addActionListener(this);
		op.chee.addActionListener(this);
		op.trippy.addActionListener(this);
		op.waves.addActionListener(this);
		try
	 	{
	 		// create the clip that will played later
	 		// You can play files type: .au, .aif, .mid, .rmf, and .wav.
	 		// this method doesn't play wma or mp3 files.
			clip = java.applet.Applet.newAudioClip(new java.net.URL("file:sounds/dub.wav"));
			brother = java.applet.Applet.newAudioClip(new java.net.URL("file:sounds/brother.wav"));
	 	}
      catch(Exception xx) {xx.printStackTrace();}
		
		
		if (Hits > 10){
			remove(l1);
			add(l2);
			validate();
			repaint();
			}
		
		
	}// end constructor
	
	//----------------------------------------
	// METHODS
	//----------------------------------------
	public void actionPerformed(ActionEvent event)
	{
		Object obj = event.getSource();
		if(obj == op.boom)
		{
			try
		 	{
		 		clip.play();//play
		 	}
          catch(Exception xx) {xx.printStackTrace();}
		}
		
		if(obj == wp.option)
		{
			remove(wp);
			add(op);
			validate();
			repaint();
		}
		else if(obj == op.back)
		{
			remove(op);
			add(wp);
			validate();
			repaint();
		}
		else if(obj == wp.instruct)
		{
			remove(wp);
			add(ip);
			validate();
			repaint();
		}
		else if(obj == wp.play)
		{
			
			remove(wp);
			add(l1);
			validate();
			repaint();
			
			l1.pf1.pad1.requestFocusInWindow();
			
			
			
		}
		else if(obj == wp.quit)
		{
			System.exit(0);
		}
		else if(obj == ip.ok)
		{
			remove(ip);
			add(wp);
			validate();
			repaint();
		}
		else if(obj == l1.d1.ok)
		{
			remove(l1);
			add(l2);
			validate();
			repaint();
			
			l2.pf2.pad1.requestFocusInWindow();
			
			try
		 	{
		 		brother.play();//play
		 	}
          catch(Exception xx) {xx.printStackTrace();}
		}
		else if(obj == l1.d1.stop){
			
			try
		 	{
		 		clip.stop();//play
		 	}
          catch(Exception xx) {xx.printStackTrace();}
			
		}
		else if(obj == l1.d1.go){
			
			try
		 	{
		 		clip.play();//play
		 	}
          catch(Exception xx) {xx.printStackTrace();}
			
		}	
		else if(obj == l2.d2.stop){
			
			try
		 	{
		 		clip.stop();//play
		 	}
          catch(Exception xx) {xx.printStackTrace();}
			
		}
		else if(obj == l2.d2.go){
			
			try
		 	{
		 		clip.play();//play
		 	}
          catch(Exception xx) {xx.printStackTrace();}
			
		}
		else if(obj == l3.d3.stop){
			
			try
		 	{
		 		clip.stop();//play
		 	}
          catch(Exception xx) {xx.printStackTrace();}
			
		}
		else if(obj == l3.d3.go){
			
			try
		 	{
		 		clip.play();//play
		 	}
          catch(Exception xx) {xx.printStackTrace();}
			
		}
		else if(obj == l2.d2.ok)
		{
			try
		 	{
		 		brother.play();//play
		 	}
          catch(Exception xx) {xx.printStackTrace();}
			
			remove(l2);
			add(l3);
			validate();
			repaint();
			
			l3.pf3.pad1.requestFocusInWindow();
			
			
		}
		else if(obj == Option.easy){
			l1.pf1.delay = 15;
     		l1.d1.lives = 15;
     		l1.d1.jl1.setText("Lives: " + l1.d1.lives);
		}
		else if(obj == Option.medium){
			l1.pf1.delay = 12;
			l1.d1.lives = 10;
			l1.d1.jl1.setText("Lives: " + l1.d1.lives);
		}
		else if(obj == Option.hard){
			l1.pf1.delay = 12;
			l1.d1.lives = 5;
			l1.d1.jl1.setText("Lives: " + l1.d1.lives);
		}
		else if(obj == l3.d3.ok)
		{
			remove(l3);
			add(wp);
			validate();
			repaint();
			
			try
		 	{
		 		brother.play();//play
		 	}
          catch(Exception xx) {xx.printStackTrace();}
			
		}
		else if(obj == l3.pf3.menu){
			remove(l3);
			add(wp);
			validate();
			repaint();
		}
		 if (obj == Option.chee)
    	 {
     		l1.pf1.pad1.setIcon(cheePic);
     	 }
     	 if (obj == Option.trippy)
     	 {
     		l1.pf1.pad1.setIcon(tripPic);
     	 }
     	 if (obj == Option.waves)
     	 {
     		l1.pf1.pad1.setIcon(wavePic);
     	 }
	}	//end action performed
	
	
}// end class