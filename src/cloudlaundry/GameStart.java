package cloudlaundry;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStart extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image background = null;
	String user;
	boolean h = true;
	boolean overflag = true;
	String cImg[] = { "Cloud_img-17.png", "Cloud_img-16.png", "Cloud_img-15.png", "Cloud_img-14.png",
			"Cloud_img-14.png", "Cloud_img-13.png", "Cloud_img-12.png", "Cloud_img-11.png", "Cloud_img-10.png",
			"Cloud_img-09.png", "Cloud_img-08.png", "Cloud_img-07.png", "Cloud_img-06.png", "Cloud_img-05.png",
			"Cloud_img-04.png", "Cloud_img-03.png", "Cloud_img-02.png", "Cloud_img-01.png" };
	int cnt = 0;
	JLabel timerLabel = null;
	JLabel scoreLabel = null;
	GameObject go = new GameObject();
	public MainCloud main;
	int score = 0;
	Cloud cloud[] = new Cloud[go.level[go.getLev()]];
	JButton cloud_btn[] = new JButton[go.level[go.getLev()]];

	JLabel hand = null;
	ImageIcon hand1 = new ImageIcon(getClass().getClassLoader().getResource("hand1.png"));
	ImageIcon hand2 = new ImageIcon(getClass().getClassLoader().getResource("hand2.png"));

	int t = 20;
	JLabel timer = new JLabel(t + "초");

	ActionListener listener[] = new ActionListener[cloud.length];

	public void listeneradd() {
		for (int i = 0; i < cloud.length; i++) {
			int j = i;
			listener[i] = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (cloud[j].getClickNum() > 0) {
						cloud[j].setClickNum(cloud[j].getClickNum() - 1);
						((AbstractButton) e.getSource()).setIcon(new ImageIcon(
								getClass().getClassLoader().getResource(cImg[cloud[j].getClickNum()])));
						if (h) {
							hand.setIcon(hand2);
							h = false;
						} else {
							hand.setIcon(hand1);
							h = true;
						}
					} else {
						((AbstractButton) e.getSource()).setVisible(false);
					}
				}
			};
		}
	}

	public GameStart(MainCloud main) {
		background = new ImageIcon(getClass().getClassLoader().getResource("game_bg.png")).getImage();
		this.main = main;
		setSize(1010, 710);
		setLayout(null);

		hand = new JLabel("handlabel");
		hand.setIcon(hand1);
		hand.setBounds(780, 530, 160, 100);
		add(hand);

		setVisible(true);
		listeneradd();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	@SuppressWarnings({ "deprecation"})
	public void cloudMove() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < cloud_btn.length; i++) {
			cloud[i] = new Cloud();
			cloud_btn[i] = new JButton(
					new ImageIcon(getClass().getClassLoader().getResource(cImg[cloud[i].pollut])));
			cloud_btn[i].setBounds(cloud[i].getX(), cloud[i].getY(), 160, 124);
			cloud_btn[i].setBorderPainted(false);
			cloud_btn[i].setContentAreaFilled(false);
			cloud_btn[i].setFocusPainted(false);
			add(cloud_btn[i]);
			cloud_btn[i].addActionListener(listener[i]);
		}

		timerLabel = new JLabel("30");
		timerLabel.setBounds(820, 230, 100, 111);
		timerLabel.setForeground(Color.WHITE);
		timerLabel.setFont(new Font(null, Font.BOLD, 20));
		add(timerLabel);
		Thread timer = new Thread(new GameTimer(timerLabel));
		timer.start();

		scoreLabel = new JLabel("0점");
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setFont(new Font(null, Font.BOLD, 20));
		scoreLabel.setBounds(820, 350, 100, 111);
		add(scoreLabel);

		while (go.getLev() <= 3) {
			for (int i = 0; i < cloud_btn.length; i++) {
				if (cloud[i].getWait() > 0) {
					cloud[i].setWait(cloud[i].getWait() - 1);
				} else {
					try {
						Thread.sleep(go.speed[go.getLev()]);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (cloud[i].getY() > 560) {
						main.change("gameover");

						cloud[i] = null;
						cloud_btn[i] = null;
						timer.stop();

						return;
					} else if (cloud[i].getClickNum() == 0) {
						if (cloud[i].getCh()) {
							score += 100;
							scoreLabel.setText(score + "점");
							main.setScore(score);
							cloud[i].setCh(false);
							++cnt;
							if (cnt >= cloud.length) {
								main.setScore(score);
								timer.stop();
								main.change("gameclear");
							}
						}
					} else {
						cloud_btn[i].setBounds(cloud[i].getX(), cloud[i].getY(), 160, 124);
						cloud[i].setY(cloud[i].getY() + cloud[i].getSpeed());
					}
				} // else
			} // for move
		} // while
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}