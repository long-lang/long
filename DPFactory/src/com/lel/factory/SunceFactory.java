package com.lel.factory;

public class SunceFactory extends Factory{
	public Role createRole() {
		return new SunCe();
	}
}
