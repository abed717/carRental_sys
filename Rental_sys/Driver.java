package P1;

import java.util.*;

public class Driver {
     
	
	
	public static void main(String[] args) {
		
		Vehicle[] availableVehicles = { 
				
				new Vehicle("Car", "ABC123", "Toyota", 50.0, true), 
				new Vehicle("Bike", "DEF456", "Honda", 20.0, true), 
				new Vehicle("Truck", "GHI789", "Ford", 80.0, true), 
				new Vehicle("Car", "JKL012", "Hyundai", 55.0, true), 
				new Vehicle("Bike", "MNO345", "Yamaha", 160.0, true) 
				}; 
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of customers : ");
		int numOfCus = sc.nextInt();
		Customer[] cArr = new Customer[numOfCus];
		
		String cName;
		int cId=0;
		String lisN;
		int mxNR=0;
		int finalCarsN=0;
		String enteredReg;
		
		for(int i=0 ; i< cArr.length ; i++) {
			System.out.println("Enter the "+(i+1)+" Customer Details : ");
			System.out.println(" ");
			System.out.println("Enter the Customer NAME : ");
			sc.nextLine();
			cName=sc.nextLine(); 
			System.out.println(" ");
			System.out.println("Enter the Customer id : ");
			cId=sc.nextInt();
			System.out.println(" ");
			System.out.println("Enter the Customer license number : ");
			sc.nextLine();
			lisN = sc.nextLine();
			System.out.println(" ");
			System.out.println("Enter the Customer  max number of rented cars : ");
			mxNR = sc.nextInt();
			cArr[i] = new Customer( cName , cId , lisN , mxNR );
			System.out.println(" ");
			System.out.println("Enter the number of cars to rent now : ");
			finalCarsN = sc.nextInt();
			if( finalCarsN == 0 ) {
				System.out.println(" ");
				System.out.println("Sorry you cant rent a car right now");
				continue;
			}
			System.out.println(" ");
			System.out.println("Available vehicles for rental : ");
			System.out.println(" ");
			for( int j=0 ; j<availableVehicles.length ; j++) {
				
				if(availableVehicles[j].isAvailable()) {
					System.out.println( availableVehicles[j].getType()+" "+"(Registration: "+availableVehicles[j].getRegistrationNumber()+"), "
				+availableVehicles[j].getBrand()+" - $"+availableVehicles[j].getRentalRatePerDate()+"/day");
				}
				
			}
			
			int count=0;
			while( cArr[i].getNumberOfCurrentRented() != finalCarsN ) {
				 
				
				 System.out.println(" ");
				 System.out.println("Enter registration number of vehicle "+(cArr[i].getNumberOfCurrentRented()+1)+" to rent: ");
				 
				 if(count == 0 ) { sc.nextLine();}
			     enteredReg= sc.nextLine();
			     if(enteredReg.length()>0) {
			     if(enteredReg.toLowerCase().equals("exit")) {
			    	 System.out.println(" ");
			    	 System.out.println("Rental process ended by customer");
			    	 count++;break;
			    	 
			     }
			     if(findVehicleByRegistrationNumber(availableVehicles,enteredReg) == null) {
			    	 System.out.println(" ");
			    	 System.out.println("Vehicle not found. Please choose another.");
			    	  count++;continue;
			    	
			     }
			     if(!(findVehicleByRegistrationNumber(availableVehicles,enteredReg).isAvailable())) {
			    	 System.out.println(" ");
			    	 System.out.println("Vehicle not available. Please choose another.");
			    	 count++;continue;
			    	 
			     }
			     
			     System.out.println(" ");
			     System.out.println("Enter rental days: ");
			     cArr[i].rentVehicle(findVehicleByRegistrationNumber(availableVehicles,enteredReg) , sc.nextInt());
			     findVehicleByRegistrationNumber(availableVehicles,enteredReg).setAvailable(false);
			    count++;
			     }
			}
			
		}
		
		int choice=0;
		String enteredType;
		int enteredId=0;
		while(choice != 8) {
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Main Menu");
		System.out.println("1: Print Customer Information  ");
		System.out.println("2: Display Total Rental Cost for a Customer ");
		System.out.println("3: Count Rented Vehicles by Type  ");
		System.out.println("4: Rent a New Vehicle ");
		System.out.println("5: Return a Vehicle  ");
		System.out.println("6: Display All Available Vehicles in Ascending Order of Price  ");
		System.out.println("7: Display All Available Vehicles in Alphabetical Order of Type  ");
		System.out.println("8: Exit  ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Enter your choice:  ");
		choice = sc.nextInt();
		switch(choice) {
		
		case 1: System.out.println("Enter customer id: ");
		      enteredId=sc.nextInt();
		      if( findCustomerById(cArr,enteredId) == null ) {
			 System.out.println("Customer not found.");
			 continue;
		      }
		      findCustomerById(cArr,enteredId).printInfo();
			break;
		case 2: System.out.println("Enter customer id: ");
		 enteredId=sc.nextInt();
		 if( findCustomerById(cArr,enteredId) == null ) {
			 System.out.println("Customer not found.");
			 continue;
		 }
		 System.out.println("Total Rental Cost for "+(findCustomerById(cArr,enteredId)).getName()+": $"+(findCustomerById(cArr,enteredId)).calculateRent());
			break;
		case 3: System.out.println("Enter customer id: ");
	            enteredId=sc.nextInt();
	            if( findCustomerById(cArr,enteredId) == null ) {
		        System.out.println("Customer not found.");
		        continue;
	            }
		        System.out.println("Enter vehicle type to count (e.g., Car, Bike): ");
			    sc.nextLine();
			    enteredType=sc.nextLine();
			    
			    System.out.println("Number of "+enteredType+"(s) rented by "+findCustomerById(cArr,enteredId).getName()+" : "+findCustomerById(cArr,enteredId).countVehiclesByType(enteredType));
		        break;
		        
		case 4: System.out.println("Enter customer id: ");
	            enteredId=sc.nextInt();
	            if( findCustomerById(cArr,enteredId) == null ) {
		        System.out.println("Customer not found.");
	        	 continue;
	            }
	            System.out.println("Enter vehicle type to count (e.g., Car, Bike): ");
			    sc.nextLine();
			    enteredType=sc.nextLine();
			    System.out.println("Available vehicles of type ’"+enteredType+"’"+" : ");
			  
			    for( int j=0 ; j<availableVehicles.length ; j++) {
					if(availableVehicles[j].isAvailable() && (availableVehicles[j].getType()).equals(enteredType)) {
						System.out.println( (j+1)+". "+availableVehicles[j].getType()+" "+"(Registration: "+availableVehicles[j].getRegistrationNumber()+"), "
					+availableVehicles[j].getBrand()+" - $"+availableVehicles[j].getRentalRatePerDate()+"/day");
					}
				}
			    
			    System.out.println(" ");
			    System.out.println("Enter registration number of vehicle to rent: ");
			    
			    
    enteredReg= sc.nextLine();
    if(enteredReg.length()>0) {
    if(enteredReg.toLowerCase().equals("exit")) {
   	 System.out.println(" ");
   	 System.out.println("Rental process ended by customer");
   	 continue;
   	 
    }
    if(findVehicleByRegistrationNumber(availableVehicles,enteredReg) == null) {
   	 System.out.println(" ");
   	 System.out.println("Vehicle not found. Please choose another.");
   	continue;
   	
    }
    if(!(findVehicleByRegistrationNumber(availableVehicles,enteredReg).isAvailable())) {
   	 System.out.println(" ");
   	 System.out.println("Vehicle not available. Please choose another.");
   	continue;
   	 
    }
    
    System.out.println(" ");
    System.out.println("Enter rental days: ");
    findCustomerById(cArr,enteredId).rentVehicle(findVehicleByRegistrationNumber(availableVehicles,enteredReg) , sc.nextInt());
    findVehicleByRegistrationNumber(availableVehicles,enteredReg).setAvailable(false);
    
    }	    
			break;
		case 5: System.out.println("Enter customer id: ");
                enteredId=sc.nextInt();
                if( findCustomerById(cArr,enteredId) == null ) {
                System.out.println("Customer not found.");
            	continue;
                }
                System.out.println(" ");
                System.out.println("List of vehicles currently rented: ");
                System.out.println(" ");
                Vehicle[] rented = new Vehicle[findCustomerById(cArr , enteredId).getNumberOfCurrentRented()];
                System.arraycopy(findCustomerById(cArr , enteredId).getVehiclesRented(), 0, rented, 0, rented.length);
         
                for( int j=0 ; j<rented.length ; j++) {

						System.out.println("- "+rented[j].getType()+" "+"(Registration: "+rented[j].getRegistrationNumber()+"), "
					+rented[j].getBrand()+" - $"+rented[j].getRentalRatePerDate()+"/day");
					
				}
                System.out.println(" ");
                System.out.println("Enter registration number of the vehicle to return: ");
                sc.nextLine();
                enteredReg =  sc.nextLine();
                if(  findVehicleByRegistrationNumber(rented,enteredReg) == null ) {
                  	 System.out.println(" ");
                  	 System.out.println("Vehicle not found. Please choose another.");
                  	continue;
                  	
                   }
                findCustomerById(cArr , enteredId).reternVehicle(findVehicleByRegistrationNumber(availableVehicles,enteredReg));
                findVehicleByRegistrationNumber(availableVehicles,enteredReg).setAvailable(true);
                
                
			
			break;
		case 6:  System.out.println("Available Vehicles Sorted by Rental Rate: ");
	             System.out.println(" ");
                 displayVehiclesByPrice(availableVehicles);
                 
			break;
		case 7:   System.out.println("Available Vehicles in Alphabetical Order of Type: ");
		          System.out.println(" ");
		          displayVehiclesByType(availableVehicles);
		          
			break;
		case 8: System.out.println("Goodbye !! ");
		    return;
			
			
		
		}
		

	}

		
		
		
		
		
	}
	
