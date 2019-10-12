import java.awt.Graphics;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Random;

import javax.security.auth.login.FailedLoginException;

public class gameManager {

	private world world;
	private motor m;
	
	private long time = System.nanoTime();
	private long delay, delay2, delay3;
	private int health, score, prev, coinsEaten;
	public static int fire;
	private ArrayList<EnemyMotor> enemyMotors;
	private ArrayList<GoldCoin> goldCoins;
	private ArrayList<SilverCoin> silverCoins;
	private ArrayList<health> healths;
	private ArrayList<death> deaths;
	private ArrayList<gun> guns;
	
	private speedMeter speedMeter;
	private int flag1, flag2, flag3;
	private Bullet bullet;
	private motor motor;
	
	//private int y;
	public gameManager()
	{
		prev = -10;
		score = 0;
		health = 3;
		delay = 2000;//2000
		delay2 = 3800; 
		delay3 = 4500;
		coinsEaten = 0;
		m = new motor();
		world = new world(m);
		speedMeter = new speedMeter(m);
		enemyMotors = new ArrayList<EnemyMotor>();
		goldCoins = new ArrayList<GoldCoin>();
		silverCoins = new ArrayList<SilverCoin>();
		healths = new ArrayList<health>();
		deaths = new ArrayList<death>();
		guns = new ArrayList<gun>();
	
		flag1=0;
		flag2=0;
		flag3 = 0;
		motor = new motor();
	}
	
	public void init()
	{
		//world = new world();
		//m = new motor();
		
		
		m.init();
		loadImage.init();
		//y = 0;
	}
	
