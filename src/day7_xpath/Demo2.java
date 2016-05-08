package day7_xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/*
	学习xpath的语法
*/
public class Demo2 {
	public static void main(String[] args) throws Exception {
		//读取xml文件的document
		Document document=new SAXReader().read(Demo1.class.getResourceAsStream("/day7_xpath/Demo2xml1.xml"));
		
		String xpath="";
		
		//1		/
		xpath="/contactList";			//
		xpath="/contactList/contact";	//所有contactList下的contact标签对象
		
		//2 	//
		xpath="//contact/name";		//所有contact标签下的name标签对象
		xpath="//name";				//所有的name标签对象
		
		//3		*	通配符
		xpath="/contactList/*";		//根标签contactList下所有子标签对象
		xpath="/contactList//*";	//根标签contactList下所有标签对象
		
		//4		[]	条件
		xpath="//contact[@id]";		//带有id属性的contact标签对象
		xpath="//contact[1]";		//选取第一个contact标签对象
		xpath="//contact[last()]";		//选取最后一个contact标签对象
		
		//5		@	属性
		xpath="//@id";						//所有的id属性对象
		xpath="//*[not(@id)]";				//所有的不包含id属性的标签对象
		
		xpath="//contact[@id='003']";			//选取id属性时为003的contact标签对象
		
		//6		and		并且
		xpath="//contact[@id='001' and @name='xxx']";		//选取id属性为001，且name属性为xxx的contact标签对象
		
		//7		text()	文本
		xpath="//name/text()";		//name标签下的文本对象
		xpath="//contact[name/text()='张三']";			//选择姓名为张三的contact标签
		
		
		
		
		List<Node> nodes = document.selectNodes(xpath);
		for(Node node:nodes){
			System.out.println(node);
		}
		
	}
}
