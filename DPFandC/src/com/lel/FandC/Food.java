package com.lel.FandC;

public class Food {
	private Drink drink;
	private Meal  meal;
	public Drink getDrink() {
		return drink;
	}
	public void setDrink(Drink drink) {
		this.drink = drink;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	
	public String toString() {
		return this.drink.toString()+this.meal.toString();
	}

}
