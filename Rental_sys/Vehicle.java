package P1;

public class Vehicle {

	
	
	private String type;
	private String registrationNumber;
	private String brand;
	private double  rentalRatePerDate;
	private int rentDays;
	private boolean available;
	
	public Vehicle() {
		
	}
	public Vehicle(String type, String registrationNumber, String brand, double rentalRatePerDate, boolean available) {
		setType(type);
		setRegistrationNumber(registrationNumber);
		setBrand(brand);
		setRentalRatePerDate(rentalRatePerDate);
		setAvailable(available);
	}
	
	public String getType() {  
		
		return
				type;
	}
	public void setType
	(String type) {
		this.type
		= type;
	}
	public String 
	
	getRegistrationNumber() {
		
		return
				registrationNumber;
	}
	public void setRegistrationNumber
	(String registrationNumber) {
		this.registrationNumber =
				registrationNumber;
	}
	public String 
	
	getBrand() {
		
		
		return brand;
	}
	
	
	public void 
	
	setBrand(String brand) {
		this.brand
		
		= brand;
	}
	public double
	
	getRentalRatePerDate() {
		return 
				
				rentalRatePerDate;
	}
	public void 
	
	setRentalRatePerDate(double rentalRatePerDate) {
		this.rentalRatePerDate = 
				
				rentalRatePerDate;
	}
	public int 
	
	getRentDays() {
		return 
				
				rentDays;
	}
	public void 
	
	setRentDays(int rentDays) {
		this.rentDays = 
				
				rentDays;
	}
	public boolean
	
	isAvailable() {
		return
				
				available;
	}
	public void 
	
	setAvailable(boolean available) {
		this.available
		
		= available;
	}
	
	public void printInfo() {
		System.out.println(" - Vehicle Code: "+type.toUpperCase()+registrationNumber+", Type"
				+ " : "+type+", Brand : "+brand+", DailyRate : "+rentalRatePerDate);
		
	}
	
	
	
	
}
