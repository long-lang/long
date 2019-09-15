package staticproxy;

public class Bootsrap {
	public static void main(String[] args) {
		Business business = new Business();
		Takeaway takeaway = new Takeaway(business);
		takeaway.speak("  ËÍÍâÂô");
	}

}
