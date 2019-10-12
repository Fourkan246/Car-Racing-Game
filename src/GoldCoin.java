import java.awt.Graphics;

public class GoldCoin {
	private int x,y;
	private motor motor;
	
	public GoldCoin(motor m, int x, int y)
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
		graphics.drawImage(loadImage.coin, x, y-motor.getOffset(), 20,25,null);
		
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
