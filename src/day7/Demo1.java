package day7;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/*
	回顾：
	xml基础：
		1.xml的作用
			1.1 作为软件配置文件
			1.2作为小型数据库
		2.xml语法（由w3c组织规定）
			标签：
				标签不能以数字开头，中间不能有空格，区分大小写，有且仅有一个根标签
			属性：
				可有多个属性，但属性值必须用引号（单引号或双引号）包含，但不能省略，也不能单双混用
			文档声明：
				<?xml version="1.0" encoding="UTF-8"?>
				version		版本
				encoding	解析xml文档时的编码
				保存xml文档时和解析xml时的编码要保持一直
		3.xml解析
			程序操作xml文档
			两种解析方式：DOM解析，SAX解析
			DOM解析原理，一次性把xml文档加载成Document树，通过Document对象得到节点对象，通过节点对象访问xml文档内容（标签，属性，文本，注释）
			
			Dom4j工具（基于DOM解析原理）
				读取xml文档：
					Document document=new SAXReader().read("xml文件");
				节点：
					Iterator  Element.nodeIterator();  //获取当前标签节点下的所有子节点
				标签：
					Element  Document.getRootElement();			//获取xml文档的根标签		
					Element   ELement.element("标签名");			//指定名称的第一个子标签
					Iterator<Element> Element.elementIterator("标签名");		// 指定名称的所有子标签
					List<Element>	 Element.elements();					//获取所有子标签
				属性：
					String   Element.attributeValue("属性名") 		//获取指定名称的属性值
					Attribute    Element.attribute("属性名")；		//获取指定名称的属性对象	
					Attribute.getName()  //获取属性名称
					Attibute.getValue()  //获取属性值
					List<Attribute>	 Element.attributes();  			//获取所有属性对象
					Iterator<Attribute>		Element.attibuteIterator(); //获取所有属性对象
				文本：
					Element.getText();					//获取当前标签的文本
					Element.elementText("子标签名");		//获取当前标签的指定名称的子标签的文本内容
		
*/
public class Demo1 {

}
