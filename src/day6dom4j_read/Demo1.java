package day6dom4j_read;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;


/*
Dom4j解析xml文件

	得到文档数

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
	public static void main(String[] args) throws Exception {
		InputStream iSource=Demo1.class.getResourceAsStream("/day6dom4j_read/2xml解析1.xml");
		//用dom4j读取xml文件得到document对象
		Document document=read1(iSource);
		
		//用document得到所有子节点迭代器，不包括孙节点
		Iterator<Node> it=document.nodeIterator();
		
		
//		while(it.hasNext()){
//			Node node=it.next();//取出子节点
//			System.out.println(node.getName());
//			
//			//取出孙节点……如果是标签节点，才可能有子节点
//			if(node instanceof Element){//判断当前节点是否是标签节点
//				Element element=(Element) node;
//				Iterator<Node> it2=element.nodeIterator();
//				while(it2.hasNext()){
//					Node node2=it2.next();
//					System.out.println(node2.getName());
//				}
//			}
//		}
		
//		readDocument(it);
		
		getElement(document.getRootElement());
		
//		getAttribute(document.getRootElement().element("contact"));
		
//		getTest(document.getRootElement());
		
		StringBuilder sBuilder=new StringBuilder();
//		printXML(document.getRootElement(),sBuilder);
		printXML2(document.getRootElement(), sBuilder);
		System.out.println(sBuilder.toString());
	}
	
	//练习：用Dom4j原封不动的打印出xml文件内容		得到子标签或文本时处理，而不是得到全部文本
	public static void printXML2(Element element,StringBuilder sBuilder) {
		sBuilder.append("<"+element.getName());
		//得到属性
		List<Attribute> attributes = element.attributes();
		for(Attribute attribute:attributes){
			sBuilder.append(" "+attribute.getName()+"=\""+attribute.getValue()+"\"");
		}
		sBuilder.append(">");
		//得到子标签或文本，一部分一部分的拿出文本
		Iterator<Node> nodeIterator = element.nodeIterator();
		while(nodeIterator.hasNext()){
			Node node = nodeIterator.next();
			//标签
			if(node instanceof Element){
				Element e=(Element) node;
				printXML2(e, sBuilder);
			}
			//文本
			if(node instanceof Text){
				Text text=(Text) node;
				sBuilder.append(text.getText());
			}
		}
		sBuilder.append("</"+element.getName()+">");
	}
	
	//练习：用Dom4j原封不动的打印出xml文件内容		存在问题，得到文本时得到的时全部的文本，所有格式不对
	public static void printXML(Element element,StringBuilder sBuilder) {
		sBuilder.append("<"+element.getName());
		//得到属性
		List<Attribute> attributes = element.attributes();
		for(Attribute attribute:attributes){
			sBuilder.append(" "+attribute.getName()+"=\""+attribute.getValue()+"\"");
		}
		sBuilder.append(">");
		//得到标签内容
		String text1 = element.getTextTrim();
//		String text1 = element.getText();
		sBuilder.append(text1);
		//得到子标签
		List<Element> elements = element.elements();	
		for(Element e:elements){
//			String string=element.elementText(e.getName());
			printXML(e,sBuilder);
		}
		sBuilder.append("</"+element.getName()+">");
	}
	
	//得到文本
	public static void getTest(Element element) {
		String text = element.getText();	//得到该标签的文本
		
		String elementText = element.elementText("contact");		//获取当前标签的指定名称的子标签的文本内容
		
		//⚠注意：空格和换行也是xml的内容
		System.out.println("\""+elementText+"\"");
	}
	
	//得到指定标签的属性
	public static void getAttribute(Element element) {
		
		String attributeValue = element.attributeValue("id");	//得到该标签下指定属性名的属性值
		
		Attribute idAttribute = element.attribute("id");	//得到该标签下指定属性名的属性对象
		
		Iterator<Attribute> attributeIterator = element.attributeIterator();	//得到所有属性的迭代器
		
		List<Attribute> attributes = element.attributes();	//得到该标签的所有属性对象
		Iterator<Attribute> iterator = attributes.iterator();
		while(iterator.hasNext()){
			Attribute attribute = iterator.next();
			String name=attribute.getName();		//得到属性
			String value = attribute.getValue();	//得到属性值
			System.out.println(name+":"+value);
		}
		
		
	}
	
	//得到所有标签节点 
	public static void getElement(Element rootElement){
		System.out.println(rootElement.getName());
		
		Element contact=rootElement.element("contact");		//得到rootElement下第一个指定的标签
		
		Iterator<Element> it=rootElement.elementIterator("contact"); //得到当前标签下所有指定名称的标签迭代器		
		
		//得到rootElement下的所有标签	然后取出（3种方式：git,增强for循环，迭代器）
		List<Element> elements = rootElement.elements();		//control+2松开，l
		for(Element element2:elements){
			getElement(element2);
		}
	}
	
	//递归读取所有节点
	public static void readDocument(Iterator<Node> it) {
		while(it.hasNext()){
			Node node=it.next();
			if(node instanceof Attribute){//如果是属性节点
				Attribute attribute=(Attribute) node;
				String name=attribute.getName();
				String value=attribute.getValue();
				System.out.println("属性："+name+"="+value);
			}else if(node instanceof Text){//如果是文本节点
				Text text=(Text) node;
				System.out.println("文本："+text.getStringValue());
			}else if(node instanceof Element){//如果是标签节点
				System.out.println("标签："+node.getName());
				Element element=(Element) node;
				Iterator<Node> it2=element.nodeIterator();
				readDocument(it2);
			}
		}
	}
	
	//用dom4j读取xml文件,得到document对象
	public static Document read1(InputStream iSource) throws DocumentException {
		SAXReader reader=new SAXReader();
		Document document=reader.read(iSource);
		return document;
	}
}
