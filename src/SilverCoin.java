import java.awt.Graphics;

public class SilverCoin {
	private int x,y;
	private motor motor;
	
	public SilverCoin(motor m, int x, int y)
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
		graphics.drawImage(loadImage.silverCoin, x, y-motor.getOffset(), 20,25,null);
		
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
