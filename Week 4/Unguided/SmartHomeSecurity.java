package tugas;

public class SmartHomeSecurity {
	public static void main(String[] args) {
		SmartCamera cam = new SmartCamera();
		SmartDoorLock door = new SmartDoorLock();
		SmartHomeController controller = new SmartHomeController();
		
		controller.activateAll(cam, door);
		controller.checkAll(cam, door);
		controller.deactivateAll(cam, door);
		controller.checkAll(cam, door);
		
		
	}

}
