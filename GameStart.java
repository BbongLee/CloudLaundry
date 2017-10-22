package cloudlaundry_test;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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

class GameObject {
	public int[] level = {3, 5, 7}; //내려올 구름 갯수!
	int lev = 0; //레벨 0 - 1 - 2 setLev로 바꿀 예정입니당!
	
	public int[] getLevel() {
		return level;
	}
	public void setLevel(int[] level) {
		this.level = level;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	
}

class Cloud extends GameObject{
	//x,y좌표
	//속도
	//터치메서드
	//오염정도 (이미지로 바꿀 수 있게
	private int x, y;
	private int speed = 0; //y좌표에 추가해서 구름 내려가기
	private int pollut =0;
	String cimg[] = {"CloudClean0.png", "CloudClean1.png","CloudClean2.png","CloudClean3.png","CloudClean4.png"};
	//구름오염도에 따른 구름!
//	ImageIcon[] iic;	
//	iic[0] = new ImageIcon("CloudClean0.png");
//	iic1 = new ImageIcon("CloudClean1.png");
//	iic2 = new ImageIcon("CloudClean2.png");
//	iic3 = new ImageIcon("CloudClean3.png");
//	iic4 = new ImageIcon("CloudClean4.png");
//	
	
//	public void makeCloud() {
//		pollut = (int)Math.random()*5;
//		private JButton cloudButton = new JButton(new ImageIcon(cc[pollut]));
//		x = (int)Math.random()*630;
//		y = 0;
//		speed = (int)Math.random()*20;
//		//온클릭시 pollut--;
//		//버튼 사이즈, add하기!;
//	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPollut() {
		return pollut;
	}

	public void setPollut(int pollut) {
		this.pollut = pollut;
	}
}
public class GameStart extends JFrame{
	GameObject go;
	Cloud cloud[] = new Cloud[3];
	Image screenImage;
	Graphics screenGraphic;
	private int mouseX, mouseY;
	JPanel leftJP = new JPanel();     //구름있는 패널
	JPanel rightJP = new JPanel();   //타임, 스코어, 네임, 메세지 패널
	
	
	Image background = new ImageIcon(Main.class.getResource("../image/GameBG.png")).getImage();
	
	ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/exitButtonEntered.png"));
	ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/exitButtonBasic.png")); 
	JButton exitButton = new JButton(exitButtonBasicImage);
	
	JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));

	// *****************************
	JLabel title = new JLabel(new ImageIcon(Main.class.getResource("../image/titleImage.png")));
	
	JLabel timer = new JLabel("100초");
	
	JLabel clock = new JLabel(new ImageIcon(Main.class.getResource("../image/Alarm01.png")));


	
	public GameStart(){
		setUndecorated(true);  //기본 메뉴바 안보임
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // 화면에 보이게 해줌
		
		//사이즈
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		leftJP.setSize(630, 600);
		rightJP.setSize(265, 600);
		//배경
		setBackground(new Color(0, 0, 0, 0));
		leftJP.setBackground(new Color(0, 0, 0, 0));
		rightJP.setBackground(new Color(0, 0, 0, 0));
		//레이아웃 
		setLayout(null); 
		leftJP.setLayout(null); 
		rightJP.setLayout(null); 
		//위치
		leftJP.setBounds(25, 55, 640, 625);
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
		
		//색깔
//		leftJP.setBackground(Color.BLUE);
//		rightJP.setBackground(Color.RED);
		JButton[] butCloud = new JButton[cloud.length];

		for(int i=0; i<cloud.length; i++) {
			cloud[i].setPollut((int)Math.random()*3+2);
			butCloud[i] = new JButton(new ImageIcon(cloud[i].cimg[cloud[i].getPollut()]));
			cloud[i].setX((int)Math.random()*630);
			cloud[i].setY(0);
			cloud[i].setSpeed((int)Math.random()*20);
			//온클릭시 pollut--;
			//버튼 사이즈, add하기!;
			butCloud[i].setBounds(cloud[i].getX(), cloud[i].getY(), 160, 124);
			leftJP.add(butCloud[i]);
		}
		//버튼 온클릭시 set바꿔주기
		leftJP.setVisible(true);
		add(leftJP);
		rightJP.setVisible(true);
		add(rightJP);
		
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
