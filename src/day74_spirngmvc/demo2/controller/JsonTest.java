package day74_spirngmvc.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import day74_spirngmvc.demo2.entity.ItemsCustom;

/*

JSON数据交互
		依赖jar包
			jackson-core-lgpl-1.2.1.jar
			jackson-mapper-lgpl-1.2.1.jar
		请求json			响应json
		请求key/value	响应json
	
		@requestBody	加在方法行参前
			用于将json格式请求参数contentType=application/json;charaset=utf-8
				转换成controller方法的形参
		@responseBody	加在方法上
			用于将方法的返回值转换长json格式

 */

@RequestMapping("jsonTest")
@Controller
public class JsonTest {
	
	//请求json，响应json
	@RequestMapping("test1")
	@ResponseBody
	public Object test1(@RequestBody ItemsCustom itemsCustom){
		return itemsCustom;
	}
	
	//请求key/value 响应json
	@RequestMapping("test2")
	@ResponseBody
	public Object test2(ItemsCustom itemsCustom){
		return itemsCustom;
	}
}
