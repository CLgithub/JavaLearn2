package smm.day59esayui.tmpentity;

/**
 * 临时实体，封装省份和城市
 * @author L
 * @date 2016年7月14日
 */
public class ProvinceCity {
	private String province;
	private String city;

	public ProvinceCity() {
	}

	public ProvinceCity(String province, String city) {
		this.province = province;
		this.city = city;
	}

	@Override
	public String toString() {
		return "ProvinceCity [province=" + province + ", city=" + city + "]";
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
