import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Sound {
	
	static URL url1 = null;
	static URL url2 = null;
	static URL urlHigh = null;
	static URL urlLow = null;
	static URL urlMedium = null;
	
	static AudioClip clip;
	static AudioClip clip2;
	static AudioClip high,low,medium;
	
	static int sOff;
	static int sOther;
	
	public Sound() {}
	
	public static void init(){
		sOff = 0;
		sOther = 1;
		
		try {
			//C:/Users/MobiN/Desktop/Project/Racing_Game (lab)
			//System.out.println(System.getProperty("user.dir"));
			
			String string = System.getProperty("user.dir");
			String fileURL = convertToFileURL(string);
			//System.out.println(fileUrl);
			
			//url1 = new URL("file:C:/Users/MobiN/Desktop/Project/Racing_Game_(lab)/Yaver_Clap_Momentum.wav");
			//url2 = new URL("file:C:/Users/MobiN/Desktop/Project/Racing_Game_(lab)/snd_gearnormal_short.wav");
			
			
			url1 = new URL(fileURL+"/Yaver_Clap_Momentum.wav");
			url2 = new URL(fileURL+"/snd_gearnormal_short.wav");
			urlHigh = new URL(fileURL+"/High.wav");
			urlLow = new URL(fileURL+"/Low.wav");
			urlMedium = new URL(fileURL+"/Medium.wav");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		clip = Applet.newAudioClip(url1);
		clip2 = Applet.newAudioClip(url2);
		
		high = Applet.newAudioClip(urlHigh);
		low = Applet.newAudioClip(urlLow);
		medium = Applet.newAudioClip(urlMedium);
		
	}
	
	
	public static String convertToFileURL ( String filename )
	{
	    String path = new File ( filename ).getAbsolutePath ();
	    if ( File.separatorChar != '/' )
	    {
	        path = path.replace ( File.separatorChar, '/' );
	    }
	    if ( !path.startsWith ( "/" ) )
	    {
	        path = "/" + path;
	    }
	    String retVal =  "file:" + path;

	    return retVal;
	}
	
	public static void addUrl()
	{
		com.sun.security.auth.module.NTSystem NTSystem = new com.sun.security.auth.module.NTSystem();
		System.out.println(NTSystem.getName());
	}
	
	///////////////////background
	public static void backGroundPlay()
	{
		sOff = 1;
		clip.loop();
	}
	public static void backGroundStop()
	{
		sOff = 0;
		clip.stop();
	}
	
	
	///////////////////gameplay
	public static void lowPlay() {
		if(sOther==1)
			low.loop();
	}
	public static void lowPlayStop()
	{
		low.stop();
	}
	
	
	public static void highPlay() {
		if(sOther==1)
			high.loop();
	}
	public static void highPlayStop()
	{
		high.stop();
	}
	
	
	public static void medPlay() {
		if(sOther==1)
			medium.loop();
	}
	public static void medPlayStop()
	{
		medium.stop();
	}
	
	
	
	public static void main(String[] args) throws Exception {

//		System.out.println("1");
//		URL url = new URL("http://www.edu4java.com/sound/back.wav");
//		System.out.println("2");
//		AudioClip clip = Applet.newAudioClip(url);
//		System.out.println("3");
//		clip.play();
//		System.out.println("4");
//		Thread.sleep(1000);

//		URL url = new URL(
//			"file:/C:/Users/Eli/workspace/minitennis/src/com/edu4java/minitennis7/back.wav");

//		URL url = new URL("file:/C:/Users/MobiN/eclipse-workspace/ProjToday/back.wav");
//		//URL url = SoundTest.class.getResource("back.wav");
//		AudioClip clip = Applet.newAudioClip(url);
//		AudioClip clip2 = Applet.newAudioClip(url);
		
		
		//////////////////////////////////////////
//		clip.play();
//		Thread.sleep(1000);
		
//		clip2.loop();
		
//		Thread.sleep(2000);
//		clip2.stop();
		
//		System.out.println("end");
		
		
		
		Sound s = new Sound();
		s.init();
		
		//s.addUrl();
		//clipPlay();
//		int check;
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			check = sc.nextInt();
//			if(check==1) s.backGroundPlay();
//			else s.backGroundStop();
//		}
		
		backGroundPlay();
		Thread.sleep(1000);
		backGroundStop();
		//addUrl();
		
	}
}
