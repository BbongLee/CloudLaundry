package cloudlaundry;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cloudlaundry_0922.Main;

class StartGame extends JPanel{
	private Laundry frame;
	public StartGame (Laundry laundry){
		frame = laundry; 
		
		
		setVisible(true);
	}
}
