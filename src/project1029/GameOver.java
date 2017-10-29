package project1029;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameOver extends JPanel{
	private ImageIcon start_btn = new ImageIcon(Main1029.class.getResource("../image/replay_btn.png")); 
	private ImageIcon entered_btn = new ImageIcon(Main1029.class.getResource("../image/entered_btn.png"));
	private ImageIcon main_btn = new ImageIcon(Main1029.class.getResource("../image/main_btn.png"));
	private ImageIcon rank_btn = new ImageIcon(Main1029.class.getResource("../image/rank_btn.png"));
	Image background = null;
	String user;
	private Main1029 main;
	
	public GameOver(Main1029 main) {
		background = new ImageIcon(Main1029.class.getResource("../image/gameover_bg.png")).getImage();
		this.main = main;
		setSize(1010,710);
		setLayout(null);
		
		
		JButton btn_start = new JButton();
		btn_start.setIcon(start_btn);
		btn_start.setBounds(142,547, 200, 63);
		btn_start.setBorderPainted(false);
		btn_start.setContentAreaFilled(false);
		add(btn_start);
		
		btn_start.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				btn_start.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_start.setIcon(entered_btn);
			}
			public void mouseExited(MouseEvent e){
				btn_start.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btn_start.setIcon(start_btn);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				user = JOptionPane.showInputDialog(null,"닉네임을 입력해주세요!");
				if(user == null){
					System.out.println(user);
					return;
				}
				else{
					System.out.println(user);
					main.setUser(user);
					main.change("gamePage");
				}
			}
		});
		
		JButton btn_main = new JButton();
		btn_main.setIcon(main_btn);
		btn_main.setBounds(398, 547, 200, 63);
		btn_main.setBorderPainted(false);
		btn_main.setContentAreaFilled(false);
		add(btn_main);
		
		btn_main.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				btn_main.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_main.setIcon(entered_btn);
			}
			public void mouseExited(MouseEvent e){
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
		btn_rank.setBounds(657, 547, 200, 63);
		btn_rank.setBorderPainted(false);
		btn_rank.setContentAreaFilled(false);
		add(btn_rank);
		
		btn_rank.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				btn_rank.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_rank.setIcon(entered_btn);
			}
			public void mouseExited(MouseEvent e){
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
