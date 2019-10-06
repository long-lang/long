package book;

import java.util.Arrays;
import java.util.List;

public class Bootstrap {
	public static void main(String[] args) {
		List<Person> Persons= Arrays.asList(new Teacher(),new Student());
		for(Person person : Persons) {
			if(person.getClass().equals(Teacher.class)) {
				Person.speak("teacher");
			}
		}
	}
}
 