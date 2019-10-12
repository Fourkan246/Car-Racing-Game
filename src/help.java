import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class help extends JFrame {

	private JPanel contentPane;
	private JLabel lblRules;
	private JTextArea txtRules;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					help frame = new help();
					frame.setVisible(true);
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
	public help() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 501);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHowToPlay = new JLabel("How To Play");
		lblHowToPlay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHowToPlay.setBounds(10, 41, 100, 28);
		contentPane.add(lblHowToPlay);
		
		lblRules = new JLabel("Rules");
		lblRules.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRules.setBounds(10, 216, 100, 28);
		contentPane.add(lblRules);
		
		JTextArea txtHowToPlay = new JTextArea();
		txtHowToPlay.setBackground(SystemColor.inactiveCaption);
		txtHowToPlay.setEditable(false);
		
		txtHowToPlay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHowToPlay.setBounds(10, 82, 437, 123);
		txtHowToPlay.setText("Move your car left and right by using the right and left arrow keys.\n\nAccelerate your car to your preferred speed using the up arrow key.\n\nUse the down arrow key to steadily decrease the speed.\n\nFire using space key once you are eligible to fire.\n");
		contentPane.add(txtHowToPlay);
		
		txtRules = new JTextArea();
		txtRules.setBackground(SystemColor.inactiveCaption);
		txtRules.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRules.setText("Try to avoid the cars coming from the opposite direction.\n\nKeep an eye out for special items like health and fire.\n\nBe extra careful about the instant death that will kill you instantly.\n");
		txtRules.setEditable(false);
		txtRules.setBounds(10, 255, 437, 96);
		contentPane.add(txtRules);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainMenu().setVisible(true);
			
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(358, 11, 89, 23);
		contentPane.add(btnBack);
	}
}
