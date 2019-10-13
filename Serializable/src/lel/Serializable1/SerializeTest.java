package lel.Serializable1;
//父类没实现Seializable接口，子类实现Seializable接口的实验结果
//序列子类时只序列子类不序列父类

public class SerializeTest {
	public static void main(String[] args) throws Exception{
		Teacher t = new Teacher();
		SerializeTool.serialize(t,"teacher");
		SerializeTool.printFileInfo("teacher");
	}
}
