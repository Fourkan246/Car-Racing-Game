import java.awt.Graphics;

public class gun {

	private int x,y;
	private motor motor;
	
	public gun(motor m, int x, int y)
	{
		motor = m;
		this.x = x;
		this.y = y;
		
	}
	public void tick()
	{
		y += 1;
	}
	public void render(Graphics graphics)
	{
		graphics.drawImage(loadImage.gun, x, y-motor.getOffset(), 30,20,null);
		
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
