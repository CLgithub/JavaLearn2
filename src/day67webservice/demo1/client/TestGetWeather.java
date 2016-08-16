package day67webservice.demo1.client;

import day67webservice.demo1.stub.GlobalWeather;
import day67webservice.demo1.stub.GlobalWeatherSoap;

public class TestGetWeather {
	public static void main(String[] args) {
		//创建服务器访问点集合
		GlobalWeather gWeather=new GlobalWeather();
		//根据服务访问点获得绑定的类 wsdl:portType
		GlobalWeatherSoap serviceClass = gWeather.getGlobalWeatherSoap();
		//调用具体业务逻辑
		String result=serviceClass.getWeather("guiyang", "");
		System.out.println(result);
	}
}
