package cloudlaundry;

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

class Laundry extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/exitButtonBasic.png")); 
	
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/startButtonEntered.png")); 
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../image/startButtonBasic.png"));
	
	private ImageIcon HowToButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/HowToButtonEntered.png")); 
	private ImageIcon HowToButtonBasicImage = new ImageIcon(Main.class.getResource("../image/HowToButtonBasic.png"));
	
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/quitButtonEntered.png")); 
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/quitButtonBasic.png"));
	
	
	private Image background = new ImageIcon(Main.class.getResource("../image/introbackground.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton HowToButton = new JButton(HowToButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	private int mouseX, mouseY;  //마우스의 좌표
	
	public Laundry() {
		setUndecorated(true);  //기본 메뉴바 안보임
		setTitle("구름세탁소");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // 화면에 보이게 해줌
		setBackground(new Color(0, 0, 0, 0));  //배경은 하얀색
		setLayout(null); 

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
		
		
		startButton.setBounds(220,340, 500, 150);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				startButton.setIcon(startButtonEnteredImage);
			}
			public void mouseExited(MouseEvent e){
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				startButton.setIcon(startButtonBasicImage);
			}
			public void mousePressed(MouseEvent e){
				startButton.setVisible(false);
				HowToButton.setVisible(false);
				quitButton.setVisible(false);  //버튼들 화면에 X 
				background = new ImageIcon(Main.class.getResource("../image/mainBackground.png")).getImage();
			//	StartGame
				// mianBackground 배경화면
			}
		});
		add(startButton);
		
		
		HowToButton.setBounds(220,440, 500, 150);
		HowToButton.setBorderPainted(false);
		HowToButton.setContentAreaFilled(false);
		HowToButton.setFocusPainted(false);
		HowToButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				HowToButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				HowToButton.setIcon(HowToButtonEnteredImage);
			}
			public void mouseExited(MouseEvent e){
				HowToButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				HowToButton.setIcon(HowToButtonBasicImage);
			}
			public void mousePressed(MouseEvent e){ //게임방법
				startButton.setVisible(false);
				HowToButton.setVisible(false);
				quitButton.setVisible(false);  //버튼들 화면에 X 
				background = new ImageIcon(Main.class.getResource("../image/mainBackground.png")).getImage();  //게임방법 이미지로 바꾸기  
				
				// 여기에 게임방법에서 게임시작으로 넘어가는 버튼 하나 넣어주자 !!!  
				// mainBackground 배경화면
			}
		});
		add(HowToButton);
		
		
		quitButton.setBounds(220,540, 500, 150);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				quitButton.setIcon(quitButtonEnteredImage);
			}
			public void mouseExited(MouseEvent e){
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				quitButton.setIcon(quitButtonBasicImage);
			}
			public void mousePressed(MouseEvent e){
				System.exit(0); //종료 
			}
		});
		add(quitButton);
		
		
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
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	private void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); //단순이미지(배경)
		paintComponents(g); // 고정이미지(메뉴바)
		this.repaint();
	}
}

