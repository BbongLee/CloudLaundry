package project1028_;
import java.io.IOException;

import javax.swing.JFrame;

public class Main1028 extends  JFrame{
	public String user;
	//�г��߰�
	
	public IndexPage indexPage = null;
	public IORank ioRank = null;
	public Howtoplay howto = null;
	public static GameStart gamePage = null;
	
	public static void main(String[] args) throws IOException {
		Main1028 main = new Main1028();
		main.setTitle("������Ź�� | ������ �̿���");
		
		//�г��߰�
		main.indexPage = new IndexPage(main);
		main.ioRank = new IORank(main,"rank.txt");
		main.howto = new Howtoplay(main);
		main.gamePage = new GameStart(main);
		
		main.add(main.indexPage);
		main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		main.setVisible(true);
		main.setSize(1015,710);
		
//		//gamePage.cloudMove();
//		CloudThread ct = new CloudThread();
//		TimeThread tt = new TimeThread();
//		ct.start();
//		tt.start();
	}
	
	public void setUser(String user){
		this.user = user;
	}
	public String getUser(){
		return user;
	}
	
	public void change(String panelName) {
		if(panelName.equals("rankPage")){
			getContentPane().removeAll();
			getContentPane().add(ioRank);
			revalidate();
			repaint();
		}
		else if(panelName.equals("indexPage")){
			getContentPane().removeAll();
			getContentPane().add(indexPage);
			revalidate();
			repaint();
		}
		else if(panelName.equals("howtoPage")){
			getContentPane().removeAll();
			getContentPane().add(howto);
			revalidate();
			repaint();
		}
		else if(panelName.equals("gamePage")){
			getContentPane().removeAll();
			getContentPane().add(gamePage);
			
			revalidate();
			repaint();
			
		}
	}
}