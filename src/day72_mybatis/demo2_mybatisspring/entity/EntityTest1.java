package day72_mybatis.demo2_mybatisspring.entity;

public class EntityTest1 {
	private Integer id;
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

	@Override
	public String toString() {
		return "EntityTest1 [id=" + id + ", name=" + name + "]";
	}

	public EntityTest1(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public EntityTest1() {
	}

}
