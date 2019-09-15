package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public  class Takeaway implements InvocationHandler {
	private Object Business;
	public Takeaway(Object Business) {
		this.Business=Business;
	}
	public Object invoke(Object proxy,Method method,Object[]args)
			throws Throwable{
		method.invoke(this.Business,args);
		return null;
	}
}
