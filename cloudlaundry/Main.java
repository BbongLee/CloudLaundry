package cloudlaundry;

public class Main {
	public static final int SCREEN_WIDTH = 1000;
	public static final int SCREEN_HEIGHT = 700;

	public static void main(String[] args) {
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		new Laundry();

	}
}
