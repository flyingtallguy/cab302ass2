package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** A class that represents a customer that has chosen to have their pizza delivered by a drone. 
 * This class extends the abstract Customer class and calculates the delivery distance as the Euclidean 
 * Distance between the customer and the restaurant.  A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.
 * 
 * @author PersonB
 *
 */
public class DroneDeliveryCustomer extends Customer {
//	private String name;
//	private String mobileNumber;
//	private int locationX;
//	private int locationY;

	/**
	 *  This class represents a customer of the Pizza Palace restaurant that has chosen to have their pizza delivered by 
	 *  a drone.  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment
	 *  Specification are violated. 
     *
     * <P> PRE: TRUE
     * <P> POST: All field values are set
     *
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @throws CustomerException if supplied parameters are invalid
	 * 
	 */
	public DroneDeliveryCustomer(String name, String mobileNumber, int locationX, int locationY) throws CustomerException {
		super(name, mobileNumber, locationX, locationY, "DNC");
//		this.name = name;
//		this.mobileNumber = mobileNumber;
//		this.locationX = locationX;
//		this.locationY = locationY;
		
		if(name.length() > 20 || name.contentEquals(" ") || mobileNumber.length() > 10 || mobileNumber.startsWith("0") || locationX == 0.0 || locationY == 0.0){
			throw new CustomerException();
		}
	}

	/**
	 * Returns the Euclidean Distance between the instance of DroneDeliveryCustomer and the restaurant. Overrides  
	 * getDeliveryDistance() in Customer.
	 * 
     * @return The distance between the restaurant and the customer in Euclidean distance.
	 */
	@Override
	public double getDeliveryDistance() {
		int LocationX = getLocationX();
		int LocationY = getLocationY();
		int storeLocationX = 0;
		int storeLocationY = 0;
		
		double euclidianDistance = Math.sqrt((Math.pow(LocationX, 2) - Math.pow(storeLocationX, 2)) - (Math.pow(LocationY, 2) - Math.pow(storeLocationY, 2)));
		return euclidianDistance;
	}
	

}
