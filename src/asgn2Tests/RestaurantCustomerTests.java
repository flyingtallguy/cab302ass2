package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Person A
 */
public class RestaurantCustomerTests {
	public static final String filename = "./logs/20170102.txt";
	PizzaRestaurant restaurant = new PizzaRestaurant();
	Customer customer;
	
	@Before
	public void BeforeRestaurantCustomer() throws CustomerException, PizzaException, LogHandlerException{
	}
	@Test
	public void getCustomerByIndex() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(filename);
		customer = restaurant.getCustomerByIndex(1);
		assertEquals("Lucas Anderson",customer.getName());
	}
	@Test
	public void getNumCustomerOrders() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(filename);
		assertEquals(10,restaurant.getNumCustomerOrders());
	}
	@Test
	public void getTotalDeliveryDistance() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(filename);
		assertEquals(41.40965389573055,restaurant.getTotalDeliveryDistance(), 0.0000000001);
	}
	
	
	@Test(expected = Exception.class)
	public void getCustomersByIndexExceptionIndexGreaterThanNumCustomers() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(filename);
		restaurant.getCustomerByIndex(11);
	}
	
	@Test(expected = Exception.class)
	public void getCustomersByIndexExceptionIndexLessThanZero() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(filename);
		restaurant.getCustomerByIndex(-1);
	}
}
