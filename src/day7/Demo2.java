package day7;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/*
	Dom4J修改xml   + xPath技术  + SAX解析 + XML约束
	
	Dom4j修改xml
	

*/
public class Demo2 {
	public static void main(String[] args) throws Exception {
		//一，读取或创建一个document对象
		//读取原xml文件
		InputStream inputStream = Demo2.class.getResourceAsStream("/day7/xml1.xml");
		SAXReader reader=new SAXReader();
		Document document=reader.read(inputStream);
		
		//二，修改document对象内容
		
		//三、把修改后的document写到指定文件中
		//指定输出到哪个xml文件
		FileOutputStream fos=new FileOutputStream("/Users/L/javaProjectE/javaLearn2/src/day7/xml2.xml");
		//创建写出对象
		XMLWriter xmlWriter=new XMLWriter(fos);
		//写出对象
		xmlWriter.write(document);
		//关闭资源
		xmlWriter.close();
	}
}
