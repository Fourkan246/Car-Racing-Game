import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class SecondMenu extends JFrame {

	public static int select;
	public static String playerName;
	private JPanel contentPane;
	public static SecondMenu frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//SecondMenu frame = new SecondMenu();
					frame = new SecondMenu();
					//frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 501);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SecondMenu.playerName = textField.getText();
				//dispose();
				//contentPane.hide();
				/////////////////////////sound
				Sound.backGroundStop();
				//Sound.gamePlay();
				//Sound.lowPlay();
				
				dispose();
				select = 1;
				gameSetup game = new gameSetup("Racing Game", 700, 600);
				game.start();
				//new main()
				
			}
		});
		btnEasy.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEasy.setBounds(177, 149, 89, 23);
		contentPane.add(btnEasy);
		
		JButton btnMedium = new JButton("Medium");
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SecondMenu.playerName = textField.getText();
				dispose();
				
				Sound.backGroundStop();
				//Sound.medPlay();
				
				select = 2;
				gameSetup game = new gameSetup("Racing Game", 700, 600);
				game.start();
				
				
			}
		});
		btnMedium.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMedium.setBounds(177, 207, 89, 23);
		contentPane.add(btnMedium);
		
		JButton btnExpert = new JButton("Hard");
		btnExpert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				SecondMenu.playerName = textField.getText();
				dispose();
				
				Sound.backGroundStop();
				//Sound.highPlay();
				
				select = 3;
				gameSetup game = new gameSetup("Racing Game", 700, 600);
				game.start();
				
			}
		});
		btnExpert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExpert.setBounds(177, 264, 89, 23);
		contentPane.add(btnExpert);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainMenu().setVisible(true);
			
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(358, 22, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlayerName.setBounds(33, 80, 105, 23);
		contentPane.add(lblPlayerName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(180, 83, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SecondMenu.class.getResource("/icons/backf.jpg")));
		lblNewLabel.setBounds(0, 0, 457, 462);
		contentPane.add(lblNewLabel);
		
		playerName = textField.getText().toString();
	}

}
