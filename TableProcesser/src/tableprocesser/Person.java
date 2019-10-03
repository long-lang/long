package tableprocesser;

@Entity("People")
public class Person {
	
	@ID
	@Colum(nullable = false)
	private Integer id;
	
	@Colum(nullable = false, length = 16)
	private String name;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
