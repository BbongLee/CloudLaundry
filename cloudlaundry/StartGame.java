package cloudlaundry;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.print.DocFlavor.URL;
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
	private JLabel cloudsJL[] = new JLabel[20];
	private ImageIcon cloudClean = new ImageIcon(Main.class.getResource("../image/cloudClean.png")); 
	private ImageIcon cloudDirtyBasic = new ImageIcon(Main.class.getResource("../image/cloudDirtyBasic.png")); 
	private ImageIcon cloudDirtyEntered = new ImageIcon(Main.class.getResource("../image/cloudDirtyEntered.png"));
	
	private ImageIcon cloudBubble1 = new ImageIcon((Main.class.getResource("../image/cloudBubble_01.png")));
	private ImageIcon cloudBubble2 = new ImageIcon(Main.class.getResource("../image/cloudBubble_02.png"));
	private ImageIcon cloudBubble3 = new ImageIcon(Main.class.getResource("../image/cloudBubble_03.png"));
	private ImageIcon cloudBubble4 = new ImageIcon(Main.class.getResource("../image/cloudBubble_04.png"));
	//구름 오염도 
	private ImageIcon[] cloudDirty = new ImageIcon[5];
	
	//cloudsJL[i] = new JLabel(cloudDirty[image])); 
	//칸 사이즈 가로 : 160, 세로 : 125px
	public StartGame (Laundry laundry){

		for(JLabel label : cloudsJL ) {
			label = new JLabel();
		}
		
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
		//좌표생성 규칙 
		int x = 0;
		for(int i=0; i<cloudsJL.length; i++) {
			switch((int)(i%4)) {
			case 0:case 4:case 8:case 12:case 16:
				x=0;
				break;
			case 1:case 5:case 9:case 13:case 17:
				x=1;
				break;
			case 2:case 6:case 10:case 14:case 18:
				x=2;
				break;
			case 3:case 7:case 11:case 15:case 19:
				x=3; 
				break;
			default:
				System.out.println("좌표생성 에러!");
				break;
			}
			cloudsJL[i].setBounds(25+x*160, 25+(i/4)*125, 160, 125);
		}
		//	랜덤으로 들어갈 개수만큼 이미지배열방(ex)20개중 5개) 구하기.
		for(int i=0; i<cloudsJL.length; i++) {
		//랜덤으로 더러움정도 넣기!, 정도에따라 스페이스바 횟수가 달라짐.
			cloudsJL[i] = new JLabel(cloudDirty[(int)(Math.random()*5)]);
			//System.out.println(cloudsJL[i]);
		}
		
		for (int i=0; i<cloudsJL.length; i++) {
			leftJP.add(cloudsJL[i]); 
		}
		leftJP.setBounds(25,25,640,650);
		leftJP.setLayout(null);

		//add(leftJP);
		this.add(leftJP);
		
		//Right JPanel
		setVisible(true);

	}//startGame(Laundry)생성자메서드!
}