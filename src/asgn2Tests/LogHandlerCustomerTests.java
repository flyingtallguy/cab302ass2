package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Daniel Perkovic
 */
public class LogHandlerCustomerTests {
	// TO DO
	@Before
	public void LogHandlerCustomer() throws CustomerException{
		//Customer Customer = CustomerFactory.getCustomer("PUC", "Jayden Worrall", "0412423815", 5, 5);
		
	}
	
	
	@Test(expected = Exception.class)
	public void getCustomerException() throws CustomerException, LogHandlerException{
		String log = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
		Customer Customer = LogHandler.createCustomer(log);
		//assertEquals("Drone Delivery",Customer.getCustomerType());
	}
	
	@Test
	public void getCustomer() throws CustomerException, LogHandlerException{
		String log = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
		//String[] logList = log.split(",");
		Customer Customer = LogHandler.createCustomer(log);
		assertEquals("Drone Delivery",Customer.getCustomerType());
	}
	
//	@Test
//	public void PopulateCustomerDataset() throws CustomerException, LogHandlerException{
//		String log = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
//		//String[] logList = log.split(",");
//		//Customer Customer = LogHandler.createCustomer(log);
//		BufferedReader reader = new BufferedReader(new FileReader(filename));
//		String line;
//		assertEquals("Drone Delivery",Customer.getCustomerType());
//	}
}
