package book;

public class text {
		public static void main(String[] args) {
			String s = "hello&world&h";
		    String[] info = s.split("&");
			System.out.println(info[0]);
			System.out.println(info[1]);
			System.out.println(info[2]);
		}
}
