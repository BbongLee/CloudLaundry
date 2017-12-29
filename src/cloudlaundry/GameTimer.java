package cloudlaundry;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameTimer extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int k = 30;
	JLabel timerLabel;

	public GameTimer(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	public void run() {
		MainCloud main = new MainCloud();
		GameStart gs = new GameStart(main);

		while (k >= 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timerLabel.setText(k + "√ ");
			k--;
		}
		main.change("gameover");
		main.setScore(gs.getScore());

	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}
}
