import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cloudlaundry.Main;


public class GameStart extends JFrame{
	Image screenImage;
	Graphics screenGraphic;
	
	Image background = new ImageIcon(Main.class.getResource("../image/GameBG.png")).getImage();
	
	ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/exitButtonEntered.png"));
	ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/exitButtonBasic.png")); 
	JButton exitButton = new JButton(exitButtonBasicImage);
	
	JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));

	JPanel leftJP = new JPanel();     //구름있는 패널
	JPanel rightJP = new JPanel();   //타임, 스코어, 네임, 메세지 패널
	
	//구름오염도에 따른 구름!
	ImageIcon str0 = new ImageIcon("CloudClean0.png");
	ImageIcon str1 = new ImageIcon("CloudClean1.png");
	ImageIcon str2 = new ImageIcon("CloudClean2.png");
	ImageIcon str3 = new ImageIcon("CloudClean3.png");
	ImageIcon str4 = new ImageIcon("CloudClean4.png");
	//구름 칸 
	JLabel cloud0 = new JLabel(str0); JLabel cloud1 = new JLabel(str3); JLabel cloud2 = new JLabel(str0); JLabel cloud3 = new JLabel(str4);
	JLabel cloud4 = new JLabel(str1); JLabel cloud5 = new JLabel(str0); JLabel cloud6 = new JLabel(str3); JLabel cloud7 = new JLabel(str0);	
	JLabel cloud8 = new JLabel(str0); JLabel cloud9 = new JLabel(str0);	JLabel cloud10 = new JLabel(str1); JLabel cloud11 = new JLabel(str2);
	JLabel cloud12 = new JLabel(str3); JLabel cloud13 = new JLabel(str4); JLabel cloud14 = new JLabel(str0);	JLabel cloud15 = new JLabel(str4);
	JLabel cloud16 = new JLabel(str4);	JLabel cloud17 = new JLabel(str0);	JLabel cloud18 = new JLabel(str1);	JLabel cloud19 = new JLabel(str0);
	
	private int mouseX, mouseY;

	public GameStart(){
		setUndecorated(true);  //기본 메뉴바 안보임
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // 화면에 보이게 해줌
		
		//사이즈
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		leftJP.setSize(690, Main.SCREEN_HEIGHT);
		rightJP.setSize(300, Main.SCREEN_HEIGHT);
		//배경
		setBackground(new Color(0, 0, 0, 0));
		leftJP.setBackground(new Color(0, 0, 0, 0));
		rightJP.setBackground(new Color(0, 0, 0, 0));
		//레이아웃 
		setLayout(null); 
		leftJP.setLayout(null); 
		rightJP.setLayout(null); 
		//위치
		leftJP.setBounds(25, 55, 640, 625 );
		rightJP.setBounds(690, 55, 285, 625);
		
		setLocationRelativeTo(null); //중앙배치
		
		//창끄기 버튼
		exitButton.setBounds(965,0,30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				exitButton.setIcon(exitButtonEnteredImage);
			}
			public void mouseExited(MouseEvent e){
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				exitButton.setIcon(exitButtonBasicImage);
			}
			public void mousePressed(MouseEvent e){
				System.exit(0);
			}
		});
		add(exitButton);
		
		//메뉴바
		menuBar.setBounds(0, 0, 1000, 30);
		menuBar.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				mouseX = e.getX();
				mouseY = e.getY();
				
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				int x = e.getXOnScreen();  //현재스크린의 좌표
				int y = e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY);
			}
		});
		add(menuBar);
//		//색깔
//		leftJP.setBackground(Color.BLUE);
//		rightJP.setBackground(Color.RED);
		//구름 한개
		cloud0.setBounds(0,0,160,125);cloud1.setBounds(160,0,160,125);cloud2.setBounds(320,0,160,125);cloud3.setBounds(480,0,160,125);
		cloud4.setBounds(0,125,160,125);cloud5.setBounds(160,125,160,125);cloud6.setBounds(320,125,160,125);cloud7.setBounds(480,125,160,125);
		cloud8.setBounds(0,250,160,125);cloud9.setBounds(160,250,160,125);cloud10.setBounds(320,250,160,125);cloud11.setBounds(480,250,160,125);
		cloud12.setBounds(0,375,160,125);cloud13.setBounds(160,375,160,125);cloud14.setBounds(320,375,160,125);cloud15.setBounds(480,375,160,125);
		cloud16.setBounds(0,500,160,125);cloud17.setBounds(160,500,160,125);cloud18.setBounds(320,500,160,125);cloud19.setBounds(480,500,160,125);
		leftJP.add(cloud0);leftJP.add(cloud1);leftJP.add(cloud2);leftJP.add(cloud3);
		leftJP.add(cloud4);leftJP.add(cloud5);leftJP.add(cloud6);leftJP.add(cloud7);
		leftJP.add(cloud8);leftJP.add(cloud9);leftJP.add(cloud10);leftJP.add(cloud11);
		leftJP.add(cloud12);leftJP.add(cloud13);leftJP.add(cloud14);leftJP.add(cloud15);
		leftJP.add(cloud16);leftJP.add(cloud17);leftJP.add(cloud18);leftJP.add(cloud19);

		leftJP.setVisible(true);
		add(leftJP);
		
		
		rightJP.setVisible(true);
		add(rightJP);
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); //단순이미지(배경)
		paintComponents(g); // 고정이미지(메뉴바)
		this.repaint();
	}
	public static void main(String[] args) {
		new GameStart();
	}

}