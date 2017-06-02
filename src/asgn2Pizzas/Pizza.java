package asgn2Pizzas;

import java.time.LocalTime;
import java.util.ArrayList;

import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Person A
 *
 */
public abstract class Pizza  {
	
	private int quantity;
	
	private LocalTime orderTime;
	private LocalTime deliveryTime;
	private String type;
	private double price;
	private double cost;
	private double totalPrice = 0;
	private double totalCost = 0;
	private double orderProfit = 0;

	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 * 
	 */
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
		// TO DO
		
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
		
		
		this.quantity = quantity;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.type = type;
		this.price = price;
		
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
		else if(type.equals("Margherita") == false && type.equals("Vegetarian") == false && type.equals("Meat Lovers") == false){
			throw new PizzaException("Invalid pizza type");
		}
		// delivery time cut off is 23
		// order time of 21:52 / 9:52
		// delivery time of 22:07 / 10:07
		// so the delivery took 15 minutes and is within the bounds
		// so i need to throw exception if orderTime + the time of delivery > 1 hour
		// timeOfORder = 21:52 = 21 * 60 + 52 = 1312
		// timeOfDeilvery = 22:07 = 22 * 60 + 07 = 1327
		// if timeOfDelivery - timeOfOrder > 60

		
	}


	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		// TO DO
		if(type.equals("Margherita")){
			this.cost = PizzaTopping.CHEESE.getCost() + PizzaTopping.TOMATO.getCost();
		}
		else if(type.equals("Vegetarian")){
			this.cost = PizzaTopping.TOMATO.getCost() + PizzaTopping.CHEESE.getCost() + PizzaTopping.EGGPLANT.getCost()
			+ PizzaTopping.MUSHROOM.getCost() + PizzaTopping.CAPSICUM.getCost();
		}
		else if(type.equals("Meat Lovers")){
			this.cost = PizzaTopping.TOMATO.getCost() + PizzaTopping.CHEESE.getCost() + PizzaTopping.BACON.getCost()
			+ PizzaTopping.PEPPERONI.getCost() + PizzaTopping.SALAMI.getCost();
		}
	}

	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		// TO DO
		calculateCostPerPizza();
		return cost;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		// TO DO
		return price;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		// TO DO
		calculateCostPerPizza();
		totalCost = cost * quantity;
		return totalCost;
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		// TO DO
		totalPrice = price * quantity;
		return totalPrice;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		// TO DO
		getOrderPrice();
		getOrderCost();
		orderProfit = totalPrice - totalCost;
		return orderProfit;
		
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){
		// TO DO
		if(type == "Margherita" && (topping == PizzaTopping.CHEESE || topping == PizzaTopping.TOMATO)){
			return true;
		}
		else if(type == "Vegetarian" && (topping == PizzaTopping.CHEESE || topping == PizzaTopping.TOMATO
				|| topping == PizzaTopping.EGGPLANT || topping == PizzaTopping.MUSHROOM || topping == PizzaTopping.CAPSICUM)){
			return true;
		}
		if(type == "Meat Lovers" && (topping == PizzaTopping.CHEESE || topping == PizzaTopping.TOMATO
				|| topping == PizzaTopping.BACON || topping == PizzaTopping.PEPPERONI || topping == PizzaTopping.SALAMI)){
			return true;
		} else {
			return false;
		}
	}	
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		// TO DO
		return quantity;
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		// TO DO
		return type;
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}

	
}
