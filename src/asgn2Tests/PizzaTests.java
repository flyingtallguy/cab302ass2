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
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Jayden Worrall
 *
 */
public class PizzaTests {
	@Before
	public void BeforePizzaTest(){
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);

	}
	
	@Test
	public void MeatLoversPizzaToppingCHEESE() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(true,MeatLoversPizza.containsTopping(PizzaTopping.CHEESE));
	}
	
	@Test
	public void MeatLoversPizzaToppingTOMATO() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(true,MeatLoversPizza.containsTopping(PizzaTopping.TOMATO));
	}
	
	@Test
	public void MeatLoversPizzaToppingBACON() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(true,MeatLoversPizza.containsTopping(PizzaTopping.BACON));
	}
	
	@Test
	public void MeatLoversPizzaToppingSALAMI() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(true,MeatLoversPizza.containsTopping(PizzaTopping.SALAMI));
	}
	
	@Test
	public void MeatLoversPizzaToppingPEPPERONI() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(true,MeatLoversPizza.containsTopping(PizzaTopping.PEPPERONI));
	}
	
	@Test
	public void MeatLoversPizzaToppingCAPSICUM() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(false,MeatLoversPizza.containsTopping(PizzaTopping.CAPSICUM));
	}
	
	@Test
	public void MeatLoversPizzaToppingMUSHROOM() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(false,MeatLoversPizza.containsTopping(PizzaTopping.MUSHROOM));
	}
	
	@Test
	public void MeatLoversPizzaToppingEGGPLANT() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(false,MeatLoversPizza.containsTopping(PizzaTopping.EGGPLANT));
	}

	@Test
	public void VegetarianPizzaToppingCHEESE() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(true,VegetarianPizza.containsTopping(PizzaTopping.CHEESE));
	}
	
	@Test
	public void VegetariaPizzaToppingTOMATO() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(true,VegetarianPizza.containsTopping(PizzaTopping.TOMATO));
	}
	
	@Test
	public void VegetariaPizzaToppingBACON() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(false,VegetarianPizza.containsTopping(PizzaTopping.BACON));
	}
	
	@Test
	public void VegetariaPizzaToppingSALAMI() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(false,VegetarianPizza.containsTopping(PizzaTopping.SALAMI));
	}
	
	@Test
	public void VegetariaPizzaToppingPEPPERONI() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(false,VegetarianPizza.containsTopping(PizzaTopping.PEPPERONI));
	}
	
	@Test
	public void VegetariaPizzaToppingCAPSICUM() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(true,VegetarianPizza.containsTopping(PizzaTopping.CAPSICUM));
	}
	
	@Test
	public void VegetariaPizzaToppingMUSHROOM() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(true,VegetarianPizza.containsTopping(PizzaTopping.MUSHROOM));
	}
	
	@Test
	public void VegetarianPizzaToppingEGGPLANT() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(true,VegetarianPizza.containsTopping(PizzaTopping.EGGPLANT));
	}
	
	
	
	@Test
	public void MargheritaPizzaToppingCHEESE() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(true,MargheritaPizza.containsTopping(PizzaTopping.CHEESE));
	}
	
	@Test
	public void MargheritaPizzaToppingTOMATO() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(true,MargheritaPizza.containsTopping(PizzaTopping.TOMATO));
	}
	
	@Test
	public void MargheritaPizzaToppingBACON() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(false,MargheritaPizza.containsTopping(PizzaTopping.BACON));
	}
	
	@Test
	public void MargheritaPizzaToppingSALAMI() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(false,MargheritaPizza.containsTopping(PizzaTopping.SALAMI));
	}
	
	@Test
	public void MargheritaPizzaToppingPEPPERONI() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(false,MargheritaPizza.containsTopping(PizzaTopping.PEPPERONI));
	}
	
	@Test
	public void MargheritaPizzaToppingCAPSICUM() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(false,MargheritaPizza.containsTopping(PizzaTopping.CAPSICUM));
	}
	
	@Test
	public void MargheritaPizzaToppingMUSHROOM() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(false,MargheritaPizza.containsTopping(PizzaTopping.MUSHROOM));
	}
	
	@Test
	public void MargheritaPizzaToppingEGGPLANT() throws PizzaException{
		PizzaTopping topping ;
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(false,MargheritaPizza.containsTopping(PizzaTopping.EGGPLANT));
	}
	
	
	
	@Test
	public void MargheritaPizzasgetPizzaPrice() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(8,MargheritaPizza.getPricePerPizza(), 0.00);
	}
	
	@Test
	public void VegetarianPizzasgetPizzaPrice() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(10,VegetarianPizza.getPricePerPizza(), 0.00);
	}
	
	@Test
	public void MeatLoversPizzasgetPizzaPrice() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoverPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(12,MeatLoverPizza.getPricePerPizza(), 0.00);
	}
	
	
	@Test
	public void MargheritaCostPerPizza() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargeritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(1.5,MargeritaPizza.getCostPerPizza(), 0.00);
	}
	
	@Test
	public void VegetarianCostPerPizza() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(5.5,VegetarianPizza.getCostPerPizza(), 0.00);
	}

	@Test
	public void MeatLoversCostPerPizza() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(5,MeatLoversPizza.getCostPerPizza(), 0.00);
	}
	
	@Test
	public void MargheritaPizzaGetQuantity() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargeritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(5,MargeritaPizza.getQuantity());
	}
	
	@Test
	public void VegetarianPizzaGetQuantity() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 1, orderTime, deliveryTime);
		assertEquals(1,VegetarianPizza.getQuantity());
	}
	
	@Test
	public void MeatLoversPizzaGetQuantity() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 9, orderTime, deliveryTime);
		assertEquals(9,MeatLoversPizza.getQuantity());
	}	
	
	
	@Test
	public void MargheritaCostPerOrder() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargeritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(7.5,MargeritaPizza.getOrderCost(), 0.00);
	}
	
	@Test
	public void VegatrianCostPerOrder() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(27.5,VegetarianPizza.getOrderCost(), 0.00);
	}
	
	@Test
	public void MeatLoversPizzaCostPerOrder() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(25,MeatLoversPizza.getOrderCost(), 0.00);
	}
	
	
	
	@Test
	public void MeatLoversgetPizzaType() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals("Meat Lovers",MeatLoversPizza.getPizzaType());
	}
	
	@Test
	public void MargheritagetPizzaType() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals("Margherita",MargheritaPizza.getPizzaType());
	}
	
	@Test
	public void VegetarianPizzasgetPizzaType() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals("Vegetarian",VegetarianPizza.getPizzaType());
	}
	
	
	
	@Test
	public void VegetarianPizzasgetOrderPrice() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(50,VegetarianPizza.getOrderPrice(), 0.00);
	}
	
	@Test
	public void MargheritaPizzasgetOrderPrice() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritaPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(40,MargheritaPizza.getOrderPrice(), 0.00);
	}
	
	@Test
	public void MeatLoversPizzasgetOrderPrice() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(60,MeatLoversPizza.getOrderPrice(), 0.00);
	}
	
	
	@Test
	public void MeatLoversPizzasgetPizzaProfit() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MeatLoversPizza = PizzaFactory.getPizza("PZL", 5, orderTime, deliveryTime);
		assertEquals(35,MeatLoversPizza.getOrderProfit(), 0.00);
	}
	
	@Test
	public void MargheritaPizzasgetPizzaProfit() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargheritasPizza = PizzaFactory.getPizza("PZM", 5, orderTime, deliveryTime);
		assertEquals(32.5,MargheritasPizza.getOrderProfit(), 0.00);
	}
	
	@Test
	public void VegetarianPizzasgetPizzaProfit() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza VegetarianPizza = PizzaFactory.getPizza("PZV", 5, orderTime, deliveryTime);
		assertEquals(22.5,VegetarianPizza.getOrderProfit(), 0.00);
	}
	
	@Test(expected = Exception.class)
	public void MaxQuantityException() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargeritaPizza = PizzaFactory.getPizza("PZM", 11, orderTime, deliveryTime);
	}
	
	@Test(expected = Exception.class)
	public void MinQuantityException() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Pizza MargeritaPizza = PizzaFactory.getPizza("PZM", 0, orderTime, deliveryTime);
	}
	
	@Test(expected = Exception.class)
	public void LateOrderTimeException() throws PizzaException{
		LocalTime orderTime = LocalTime.of(23, 00);
		LocalTime deliveryTime = LocalTime.of(23, 20);
		Pizza MargeritaPizza = PizzaFactory.getPizza("PZM", 0, orderTime, deliveryTime);
	}
	
	@Test(expected = Exception.class)
	public void EarlyOrderTimeException() throws PizzaException{
		LocalTime orderTime = LocalTime.of(15, 00);
		LocalTime deliveryTime = LocalTime.of(15, 20);
		Pizza MargeritaPizza = PizzaFactory.getPizza("PZM", 0, orderTime, deliveryTime);
	}
	
	@Test(expected = Exception.class)
	public void MaxDeliveryTimeException() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 00);
		LocalTime deliveryTime = LocalTime.of(21, 20);
		Pizza MargeritaPizza = PizzaFactory.getPizza("PZM", 0, orderTime, deliveryTime);
	}
	
	@Test(expected = Exception.class)
	public void MinDeliveryTimeException() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 00);
		LocalTime deliveryTime = LocalTime.of(20, 05);
		Pizza MargeritaPizza = PizzaFactory.getPizza("PZM", 0, orderTime, deliveryTime);
	}
	
	@Test(expected = Exception.class)
	public void PizzaTypeException() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 00);
		LocalTime deliveryTime = LocalTime.of(21, 20);
		Pizza MargeritaPizza = PizzaFactory.getPizza("pza", 0, orderTime, deliveryTime);
	}

	
}
