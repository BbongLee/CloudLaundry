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

	JPanel leftJP = new JPanel();     //�����ִ� �г�
	JPanel rightJP = new JPanel();   //Ÿ��, ���ھ�, ����, �޼��� �г�
	ImageIcon str[] = new ImageIcon[5];
	public void insertCloudImage(){
		for(int i=0; i<5; i++) {
			str[i] = new ImageIcon(Main.class.getResource("../image/CloudClean"+(i+1)+".png"));
		}
	}
	//JLabel cloud = new JLabel(str1);
	JLabel clouds[] = new JLabel[20];
	public void insertCloudLabel(){
		//clouds[0] = new JLabel(str[0]);
		//���� ���� �־��ֱ�
		for(int i=0; i<20; i++) {
			clouds[i] = new JLabel(str[(int)(Math.random()*5+1)]);
		}
	}
	private int mouseX, mouseY;
	int[][] c_location = new int[20][2];  //cloud location : ���� ��ǥ
	
	public void insertXY(){
		int x = 0;
		for(int i=0; i<20; i++) {
			x = 0;
			switch((int)(i%4)) {
			case 0:case 4:case 8:case 12:case 16: x=0; break;
			case 1:case 5:case 9:case 13:case 17: x=1; break;
			case 2:case 6:case 10:case 14:case 18: x=2; break;
			case 3:case 7:case 11:case 15:case 19: x=3;  break;
			default: System.out.println("��ǥ���� ����!"); break;
			}
			c_location[i][0] = x * 160;
			c_location[i][1] = (i / 4) * 125;
		}
	}
	public GameStart(){
		setUndecorated(true);  //�⺻ �޴��� �Ⱥ���
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // ȭ�鿡 ���̰� ����
		
		//������
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		leftJP.setSize(690, Main.SCREEN_HEIGHT);
		rightJP.setSize(300, Main.SCREEN_HEIGHT);
		//���
		setBackground(new Color(0, 0, 0, 0));
		leftJP.setBackground(new Color(0, 0, 0, 0));
		rightJP.setBackground(new Color(0, 0, 0, 0));
		//���̾ƿ� 
		setLayout(null); 
		leftJP.setLayout(null); 
		rightJP.setLayout(null); 
		//��ġ
		leftJP.setBounds(25, 55, 640, 625 );
		rightJP.setBounds(690, 55, 285, 625);
		
		setLocationRelativeTo(null); //�߾ӹ�ġ
		
		//â���� ��ư
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
		
		//�޴���
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
		//����
		leftJP.setBackground(Color.BLUE);
		rightJP.setBackground(Color.RED);
//		//���� �Ѱ�
//		cloud.setBounds(0,0,160,125);
//		leftJP.add(cloud);
		//���� ������
		for(int i=0; i<20; i++) {
		clouds[i].setBounds(c_location[i][0],c_location[i][1],160,125);
		leftJP.add(clouds[i]);
		}
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
		g.drawImage(background, 0, 0, null); //�ܼ��̹���(���)
		paintComponents(g); // �����̹���(�޴���)
		this.repaint();
	}
	public static void main(String[] args) {
		new GameStart();
	}

}