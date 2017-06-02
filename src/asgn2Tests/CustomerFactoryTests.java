package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A
 *
 */
public class CustomerFactoryTests {
	@Before
	public void BeforeCustomerFactory() throws CustomerException{
		//Customer PickUpCustomer = CustomerFactory.getCustomer("PZL", "Oroku Saki", "0111222333", 0, 0);
		//Customer DeliveryCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		//Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 3, 4);
	}
	@Test
	public void PickUpCustomer() throws CustomerException{
		Customer PickUpCustomer = CustomerFactory.getCustomer("PUC", "Oroku Saki", "0111222333", 0, 0);
		assertEquals("Pick Up",PickUpCustomer.getCustomerType());
	}
	
	@Test
	public void DeliveryCustomer() throws CustomerException{
		Customer DeliveryCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		assertEquals("Driver Delivery",DeliveryCustomer.getCustomerType());
	}
	
	@Test
	public void DroneCustomer() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 3, 4);
		assertEquals("Drone Delivery",DroneCustomer.getCustomerType());
	}
	@Test(expected = Exception.class)
	public void CustomerExceptionTest() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNT", "April O'Neal", "0987654321", 3, 4);
	}
	
}
