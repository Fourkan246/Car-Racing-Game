import java.awt.Graphics;

public class Bullet {

	public static int x,y;
	private motor motor;
	
	public Bullet(motor m, int x, int y)
	{
		motor = m;
		this.x = motor.bulletX;
		this.y = motor.bulletY;
		
	}
	public void tick()
	{
		y += 1;
	}
	public void render(Graphics graphics)
	{
		graphics.drawImage(loadImage.bullet, x, y-motor.getOffset(), 7, 10,null);
		
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}

	
}
