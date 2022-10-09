package general.sound;

public class Sound {
	private SoundClip move;
	private SoundClip point;
	private SoundClip shot;
	private SoundClip finish;
	private static Sound instance;
	
	private Sound() {
		move = new SoundClip("/assets/sound/move.wav");
		point = new SoundClip("/assets/sound/point.wav");
		shot = new SoundClip("/assets/sound/shot.wav");
		finish = new SoundClip("/assets/sound/finish.wav");
	}
	
	public static Sound getInstance() {
		if(instance == null)
			instance = new Sound();
		return instance;
	}
	
	public void moveSound() {
		move.play();
	}
	
	public void pointSound() {
		point.play();
	}
	
	public void shotSound() {
		shot.play();
	}
	
	public void finishSound() {
		finish.play();
	}
}
