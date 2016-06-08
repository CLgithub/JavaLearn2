package day18_transaction;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.junit.Test;

/*
连接池
	连接池是什么，有什么用？
		连接池：创建一个容器，用于装入Connection对象，使用连接对象时，从容器中获取一个Connection对象，
		使用完毕后，再将这个Connection重新装入到容器中，这个容器就是连接池（DataSource）,也叫数据源
	作用：我们可以通过连接池获取连接对象Connection
	优点：节省创建连接与释放连接 性能消耗 ---- 连接池中连接起到复用的作用 ，提高程序性能
	
自定义连接池
		1.创建一个MyDataSource类，在这个类中创建一个LinkedList<Connection>
		2.在其构造方法中初始化List集合，并向其中装入5个Connection对象。
		3.创建一个public Connection getConnection();从List集合中获取一个连接对象返回.
		4.创建一个  public void readd(Connection) 这个方法是将使用完成后的Connection对象重新装入到List集合中.
	代码问题：
		1.连接池的创建是有标准的，javax.sql.DataSource接口
			所有的连接池必须实现这个接口
		2.我们操作时，要使用标准，怎么让connection.close();不是销毁，而是重新放回连接池
			解决：其实本质就是将connection中的close()方法的行为改变（对方法功能进行增强）
				1.继承
				2.装饰模式，详情看javaLearn，com.cl.javabasis.day21other
				3.动态代理
					可以对行为增强
					Proxy.newProxyInstance(classLoacer, class[],InvoactionHandler);
			结论：connection对象如果是从连接池中获取，那么它的close方法的行为已经改变，不是关闭，而是重新装入连接池

*/
public class Demo3 {
	@Test
	public void Test1() throws Exception{
		//创建一个连接池
		DataSource myDataSource=new MyDataSource();
		//获取一个连接对象
		Connection connection = myDataSource.getConnection();
		//操作
		ResultSet resultSet = connection.createStatement().executeQuery("select * from account");
		while(resultSet.next()){
			System.out.println(resultSet.getInt("id")+"  "+resultSet.getString("accountName")+"  "+resultSet.getDouble("money"));
		}
		resultSet.close();
		
		//将连接对象重新转入连接池
//		myDataSource.reAddConnection(connection);
		connection.close();//原本作用是关闭connection对象，我们在使用连接池，获取connection对象后，这个方法就不再是销毁，
						//而是将其重新放回到连接池
	}
}


