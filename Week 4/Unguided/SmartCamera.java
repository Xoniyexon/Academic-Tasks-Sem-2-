package tugas;

class SmartCamera implements SmartSecurity {
	private boolean isOn;

	@Override
	public void activateSecurity() {
		isOn = true;
		System.out.println("Smart Camera is now RECORDING.");
	}
	
	@Override
	public void deactivateSecurity() {
		isOn = false;
		System.out.println("Smart Camera is now OFF.");
	}
	
	@Override
	public void getSecurityStatus() {
		System.out.println("Smart Camera Status: " + (isOn ? "RECORDING" : "OFF"));
	}
	
}
