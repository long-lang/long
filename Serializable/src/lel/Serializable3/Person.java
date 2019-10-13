package lel.Serializable3;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name = "simple";
	private Integer age = 15;
	
	public String getName(){
		return this.name;
	}
}
