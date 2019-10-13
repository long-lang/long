package lel.Serializable2;
//父类实现实现Seializable接口，子类也实现Seializable接口的实验结果
//序列化子类时父类也被序列化.
public class SerializeTest {
	public static void main(String[] args) throws Exception{
		Teacher t = new Teacher();
		SerializeTool.serialize(t,"teacher");
		SerializeTool.printFileInfo("teacher");
	}
}
