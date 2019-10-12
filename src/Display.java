import java.awt.Canvas;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Display {

	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";

	private String title;
	public static int height;
	public static int width;
	public static JFrame frame;
	public static Canvas canvas;
	private motor motor;

	public Display(String title, int height, int width) {
		this.title = title;
		this.height = height;
		this.width = width;
		createDisplay();
	}

	public void close() {

	}

	public void createDisplay() {
		//// sound
		// Sound.gamePlayStop();
		// Sound.backGroundPlay();

		frame = new JFrame(title);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				gameSetup.whileCheck = false;
				Sound.lowPlayStop();
				Sound.medPlayStop();
				Sound.highPlayStop();
				motor.flagHigh = false;
				motor.flagLow = false;
				motor.flagMed = false;
				if (motor.over) {
					gameSetup.whileCheck = false;
					frame.dispose();
					Sound.lowPlayStop();
					Sound.medPlayStop();
					Sound.highPlayStop();
					motor.flagHigh = true;
					motor.flagLow = true;
					motor.flagMed = true;
					try {
						Runtime.getRuntime().exec(KILL + "javaw.exe");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


				} else {
					int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?");
					if (option == JOptionPane.YES_OPTION) {
						gameSetup.whileCheck = false;
						frame.dispose();
						System.out.println("gfdh");
						Sound.lowPlayStop();
						Sound.medPlayStop();
						Sound.highPlayStop();
						// Sound.backGroundStop();

						try {
							Runtime.getRuntime().exec(KILL + "javaw.exe");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					if (option == JOptionPane.NO_OPTION) {
						System.out.println("fasdf");
						gameSetup.whileCheck = true;
						Sound.backGroundStop();
						motor.playSound();
						
					}
					if (option == JOptionPane.CANCEL_OPTION) {
						gameSetup.whileCheck = true;
						Sound.backGroundStop();
						motor.playSound();
					}
				}

			}
		});
		frame.setSize(height, width);
		frame.setVisible(true);
		if (!motor.over)
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		else {
			
			try {
				Runtime.getRuntime().exec(KILL + "javaw.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		frame.setLocationRelativeTo(null);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(height, width));
		canvas.setFocusable(false);
		frame.getContentPane().add(canvas);
		frame.pack();

	}
}
