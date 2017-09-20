package cloudlaundry_0919;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class StartGame extends JFrame{
	private ImageIcon movingCloud = new ImageIcon(Main.class.getResource("../image/movingCloud.png")); 
	private ImageIcon cloudClean = new ImageIcon(Main.class.getResource("../image/cloudClean.png")); 
	
	private ImageIcon cloudDirtyBasic = new ImageIcon(Main.class.getResource("../image/cloudDirtyBasic.png")); 
	private ImageIcon cloudDirtyEntered = new ImageIcon(Main.class.getResource("../image/cloudDirtyEntered.png"));
	
	private ImageIcon cloudBubble1 = new ImageIcon(Main.class.getResource("../image/cloudBubble_01.png"));
	private ImageIcon cloudBubble2 = new ImageIcon(Main.class.getResource("../image/cloudBubble_02.png"));
	private ImageIcon cloudBubble3 = new ImageIcon(Main.class.getResource("../image/cloudBubble_03.png"));
	private ImageIcon cloudBubble4 = new ImageIcon(Main.class.getResource("../image/cloudBubble_04.png"));
	
	private JButton cloudDirty= new JButton(cloudDirtyBasic);
	private JButton Bubble = new JButton(cloudBubble1); 
	
	static int bubble = 1;
	
	public StartGame(){
		
		cloudDirty.setBounds(0,0,1000,1000);
		cloudDirty.setBorderPainted(false);
		cloudDirty.setContentAreaFilled(false);
		cloudDirty.setFocusPainted(false);
		
		cloudDirty.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				cloudDirty.setCursor(new Cursor(Cursor.HAND_CURSOR));
				cloudDirty.setIcon(cloudDirtyEntered);
			}
			
			public void mouseExited(MouseEvent e){
				cloudDirty.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				cloudDirty.setIcon(cloudDirtyBasic);
				Bubble.setVisible(false);
			}
			
			public void mousePressed(MouseEvent e){
				bubble++;
				switch(bubble){
				case 1: Bubble.setIcon(cloudBubble1); break;
				case 2: Bubble.setIcon(cloudBubble2); break;
				case 3: Bubble.setIcon(cloudBubble3); break;
				case 4: Bubble.setIcon(cloudBubble4); break;
				}
				if(bubble>=5){
					bubble = 0;
				}
			}
		});
		add(cloudDirty);
	}
}
