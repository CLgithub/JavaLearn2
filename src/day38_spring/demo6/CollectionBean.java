package day38_spring.demo6;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class CollectionBean {
	private List<String> list1;
	private Set<Integer> set1;
	private Map<String, Integer> map1;
	private Properties properties1;

	public Properties getProperties1() {
		return properties1;
	}

	public void setProperties1(Properties properties1) {
		this.properties1 = properties1;
	}

	public Map<String, Integer> getMap1() {
		return map1;
	}

	public void setMap1(Map<String, Integer> map1) {
		this.map1 = map1;
	}

	public Set<Integer> getSet1() {
		return set1;
	}

	public void setSet1(Set<Integer> set1) {
		this.set1 = set1;
	}

	public List<String> getList1() {
		return list1;
	}

	public void setList1(List<String> list1) {
		this.list1 = list1;
	}

	@Override
	public String toString() {
		return "CollectionBean [list1=" + list1 + ", set1=" + set1 + ", map1=" + map1 + ", properties1=" + properties1
				+ "]";
	}

}
