package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;

/**
 * 
 *  A class that represents a meat lovers pizza made at the Pizza Palace restaurant. 
 *  The meat lovers pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author PersonA
 *
 */
public class MeatLoversPizza extends Pizza {

	/**
	 * 
	 *  This class represents a meat lovers pizza made at the  Pizza Palace restaurant. The meat lovers pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
 	 * <P> PRE: TRUE
 	 * <P> POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public MeatLoversPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		// TO DO
		super(quantity, orderTime, deliveryTime, "Meat Lovers", 12);
		int endOrderTime = 23;
		int startOrderTime = 19;
		int maxOrderTime = 60;
		int minOrderTime = 10;
		int maxPizza = 10;
		int minPizza = 1;
		
		int orderTimeHour = orderTime.getHour();
		int orderTimeMinute = orderTime.getMinute();
		int deliveryTimeHour = deliveryTime.getHour();
		int deliveryTimeMinute = deliveryTime.getMinute();
		
		int timeOfOrder = (orderTimeHour * 60) + orderTimeMinute;
		int timeOfDelivery = (deliveryTimeHour * 60) + deliveryTimeMinute;
		
		if(quantity > maxPizza){
			throw new PizzaException("No Pizzas were ordered");
		}
		else if (quantity < minPizza){
			throw new PizzaException("Maximum 10 pizzas");
		}
		else if (orderTime.getHour() > endOrderTime){
			throw new PizzaException("No orders past 11pm, Restaurant Closed");
		}
		else if(orderTime.getHour() < startOrderTime){
			throw new PizzaException("No orders before 7pm, Restaurant Closed");
		}
		else if ((timeOfDelivery - timeOfOrder) >= maxOrderTime){
			throw new PizzaException("Delivery time over 1 hour, no longer edible");
		}
		else if((timeOfDelivery - timeOfOrder) < minOrderTime){
			throw new PizzaException("Delivery time under 10 minutes, pizza is raw");
		}
		
	}

}
