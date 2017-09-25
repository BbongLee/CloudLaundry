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
	private JPanel leftJP; //�����ִ� �г�
	private JPanel rightJP; //����(?)�ִ� �г�
	private JLabel cloudsJL[] = new JLabel[20];
	private ImageIcon cloudClean = new ImageIcon(Main.class.getResource("../image/cloudClean.png")); 
	private ImageIcon cloudDirtyBasic = new ImageIcon(Main.class.getResource("../image/cloudDirtyBasic.png")); 
	private ImageIcon cloudDirtyEntered = new ImageIcon(Main.class.getResource("../image/cloudDirtyEntered.png"));
	
	private ImageIcon cloudBubble1 = new ImageIcon((Main.class.getResource("../image/cloudBubble_01.png")));
	private ImageIcon cloudBubble2 = new ImageIcon(Main.class.getResource("../image/cloudBubble_02.png"));
	private ImageIcon cloudBubble3 = new ImageIcon(Main.class.getResource("../image/cloudBubble_03.png"));
	private ImageIcon cloudBubble4 = new ImageIcon(Main.class.getResource("../image/cloudBubble_04.png"));
	//���� ������ 
	private ImageIcon[] cloudDirty = new ImageIcon[5];
	
	//cloudsJL[i] = new JLabel(cloudDirty[image])); 
	//ĭ ������ ���� : 160, ���� : 125px
	public StartGame (Laundry laundry){

		for(JLabel label : cloudsJL ) {
			label = new JLabel();
		}
		
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
		//��ǥ���� ��Ģ 
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
				System.out.println("��ǥ���� ����!");
				break;
			}
			cloudsJL[i].setBounds(25+x*160, 25+(i/4)*125, 160, 125);
		}
		//	�������� �� ������ŭ �̹����迭��(ex)20���� 5��) ���ϱ�.
		for(int i=0; i<cloudsJL.length; i++) {
		//�������� ���������� �ֱ�!, ���������� �����̽��� Ƚ���� �޶���.
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

	}//startGame(Laundry)�����ڸ޼���!
}