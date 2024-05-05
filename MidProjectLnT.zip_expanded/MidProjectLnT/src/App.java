import java.util.ArrayList;
import java.util.Scanner;

public class App {
	ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	public void displayMenu() {
		System.out.println("ChipiChapa App:");
		System.out.println("1. Input Vehicle");
		System.out.println("2. View Vehicle");
		System.out.println("3. Exit");
		System.out.print(">> ");
	}
	
	public String checkVehicleType(Vehicle vehicle) {
		if(vehicle instanceof Car) {
			return "Car";
		}else if(vehicle instanceof Motorcycle) {
			return "Motorcycle";
		}
		return "";
	}
	
	public boolean licenseValidation(String tempLicense) {
		String[] parts = tempLicense.split(" ");
		
		if (parts.length != 3) {
            return false;
        }
		if (!Character.isUpperCase(parts[0].charAt(0))) {
            return false;
        }
		if (!parts[1].matches("\\d{1,4}")) {
            return false;
        }
		if (!parts[2].matches("[A-Z]{1,3}")) {
            return false;
        }
		
		return true;
	}
	
	public void createVehicle(Scanner scan) {
		
		String tempType = "";
		String tempVehicleType = "";
		String tempBrand = "";
		String tempName = "";
		String tempLicense = "";
		Double tempTopSpeed = 0.0;
		Double tempGasCapasity = 0.0;
		int tempWheel = 0;
		int tempSpesificType = 0;
		
		do {
			System.out.print("Input type [Car | Motorcycle]: ");
			tempType = scan.nextLine();
		} while (!tempType.contains("Car") && !tempType.contains("Motorcycle"));
		
		System.out.println(tempType);
		
		do {
			System.out.print("Input brand [>= 5]: ");
			tempBrand = scan.nextLine();
		} while (tempBrand.length() < 5);
		
		do {
			System.out.print("Input name [>= 5]: ");
			tempName = scan.nextLine();
		} while (tempName.length() < 5);
		
		do {
			System.out.print("Input license: ");
			tempLicense = scan.nextLine();
		} while (!licenseValidation(tempLicense));
		
		do {
			System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
			try {
				tempTopSpeed = scan.nextDouble();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			
		} while (tempTopSpeed < 100 || tempTopSpeed > 250);
		
		do {
			System.out.print("Input gas capasity [30 <= gasCap <= 60]: ");
			try {
				tempGasCapasity = scan.nextDouble();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (tempGasCapasity < 30 || tempGasCapasity > 60);
		
		if(tempType.contains("Car")) {
			do {
				System.out.print("Input wheel [4 <= wheel <= 6]: ");
				try {
					tempWheel = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
			} while (tempWheel < 4 || tempWheel > 6);
		}else {
			do {
				System.out.print("Input wheel [2 <= wheel <= 3]: ");
				try {
					tempWheel = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
			} while (tempWheel < 2 || tempWheel > 3);
		}
		
		if(tempType.contains("Car")) {
			do {
				System.out.println("Input type [SUV | Supercar | Minivan]: ");
				tempVehicleType = scan.nextLine();
			} while (!tempVehicleType.contains("SUV") &&
					!tempVehicleType.contains("Supercar") &&
					!tempVehicleType.contains("Minivan"));
		}else {
			do {
				System.out.println("Input type [Automatic | Manual]: ");
				tempVehicleType = scan.nextLine();
			} while (!tempVehicleType.contains("Automatic") &&
					!tempVehicleType.contains("Manual"));
		}
		
		if(tempType.contains("Car")) {
			do {
				System.out.println("Input entertainment system amount [>= 1]: ");
				try {
					tempSpesificType = scan.nextInt();					
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
			} while (tempSpesificType < 1);
		}else {
			do {
				System.out.println("Input helm amount [>= 1]: ");
				try {
					tempSpesificType = scan.nextInt();					
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
			} while (tempSpesificType < 1);
		}
		
		if(tempType.contains("Car")) {
			vehicleList.add(new Car(tempBrand, tempName, tempLicense, tempTopSpeed, tempGasCapasity, tempWheel, tempVehicleType, tempSpesificType));
		}else {
			vehicleList.add(new Motorcycle(tempBrand, tempName, tempLicense, tempTopSpeed, tempGasCapasity, tempWheel, tempVehicleType, tempSpesificType));
		}
			
		System.out.print("ENTER to return");
		scan.nextLine();
	}
	
	public void viewVehicle(Scanner scan) {
		System.out.printf("|-----|----------|----------------------------------------|\n");
		System.out.printf("|%-5s|%-10s|%-40s|\n", "No.", "Type", "Name");
		System.out.printf("|-----|----------|----------------------------------------|\n");
		for (Vehicle i : vehicleList) {
			System.out.printf("|%-5d|%-10s|%-40s|\n", vehicleList.indexOf(i) + 1, checkVehicleType(i), i.getName());
		}
		System.out.printf("|-----|----------|----------------------------------------|\n");
		
		if(vehicleList.size() == 0)
			return;
		
		int tempVehicleNumber = 0;
		do {
			System.out.print("Pick a vehicle number to test drive[Enter '0' to exit]: ");
			try {
				tempVehicleNumber = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		} while (tempVehicleNumber > vehicleList.size() && tempVehicleNumber != 0);
		
		if(tempVehicleNumber == 0)
			return;
		
		Vehicle currentVehicle = vehicleList.get(tempVehicleNumber - 1);
		
		
		System.out.println("Brand: " + currentVehicle.getBrand());
		System.out.println("Name: " + currentVehicle.getName());
		System.out.println("License Plate: " + currentVehicle.getLicenseNumber());
		System.out.println("Type: " + currentVehicle.getVehicleType());
		System.out.println("Gas Capasity: " + currentVehicle.getGasCap());
		System.out.println("Top Speed: " + currentVehicle.getTopSpeed());
		System.out.println("Wheel(s): " + currentVehicle.getWheel());
		
		if(currentVehicle instanceof Car) {
			System.out.println("Entertainment System: " + ((Car) currentVehicle).getEntertaintmentSystem());
			System.out.println("Turning on entertainment system...");
			if(currentVehicle.getVehicleType().contains("Supercar")) {
				System.out.println("Boosting!");
			}
		}else if(currentVehicle instanceof Motorcycle) {
			System.out.println("Helm: " + ((Motorcycle) currentVehicle).getTotalHelmet());
			System.out.println(currentVehicle.getName() + " is standing!");
			
			do {
				System.out.println("Input helm price: ");
				try {
					((Motorcycle) currentVehicle).setPrice(scan.nextInt());
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
				}
			}while(((Motorcycle) currentVehicle).getPrice() < 0);
			
			System.out.println("Price: " + ((Motorcycle) currentVehicle).getPrice());
		}
		
	}

	public int menuApp(int choice, Scanner scan) {
		displayMenu();
		do {
			try {
				choice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				System.out.println("Input must be number!!");
				scan.nextLine();
			}
		} while (choice > 3 || choice < 1);
		
		switch(choice)
		{
			case 1:
			{
				createVehicle(scan);
				break;
			}
			case 2:
			{
				viewVehicle(scan);
				break;
			}
			case 3:
			{
				
				break;
			}
			default:
			{
				
				break;
			}
		}
		
		return choice;
	}
	
	App(){
		Scanner scan = new Scanner(System.in);
		int choice = -1;
		do {
			choice = menuApp(choice, scan);
		}while(choice != 3);
	}
	
	public static void main(String[] args) {
		new App();
	}

}
