package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDriverCustomer,
 * asgn2Customers.DroneDriverCustomer classes. Note that an instance of asgn2Customers.DriverDriverCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Daniel Perkovic
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
	public void DriverCustomerGetName() throws CustomerException{
		Customer DriverCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		assertEquals("Casey Jones",DriverCustomer.getName());
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
	public void DriverCustomerMobileNumber() throws CustomerException{
		Customer DriverCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		assertEquals("0123456789",DriverCustomer.getMobileNumber());
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
	public void DriverCustomerLocationX() throws CustomerException{
		Customer DriverCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		assertEquals(5,DriverCustomer.getLocationX());
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
	public void DriverCustomerLocationY() throws CustomerException{
		Customer DriverCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		assertEquals(5,DriverCustomer.getLocationY());
	}
	@Test
	public void DroneCustomerLocationY() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 3, 4);
		assertEquals(4,DroneCustomer.getLocationY());
	}
	@Test
	public void DroneCustomerDistance() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 3, 4);
		assertEquals(5.0,DroneCustomer.getDeliveryDistance(), 0.0000001);
	}
	@Test
	public void DriverCustomerDistance() throws CustomerException{
		Customer DriverCustomer = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5);
		assertEquals(10.0,DriverCustomer.getDeliveryDistance(), 0.0000001);
	}
	@Test
	public void PickupCustomerDistance() throws CustomerException{
		Customer PickUpCustomer = CustomerFactory.getCustomer("PUC", "Oroku Saki", "0111222333", 0, 0);
		assertEquals(0.0,PickUpCustomer.getDeliveryDistance(), 0.0000001);
	}
	
	@Test(expected = Exception.class)
	public void CustomerNameTooLongExceptionTest() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "Apu Nahasapeenapetalon", "0987654321", 3, 4);
	}
	@Test(expected = Exception.class)
	public void CustomerNameOnleSpacesExceptionTest() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "        ", "0987654321", 3, 4);
	}
	@Test(expected = Exception.class)
	public void CustomerMobileNumberTooLongExceptionTest() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "09876543210", 3, 4);
	}
	@Test(expected = Exception.class)
	public void CustomerMobileNumberTooShortExceptionTest() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "098765432", 3, 4);
	}
	@Test(expected = Exception.class)
	public void CustomerMobileNumberDoesntStartWithZeroExceptionTest() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "1987654321", 3, 4);
	}
	@Test(expected = Exception.class)
	public void CustomerPickUpLocationNotZeroExceptionTest() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("PUC", "April O'Neal", "0987654321", 3, 4);
	}
	@Test(expected = Exception.class)
	public void CustomerDeliveryLocationNotZeroExceptionTest() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 0, 0);
	}
	@Test(expected = Exception.class)
	public void CustomerLocationXAboveTen() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 11, 4);
	}
	@Test(expected = Exception.class)
	public void CustomerLocationXBelowMinusTen() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", -11, 4);
	}
	@Test(expected = Exception.class)
	public void CustomerLocationYAboveTen() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 11, 4);
	}
	@Test(expected = Exception.class)
	public void CustomerLocationYBelowMinusTen() throws CustomerException{
		Customer DroneCustomer = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", -11, 4);
	}
	
}
