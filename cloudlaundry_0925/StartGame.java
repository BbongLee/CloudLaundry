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
	
	//타이머 
	Timer t = new Timer();
	
	private JPanel leftJP = new JPanel(); //구름있는 패널
	
	private JPanel rightJP = new JPanel();//정보있는 패널
	private JLabel time = new JLabel("30초");  //처음 = 30초

	private Laundry frame;
	public StartGame (Laundry laundry){
		frame = laundry; 
		
		leftJP.setBackground(new Color(0, 0, 0, 0));
		rightJP.setBackground(new Color(0, 0, 0, 0));
		leftJP.setLayout(null); rightJP.setLayout(null);
		setLayout(null); 
		
		leftJP.setSize(665,665);rightJP.setSize(getMaximumSize());
		
		
		time.setFont(new Font("Gothic",Font.ITALIC,80)); //레이블의 폰트 설정 
		time.setBounds(700, 80, 200, 200);
		rightJP.add(time);  //오른쪽에 시간 붙임 ! 
		
		int i = 30;
		while(i>=0){
			System.out.println(time.getBounds()+"    "+time.getText());
			time.setText(""+i+"초");
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
	private JPanel leftJP; //구름있는 패널
	private JPanel rightJP; //설명(?)있는 패널
	private JLabel[] cloudsJL = new JLabel[20];
	private ImageIcon cloudClean = new ImageIcon(Main.class.getResource("../image/cloudClean.png")); 
	private ImageIcon cloudDirtyBasic = new ImageIcon(Main.class.getResource("../image/cloudDirtyBasic.png")); 
	private ImageIcon cloudDirtyEntered = new ImageIcon(Main.class.getResource("../image/cloudDirtyEntered.png"));
	
	private ImageIcon cloudBubble1 = new ImageIcon(Main.class.getResource("../image/cloudBubble_01.png"));
	private ImageIcon cloudBubble2 = new ImageIcon(Main.class.getResource("../image/cloudBubble_02.png"));
	private ImageIcon cloudBubble3 = new ImageIcon(Main.class.getResource("../image/cloudBubble_03.png"));
	private ImageIcon cloudBubble4 = new ImageIcon(Main.class.getResource("../image/cloudBubble_04.png"));
	//구름 오염도 
	private ImageIcon[] cloudDirty = new ImageIcon[5]; //new ImageIcon(Main.class.getResource("../image/CloudClean1.png"));
	private ImageIcon cloudDirty1 = new ImageIcon(Main.class.getResource("../image/CloudClean1.png"));
	private ImageIcon cloudDirty2 = new ImageIcon(Main.class.getResource("../image/CloudClean2.png"));
	private ImageIcon cloudDirty3 = new ImageIcon(Main.class.getResource("../image/CloudClean3.png"));
	private ImageIcon cloudDirty4 = new ImageIcon(Main.class.getResource("../image/CloudClean4.png"));
	private ImageIcon cloudDirty5 = new ImageIcon(Main.class.getResource("../image/CloudClean5.png"));

	//cloudsJL[i] = new JLabel(cloudDirty[image])); 
	//칸 사이즈 가로 : 160, 세로 : 125px
	public StartGame (Laundry laundry){
		frame = laundry;
		setUndecorated(true);  //기본 메뉴바 안보임
		setTitle("구름세탁중 . . .");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // 화면에 보이게 해줌
		setBackground(new Color(0, 0, 0, 0));  //배경은 하얀색
		setLayout(null);
		//left JPanel
		//cloudDirty
		for(int i=0; i<5; i++) {
			cloudDirty[i] = new ImageIcon(Main.class.getResource("../image/CloudClean"+(i+1)+".png"));
		}
		//cloudsJLabel
		//라벨 위치 지정
		//for(int i=0;i<20;i++) {
		//	cloudsJL[i].setBounds(25,25,160*(i/4),125*(i/5));
		//}
			//	랜덤으로 들어갈 개수만큼 이미지배열방(ex)20개중 5개) 구하기.
		for(int i=0; i<20; i++) {
		//랜덤으로 더러움정도 넣기!, 정도에따라 스페이스바 횟수가 달라짐.
			cloudsJL[i] = new JLabel(cloudDirty[(int)(Math.random()*5)]);
		leftJP.add(cloudsJL[i]); 
		}
		
		leftJP.setBounds(25,25,640,650);
		leftJP.setLayout(null);

		//add(leftJP);
		this.add(leftJP);
		
		//Right JPanel
		setVisible(true);

	}//startGame(Laundry)생성자메서드!
}*/