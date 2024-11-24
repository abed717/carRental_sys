package P1;

public class Customer {

	
	
	
	private String name;
	private int id;
	private String licenseNumber;
	private int numberOfCurrentRented=0;
	private Vehicle[] vehiclesRented;
	
	public Customer() {
		
	}
	public Customer(String name, int id, String licenseNumber, int maxVehicle) {
		setName(name);
		setId(id);
		setLicenseNumber(licenseNumber);
		vehiclesRented = new Vehicle[maxVehicle];
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public int getNumberOfCurrentRented() {
		return numberOfCurrentRented;
	}
	public void setNumberOfCurrentRented(int numberOfCurrentRented) {
		this.numberOfCurrentRented = numberOfCurrentRented;
	}
	
	public void  rentVehicle(Vehicle vehicle, int day) {
		
		vehiclesRented[numberOfCurrentRented] = vehicle;
		vehiclesRented[numberOfCurrentRented].setRentDays(day);
		numberOfCurrentRented++;
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Vehicle rented successfully.");
	}
	public void reternVehicle(Vehicle vehicle) {
		
		/*vehiclesRented[numberOfCurrentRented-1] = null;*/
		for(int i=0 ; i<numberOfCurrentRented ; i++) {
			if(vehiclesRented[i] == vehicle ) {
				vehiclesRented[i] = null;
			}
		}
		Vehicle[] temp = new Vehicle[numberOfCurrentRented-1];
		int indicator=0;
		for(int i=0 ; i<numberOfCurrentRented ; i++) {
			if (vehiclesRented[i] != null) {
				temp[indicator] = vehiclesRented[i];
				indicator++;
			}
		}
		System.arraycopy(temp, 0, vehiclesRented, 0, temp.length);
		
		numberOfCurrentRented--;
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Vehicle returned successfully.");
	}
    public double calculateRent() {
    	
    	double cost=0;
    	
    	for(int i=0 ; i<numberOfCurrentRented ; i++) {
    		cost += (vehiclesRented[i].getRentDays())*(vehiclesRented[i].getRentalRatePerDate());
    	}
    	return cost;
    }
    public double calculateRent(String type) {
    	
    	double cost=0;
 
    	for(int i=0 ; i<numberOfCurrentRented ; i++) {
    		
    		if( vehiclesRented[i].getType().equals(type) )
    		cost += (vehiclesRented[i].getRentDays())*(vehiclesRented[i].getRentalRatePerDate());
    	}
    	return cost;
    }
    public int countVehiclesByType(String type) {
    	
    	int counter=0;
    	for(int i=0 ; i<numberOfCurrentRented ; i++) {
    		if( vehiclesRented[i].getType().equals(type) )
    			counter++;
    	}
    	return counter; 
    }
    public void printInfo() {
    	System.out.println("Customer Information: ");
    	System.out.println(" ");
    	System.out.println("name : "+name);
    	System.out.println("id : "+id);
    	System.out.println("licenseNumber : "+licenseNumber);
    	System.out.println(" ");
    	System.out.println("Vehicles Rented: ");
    	System.out.println(" ");
    	for(int i=0 ; i<numberOfCurrentRented ; i++)
    		vehiclesRented[i].printInfo();
    }
	public Vehicle[] getVehiclesRented() {
		return vehiclesRented;
	}
	public void setVehiclesRented(Vehicle[] vehiclesRented) {
		this.vehiclesRented = vehiclesRented;
	}
	
	
}
