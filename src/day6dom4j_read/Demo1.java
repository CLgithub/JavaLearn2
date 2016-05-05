package day6dom4j_read;

import java.io.InputStream;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;


/*
Dom4j解析xml文件


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
		readDocument(it);
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
