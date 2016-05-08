package day7;

import java.io.FileOutputStream;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/*
	修改xml内容
	增加：文档，标签，属性
	修改：属性值，文本
	删除：标签，属性
*/
public class Demo4 {
	
	/**
	 * 增加：标签，属性
	 * @author L
	 * @throws Exception 
	 * @date 2016年5月8日
	 */
	@Test
	public void test1() throws Exception{
		//1，创建一个文档
		Document document = DocumentHelper.createDocument();
		
		//2.增加一个标签
		Element rootElement = document.addElement("contactList");
		Element contactE = rootElement.addElement("contact");
		Element nameE = contactE.addElement("name");

		//添加属性
		contactE.addAttribute("id", "001");
		contactE.addAttribute("name", "小明");
		
		//二，修改document对象内容
		
		//三、把修改后的document写到指定文件中
		FileOutputStream fos=new FileOutputStream("/Users/L/javaProjectE/javaLearn2/src/day7/Demo4xml1.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(fos,format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
}
