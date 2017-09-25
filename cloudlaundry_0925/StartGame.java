package cloudlaundry_0925;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cloudlaundry_0922.Main;

class StartGame extends JPanel{
	private Image screenImage;
	private Graphics screenGraphic;
	
	//Ÿ�̸� 
	Timer t = new Timer();
	
	private JPanel leftJP = new JPanel(); //�����ִ� �г�
	
	private JPanel rightJP = new JPanel();//�����ִ� �г�
	private JLabel time = new JLabel("30��");  //ó�� = 30��

	private Laundry frame;
	public StartGame (Laundry laundry){
		frame = laundry; 
		
		leftJP.setBackground(new Color(0, 0, 0, 0));
		rightJP.setBackground(new Color(0, 0, 0, 0));
		leftJP.setLayout(null); rightJP.setLayout(null);
		setLayout(null); 
		
		leftJP.setSize(665,665);rightJP.setSize(getMaximumSize());
		
		
		time.setFont(new Font("Gothic",Font.ITALIC,80)); //���̺��� ��Ʈ ���� 
		time.setBounds(700, 80, 200, 200);
		rightJP.add(time);  //�����ʿ� �ð� ���� ! 
		
		int i = 30;
		while(i>=0){
			System.out.println(time.getBounds()+"    "+time.getText());
			time.setText(""+i+"��");
			try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			i--;
		}
		
		
		
		
		add(leftJP);     leftJP.setVisible(true);
		add(rightJP);   rightJP.setVisible(true);
		
		setVisible(true);
	}
}


/*
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class StartGame extends JFrame{
	
	private Laundry frame; 
	//private Image background = new ImageIcon(Main.class.getResource("../image/GameBG.png")).getImage();
	private JPanel leftJP; //�����ִ� �г�
	private JPanel rightJP; //����(?)�ִ� �г�
	private JLabel[] cloudsJL = new JLabel[20];
	private ImageIcon cloudClean = new ImageIcon(Main.class.getResource("../image/cloudClean.png")); 
	private ImageIcon cloudDirtyBasic = new ImageIcon(Main.class.getResource("../image/cloudDirtyBasic.png")); 
	private ImageIcon cloudDirtyEntered = new ImageIcon(Main.class.getResource("../image/cloudDirtyEntered.png"));
	
	private ImageIcon cloudBubble1 = new ImageIcon(Main.class.getResource("../image/cloudBubble_01.png"));
	private ImageIcon cloudBubble2 = new ImageIcon(Main.class.getResource("../image/cloudBubble_02.png"));
	private ImageIcon cloudBubble3 = new ImageIcon(Main.class.getResource("../image/cloudBubble_03.png"));
	private ImageIcon cloudBubble4 = new ImageIcon(Main.class.getResource("../image/cloudBubble_04.png"));
	//���� ������ 
	private ImageIcon[] cloudDirty = new ImageIcon[5]; //new ImageIcon(Main.class.getResource("../image/CloudClean1.png"));
	private ImageIcon cloudDirty1 = new ImageIcon(Main.class.getResource("../image/CloudClean1.png"));
	private ImageIcon cloudDirty2 = new ImageIcon(Main.class.getResource("../image/CloudClean2.png"));
	private ImageIcon cloudDirty3 = new ImageIcon(Main.class.getResource("../image/CloudClean3.png"));
	private ImageIcon cloudDirty4 = new ImageIcon(Main.class.getResource("../image/CloudClean4.png"));
	private ImageIcon cloudDirty5 = new ImageIcon(Main.class.getResource("../image/CloudClean5.png"));

	//cloudsJL[i] = new JLabel(cloudDirty[image])); 
	//ĭ ������ ���� : 160, ���� : 125px
	public StartGame (Laundry laundry){
		frame = laundry;
		setUndecorated(true);  //�⺻ �޴��� �Ⱥ���
		setTitle("������Ź�� . . .");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // ȭ�鿡 ���̰� ����
		setBackground(new Color(0, 0, 0, 0));  //����� �Ͼ��
		setLayout(null);
		//left JPanel
		//cloudDirty
		for(int i=0; i<5; i++) {
			cloudDirty[i] = new ImageIcon(Main.class.getResource("../image/CloudClean"+(i+1)+".png"));
		}
		//cloudsJLabel
		//�� ��ġ ����
		//for(int i=0;i<20;i++) {
		//	cloudsJL[i].setBounds(25,25,160*(i/4),125*(i/5));
		//}
			//	�������� �� ������ŭ �̹����迭��(ex)20���� 5��) ���ϱ�.
		for(int i=0; i<20; i++) {
		//�������� ���������� �ֱ�!, ���������� �����̽��� Ƚ���� �޶���.
			cloudsJL[i] = new JLabel(cloudDirty[(int)(Math.random()*5)]);
		leftJP.add(cloudsJL[i]); 
		}
		
		leftJP.setBounds(25,25,640,650);
		leftJP.setLayout(null);

		//add(leftJP);
		this.add(leftJP);
		
		//Right JPanel
		setVisible(true);

	}//startGame(Laundry)�����ڸ޼���!
}*/