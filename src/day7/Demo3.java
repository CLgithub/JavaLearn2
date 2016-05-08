package day7;

import java.io.FileOutputStream;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/*
	写出xml的细节
*/
public class Demo3 {
	public static void main(String[] args) throws Exception {
		Document document=new SAXReader().read(Demo2.class.getResourceAsStream("/day7/xml1.xml"));
		//三、把修改后的document写到指定文件中
		//指定输出到哪个xml文件
		FileOutputStream fos=new FileOutputStream("/Users/L/javaProjectE/javaLearn2/src/day7/Demo3xml2.xml");
		/**
		 * 1.指定一个写出格式
		 */
//		OutputFormat format=OutputFormat.createCompactFormat();		//创建一个Compact（紧凑）的格式		一行	给机器用
		OutputFormat format=OutputFormat.createPrettyPrint();		//创建一个Pretty（漂亮）的格式		有缩紧	给人用
		/**
		 * 2.指定生成的xml文档的编码
		 * 		同时影响了xml保存和声明时的编码
		 */
		format.setEncoding("GBK");
		
		//创建写出对象
		XMLWriter xmlWriter=new XMLWriter(fos,format);
		//写出对象
		xmlWriter.write(document);
		//关闭资源
		xmlWriter.close();
	}
}
