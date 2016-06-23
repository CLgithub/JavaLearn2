package day30_struts2;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2MapAction extends ActionSupport {

	private Map<String, User> map;

	public Map<String, User> getMap() {
		return map;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(map);
		return NONE;
	}

}
