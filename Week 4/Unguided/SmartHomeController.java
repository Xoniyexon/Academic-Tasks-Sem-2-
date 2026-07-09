package tugas;

public class SmartHomeController {

	public void activateAll(SmartSecurity cam, SmartSecurity door) {
		System.out.println("Activating All Security Devices...");
		cam.activateSecurity();
		door.activateSecurity();
		System.out.println();
	}

	public void checkAll(SmartSecurity cam, SmartSecurity door) {
		System.out.println("Checking Security Status...");
		cam.getSecurityStatus();
		door.getSecurityStatus();
		System.out.println();
	}

	public void deactivateAll(SmartSecurity cam, SmartSecurity door) {
		System.out.println("Deactivating All Security Devices...");
		cam.deactivateSecurity();
		door.deactivateSecurity();
		System.out.println();
	}

}
