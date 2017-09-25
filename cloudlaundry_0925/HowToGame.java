package cloudlaundry_0925;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import cloudlaundry_0922.Main;

public class HowToGame extends JPanel{
	private Laundry frame;
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/backButtonEntered.png")); 
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../image/backButtonBasic.png"));
	
	private ImageIcon startButtonEntered2Image = new ImageIcon(Main.class.getResource("../image/startButtonEntered2.png")); 
	private ImageIcon startButtonBasic2Image = new ImageIcon(Main.class.getResource("../image/startButtonBasic2.png"));
	
	private JButton backButton = new JButton(backButtonBasicImage);
	private JButton startButton2 = new JButton(startButtonBasic2Image);
	
	private JPanel btnPanel = new JPanel();
	
	public HowToGame (Laundry laundry){
		frame = laundry; 
		btnPanel.setBackground(new Color(0, 0, 0, 0));  //배경은 하얀색
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		btnPanel.setLayout(null); 
		setLayout(null); 
		btnPanel.setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		frame = laundry; 
		
		startButton2.setBounds(700,130, 200, 99);
		startButton2.setBorderPainted(false);
		startButton2.setContentAreaFilled(false);
		startButton2.setFocusPainted(false);
		startButton2.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				startButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				startButton2.setIcon(backButtonEnteredImage);
			}
			public void mouseExited(MouseEvent e){
				startButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				startButton2.setIcon(backButtonBasicImage);
			}
			public void mousePressed(MouseEvent e){ //게임방법
				laundry.nextPanel();
				laundry.background =new ImageIcon(Main.class.getResource("../image/HowToBackground.png")).getImage();
				btnPanel.setVisible(false);
			}
		});
		
		backButton.setBounds(100,130, 200, 99);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				backButton.setIcon(backButtonEnteredImage);
			}
			public void mouseExited(MouseEvent e){
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				backButton.setIcon(backButtonBasicImage);
			}
			public void mousePressed(MouseEvent e){ //게임방법
				laundry.nextPanel();
				laundry.background =new ImageIcon(Main.class.getResource("../image/HowToBackground.png")).getImage();
				btnPanel.setVisible(true);
			}
		});
		
		btnPanel.add(startButton2);
		btnPanel.add(backButton);
		
		add(btnPanel);
		btnPanel.setVisible(true);
		
		setVisible(true);
	}
}
