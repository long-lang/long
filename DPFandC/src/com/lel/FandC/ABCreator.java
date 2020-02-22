package com.lel.FandC;

public abstract class ABCreator {
		public Food food;
		public ABCreator() {
			this.food=new Food();
		}
		abstract public void createDrink(); 
		abstract public void createMeal(); 
		public Food getFood() {
			return food;
			
		};
}
