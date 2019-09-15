package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Bootsrap {
	public static void main(String[] args) {
		Business business = new Business();
		 InvocationHandler handler = new Takeaway(business);
		Meituan InvotionHandler =(Meituan)Proxy.newProxyInstance(
				Meituan.class.getClassLoader(),new Class[] {Meituan.class}, handler);
		InvotionHandler.Speak("Õ‚¬Ù");
	}

}
