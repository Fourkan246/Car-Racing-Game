import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.util.IllegalFormatCodePointException;

import javax.xml.soap.DetailEntry;

public class motor implements KeyListener {

	private int x, y, offset;
	public static boolean left, right, up, down, space, flagLow, flagMed, flagHigh;
	public static double speed;
	private int health, score, maxScore, fire;
	public static int gear;
	public static int highScore1, highScore2, highScore3;
	public static boolean over = false, flag;
	public static int bulletY, bulletX;

	public int soundFlag = 1;
	
	public motor() {
		x = Display.width / 2;
		// y = Display.height;
		// x = 0;
		y = Tile.tileHeight * 5760;
		offset = 0;
		speed = 0.3f;
		if (SecondMenu.select == 2)
			speed = 10;
		else if (SecondMenu.select == 3)
			speed = 16;
		health = 3;
		gear = 0;
		score = 0;
		maxScore = 0;
		fire = 0;
		highScore1 = 30;
		highScore2 = 20;
		highScore3 = 10;
		over = false;
		flag = true;
		bulletY = 0;
		flagHigh = flagLow = flagMed = false;
	}

	public void init() {
		Display.frame.addKeyListener(this);// since we implemented this class by
											// keyListener
		//playSound();
	}
	
	public void playSound()
	{
		if (speed >= 16)
		{
			gear = 5;
			if(!flagHigh)
			{
				Sound.medPlayStop();
				Sound.lowPlayStop();
				flagMed = false;
				flagLow = false;
				Sound.highPlay();
				flagHigh = true;
			}
		}
			
		else if (speed >= 13)
		{
			gear = 4;
			if(!flagMed)
			{
				Sound.lowPlayStop();
				Sound.highPlayStop();
				flagHigh = false;
				flagLow = false;
				Sound.medPlay();;
				flagMed = true;
			}
		}
			
		else if (speed >= 7)
		{
			gear = 3;
			if(!flagMed)
			{
				Sound.lowPlayStop();
				Sound.highPlayStop();
				flagHigh = false;
				flagLow = false;
				Sound.medPlay();
				flagMed = true;
			}
		}
		else if (speed >= 5)
		{
			if(!flagLow)
			{
				Sound.medPlayStop();
				Sound.highPlayStop();
				flagHigh = false;
				flagMed = false;
				Sound.lowPlay();
				flagLow = true;
			}
			gear = 2;
		}
		else if (speed >= 2)
		{
			if(!flagLow)
			{
				Sound.medPlayStop();
				Sound.highPlayStop();
				flagHigh = false;
				flagMed = false;
				
				Sound.lowPlay();
				flagLow = true;
			}
			gear = 1;
		}
		else if (speed < 2)
		{
			
			if(!flagLow)
			{
				Sound.medPlayStop();
				Sound.highPlayStop();
				flagHigh = false;
				flagMed = false;
				Sound.lowPlay();
				flagLow = true;
			}
			
			gear = 0;
		}
	}

	public void tick() {
		// System.out.println(x);
		if (health > 0) {
			offset = y - (Display.height) / 2 - 185;
			// offset += 2;
			if (right) {
				if (x <= 515)
					x += 5;
			}
			if (left) {
				if (x >= 145)
					x -= 5;
			}
			if (up) {
				// if(y>700)
				// {
				speed += 0.04f;
				if (speed >= 22)
					speed = 22;
				// }

				// y -= 3;
			}

			if (down) {
				speed -= 0.04f;
				if (SecondMenu.select == 2) {
					if (speed <= 9)
						speed = 10;

				} else if (SecondMenu.select == 3) {
					if (speed <= 15)
						speed = 16;

				} else if (SecondMenu.select == 1) {
					if (speed <= 2)
						speed = 2;
				}

				// y += 3;
			}
			// if(y>700)
			y -= speed;
			

		}
		

	}

