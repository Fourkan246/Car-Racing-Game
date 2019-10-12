import java.awt.Graphics;

public class EnemyMotor {

	
	private int x,y;
	private motor motor;
	public EnemyMotor(motor m,int x, int y)
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
		graphics.drawImage(loadImage.enemyCar, x, y-motor.getOffset(), 40,70,null);
		
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
