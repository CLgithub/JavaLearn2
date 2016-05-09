package day7_sax;

import java.io.File;
import java.lang.String;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl;

/*
	第一个SAX读取xml文件程序
*/
public class Demo1 {
	public static void main(String[] args) throws Exception {
		//1.创建SAXParser对象
//		SAXParser saxParser=new SAXParserFactoryImpl().newSAXParser();
		SAXParser saxParser=SAXParserFactory.newInstance().newSAXParser();
		
		//2.调用parse方法
		/*
		 * 第一个参数：xml文件
		 * 第二个参数：DefaultHandler的子类
		 */
		saxParser.parse(new File("/Users/L/javaProjectE/javaLearn2/src/day7_sax/Demo1xml1.xml"), new MyDefaultHandler());
	}
}


class MyDefaultHandler extends DefaultHandler {

	/**
	 * 在读到文档开始时调用
	 */
	@Override
	public void startDocument() throws SAXException {
		System.out.println("MyDefaultHandler.startDocument()");
	}

	/**
	 * 读到开始标签时调用 
	 * qName:开始标签名称 
	 * attributes：开始标签包含的属性列表
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("MyDefaultHandler.startElement()-->" + qName);
	}

	/**
	 * 读到结束标签时调用 qName：技术标签名称
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("MyDefaultHandler.endElement()-->" + qName);
	}

	/**
	 * 读到文本内容时调用 
	 * ch:当前读完的所有文本内容 
	 * start：当前需要读取的文本内容开始读取位置 
	 * length:当前需要读取文本内容长度
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("MyDefaultHandler.characters()-->" + new String(ch, start, length));
	}

	/**
	 * 在读到文档结束时调用
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("MyDefaultHandler.endDocument()");
	}
}