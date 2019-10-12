import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public About() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 501);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrMdFourkanulIslam = new JTextArea();
		txtrMdFourkanulIslam.setBackground(SystemColor.inactiveCaption);
		txtrMdFourkanulIslam.setEditable(false);
		txtrMdFourkanulIslam.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrMdFourkanulIslam.setText("    Md. Fourkanul Islam\r\n    Roll: 201614037\r\n    mobin.fim@gmail.com\r\n\r\n    \r\n    \r\n    Sifat Bin Zaman\r\n    Roll: 201614053\r\n    srijonsbzsifat@gmail.com\r\n");
		txtrMdFourkanulIslam.setBounds(112, 131, 264, 208);
		contentPane.add(txtrMdFourkanulIslam);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainMenu().setVisible(true);
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(358, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblDevelopers = new JLabel("Developers:");
		lblDevelopers.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDevelopers.setBounds(35, 66, 111, 23);
		contentPane.add(lblDevelopers);
	}
}
