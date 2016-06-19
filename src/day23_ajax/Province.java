package day23_ajax;

import java.util.List;

public class Province {
	private int id;
	private String name;
	private List<City> citys;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	public Province() {
	}

	public Province(int id, String name, List<City> citys) {
		this.id = id;
		this.name = name;
		this.citys = citys;
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", name=" + name + ", citys=" + citys + "]";
	}

}
