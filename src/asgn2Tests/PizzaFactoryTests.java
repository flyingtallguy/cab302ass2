package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.VegetarianPizza;

import asgn2Pizzas.PizzaTopping;

import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

import asgn2Exceptions.PizzaException;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Jayden Worrall 
 * 
 */
public class PizzaFactoryTests {
	
	@Before
	public void BeforePizzaTest(){
		
	}
		@Test
		public void VegetarianCode() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 00);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
			assertEquals("Vegetarian",VegetarianPizza.getPizzaType());
		}
		
		@Test
		public void MargheritaCode() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 00);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
			assertEquals("Margherita",MargheritaPizza.getPizzaType());
		}
		
		@Test
		public void MeatLoversCode() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 00);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			Pizza MeatLovers = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
			assertEquals("Meat Lovers",MeatLovers.getPizzaType());
		}
		
		@Test(expected = Exception.class)
		public void ExceptionCode() throws PizzaException {
			LocalTime orderTime = LocalTime.of(19, 00);
			LocalTime deliveryTime = LocalTime.of(19, 20);
			Pizza VegetarianPizza = PizzaFactory.getPizza("1738", 5, orderTime, deliveryTime);
			assertEquals("Vegetarian",VegetarianPizza.getPizzaType());
		}
}