package com.lel.FandC;

public class Main {
	public static void main(String[] args) {
		ABCreator cr = new Creator01();
		Waiter waiter = new Waiter();
		waiter.setCr(cr);
		Food food = waiter.construct();
		System.out.println(food);
	}
}
