package tugas;

public class SmartHome {
	public static void main(String[] args) {
		SmartDevice light = new SmartLight();
		SmartDevice speaker = new SmartSpeaker();
		
		light.turnOn();
		light.getStatus();
		light.turnOff();
		
		System.out.println();
		
		speaker.turnOn();
		speaker.getStatus();
		speaker.turnOff();
	}
}
