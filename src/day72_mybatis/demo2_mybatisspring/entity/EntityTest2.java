package day72_mybatis.demo2_mybatisspring.entity;

public class EntityTest2 {
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
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "EntityTest2 [id=" + id + ", name=" + name + "]";
	}
    
    
}