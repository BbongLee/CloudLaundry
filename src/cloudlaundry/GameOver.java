package cloudlaundry;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameOver extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon entered_btn = new ImageIcon(getClass().getClassLoader().getResource("entered_btn.png"));
	private ImageIcon main_btn = new ImageIcon(getClass().getClassLoader().getResource("main_btn.png"));
	private ImageIcon rank_btn = new ImageIcon(getClass().getClassLoader().getResource("rank_btn.png"));
	Image background = null;
	String user;
	public GameOver(MainCloud main) {

		background = new ImageIcon(getClass().getClassLoader().getResource("gameover_bg.png")).getImage();
		setSize(1010, 710);
		setLayout(null);

		JButton btn_main = new JButton();
		btn_main.setIcon(main_btn);
		btn_main.setBounds(265, 549, 200, 63);
		btn_main.setBorderPainted(false);
		btn_main.setContentAreaFilled(false);
		add(btn_main);

		btn_main.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btn_main.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_main.setIcon(entered_btn);
			}

			public void mouseExited(MouseEvent e) {
				btn_main.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btn_main.setIcon(main_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				main.change("indexPage");
			}
		});

		JButton btn_rank = new JButton();
		btn_rank.setIcon(rank_btn);
		btn_rank.setBounds(524, 549, 200, 63);
		btn_rank.setBorderPainted(false);
		btn_rank.setContentAreaFilled(false);
		add(btn_rank);

		btn_rank.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btn_rank.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_rank.setIcon(entered_btn);
			}

			public void mouseExited(MouseEvent e) {
				btn_rank.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btn_rank.setIcon(rank_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				main.change("rankPage");
			}
		});

	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
