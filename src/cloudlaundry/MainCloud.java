package cloudlaundry;

import java.io.IOException;

import javax.swing.JFrame;

public class MainCloud extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String user = "user";
	int score = 0;
	// 패널추가

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	static MainCloud main;
	public IndexPage indexPage = null;
	public IORank ioRank = null;
	public Howtoplay howto = null;
	public static GameStart gamePage = null;
	public GameOver overPage = null;
	public GameClear clearPage = null;

	public static void main(String[] args) throws IOException {
		main = new MainCloud();
		main.setTitle("구름세탁소 | 김윤영 이예본");

		// 패널추가
		main.indexPage = new IndexPage(main);
		main.ioRank = new IORank(main, "rank.txt");
		main.howto = new Howtoplay(main);
		MainCloud.gamePage = new GameStart(main);
		main.overPage = new GameOver(main);

		main.add(main.indexPage);
		main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		main.setVisible(true);
		main.setSize(1015, 740);

		Music introMusic = new Music("music/introMusic.mp3", true);
		introMusic.start();

		gamePage.cloudMove();

		introMusic.close();

	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void change(String panelName) {
		if (panelName.equals("rankPage")) {
			ioRank = new IORank(main, "rank.txt");
			getContentPane().removeAll();
			getContentPane().add(ioRank);
			revalidate();
			repaint();
		} else if (panelName.equals("indexPage")) {
			getContentPane().removeAll();
			getContentPane().add(indexPage);
			revalidate();
			repaint();
		} else if (panelName.equals("howtoPage")) {
			getContentPane().removeAll();
			getContentPane().add(howto);
			revalidate();
			repaint();
		} else if (panelName.equals("gamePage")) {
			getContentPane().removeAll();
			getContentPane().add(gamePage);
			revalidate();
			repaint();
		} else if (panelName.equals("gameover")) {
			getContentPane().removeAll();
			getContentPane().add(overPage);
			revalidate();
			repaint();
		} else if (panelName.equals("gameclear")) {
			main.clearPage = new GameClear(main);
			getContentPane().removeAll();
			getContentPane().add(clearPage);
			revalidate();
			repaint();
		}
	}
}
