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
	public int[] level = {3, 5, 7}; //������ ���� ����!
	int lev = 0; //���� 0 - 1 - 2 setLev�� �ٲ� �����Դϴ�!
	
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
	//x,y��ǥ
	//�ӵ�
	//��ġ�޼���
	//�������� (�̹����� �ٲ� �� �ְ�
	private int x, y;
	private int speed = 0; //y��ǥ�� �߰��ؼ� ���� ��������
	private int pollut =0;
	String cimg[] = {"CloudClean0.png", "CloudClean1.png","CloudClean2.png","CloudClean3.png","CloudClean4.png"};
	//������������ ���� ����!
//	ImageIcon[] iic;	
//	iic[0] = new ImageIcon("CloudClean0.png");
//	iic1 = new ImageIcon("CloudClean1.png");
//	iic2 = new ImageIcon("CloudClean2.png");
//	iic3 = new ImageIcon("CloudClean3.png");
//	iic4 = new ImageIcon("CloudClean4.png");
	public Cloud(){
		pollut = (int)(Math.random()*3)+2;
		x = (int)(Math.random()*506);
		y = 0;
		speed = (int)(Math.random()*20);
	}
	
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
}//cloud

public class GameStart extends JFrame{
	GameObject go = new GameObject();
	Cloud cloud[] = new Cloud[go.level[go.getLev()]];
	
	Image screenImage;
	Graphics screenGraphic;
	private int mouseX, mouseY;
	JPanel leftJP = new JPanel();     //�����ִ� �г�
	JPanel rightJP = new JPanel();   //Ÿ��, ���ھ�, ����, �޼��� �г�
	
	
	Image background = new ImageIcon(Main.class.getResource("../image/GameBG.png")).getImage();
	
	ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/exitButtonEntered.png"));
	ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/exitButtonBasic.png")); 
	JButton exitButton = new JButton(exitButtonBasicImage);
	
	JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));

	// *****************************
	JLabel title = new JLabel(new ImageIcon(Main.class.getResource("../image/titleImage.png")));
	
	JLabel timer = new JLabel("100��");
	
	JLabel clock = new JLabel(new ImageIcon(Main.class.getResource("../image/Alarm01.png")));


	
	public GameStart() throws InterruptedException{
		setUndecorated(true);  //�⺻ �޴��� �Ⱥ���
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // ȭ�鿡 ���̰� ����
		
		//������
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		leftJP.setSize(630, 600);
		rightJP.setSize(265, 600);
		//���
		setBackground(new Color(0, 0, 0, 0));
		leftJP.setBackground(new Color(0, 0, 0, 0));
		rightJP.setBackground(new Color(0, 0, 0, 0));
		//���̾ƿ� 
		setLayout(null); 
		leftJP.setLayout(null); 
		rightJP.setLayout(null); 
		//��ġ
		leftJP.setBounds(25, 55, 640, 625);
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
//		leftJP.setBackground(Color.BLUE);
//		rightJP.setBackground(Color.RED);
		JButton[] butCloud = new JButton[cloud.length];
		
		for(int i=0; i<cloud.length; i++) {
			cloud[i] = new Cloud();
			System.out.println(i + "������ : "+ cloud[i].getPollut());
			butCloud[i] = new JButton(new ImageIcon(cloud[i].cimg[cloud[i].getPollut()]));
			System.out.println(cloud[i].cimg[cloud[i].getPollut()]);
//			//��Ŭ���� pollut--;
//			//��ư ������, add�ϱ�!;
			System.out.println(i + "x��ǥ : "+ cloud[i].getX());
			butCloud[i].setBounds(cloud[i].getX(), cloud[i].getY(), 160, 124);
			leftJP.add(butCloud[i]);
			System.out.println(i+"��° ���� ����");
			Thread.sleep(1000);
		}
		for(int i=0; i<cloud.length; i++) {
			System.out.println(i+"���ǵ�"+cloud[i].getSpeed());
			cloud[i].setY(cloud[i].getSpeed());
			butCloud[i].setBounds(cloud[i].getX(), cloud[i].getY(), 160, 124);
			leftJP.add(butCloud[i]);
		}
		//��ư ��Ŭ���� set�ٲ��ֱ�
		leftJP.setVisible(true);
		add(leftJP);
		rightJP.setVisible(true);
		add(rightJP);
		
	}//������ �޼���
	
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
	public static void main(String[] args) throws InterruptedException {
		new GameStart();
	}
}
