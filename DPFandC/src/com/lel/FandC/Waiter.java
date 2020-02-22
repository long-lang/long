package com.lel.FandC;



public class Waiter {
		private ABCreator cr;

		public void setCr(ABCreator cr) {
			this.cr = cr;
		}
		
		public Food construct() {
			cr.createDrink();
			cr.createMeal();
			return cr.getFood();
			
		}
		
}
