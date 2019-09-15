package staticproxy;

public class Takeaway {
	private Business business;
	public Takeaway(Business business) {
		this.business=business;
	}
	public void speak(String message) {
		this.business.speak(message);
	}
}
