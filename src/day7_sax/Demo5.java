package day7_sax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/*
	作业：
	设计一个通讯录程序
			联系人： 编号  姓名  性别  年龄  电话  QQ 邮箱
			功能要求：
				添加联系人
				修改联系人
				删除联系人
				查询所有联系人
			
		要求： 
		1）交互使用console（控制台）	
		2）数据存储到xml文件（作为“数据库”）（使用dom4j）
		
		提示：
		启动程序
				================
				【1】添加联系人
				【2】修改联系人
				【3】删除联系人
				【4】查询所有联系人
				【Q】退出程序
				==================
		输入 1：
				请输入编号：
				请输入姓名：
				请输入年龄
			   。。。。
				添加成功！  -> 数据保存在xml中

	 	输入2
				。。。。。。
		输入4
				编号  姓名   年龄  。。。。
				001	  张三  30
				002   李四  20 。。。
				。。。。。
*/
public class Demo5 {
	public static void main(String[] args) throws Exception {
		BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
		File xml=new File("e:/clProject/javaLearn2/src/day7_sax/Demo5xml1.xml");
		Document document=null;
		if(!xml.exists()){
			document = DocumentHelper.createDocument();
			document.addElement("contactList");
			saveXML(xml, document);
		}else {
			document=new SAXReader().read(xml);
		}
		
		boolean b=true;
		while(b){
			//提示用户选择功能
			System.out.println("请选择功能：");
			System.out.println("[1]添加联系人");
			System.out.println("[2]修改联系人");
			System.out.println("[3]删除联系人");
			System.out.println("[4]查询所有联系人");
			System.out.println("[Q]退出程序");
			//根据用户选择的功能进行相应的出来
			String str = bReader.readLine();
			if("1".equals(str)){
				//添加联系人
				addC(bReader,xml,document);
			}else if("2".equals(str)){
				//修改联系人
				updateC(bReader,xml,document);
			}else if("3".equals(str)){
				//删除联系人
				deleteC(bReader,xml,document);
			}else if("4".equals(str)){
				//查询联系人
				selectC(bReader,document);
			}else if("q".equalsIgnoreCase(str)){
				b=false;
			}else {
				System.out.println("输入有误，请重新输入");
			}
			//循环
		}
		bReader.close();
	}

	/**
	 * 添加联系人
	 * @author L
	 * @date 2016年5月10日
	 * @param bReader
	 * @param document 
	 * @throws Exception 
	 */
	private static void addC(BufferedReader bReader,File xml, Document document) throws Exception {
		//得到对象
		Contact contact=new Contact();
		System.out.println("请输入联系人姓名");
		contact.setName(bReader.readLine());
		System.out.println("请输入联系人年龄");
		contact.setAge(bReader.readLine());
		System.out.println("请输入联系人电话");
		contact.setPhone(bReader.readLine());
		System.out.println("请输入联系人邮箱");
		contact.setEmail(bReader.readLine());
		System.out.println("请输入联系人qq");
		contact.setQq(bReader.readLine());
		//存储对象
		saveCDao(contact,xml,document);
	}

	/**
	 * 查询联系人
	 * @author L
	 * @date 2016年5月10日
	 * @param bReader
	 * @param document 
	 * @throws Exception 
	 */
	private static List<Contact> selectC(BufferedReader bReader, Document document) throws Exception {
		List<Contact> list=new ArrayList<>();
		List<Node> contacts = document.selectNodes("/contactList/contact");
		for(Node c:contacts){
			Contact contact=new Contact();
			Element element=(Element) c;
			contact.setId(element.attributeValue("id"));
			contact.setName(element.element("name").getText());
			contact.setAge(element.element("age").getText());
			contact.setPhone(element.element("phone").getText());
			contact.setEmail(element.element("email").getText());
			contact.setQq(element.element("qq").getText());
			list.add(contact);
		}
		for(Contact contact:list){
			System.out.println(contact);
		}
		return list;
		
	}

	/**
	 * 修改联系人
	 * @author L
	 * @date 2016年5月10日
	 * @param bReader
	 * @param document 
	 * @throws Exception 
	 */
	private static void updateC(BufferedReader bReader,File xml, Document document) throws Exception {
		System.out.println("请输入要修改的联系人id");
		String id = bReader.readLine();
		Element node = (Element) document.selectSingleNode("/contactList/contact[@id="+id+"]");
		if (null!=node) {
			System.out.println("请输入新姓名");
			node.element("name").setText(bReader.readLine());
			System.out.println("请输入新年龄");
			node.element("age").setText(bReader.readLine());
			System.out.println("请输入新电话");
			node.element("phone").setText(bReader.readLine());
			System.out.println("请输入新邮件");
			node.element("email").setText(bReader.readLine());
			System.out.println("请输入新qq");
			node.element("qq").setText(bReader.readLine());
			saveXML(xml, document);
		}else {
			System.out.println("没有该联系人");
		}
	}

	/**
	 * 删除联系人
	 * @author L
	 * @date 2016年5月10日
	 * @param bReader
	 * @param document 
	 * @throws Exception 
	 */
	private static void deleteC(BufferedReader bReader,File xml, Document document) throws Exception {
		System.out.println("请输入要删除的联系人id");
		String id = bReader.readLine();
		Element node = (Element) document.selectSingleNode("/contactList/contact[@id="+id+"]");
		if (null!=node) {
			node.detach();
			saveXML(xml, document);
		}else {
			System.out.println("没有该联系人");
		}
	}
	
	//存储联系人到xml
	private static void saveCDao(Contact contact,File xml, Document document) throws Exception {
		Integer id=1;
		List<Node> contacts = document.selectNodes("/contactList/contact");
		if(contacts.size()!=0){
			Element elementC=(Element) contacts.get(contacts.size()-1);
			id=1+Integer.parseInt(elementC.attributeValue("id"));
		}
		Element contactElement=document.getRootElement().addElement("contact");
		contactElement.addAttribute("id", id.toString());
		contactElement.addElement("name").addText(contact.getName());
		contactElement.addElement("age").addText(contact.getAge());
		contactElement.addElement("phone").addText(contact.getPhone());
		contactElement.addElement("email").addText(contact.getEmail());
		contactElement.addElement("qq").addText(contact.getQq());
		
		saveXML(xml, document);
	
	}

	private static void saveXML(File xml, Document document)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(new FileOutputStream(xml),format);
		xmlWriter.write(document);
		xmlWriter.close();
		System.out.println("操作成功");
	}

}
/*

+-------+-------------------------------+---------------------------------------+---------------------------+
|		|标签							|属性									|文本						|
+-------+-------------------------------+---------------------------------------+---------------------------+
|增		|Element.addElement("标签名")	|Element.addAtrribute("name","value")	|/							|
+-------+-------------------------------+---------------------------------------+---------------------------+
|删		|Element.detach()				|Attribute.detach()						|/							|
+-------+-------------------------------+---------------------------------------+---------------------------+
|改		|/								|Attribute.setValue("value");修改属性值	|Element.setText("value");	|
+-------+-------------------------------+---------------------------------------+---------------------------+


*/
