package tugas;

// Implementasi SmartLight
class SmartLight implements SmartDevice{
	private boolean isOn;
	
	@Override
	public void turnOn() {
		isOn = true;
		System.out.println("Smart Light is now ON.");
	}
	
	@Override
	public void turnOff() {
		isOn = false;
		System.out.println("Smart Light is now OFF.");
	}
	
	@Override
	public void getStatus() {
		System.out.println("Smart Light status : " + (isOn ? "ON" : "OFF"));
	}
}
