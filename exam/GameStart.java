package exam;

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

class GameThread extends Thread {
	public void run() {

	}

	public void run(JLabel timer) {
		int i = 30;
		while (i >= 0) {
			System.out.println(timer.getBounds() + "    " + timer.getText());
			timer.setText("" + i + "초");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i--;
		}
	}
}

public class GameStart extends JFrame {
	Image screenImage;
	Graphics screenGraphic;
	private int mouseX, mouseY;
	JPanel leftJP = new JPanel(); // 구름있는 패널
	JPanel rightJP = new JPanel(); // 타임, 스코어, 네임, 메세지 패널

	Image background = new ImageIcon(Main.class.getResource("../image/GameBG.png")).getImage();

	ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/exitButtonEntered.png"));
	ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/exitButtonBasic.png"));
	JButton exitButton = new JButton(exitButtonBasicImage);

	JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));

	// 구름오염도에 따른 구름!
	ImageIcon[] str = new ImageIcon[5];
	ImageIcon str0 = new ImageIcon("CloudClean0.png");
	ImageIcon str1 = new ImageIcon("CloudClean1.png");
	ImageIcon str2 = new ImageIcon("CloudClean2.png");
	ImageIcon str3 = new ImageIcon("CloudClean3.png");
	ImageIcon str4 = new ImageIcon("CloudClean4.png");
	// 구름 객체
	//ArrayList<Cloud> CloudList = new ArrayList<Cloud>();
	Cloud cl;
	// *****************************
	JLabel title = new JLabel(new ImageIcon(Main.class.getResource("../image/titleImage.png")));
	int CloudNum = 30; // 구름개수 1lev
	JLabel timer = new JLabel("100초");

	JLabel clock = new JLabel(new ImageIcon(Main.class.getResource("../image/Alarm01.png")));
	JLabel money = new JLabel(new ImageIcon(Main.class.getResource("../image/money.png")));
	JLabel mon = new JLabel("2500원");
	JLabel smile = new JLabel(new ImageIcon(Main.class.getResource("../image/smile.png")));
	JLabel ment = new JLabel(new ImageIcon(Main.class.getResource("../image/ment.png")));

	public GameStart() {
		setUndecorated(true); // 기본 메뉴바 안보임
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // 화면에 보이게 해줌

		// 사이즈
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		leftJP.setSize(630, 600);
		rightJP.setSize(265, 600);
		// 배경
		setBackground(new Color(0, 0, 0, 0));
		leftJP.setBackground(new Color(0, 0, 0, 0));
		rightJP.setBackground(new Color(0, 0, 0, 0));
		// 레이아웃
		setLayout(null);
		leftJP.setLayout(null);
		rightJP.setLayout(null);
		// 위치
		leftJP.setBounds(25, 55, 640, 625);
		rightJP.setBounds(690, 55, 285, 625);

		setLocationRelativeTo(null); // 중앙배치
		
		dropClouds();
		add(leftJP);

		// *****************************

		GameThread time = new GameThread();

		title.setBounds(-5, 25, 300, 160);
		rightJP.add(title);

		clock.setBounds(55, 200, 55, 55);
		rightJP.add(clock);

		money.setBounds(55, 260, 55, 55);
		rightJP.add(money);

		// ment.setBounds(55, 400, 55, 55);
		// rightJP.add(ment);
		// smile.setBounds(55, 500, 55, 55);
		// rightJP.add(smile);

		timer.setFont(new Font("Gothic", Font.BOLD, 30)); // 레이블의 폰트 설정
		timer.setBounds(125, 130, 200, 200);
		rightJP.add(timer);

		mon.setFont(new Font("Gothic", Font.BOLD, 30)); // 레이블의 폰트 설정
		mon.setBounds(125, 190, 200, 200);
		rightJP.add(mon);
		// time.run(timer);

		// 창끄기 버튼
		exitButton.setBounds(965, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				exitButton.setIcon(exitButtonEnteredImage);
			}

			public void mouseExited(MouseEvent e) {
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				exitButton.setIcon(exitButtonBasicImage);
			}

			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exitButton);

		// 메뉴바
		menuBar.setBounds(0, 0, 1000, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen(); // 현재스크린의 좌표
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

	}
	
	public void dropClouds() {
		for (int i = 0; i < CloudNum; i++) {
			Cloud cloud = new Cloud(((int) (Math.random() * 655) + 25), 55, ((int) (Math.random() * 5)), 0);
			leftJP.add(cloud.drawCloud());
		}
	}
	

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // 단순이미지(배경)
		paintComponents(g); // 고정이미지(메뉴바)
		this.repaint();
	}


	
	public static void main(String[] args) {
		new GameStart();
	}
}