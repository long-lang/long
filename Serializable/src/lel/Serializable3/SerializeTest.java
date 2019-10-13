package lel.Serializable3;
//父类实现Serializable接口，子类没有实现Serializable接口。父类被序列化的情形
//结果只对父类进行序列化
public class SerializeTest {
	public static void main(String[] args) throws Exception{
		Person p = new Person();
		SerializeTool.serialize(p,"person");
		SerializeTool.printFileInfo("person");
	}
}
