package stringbulidertext;

public class StringBuliderText {
	static String s = "abc";
	static StringBuilder s1 = new StringBuilder();
	public static void  text1(Object s) {
		for (int i = 0; i < 100000; i++) {
			s = s + "a";
	
		}
	}
	public static void  text2(Object s) {
		s1.append("abc");
		for (int i = 0; i < 100000; i++) {
		s1.append("a");
	
		}
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		//用毫秒表示给String赋值前的时间
		System.out.println(start);
		text1(s);
		long end = System.currentTimeMillis();
		//用毫秒表示给String赋值后的时间
		System.out.println(end);
		long diff = end - start;
		//计算用String给s赋值所使用的时间
		System.out.println("the String method uses time is: " + diff);
		long start1 = System.currentTimeMillis();
		//用毫秒表示给StringBuilder赋值前的时间
		System.out.println(start1);
		text2(s1);
		long end1 = System.currentTimeMillis();
		//用毫秒表示给StringBuilder赋值前的时间
		System.out.println(end1);
		long diff1 = end1 - start1;
		//计算用StringBuilder给s1赋值的时间
		System.out.println("the StringBuilder method uses time is: " + diff1);
	}
}