package smm.day59esayui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import smm.day59esayui.tmpentity.ProvinceCity;

@Controller
@RequestMapping("provinceCityAreaController")
public class ProvinceCityAreaController {
	
	@RequestMapping("findCityRequest")
	@ResponseBody
	public Object findCityRequest(String province){
		return this.findCityByProvince(province);
	}

	private Object findCityByProvince(String province) {
		List<ProvinceCity> list=new ArrayList<>();
		if("湖南".equals(province)){
			ProvinceCity provinceCity1 = new ProvinceCity();
			provinceCity1.setCity("长沙");
			ProvinceCity provinceCity2 = new ProvinceCity();
			provinceCity2.setCity("岳阳");
			list.add(provinceCity1);
			list.add(provinceCity2);
		}else if("广东".equals(province)){
			ProvinceCity provinceCity1 = new ProvinceCity();
			provinceCity1.setCity("深圳");
			ProvinceCity provinceCity2 = new ProvinceCity();
			provinceCity2.setCity("中山");
			list.add(provinceCity1);
			list.add(provinceCity2);
		}
		return list;
	}
}
