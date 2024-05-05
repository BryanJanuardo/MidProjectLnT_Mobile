
public abstract class Vehicle {
	private String brand;
	private String name;
	private String licenseNumber;
	private Double topSpeed;
	private Double gasCap;
	private Integer wheel;
	private String vehicleType;
	
	
	public Vehicle(String brand, String name, String licenseNumber, Double topSpeed, Double gasCap, Integer wheel,
			String vehicleType) {
		super();
		this.brand = brand;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.topSpeed = topSpeed;
		this.gasCap = gasCap;
		this.wheel = wheel;
		this.vehicleType = vehicleType;
	}

	protected abstract void vehicleOutput();

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Double getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(Double topSpeed) {
		this.topSpeed = topSpeed;
	}

	public Double getGasCap() {
		return gasCap;
	}

	public void setGasCap(Double gasCap) {
		this.gasCap = gasCap;
	}

	public Integer getWheel() {
		return wheel;
	}

	public void setWheel(Integer wheel) {
		this.wheel = wheel;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	
}
