import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class speedMeter {

	private motor motor;
	public speedMeter(motor motor)
	{
		this.motor = motor;
	}
	
	public void render(Graphics graphics)
	{
//		graphics.setColor(Color.RED);
//		graphics.fillOval(8, 98, 100+2*2, 100 + 4);
//		
//		graphics.setColor(Color.white);
//		graphics.fillOval(10, 100, 100, 100);
//		
//		
//		int centerX = 10 + 50;
//		int centerY = 100 + 50;
//		double speed = motor.getSpeed()% 60.0/24 * Math.PI*2;
//		int animX = (int)(centerX + Math.sin(speed) * 40);
//		int animY = (int)(centerY - Math.cos(speed) * 40);
//		
//		graphics.setColor(Color.black);
//		graphics.drawLine(centerX, centerY, animX, animY);
//		
//		for(int i = 1; i<=6; i++)
//		{
//			int radian =(int)( i % 7.0/7*Math.PI*2);
//			int anim3 = (int)((centerX - 4) + Math.sin(radian) * 40);
//			int anim4 = (int)((centerY + 4) - Math.cos(radian) * 40);
//			
//			String dString = Integer.toString(i);
//			graphics.setFont(new Font("Times New Roman", Font.BOLD, 12));
//			graphics.drawString(dString, anim3, anim4);
//		}
	}
	
}
