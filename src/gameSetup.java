import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.lang.management.ManagementFactory;

public class gameSetup implements Runnable {

	private Thread thread;
	private Display display;
	private String title;
	private int height, width;
	private BufferStrategy bufferStrategy;
	private Graphics graphics;
	// private int y;
	private gameManager manager;

	public static boolean whileCheck = true;
	public static int score;

	public gameSetup(String title, int height, int width) {
		this.title = title;
		this.height = height;
		this.width = width;

		whileCheck = true;
		score = 0;
	}

	public void init() {
		// y=0;
		display = new Display(title, height, width);
		manager = new gameManager();
		manager.init();

	}

	public synchronized void start() {

		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tick() {
		// y += 1;
		manager.tick();
	}

	public void render() {
		bufferStrategy = display.canvas.getBufferStrategy();
		if (bufferStrategy == null) {
			display.canvas.createBufferStrategy(3);// create three screens
			return;
		}
		graphics = bufferStrategy.getDrawGraphics();
		// graphics.clearRect(0, 0, width, height);

		// draw
		// graphics.setColor(Color.RED);
		// //graphics.drawRect(12, 12, 40, 50);
		// graphics.fillRect(12, y, 40, 50);//makes the rectangle black
		manager.render(graphics);

		// draw end

		bufferStrategy.show();
		graphics.dispose();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		init();

		int fps = 50;// joto kom toto slow
		double timePerTick = 1000000000 / fps;// 1 billion nanosec/fps mane 1sec
												// e fps times frame ashbe
		double delta = 0;
		long current = System.nanoTime();
		double scDouble = 0;
		while (true) {

			delta += (System.nanoTime() - current) / timePerTick;
			current = System.nanoTime();
			delta = 0.7;
			while (whileCheck) {
				if(!motor.over && motor.speed >= 3)
				{
					scDouble += (System.nanoTime() - current) / (timePerTick * 55);
					score = (int) scDouble;
				}
				score = (int) scDouble;
				delta += (System.nanoTime() - current) / timePerTick;
				current = System.nanoTime();
				if (delta >= 1) {
					tick();
					render();
					delta--;
				}

			}

		}

	}

}
