package day7_xpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/*
	用户登录功能：
			用户输入用户名和密码 -> 到“数据库”查询是否有对应的用户 -> 
					有： 则表示登录成功
					没有： 则表示登录失败

			用xml当做数据库
					user.xml   用来存储用户的数据
*/
public class Demo3 {
	public static void main(String[] args) throws Exception {
		BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
		boolean b=true;
		while(b){
			//提示用户输入用户名
			System.out.println("请输入登陆用户名");
			String name = bReader.readLine();
			//提示用户输入密码
			System.out.println("请输入登陆密码");
			String password = bReader.readLine();
		
			//判断是否登陆成功
			//读取xml数据库信息document对象
			Document document=new SAXReader().read(Demo3.class.getResourceAsStream("/day7_xpath/user.xml"));
			//查询是否有该用户，并返回查询信息
			String xpath="//user[@name='"+name+"' and @password='"+password+"']";
			Node userNode = document.selectSingleNode(xpath);
			if(null!=userNode){
				System.out.println("登陆成功");
			}else {
				System.out.println("登陆失败");
			}
		}
		bReader.close();
	}
}
