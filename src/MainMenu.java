import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.SkeletonNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainMenu extends JFrame {

	//private Graphics graphics;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
					frame.setResizable(false);
					/////////////////////////
					Sound.init();
					Sound.backGroundPlay();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//loadImage.init();
		//graphics.drawImage(loadImage.fullImage, 40, 40, 500,600,null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 501);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//hide();
				dispose();
				new SecondMenu().setVisible(true);
			}
		});
		btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewGame.setBounds(171, 275, 105, 32);
		contentPane.add(btnNewGame);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/SettingsF.jpg")));
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				new Settings().setVisible(true);
			}
		});
		btnSettings.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSettings.setBounds(21, 395, 51, 44);
		contentPane.add(btnSettings);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/Button-Help-icon.png")));
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new help().setVisible(true);;
			}
		});
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHelp.setBounds(220, 418, 56, 44);
		contentPane.add(btnHelp);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/Actions-help-about-icon.png")));
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				dispose();
				new About().setVisible(true);
			}
		});
		btnAbout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAbout.setBounds(383, 401, 51, 32);
		contentPane.add(btnAbout);
		
		JLabel lblBack = new JLabel("back");
		lblBack.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/backf.jpg")));
		lblBack.setBounds(0, 0, 457, 462);
		contentPane.add(lblBack);
	}
}
