package day7;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
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
	
	/**
	 * 修改：属性值，文本
	 * @throws Exception
	 * @author L
	 * @date 2016年5月8日
	 */
	@Test
	public void test2() throws Exception{
		Document document=new SAXReader().read(Demo2.class.getResourceAsStream("/day7/xml1.xml"));
		
		//修改属性值,方案一：1得到标签，2得到属性对象，修改属性值
		Attribute idAttribute = document.getRootElement().element("contact").attribute("id");
		idAttribute.setValue("002");
		//修改属性值,方案二：1得到标签，通过添加同名属性修改属性值
//		document.getRootElement().element("contact").addAttribute("id", "004");
		
		//修改文本：1得到标签，修改文本
		Element nameE = document.getRootElement().element("contact").element("name");
		nameE.setText("小明");
		
		//三、把修改后的document写到指定文件中
		FileOutputStream fos=new FileOutputStream("/Users/L/javaProjectE/javaLearn2/src/day7/Demo4xml2.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(fos,format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	/**
	 * 删除：标签，属性
	 * @author L
	 * @date 2016年5月8日
	 */
	@Test
	public void test3() throws Exception{
		Document document=new SAXReader().read(Demo2.class.getResourceAsStream("/day7/xml1.xml"));
		
		//删除标签:1得到标签对象，2删除标签对象
//		Element ageElement = document.getRootElement().element("contact").element("age");
//		ageElement.detach();
//		Element contactElement = document.getRootElement().element("contact");
//		contactElement.remove(contactElement.element("age"));
		
		//删除属性 1得到标签，2得到属性对象，3删除属性
		Element contactE = document.getRootElement().elements().get(1);
		contactE.attribute("id").detach();
//		contactE.remove(contactE.attribute("id"));
		
		//三、把修改后的document写到指定文件中
		FileOutputStream fos=new FileOutputStream("/Users/L/javaProjectE/javaLearn2/src/day7/Demo4xml3.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(fos,format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	/**
	 * 练习，使用dom4j
	 * 1.生成xml文件
	 * <Students>
	 * 	<Student id="1">
	 * 		<name>小明</name>
	 * 		<gender>男</gender>
	 * 	</Student>
	 * 	<Student id="2">
	 * 		<name>小红</name>
	 * 		<gender>女</gender>
	 * 	</Student>
	 * <Students>
	 * 2.修改iid为2的学生的姓名
	 * 3，删除id为2的学生
	 */
	@Test
	public void test4() throws Exception{
		Document document=DocumentHelper.createDocument();
		
		Element StudentsE = document.addElement("Students");
		Element student1 = StudentsE.addElement("Student");
		student1.addAttribute("id", "1");
		student1.addElement("name").addText("小明");
		student1.addElement("gender").addText("男");
		
		Element student2 = StudentsE.addElement("Student");
		student2.addAttribute("id", "2");
		student2.addElement("name").addText("小红");
		student2.addElement("gender").addText("女");
		
		//修改iid为2的学生的姓名	删除id为2的学生
		List<Element> elements = document.getRootElement().elements();
		for(int i=0;i<elements.size();i++){
			if(elements.get(i).attribute("id").getValue().equals("2")){
				elements.get(i).element("name").setText("小红2");
				elements.get(i).detach();
			}
		}
		
		FileOutputStream fos=new FileOutputStream("/Users/L/javaProjectE/javaLearn2/src/day7/Demo4xml4.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(fos,format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
}
