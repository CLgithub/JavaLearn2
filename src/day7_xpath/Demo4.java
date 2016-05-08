package day7_xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;

/*
	使用xpath技术读取一个规范的html文档
	爬虫抓起页面后，就可用用这个分析
 */
public class Demo4 {
	public static void main(String[] args) throws Exception {
		Document document=new SAXReader().read(Demo3.class.getResourceAsStream("/day7_xpath/personList.html"));

		//读取title标签
		String xpath="//title";
		Element titleE = (Element) document.selectSingleNode(xpath);
		System.out.println("标题:"+titleE.getText());
		//需求：读取练习人信息，按照指定格式输出：
		
		//确定有多少个联系人
		xpath="//tr";
		List<Node> nodes = document.selectNodes(xpath);
		for(int i=1;i<nodes.size();i++){
			Element element=(Element) nodes.get(i);
			Student student = new Student();
			student.id=Integer.parseInt(element.elements().get(0).getText());
			student.age=Integer.parseInt(element.elements().get(3).getText());
			student.name=element.elements().get(1).getText();
			student.gender=element.elements().get(2).getText();
			student.address=element.elements().get(4).getText();
//			student.phoneN=element.elements().get(5).getText();
			student.phoneN=element.selectSingleNode("td[6]").getText();
			
			System.out.println(student);
		}
		
	}
}

class Student{
	int id,age;
	String name,gender,address,phoneN;
	
	@Override
	public String toString() {
		return "[id=" + id + ", age=" + age + ", name=" + name + ", gender=" + gender + ", address=" + address
				+ ", phoneN=" + phoneN + "]";
	}
	
	
}