	public void tick()//update kre
	{
		
		Random random = new Random();
		int randX = random.nextInt(520 - 140 ) + 140;
		int randX2 = random.nextInt(520 - 140 ) + 140;
		int randY2 = random.nextInt(Display.height);
		
		int randX3 = random.nextInt(520 - 140 ) + 140;
		int randY3 = random.nextInt(Display.height);
		
		int randY = random.nextInt(Display.height);
		
		int randX4 = random.nextInt(520 - 140 ) + 140;
		int randY4 = random.nextInt(Display.height);
		
//		while(randX<140)
//		{
//			randX = random.nextInt(520);
//		}
//		while(randX2 < 140)
//		{
//			randX2 = random.nextInt(520);
//		}
//		while(randX3 < 140)
//		{
//			randX3 = random.nextInt(520);
//		}
//		
//		while(randX4 < 140)
//		{
//			randX4 = random.nextInt(520);
//		}
		
		for(int i=0;i<enemyMotors.size();i++)
		{
			//player
			int px = m.getX();
			int py = m.getY();
			
			//enemies
			int ex = enemyMotors.get(i).getX();
			int ey = enemyMotors.get(i).getY();
			
			//bullet
//			int bx = px;
//			int by = motor.bulletY+m.getY();
//			//System.out.println(bx + " " + ex + " " + by + " " + " " + ey);
//			if((bx < (ex + 40) && bx + 10 > ex ) && by < (ey + 70))
//			{
//				enemyMotors.remove(i);
//				i--;
//				motor.bulletY = 0;
//			}
//			
			if(px < ex + 40 && px + 40 > ex && py < ey + 70 && py + 70 > ey)
			{//collission hoise, 40 is the width ofthe cars
				
				enemyMotors.remove(i);
				i--;
				health--;
				//System.out.println(health);
				if(SecondMenu.select == 2) m.setSpeed(10);
				else if(SecondMenu.select == 3) m.setSpeed(16);
				else m.setSpeed(0.3);
				m.setHealth(health);
			}

		}
		
		
		for(int i=0;i<enemyMotors.size();i++)
		{
			//player
			int px = m.getX();
			int py = m.getY();
			
			//enemies
			int ex = enemyMotors.get(i).getX();
			int ey = enemyMotors.get(i).getY();
			
			//bullet
			int bx = px;
			int by = motor.bulletY+m.getY();
			//System.out.println(bx + " " + ex + " " + by + " " + " " + ey);
			if((bx < (ex + 40) && bx + 10 > ex ) && by < (ey + 70))
			{
				enemyMotors.remove(i);
				i--;
				motor.bulletY = 0;
			}
			
		}
		

		for(int i=0;i<silverCoins.size();i++)
		{
			//player
			int px = m.getX();
			int py = m.getY();
			
			//coins
			int ex = silverCoins.get(i).getX();
			int ey = silverCoins.get(i).getY();
			
			
			if(px < ex + 20 && px + 40 > ex && py < ey + 30 && py + 70 > ey)
			{//collission hoise, 40 is the width ofthe cars
				
				silverCoins.remove(i);
				i--;
				coinsEaten++;
				m.setHealth(health);
			}

		}
		
		for(int i=0;i<deaths.size();i++)
		{
			//player
			int px = m.getX();
			int py = m.getY();
			
			//coins
			int ex = deaths.get(i).getX();
			int ey = deaths.get(i).getY();
			
			
			if(px < ex + 20 && px + 40 > ex && py < ey + 25 && py + 70 > ey)
			{//collission hoise, 40 is the width ofthe cars
				
				deaths.remove(i);
				i--;
				health = 0;
				m.setHealth(health);
				
			}

			
		}

		for(int i=0;i<healths.size();i++)
		{
			//player
			int px = m.getX();
			int py = m.getY();
			
			//coins
			int ex = healths.get(i).getX();
			int ey = healths.get(i).getY();
			
			
			if(px < ex + 20 && px + 40 > ex && py < ey + 25 && py + 70 > ey)
			{//collission hoise, 40 is the width ofthe cars
				
				healths.remove(i);
				i--;
				if(health <= 4)
					health++;
				//health--;
				//System.out.println(health);
				//m.setSpeed(0);
				m.setHealth(health);
				
			}

			
		}

		for(int i=0;i<guns.size();i++)
		{
			//player
			int px = m.getX();
			int py = m.getY();
			
			//coins
			int ex = guns.get(i).getX();
			int ey = guns.get(i).getY();
			
			
			if(px < ex + 30 && px + 40 > ex && py < ey + 20 && py + 70 > ey)
			{//collission hoise, 40 is the width ofthe cars
				
				guns.remove(i);
				i--;
				fire = 3;
				//health--;
				//System.out.println(health);
				//m.setSpeed(0);
				m.setFire(fire);
				m.setHealth(health);
				
			}

			
		}

		
		long elapsed = (System.nanoTime() - time)/900000;
		long elapsed2 = (System.nanoTime() - time)/1000000;
		
		//long elapsed3 = (System.nanoTime() - time)/1200000;
//		if(elapsed2 > delay2)
//		{
//			if(m.getSpeed() >= 3) silverCoins.add(new SilverCoin(m, randX2, (-randY2+m.getOffset())));
//			time = System. nanoTime();
//			
//		}
//		
		//int flag = 0;
		if(gameSetup.score%20 == 0 && gameSetup.score != 0 && flag1 == 0)
		{
			deaths.add(new death(m, randX2, (-randY2+m.getOffset())));
			flag1 = 1;
		}
		if(gameSetup.score%20 == 1 && gameSetup.score != 1)
		{
			//deaths.add(new death(m, randX2, (-randY2+m.getOffset())));
			flag1 = 0;
		}
		
		if(gameSetup.score%15 == 0 && gameSetup.score != 0 && flag2 == 0)
		{
			healths.add(new health(m, randX3, (-randY3+m.getOffset())));
			flag2 = 1;
		}
		if(gameSetup.score%15 == 1 && gameSetup.score != 1)
		{
			//deaths.add(new death(m, randX2, (-randY2+m.getOffset())));
			flag2 = 0;
		}
		
		if(gameSetup.score%25 == 0 && gameSetup.score != 0 && flag3 == 0)
		{
			guns.add(new gun(m, randX4, (-randY4+m.getOffset())));
			flag3 = 1;
		}
		if(gameSetup.score%25 == 1 && gameSetup.score != 1)
		{
			//deaths.add(new death(m, randX2, (-randY2+m.getOffset())));
			flag3 = 0;
		}
		
//		if(elapsed2 > delay2) 
//		{
//			if(m.getSpeed() >=3) deaths.add(new death(m, randX2, (-randY2+m.getOffset())));
//			time = System.nanoTime();
//		}
//		if(elapsed3 > delay3)
//		{
//			if(m.getSpeed() >= 3) goldCoins.add(new GoldCoin(m, randX3, (-randY3+m.getOffset())));
//			time = System. nanoTime();
//			
//		}
		
		if(elapsed > delay)
		{
			if(m.getSpeed()>=3) enemyMotors.add(new EnemyMotor(m,randX, (-randY+m.getOffset())));
			time = System.nanoTime();
		}
		
		
		
		//motor
		m.tick();
		//y += 1;
		
		//enemyMotor
		
		for(int i = 0; i < enemyMotors.size(); i++)
		{
			
			m.setScore(gameSetup.score);
			if(gameSetup.score > 350)
			{
				delay = 150;
				//delay2 = 125;
			}
			else if(gameSetup.score > 300)
			{
				delay = 200;
				//delay2 = 175;
			}
			else if(gameSetup.score > 250)
			{
				delay = 300;
				//delay2 = 250;
			}
			else if(gameSetup.score > 200)
			{
				delay = 400;
				//delay2 = 350;
			}
			else if(gameSetup.score > 150) 
			{
				delay = 500;
				//delay2 = 450;
			}
			else if(gameSetup.score > 100)
			{
				delay = 600;
				//delay2 = 550;
			}
			else if(gameSetup.score > 50)
			{
				delay = 800;
				//delay2 = 700;
			}
			else if(gameSetup.score > 30) 
			{
				delay = 1000; 
				//delay2=900;
				//delay3=700;
			}
			else if(gameSetup.score > 15)
			{
				delay = 1400;
				//delay2=1300;
				//delay3=1000;
			}
			
			//System.out.println(enemyMotors.size());
			enemyMotors.get(i).tick();
			
		}
		
		
		
	}
	
	public void removeEnemies()
	{
		goldCoins.clear();
		silverCoins.clear();
		enemyMotors.clear();
		healths.clear();
		deaths.clear();
		guns.clear();
	}
	
	public void render(Graphics g)//draw kre
	{
		world.render(g);
		m.render(g);
		//m.drawBoard(g);
		speedMeter.render(g);
		//g.fillRect(40, y, 60, 60);
		for(int i = 0; i < enemyMotors.size(); i++)
		{
			enemyMotors.get(i).render(g);
			
		}
//		for(int i = 0; i < goldCoins.size(); i++)
//		{
//			goldCoins.get(i).render(g);
//		}
		
		for(int i=0;i<deaths.size();i++)
		{
			deaths.get(i).render(g);
		}
		
		for(int i=0;i<healths.size();i++)
		{
			healths.get(i).render(g);
		}
		
		for(int i=0;i<guns.size();i++)
		{
			guns.get(i).render(g);
		}
		
		for(int i = 0; i < silverCoins.size(); i++)
		{
			silverCoins.get(i).render(g);
		}
		if(health <= 0) removeEnemies();
		
		m.drawBoard(g);
	}
	
}
