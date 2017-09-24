package cloudlaundry;

import java.awt.CardLayout;
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

import cloudlaundry_0922.Main;

class Laundry extends JFrame {  //���� ���̾ƿ� (�޴��� , �̵�)
	private Image screenImage;
	private Graphics screenGraphic;
	
	private CardLayout cards = new CardLayout();
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/exitButtonBasic.png")); 
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/startButtonEntered.png")); 
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../image/startButtonBasic.png"));
	
	private ImageIcon HowToButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/HowToButtonEntered.png")); 
	private ImageIcon HowToButtonBasicImage = new ImageIcon(Main.class.getResource("../image/HowToButtonBasic.png"));
	
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/quitButtonEntered.png")); 
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/quitButtonBasic.png"));
	
	
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/backButtonEntered.png")); 
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../image/backButtonBasic.png"));
	
	private ImageIcon startButtonEntered2Image = new ImageIcon(Main.class.getResource("../image/startButtonEntered2.png")); 
	private ImageIcon startButtonBasic2Image = new ImageIcon(Main.class.getResource("../image/startButtonBasic2.png"));
	
	private JButton backButton = new JButton(backButtonBasicImage);
	private JButton startButton2 = new JButton(startButtonBasic2Image);
	
	private Image background = new ImageIcon(Main.class.getResource("../image/introbackground.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));
	

	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton HowToButton = new JButton(HowToButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	
	private JPanel mainPanel = new JPanel();
	
	private int mouseX, mouseY;  //���콺�� ��ǥ
	
	public Laundry(Laundry laundry) {
		getContentPane().setLayout(cards);
	//	getContentPane().add(new LaundryMain(this));  
		getContentPane().add(new StartGame(this));
        getContentPane().add(new HowToGame(this));
	}
	public Laundry() {
		setUndecorated(true);  //�⺻ �޴��� �Ⱥ���
		setTitle("������Ź��");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // ȭ�鿡 ���̰� ����
		setBackground(new Color(0, 0, 0, 0));  //����� �Ͼ��
		setLayout(null); 
		
		getContentPane().setLayout(cards);
		getContentPane().add(new LaundryMain(this));  
		getContentPane().add(new StartGame(this));
        getContentPane().add(new HowToGame(this));
       
        
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
		
		
		
		
		
		menuBar.setBounds(0, 0, 1000, 30);
		
		menuBar.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				mouseX = e.getX();
				mouseY = e.getY();
				
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				int x = e.getXOnScreen();  //���罺ũ���� ��ǥ
				int y = e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY);
			}
		});
		add(menuBar);
		

	}
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	private void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); //�ܼ��̹���(���)
		paintComponents(g); // �����̹���(�޴���)
		this.repaint();
	}
	
	public void firstPanel() {  //����ȭ��ȣ��
        cards.first(this.getContentPane());
    }
	public void backPanel() { //��
        cards.previous(this.getContentPane());
    }
	public void nextPanel() { //����
        cards.next(this.getContentPane());
    }
	public void lastPanel() { //����
        cards.last(this.getContentPane());
    }
}

