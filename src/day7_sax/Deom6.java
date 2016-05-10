package day7_sax;

/*
课程回顾
XML加强
		1）Dom4j修改XML文档
			写出xml文档：
				XMLWriter writer = new XMLWriter()
				writer.wrtite(doc);   

			增加：
				  DocumentHelper.createDocument()  增加新文档
				  Element.addElement("name");  增加子标签
				  Element.addAtrribute（“name”，“value”） 增加属性
			修改：
				   Attribute.setValue("value");  修改属性值
				   Element.setText("value");  修改文本内容
			删除：		
					Element.detach();   删除标签
				    Attribute.detach();  删除属性
				
		2）XPath技术： 快速找到xml元素（标签，属性，文本）
				2.1 dom4j使用xpath：
						List<Node> list = Element.selectNodes("xpath表达式")；		 	多个节点对象
						Node node = Element.selectSingleNode("xpath表达式");         一个节点对象

				xpath表达式：
						/       表示根位置 或者  子标签
						//      表示后代标签（不分层次结构）
						*       表示所有元素
						[ ]      表示条件
						@      表示选择属性
						text()    表示选择文本
						and     表示与条件

		3）SAX解析： 原理： 加载一点，解析一点，处理一点，对内存要求不高！！！（基于事件）
				
				SAXPasser 类：
						parser（File file， DefaultHandler handler）：该方法使用sax解析方式去解析xml文档
					
					DefaultHandler类：重写该类中的一些方法，用于处理xml文档
							startElement( ....  String qName): 读到开始标签时调用
							characterrs(char[] ch,int start,int length);  读到文本内容时调用（包括空格和换行）
							endElement(.....String qName): 读到结束标签时调用


*/
public class Deom6 {

}
