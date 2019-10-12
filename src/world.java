import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;

import javax.xml.stream.events.EndDocument;


public class world {

	private int[][] tile;
	private int width, height;
	private motor m;
	
	public world(motor m)
	{
		this.m=m;
		loadWorld("resources/world.txt");
	}
	
	private int parseInt(String number)
	{
		return Integer.parseInt(number);
	}
	
	private void loadWorld(String path)
	{
		String file = loadFile(path);
		String[] space = file.split("\\s+");//this is symbol for space
		width = parseInt(space[0]);
		height = parseInt(space[1]);
		tile = new int[width][height];
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<height;j++)
			{
				tile[i][j] = parseInt(space[2+(i+j * width)]);
			}
		}
		
	}
	
	public String loadFile(String path)
	{
		StringBuilder stringBuilder = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line = reader.readLine()) != null)
			{
				stringBuilder.append(line+"\n");
			}
			reader.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stringBuilder.toString();
		
		
	}
	
	public void render(Graphics graphics)
	{
		int start = Math.max(0, m.getOffset()/Tile.tileHeight);
		int end = Math.min(height, (m.getOffset() + Display.height + 20)/Tile.tileHeight);
		for(int i=0;i<width;i++)
		{
			for(int j=start;j<end;j++)
			{
				Tile t = Tile.tiles[tile[i][j]];
				t.render(graphics, i*Tile.tileWidth, (j*Tile.tileHeight - m.getOffset()));
			}
		}
	}
}