	public static Customer findCustomerById(Customer[] customers, int customerId) {
		
		for(int i=0; i<customers.length ; i++) {
			if ( customerId == customers[i].getId() ) {
				return customers[i];
			}
		}
		
		return null;
	}
	public static Vehicle findVehicleByRegistrationNumber( Vehicle[] vehicles, String regNumber ) {
	
		for( int i=0 ; i<vehicles.length ; i++) {
			
			if (regNumber.equals(vehicles[i].getRegistrationNumber())) {
				return vehicles[i];
			}
			
		}
		return null;
	}
	public static void displayVehiclesByPrice(Vehicle[] vehicles) {
		
		
	                      /*sorting the elements(ascending) by comparing every elements with the previous element by using two loops */
		int flag=0;
		for(int i=0 ; i<vehicles.length ; i++) {
			if(vehicles[i].isAvailable()) {
				flag=1;
				break;              /* checking if there is available vehicles*/
			}
		}
		if(flag == 0) {
			System.out.println("there is no available vehivles ");
		}
		Vehicle[] copy = new Vehicle[vehicles.length];
		System.arraycopy(vehicles, 0, copy, 0, vehicles.length);
		
	    for (int i = 0; i < vehicles.length - 1; i++) {
	    	
	    	
	        for (int j = 0; j < vehicles.length - i - 1; j++) {
	        	
	        	
	            if (vehicles[j].getRentalRatePerDate() > vehicles[j + 1].getRentalRatePerDate()) {
	                                                 
	            	                                   /* swapping elements */
	                Vehicle temp = vehicles[j];
	                
	                vehicles[j] = vehicles[j + 1];
	                
	                vehicles[j + 1] = temp;
	                
	            }
	        }
	    }

	    for(int j=0 ; j< vehicles.length ; j++)
		 {
	    	if( vehicles[j].isAvailable() ) {
			System.out.println(vehicles[j].getType()+" "+"(Registration: "+vehicles[j].getRegistrationNumber()+"), "
		+vehicles[j].getBrand()+" - $"+vehicles[j].getRentalRatePerDate()+"/day");
	    	}
		}
	    
	    System.arraycopy(copy, 0, vehicles, 0, copy.length);
	    
	    
	}
	public static void displayVehiclesByType(Vehicle[] vehicles) {
		/*using the same way in the the previous method to sort the array by the type*/
		
		int flag=0;
		for(int i=0 ; i<vehicles.length ; i++) {
			if(vehicles[i].isAvailable()) {
				flag=1;
				break;              /* checking if there is available vehicles*/
			}
		}
		if(flag == 0) {
			System.out.println("there is no available vehivles ");
		}
		
		Vehicle[] copy = new Vehicle[vehicles.length];
		System.arraycopy(vehicles, 0, copy, 0, vehicles.length);
		
		for (int i = 0 ; i < vehicles.length - 1; i++ ) {
			
			
            for (int j = 0; j < vehicles.length - i - 1; j++) {
            	
            	
                if ( (vehicles[  j
                		          ].getType().compareTo( vehicles[j +  1].getType()  ))>	0)
                {  /* comparing every type with the previous type by
                		                                                                      compareTo thats return 0 if they are equal and positive
                		                                                                       if the first is greater and minus if the first smaller*/
                	
                	
               /*swapping the elements*/
                    Vehicle  temp = vehicles[j];
                      vehicles[j] 	= 
                    	vehicles[j +  1];
                      vehicles[j  + 1] =  
            temp  ;
                    
                }
                
                
            }
            
            
        }
		for(int j=0 ; j< vehicles.length ; j++)
		 {
	    	if( vehicles[j].isAvailable() ) {
			System.out.println(vehicles[j].getType()+" "+"(Registration: "+vehicles[j].getRegistrationNumber()+"), "
		+vehicles[j].getBrand()+" - $"+vehicles[j].getRentalRatePerDate()+"/day");
	    	}
		}
		
		System.arraycopy(copy, 0, vehicles, 0, copy.length);
	}

}
