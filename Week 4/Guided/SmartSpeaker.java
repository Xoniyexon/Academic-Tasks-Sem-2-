package tugas;

public class SmartSpeaker implements SmartDevice {
	private boolean isPlaying;
	
	@Override
	public void turnOn() {
		isPlaying = true;
		System.out.println("Smart Speaker is now PLAYING music.");
	}
	
	@Override
	public void turnOff() {
		isPlaying = false;
		System.out.println("Smart Speaker is now OFF.");
	}
	
	@Override
	public void getStatus() {
		System.out.println("Smart Speaker status : " + (isPlaying ? "PLAYING" : "OFF"));
	}

}
