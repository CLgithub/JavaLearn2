package day10_servlet_e_demo;

/*
3.1 需求分析（需求分析师）
	功能分析：
		1）添加联系人
		2）修改联系人
		3）删除联系人
		4）查询所有联系人
	功能流转
		图……
3.2 需求设计（系统分析师/架构师/资深开发人员）
	1）设计实体（抽象实体）
	联系人实体：
		class Contact{
			private String id;
			private String name;
			private String gender;
			private int age;
			private String phone;
			private String email;
			private String qq;
		}
	2）设计“数据库”，（xml代替"数据库"）
		contact.xml
		<contactList>
			<contact id="1">
				<name>张三</name>
				<gender>男</gender>
				<age>20</age>
				<phone>13433334444</phone>
				<email>zs@qq.com</email>
				<qq>43222222<qq>
			</contact>
		</contactList>
	 3）设计涉及的接口
		DAO接口（数据访问对象）：实体对象的CRUD方法。
		项目原则： 通常一个实体对象就会对应一个DAO接口和一个DAO实现类
			interface ContactDao{
				public void addContact(Contact contact);//添加联系人
				public void updateContact(Contact contact);//修改联系人
				public void deleteContact(String id);//删除联系人
				public List<Contact> findAll();  //查询所有联系人
				public Contact findById(String id);//根据编号查询联系人
			}
	4）设计项目的目录结构
		项目名称： contactSys_web
		目录结构：
		|- contactSys_web
			|-src
				|-gz.cl.contactSys_web.entity : 存放实体对象
				|-gz.cl.contactSys_web.dao : 存放dao的接口
				|-gz.cl.contactSys_web.dao.impl: 存放dao的实现类
				|-gz.cl.contactSys_web.servlet: 存放servlet的类
				|-gz.cl.contactSys_web.test: 存放单元测试类
				|-gz.cl.contactSys_web.util: 存放工具类
				|-gz.cl.contactSys_web.exception: 存放自定义异常类
			|-WebRoot
				|-html文件
				|-images：目录。存放图片资源
				|-css：目录。存放css资源
				|-js：目录。存放js资源

3.3 编码实现（软件开发工程师/攻城狮）
		开发顺序：
			设计数据库-> 实体 -> DAO接口，DAO实现-> Servlet+html页面
3.4 功能测试（测试攻城狮）	
3.5 性能测试（测试攻城狮）
3.6 部署上线（实施攻城狮） 
3.7 维护阶段（实施攻城狮）

*/
public class Demo1 {

}
