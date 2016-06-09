package day19_2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/*

1.tomcat内置连接池管理
	tomcat内置连接池使用的是dbcp。
	问题1：tomcat怎样管理连接池？（配置）
		要想将一个dbcp连接池让tomcat管理，只需要创建一个context.xml配置文件，在配置文件中配置相关信息
		<Context>
		  	<Resource name="jdbc/jdbc1" auth="Container"
					type="javax.sql.DataSource" username="L" password="123456"
					driverClassName="com.mysql.jdbc.Driver" url="jdbc:mysql:///jdbc1"
					maxActive="8" maxIdle="4"/>
		</Context>
		context.xml文件位置：
			1.放在tomcat/conf/context.xml		这时这个连接池是给整个服务器用
			2.放在tomcat/conf/Catalina/localhost		这时这个连接池只给localhost虚拟主机使用。
			3.放在web应用的META-INF目录下			只给这个应用用
			
			注意：如果是1，和2，我们需要将数据库驱动放在tomcat/lib目录下
		
	问题2:怎样从tomcat中获取连接池?
		在Servlet中获取连接池对象
		Context context = new InitialContext();
		Context envCtx = (Context) context.lookup("java:comp/env");	//固定路径
		DataSource dataSource=(DataSource) envCtx.lookup("jdbc/jdbc1");
		
	JNDI----->	JNDI(java naming and directory interface ,java命名和目录接口)是SUN公司提供的一种标准的Java命名系统接口，
					JNDI提供统一的客户端API，通过不同的访问提供者接口JNDI SPI的实现，由管理者将JNDI API映射为特定的命名服务
					和目录系统，使得Java应用程序可以和这些命名服务和目录服务之间进行交互。目录服务是一种命名服务，
					在这种服务里，对象不但有名称，还有属性。
	

*/
public class Demo1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Context context = new InitialContext();
			Context envCtx = (Context) context.lookup("java:comp/env");	//固定路径
			DataSource dataSource=(DataSource) envCtx.lookup("jdbc/jdbc1");
			//得到连接对象
			Connection connection = dataSource.getConnection();
			ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
			while(resultSet.next()){
				System.out.println(resultSet.getInt("id")+"  "+resultSet.getString("accountName")+"  "+resultSet.getDouble("money"));
			}
			resultSet.close();
			connection.close();//将connection对象重新装入连接池
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
