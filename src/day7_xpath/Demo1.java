package day7_xpath;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/*
问题：当使用dom4j查询比较深的层次结构的节点（标签，属性，文本），比较麻烦！！！

3.2 xPath作用
		主要是用于快速获取所需的节点对象。

		3.3 在dom4j中如何使用xPath技术
			1）导入xPath支持jar包 。  jaxen-1.1-beta-6.jar
			2）使用xpath方法
					List<Node>  selectNodes("xpath表达式");   查询多个节点对象
					Node       selectSingleNode("xpath表达式");  查询一个节点对象
			
		3.4 xPath语法
			/      绝对路径      表示从xml的根位置开始或子元素（一个层次结构）
			//     		       表示不分任何层次结构的选择元素。
			*      通配符         表示匹配所有元素
			[]     条件           表示选择什么条件下的元素	
			@     属性            表示选择属性节点
			and     关系          表示条件的与关系（等价于&&）
			text()    文本           表示选择文本内容
	  3.5 案例
			用户登录功能：
				用户输入用户名和密码 -> 到“数据库”查询是否有对应的用户 -> 
					有： 则表示登录成功
					没有： 则表示登录失败

			用xml当做数据库
					user.xml   用来存储用户的数据

*/
public class Demo1 {
	
	public static void main(String[] args) throws Exception {
		//需求：删除id为2的学生标签
		//读取xml文件的document
		Document document=new SAXReader().read(Demo1.class.getResourceAsStream("/day7_xpath/Demo1xml1.xml"));
		
		//用xpath 查找到id为2的学生
		Element stuElem = (Element) document.selectSingleNode("//Student[@id='2']");
		stuElem.detach();
		
		FileOutputStream fos=new FileOutputStream("/Users/L/javaProjectE/javaLearn2/src/day7_xpath/Demo1xml2.xml");
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(fos,format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
}
