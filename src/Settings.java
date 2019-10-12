import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Settings extends JFrame {

	private JPanel contentPane;
	private JLabel lblGameSettings;
	private JLabel lblSoundEffects;
	private JLabel lblMusic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
					frame.setResizable(false);
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
	public Settings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 501);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblGameSettings = new JLabel("Game Settings:");
		lblGameSettings.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGameSettings.setBounds(10, 41, 126, 23);
		contentPane.add(lblGameSettings);
		
		lblSoundEffects = new JLabel("Sound Effects:");
		lblSoundEffects.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoundEffects.setBounds(10, 157, 126, 23);
		contentPane.add(lblSoundEffects);
		
		lblMusic = new JLabel("Music:");
		lblMusic.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMusic.setBounds(10, 264, 126, 23);
		contentPane.add(lblMusic);
		
		JButton btnBackl = new JButton("BACK");
		//btnBackl.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\Racing_Game_(lab)\\resources\\Button-Back-1-512.png"));
		//JButton btnBackl = new JButton(loadImage.backIcon);
		btnBackl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainMenu().setVisible(true);
			
			}
		});
		btnBackl.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBackl.setBounds(360, 11, 87, 23);
		contentPane.add(btnBackl);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Sound.sOff==0){
					Sound.backGroundPlay();
				}
				else if(Sound.sOff==1){
					Sound.backGroundStop();
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Settings.class.getResource("/icons/Music-Library-icon.png")));
		btnNewButton.setBounds(282, 252, 59, 50);
		contentPane.add(btnNewButton);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(Sound.sOther==0){
					Sound.sOther = 1;
				}
				else if(Sound.sOff==1){
					Sound.sOther = 0;
				}
			}
		});
		tglbtnNewToggleButton.setIcon(new ImageIcon(Settings.class.getResource("/icons/Music-Library-icon.png")));
		tglbtnNewToggleButton.setBounds(282, 145, 64, 50);
		contentPane.add(tglbtnNewToggleButton);
	}
}
