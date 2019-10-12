import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	public static Tile[] tiles = new Tile[30];
	
	public static Tile roadTile = new roadTile(0);
	//public static Tile grassTile = new grassTile(1);
	//public static Tile pathTile = new pathTile(2);
	public static Tile sandTile = new sandTile(2);
	public static Tile waterTile = new waterTile(1);

	
	public static final int tileWidth = 70, tileHeight = 70;
	
	public BufferedImage texture;
	
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		tiles[id] = this;
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, null);
	}
	
}
