package day7_sax;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
	读取xml文件，然后完整输出
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		//1.创建SAXParser对象
		SAXParser saxParser=SAXParserFactory.newInstance().newSAXParser();
		//2.调用parse方法
		StringBuilder sBuilder=new StringBuilder();
		saxParser.parse(new File("/Users/L/javaProjectE/javaLearn2/src/day7_sax/Demo1xml1.xml"), new MyDefaultHandler2(sBuilder));
		System.out.println(sBuilder.toString());
		
	}
}

class MyDefaultHandler2 extends DefaultHandler {
	
	StringBuilder sBuilder;
	
	public MyDefaultHandler2(StringBuilder sBuilder) {
		this.sBuilder=sBuilder;
	}

	@Override
	public void startDocument() throws SAXException {
		
	}

	//开始标签
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		sBuilder.append("<"+qName);
		//属性
		for(int i=0;i<attributes.getLength();i++){
			String name = attributes.getQName(i);
			String valeu=attributes.getValue(i);
			sBuilder.append(" "+name+"=\""+valeu+"\"");
		}
		sBuilder.append(">");
	}

	//文本
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		sBuilder.append(new String(ch,start,length));
	}
	
	//结束标签
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		sBuilder.append("</"+qName+">");
	}
	
	@Override
	public void endDocument() throws SAXException {

	}
	
}
