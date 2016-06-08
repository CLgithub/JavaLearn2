package day18_transaction;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import day17.Demo2JdbcUtil;

public class MyDataSource implements DataSource{

	private static LinkedList<Connection> linkedList;

	public MyDataSource() {
		linkedList= new LinkedList<>();
		//当创建mydatasource对象时，会向linkedlist对象装入5个connection对象
		for(int i=0;i<5;i++){
			Connection connection=Day18JdbcUtil.getConnect();
			linkedList.add(connection);
		}
	}
	
	//获取连接
	public Connection getConnection() {
		if (linkedList.isEmpty()) {
			for (int i = 0; i < 3; i++) {
				Connection connection = Day18JdbcUtil.getConnect();
				linkedList.add(connection);
			}
		}
		Connection connection = linkedList.removeLast();
		// 使用动态代理来使从myDataSourct中获取的连接对象connection的close()方法不是关闭，而是重新加入myDataSourct连接池中
		Connection proxyCon = (Connection) Proxy.newProxyInstance(connection.getClass().getClassLoader(),
				connection.getClass().getInterfaces(), new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if ("close".equals(method.getName())) {
							// 重新装入自定义连接池
							linkedList.add(connection);
							System.out.println("重新将connection对象装入连接池");
							return null;
						} else {
							return method.invoke(connection, args);
						}
					}
				});
		return proxyCon;
	}
	
	//重新装入
	public void reAddConnection(Connection connection){
		linkedList.addLast(connection);
	}
	
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	
	
}
