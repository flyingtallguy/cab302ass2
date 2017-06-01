package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;



/**
 * 
 *  A class that represents a margherita pizza made at the Pizza Palace restaurant. 
 *  The margherita pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Person A
 *
 */
public class MargheritaPizza extends Pizza {
	
	String Type;
	Double Price;

	
	/**
	 * 
	 *  This class represents a margherita pizza made at the  Pizza Palace restaurant.   The margherita pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
	 * <P>PRE: TRUE
	 * <P>POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public MargheritaPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		// TO DO
		super(quantity, orderTime, deliveryTime, "Margherita", 8);
		int endOrderTime = 23;
		int startOrderTime = 19;
		int maxOrderTime = 60;
		int maxPizza = 10;
		int minPizza = 1;
		
		int orderTimeHour = orderTime.getHour();
		int orderTimeMinute = orderTime.getMinute();
		int deliveryTimeHour = deliveryTime.getHour();
		int deliveryTimeMinute = deliveryTime.getMinute();
		
		int timeOfOrder = (orderTimeHour * 60) + orderTimeMinute;
		int timeOfDelivery = (deliveryTimeHour * 60) + deliveryTimeMinute;
		
		if(quantity > maxPizza){
			throw new PizzaException();
		}
		else if (quantity < minPizza){
			throw new PizzaException();
		}
		else if (orderTime.getHour() > endOrderTime){
			throw new PizzaException();
		}
		else if(orderTime.getHour() < startOrderTime){
			throw new PizzaException();
		}
		else if ((timeOfDelivery - timeOfOrder) > maxOrderTime){
			throw new PizzaException();
		}
		
	}

}
