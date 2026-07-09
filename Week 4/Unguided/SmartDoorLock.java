package tugas;

class SmartDoorLock implements SmartSecurity {
	private boolean isLocked;
	
	@Override
	public void activateSecurity() {
		isLocked = true;
		System.out.println("Smart Door is now LOCKED.");
	}
	
	@Override
	public void deactivateSecurity() {
		isLocked = false;
		System.out.println("Smart Door is now UNLOCKED.");
	}
	
	@Override
	public void getSecurityStatus() {
		System.out.println("Smart Door Status: " + (isLocked ? "LOCKED" : "UNLOCKED"));
	}

}
