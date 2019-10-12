import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class loadImage {

	public static BufferedImage car, car2, playerCar, enemyCar, fullImage, fullImage2, fullImage3, subImage1, subImage2, road, grass, path;
	public static BufferedImage coin, coin2, goldCoin, silverCoin;
	public static BufferedImage fullImage4, sand;
	public static BufferedImage fullImage5, water;
	public static BufferedImage fullImage6, health;
	public static BufferedImage fullImage7, death;
	public static BufferedImage fullImage8, gun;
	public static BufferedImage fullImage9, bullet;
	public static Icon backIcon;

	
	public static void init()
	{
		fullImage = imageLoader("/roadTexture2.jpg");
		fullImage2 = imageLoader("/grassTexture.jpg");
		fullImage3 = imageLoader("/pathTexture.jpg");
		fullImage4 = imageLoader("/sandTexture.jpg");
		fullImage5 = imageLoader("/waterTexture.jpg");
		fullImage6 = imageLoader("/health.jpg");
		fullImage7 = imageLoader("/death.jpg");
		fullImage8 = imageLoader("/gun.jpg");
		fullImage9 = imageLoader("/bullet.png");
		backIcon = new ImageIcon("/Button-Back-1-512.png");
		
		car = imageLoader("/Car3.png");
		car2 = imageLoader("/Car2.png");
		//car2 = imageLoader("/blueCar.jpg");
		//car2 =imageLoader("/greenTruck.jpg");
		coin = imageLoader("/Coin.jpg");
		coin2 = imageLoader("/Coin2.png");
		crop();
	}
	
	public static BufferedImage imageLoader(String path)
	{
		try {
			return ImageIO.read(loadImage.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public static void crop()
	{
		//subImage1 = fullImage.getSubimage(100, 200, 200, 300);
		//subImage2 = fullImage.getSubimage(400, 400, 100, 100);
		road = fullImage.getSubimage(0, 0, 160, 160);
		grass = fullImage2.getSubimage(0, 0, 199, 132);
		path = fullImage3.getSubimage(0, 0, 170, 138);
		sand = fullImage4.getSubimage(0, 0, 180, 180);
		water = fullImage5.getSubimage(0, 0, 250, 250);
		playerCar = car.getSubimage(31, 31, 105, 225);
		enemyCar = car2.getSubimage(30, 30, 110, 230);
		//enemyCar = car2.getSubimage(10, 0, 140, 318);
		//enemyCar = car2.getSubimage(0, 0, 292, 688);
		goldCoin = coin.getSubimage(20, 20, 190, 230);
		silverCoin = coin2.getSubimage(20, 20, 358, 457);
		//silverCoin = fullImage6.getSubimage(0, 0, 250, 248);
		health = fullImage6.getSubimage(0, 0, 250, 248);
		gun = fullImage8.getSubimage(0, 5, 540, 369);
		death = fullImage7.getSubimage(2, 2, 225, 275);
		bullet = fullImage9.getSubimage(0, 0, 48, 55);
		
	}
	
	
	
}
