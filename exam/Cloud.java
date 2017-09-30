package exam;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import cloudlaundry_0919.Main;

public class Cloud extends Thread {
	private JButton cloud;
	
	private int x, y; // x, y좌표
	private int pollutNum; // 구름 오염도 -> 버튼 클릭 해야할 개수
	private int clickGoal; // 버튼 클릭할 개수
	private int click; // 버튼 클릭한 개수

	
	
	public Cloud(int x, int y, int pollutNum, int click) {
		super();
		this.x = x;
		this.y = y;
		this.pollutNum = pollutNum;
		this.click = click;
	}

	public JButton drawCloud() {
		switch (pollutNum) {
		case 0:
			cloud = new JButton(new ImageIcon("CloudClean0.png"));
			clickGoal = 0;
			break;
		case 1:
			cloud = new JButton(new ImageIcon("CloudClean1.png"));
			clickGoal = 3;
			break;
		case 2:
			cloud = new JButton(new ImageIcon("CloudClean2.png"));
			clickGoal = 5;
			break;
		case 3:
			cloud = new JButton(new ImageIcon("CloudClean3.png"));
			clickGoal = 7;
			break;
		case 4:
			cloud = new JButton(new ImageIcon("CloudClean4.png"));
			clickGoal = 0;
			break;
		}
		return cloud;
	}//오염도 따라 버튼 이미지 정해주기.

	public void run() {

	}
}
