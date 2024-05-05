
public class Car extends Vehicle{
	private Integer entertaintmentSystem;
	
	public Car(String brand, String name, String licenseNumber, Double topSpeed, Double gasCap, Integer wheel,
			String vehicleType, Integer entertaintmentSystem) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel, vehicleType);
		this.entertaintmentSystem = entertaintmentSystem;
	}
	
	public Integer getEntertaintmentSystem() {
		return entertaintmentSystem;
	}

	public void setEntertaintmentSystem(Integer entertaintmentSystem) {
		this.entertaintmentSystem = entertaintmentSystem;
	}
	
	public void vehicleOutput() {
		System.out.println("Boosting!");
	}
}
