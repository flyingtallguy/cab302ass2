package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A
 * 
 *
 */
public class CustomerTests {
	@Before
	public void BeforeCustomerTest(){
		
	}
	@Test
	public void PickUpCustomerGetName() throws CustomerException{
		Customer PickUpCustomer = CustomerFactory.getCustomer("PUC", "Oroku Saki", "0111222333", 0, 0);
		assertEquals("Oroku Saki",PickUpCustomer.getName());
	}
	@Test
	public void DeliveryCustomerGetName() throws CustomerException{
		Customer DeliveryCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		assertEquals("Casey Jones",DeliveryCustomer.getName());
	}
	@Test
	public void DroneCustomerGetName() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 3, 4);
		assertEquals("April O'Neal",DroneCustomer.getName());
	}
	@Test
	public void PickUpCustomerMobileNumber() throws CustomerException{
		Customer PickUpCustomer = CustomerFactory.getCustomer("PUC", "Oroku Saki", "0111222333", 0, 0);
		assertEquals("0111222333",PickUpCustomer.getMobileNumber());
	}
	@Test
	public void DeliveryCustomerMobileNumber() throws CustomerException{
		Customer DeliveryCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		assertEquals("0123456789",DeliveryCustomer.getMobileNumber());
	}
	@Test
	public void DroneCustomerMobileNumber() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 3, 4);
		assertEquals("0987654321",DroneCustomer.getMobileNumber());
	}
	@Test
	public void PickUpCustomerLocationX() throws CustomerException{
		Customer PickUpCustomer = CustomerFactory.getCustomer("PUC", "Oroku Saki", "0111222333", 0, 0);
		assertEquals(0,PickUpCustomer.getLocationX());
	}
	@Test
	public void DeliveryCustomerLocationX() throws CustomerException{
		Customer DeliveryCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		assertEquals(5,DeliveryCustomer.getLocationX());
	}
	@Test
	public void DroneCustomerLocationX() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 3, 4);
		assertEquals(3,DroneCustomer.getLocationX());
	}
	@Test
	public void PickUpCustomerLocationY() throws CustomerException{
		Customer PickUpCustomer = CustomerFactory.getCustomer("PUC", "Oroku Saki", "0111222333", 0, 0);
		assertEquals(0,PickUpCustomer.getLocationY());
	}
	@Test
	public void DeliveryCustomerLocationY() throws CustomerException{
		Customer DeliveryCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		assertEquals(5,DeliveryCustomer.getLocationY());
	}
	@Test
	public void DroneCustomerLocationY() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 3, 4);
		assertEquals(4,DroneCustomer.getLocationY());
	}
	
}
