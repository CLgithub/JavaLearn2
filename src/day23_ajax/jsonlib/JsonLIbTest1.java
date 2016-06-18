package day23_ajax.jsonlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import day23_ajax.Product;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JsonLIbTest1 {
	//将数组转换成json
	@Test
	public void fun1(){
		String[] strings={"aaa","bbb","ccc"};
		String string = JSONArray.fromObject(strings).toString();
		System.out.println(string);
	}
	
	//将list集合转换成json
	@Test
	public void fun2(){
		List<String> list=new ArrayList<>();
		list.add("aaa");
		list.add("111");
		list.add("bbb");
		list.add("333");
		String string = JSONArray.fromObject(list).toString();
		System.out.println(string);
	}
	
	//将javaBean转换成json
	@Test
	public void fun3(){
		Product product=new Product(1, "微波炉", 1000);
//		String json = JSONArray.fromObject(product).toString();
		String json = JSONObject.fromObject(product).toString();
		System.out.println(json);
	}
	
	//如果list里装的是javabean
	@Test
	public void fun4(){
		List<Product> productList=new ArrayList<>();
		productList.add(new Product(1, "洗衣机", 3200));
		productList.add(new Product(2, "手机", 3200));
		productList.add(new Product(3, "macBookPro", 16200));
		productList.add(new Product(4, "电冰箱", 3700));
		productList.add(new Product(5, "电视", 5200));
		
		JsonConfig config=new JsonConfig();
		config.setExcludes(new String[]{"type"});		//Exclude	拒绝…参加
		
		String json = JSONArray.fromObject(productList,config).toString();
		System.out.println(json);
		
	}
	
	//将map集合转换成json
	@Test
	public void fun5(){
		Map<String, String> map=new HashMap<>();
		map.put("001", "aaa");
		map.put("002", "bbb");
		map.put("003", "ccc");
		map.put("004", "ddd");
		String json = JSONObject.fromObject(map).toString();
		System.out.println(json);
	}
	
}
