package tableprocesser;

public class AnnotationTest {
	public static void main(String[] args) throws Exception {
		TableProessor processor = new TableProessor();
		String sql = processor.process(System.getProperty("user.dir"));
		System.out.println(sql);
	}
}