	public double getSpeed() {
		return speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getOffset() {
		return offset;
	}

	public void setSpeed(double x) {
		speed = x;
	}

	public void setScore(int x) {
		score = x;
		maxScore = Math.max(maxScore, score);
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setFire(int fire) {
		this.fire = fire;
	}

	public void drawBoard(Graphics graphics) {
		if (speed >= 16)
		{
			//Sound.medPlayStop();
			//Sound.highPlay();
			gear = 5;
		}
		else if (speed >= 13)
			gear = 4;
		else if (speed >= 9)
		{
			//Sound.lowPlayStop();
			//Sound.medPlay();
			gear = 3;
		}
		else if (speed >= 5)
			gear = 2;
		else if (speed >= 2)
			gear = 1;
		else if (speed < 2)
		{
			gear = 0;
			//Sound.lowPlay();
		}

		playSound();
		graphics.setColor(Color.CYAN);
		graphics.fillRect(0, 0, 700, 50);

		graphics.setColor(Color.BLACK);
		// String Sgear = "Gear: "+Integer.toString(gear);
		graphics.setFont(new Font("Times New Roman", Font.BOLD, 20));
		// graphics.drawString(Sgear, 20, 30);
		String Shealth = "Health: " + Integer.toString(health);

		graphics.drawString(Shealth, 20, 30);
		//String Sscore = "Score: " + Integer.toString(maxScore);
		String Sscore = "Score: " + Integer.toString(gameSetup.score);
		graphics.drawString(Sscore, 320, 30);

		String Sfire = "Fire: " + Integer.toString(gameManager.fire);
		graphics.drawString(Sfire, 620, 30);
		
	}

	public void GameOver(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("Times New Roman", Font.BOLD, 50));
		graphics.drawString("Game Over", Display.width / 3 + 30, Display.height / 2 - 10);
		over = true;
		
		//sound stop
		Sound.lowPlayStop();
		Sound.medPlayStop();
		Sound.highPlayStop();
		
		
		File f = new File("HighScore.txt");
		try {
			FileWriter fileWriter = new FileWriter(f);
			//
			// fileWriter.append("CHoda kha\n");
			// fileWriter.flush();
			// fileWriter.close();

			// fileWriter.flush();
			// fileWriter.close();
			// if(flag)
			// {
			// fileWriter.append("CHoda kha\n");
			// fileWriter.flush();
			// fileWriter.close();
			//
			//System.out.println(highScore1);
			if (score > 1) {
				//System.out.println(SecondMenu.playerName + " " + score);
				// fileWriter.write("\n");
				fileWriter.append("1. " + SecondMenu.playerName + " " + Integer.toString(score) + "\n");
				//highScore1 = score;
				// fileWriter.flush();
				// fileWriter.close();

			}
			else if(score > highScore2)
			{
				
			}
			// flag = false;
			// }

			fileWriter.flush();
			fileWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void render(Graphics graphics) {
		if (health > 0) {
			// graphics.setColor(Color.RED);
			// graphics.fillRect(x, y-offset, 40, 60);
			graphics.drawImage(loadImage.bullet, x + 10, y + bulletY - offset + 10, 15, 20, null);
			graphics.drawImage(loadImage.playerCar, x, y - offset, 40, 70, null);
			// graphics.drawImage(loadImage.coin2, x, y - offset,20,30, null);
		} else {
			GameOver(graphics);
		}

		// drawBoard(graphics);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int source = arg0.getKeyCode();
		if (source == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if (source == KeyEvent.VK_LEFT) {
			left = true;
		}
		if (source == KeyEvent.VK_UP) {
			up = true;
		}
		if (source == KeyEvent.VK_DOWN) {
			down = true;
		}
		if (source == KeyEvent.VK_SPACE) {
			// if(gameManager.fire > 0)
			// {
			if (gameManager.fire > 0) {

			space = true;
			if(space)
			{
				int fps = 50;// joto kom toto slow
				double timePerTick = 1000000000 / fps;// 1 billion nanosec/fps
														// mane 1sec e fps times
														// frame ashbe
				double delta = 0;

				double timeC = 0;
				double timeB = System.nanoTime();
				double currentB = .5;
				double whileBreak = 0;
				while (true) {
					timeC = System.nanoTime();
					currentB += (timeC - timeB) / timePerTick;
					whileBreak += (timeC - timeB) / timePerTick;
					timeB = System.nanoTime();
					if (currentB >= 1) {
						bulletY -= 15;
					}
					if (currentB >= 1)
						currentB = .5;

					if (whileBreak > 30) {
						bulletY = 0;
						break;

					}

				}
				gameManager.fire-- ;
			}

			}

			// for(int i=0;i<50;i++)
			// {
			// bulletY -= 2;
			// System.out.println(bulletY);
			// }
			// }
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		int source = arg0.getKeyCode();
		if (source == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if (source == KeyEvent.VK_LEFT) {
			left = false;
		}
		if (source == KeyEvent.VK_UP) {
			up = false;
		}
		if (source == KeyEvent.VK_DOWN) {
			down = false;
		}
		if(source == KeyEvent.VK_SPACE)
		{
			space = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}
