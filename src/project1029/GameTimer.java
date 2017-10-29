package project1029;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameTimer extends JPanel implements Runnable{
	int k = 30;
	JLabel timerLabel;
	public GameTimer(JLabel timerLabel){
		this.timerLabel = timerLabel;
    }
	
    public void run(){
    	Main1029 main = new Main1029();
    	GameStart gs = new GameStart(main);
    	 
         while(k>=0){
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             timerLabel.setText(k+"��");
//             System.out.println(k+"��");
             k--;
         }
         int op = JOptionPane.showConfirmDialog(null,"�ð��� �ʰ��߾��!","GameOver", JOptionPane.OK_OPTION,
					JOptionPane.PLAIN_MESSAGE,new ImageIcon(GameStart.class.getResource("/image/"+"cry.png")));
         // 0 = ��   || 1 = �ƴϿ�
         if(op == 0){
        	 main.change("gameover");
         }
         System.out.println(op);
    }

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}
}
 