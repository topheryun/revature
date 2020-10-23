package JavaFriday;

public class RevetureEmployer extends EMS {

	@Override
	public void addEmployee() {
		System.out.println("Reveature employee added to Oracle DB");
		
	}

	@Override
	public void updateEmployee() {
		System.out.println("Reveature employee updated to Oracle DB");
		
	}

	@Override
	public void getEmployee() {
		System.out.println("Reveature employee retrieved from Oracle DB");
		
	}

	@Override
	public void calcEmployeeSalary() {
		System.out.println("Reveature employee salary calculated from Oracle DB");
		
	}

	@Override
	public void deleteEmployee() {
		System.out.println("Reveature employee removed from Oracle DB");
		
	}

}
