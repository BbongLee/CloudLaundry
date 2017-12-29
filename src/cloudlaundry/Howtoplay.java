package cloudlaundry;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Howtoplay extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon start_btn = new ImageIcon(getClass().getClassLoader().getResource("start_btn.png"));
	private ImageIcon entered_btn = new ImageIcon(getClass().getClassLoader().getResource("entered_btn.png"));
	private ImageIcon main_btn = new ImageIcon(getClass().getClassLoader().getResource("main_btn.png"));

	Image background = null;
	String user;
	public Howtoplay(MainCloud main) {
		background = new ImageIcon(getClass().getClassLoader().getResource("howto_bg.png")).getImage();
		setSize(1010, 710);
		setLayout(null);

		JButton btn_start = new JButton();
		btn_start.setIcon(start_btn);
		btn_start.setBounds(272, 546, 200, 63);
		btn_start.setBorderPainted(false);
		btn_start.setContentAreaFilled(false);
		add(btn_start);

		btn_start.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btn_start.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_start.setIcon(entered_btn);
			}

			public void mouseExited(MouseEvent e) {
				btn_start.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btn_start.setIcon(start_btn);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				user = JOptionPane.showInputDialog(null, "닉네임을 입력해주세요!");
				if (user == null) {
					System.out.println(user);
					return;
				} else {
					System.out.println(user);
					main.setUser(user);
					main.change("gamePage");
				}
			}
		});

		JButton btn_main = new JButton();
		btn_main.setIcon(main_btn);
		btn_main.setBounds(528, 546, 200, 63);
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
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}
