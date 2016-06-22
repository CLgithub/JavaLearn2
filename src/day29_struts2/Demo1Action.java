package day29_struts2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/*
struts2快速入门
	以前：		index.jsp--->Demo1Servlet--->demo1.jsp
	struts2：	index.jsp--->Demo1Action--->demo1.jsp
	
	1.导包
		注意:在struts2开发，一般情况下最少导入的jar包，去apps下的struts2-blank示例程序中copy
	2.创建struts2Demo1.jsp页面
	3.对struts2框架进行配置
		1.web.xml文件中配置前端控制器（核心控制器）---就是一个filter
			让struts2框架可以运行
		2.创建一个struts.xml配置文件，这个是struts2框架配置文件
	4.创建一个Demo1Action类
		类中创建一个返回值是String类型的方法，注意，无参数
	5.在struts.xml中配置
		<package name="default" namespace="/" extends="struts-default">
			<action name="demo1" class="day29_struts2.Demo1Action" method="say" >
				<result name="good">/demo1.jsp</result>
			</action>
		</package>
	
*/

public class Demo1Action extends ActionSupport {
	
	public String say(){
		return this.SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}
}
