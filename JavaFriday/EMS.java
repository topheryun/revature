package JavaFriday;

public abstract class EMS {

	public abstract void addEmployee();
	public abstract void updateEmployee();
	public abstract void getEmployee();
	public abstract void calcEmployeeSalary();
	public abstract void deleteEmployee();
	
	public void commonEmployeeBenefits() {
		System.out.println("Common Employee benefits to any employees in the world");
	}
	
	
}
