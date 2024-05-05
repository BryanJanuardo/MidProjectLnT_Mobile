
public class Motorcycle extends Vehicle {
	private Integer totalHelmet;
	private Integer price;
	
	public Motorcycle(String brand, String name, String licenseNumber, Double topSpeed, Double gasCap, Integer wheel,
			String vehicleType, Integer totalHelmet) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel, vehicleType);
		this.totalHelmet = totalHelmet;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void displayPrice() {
		System.out.println("Price: " + getPrice());
	}
	
	public Integer getTotalHelmet() {
		return totalHelmet;
	}

	public void setTotalHelmet(Integer totalHelmet) {
		this.totalHelmet = totalHelmet;
	}

	public void vehicleOutput() {
		System.out.println(super.getName() + " is standing!");
	}
}
