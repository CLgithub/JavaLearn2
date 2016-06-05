package day19;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;


import day17.Demo2JdbcUtil;

/*
	元数据：
		在jdbc中获取数据库的定义，例如：数据库，表，列的定义信息，就用到元数据
		在jdbc中可以使用：数据库元数据，参数元数据，结果集元数据
		元数据定义相关api：xxxxMetaData
		
*/
public class Demo2 {
	
	//数据库元数据
	@Test
	public void test1() throws SQLException{
		//获取连接
		Connection connect = Demo2JdbcUtil.getConnect();
		DatabaseMetaData metaData = connect.getMetaData();
		
		System.out.println("数据库用户名："+metaData.getUserName());
		System.out.println("数据库URL："+metaData.getURL());
		
		Demo2JdbcUtil.closeC(connect, null);
	}
	
	//参数元数据
	@Test
	public void test2() throws Exception {
		Connection connect = Demo2JdbcUtil.getConnect();
		String sql="select * from student where id=? or name=?";
		Object[] values={"3","小明"};
		PreparedStatement pStatement = connect.prepareStatement(sql);
		//获取参数元数据
		ParameterMetaData parameterMetaData = pStatement.getParameterMetaData();
		//获取参数的个数
		int i = parameterMetaData.getParameterCount();
		System.out.println("参数个数："+i);
		
		Demo2JdbcUtil.closeC(connect, null);
	}

	//结果集元数据
	@Test
	public void test3() throws Exception {
		Connection connect = Demo2JdbcUtil.getConnect();
		String sql="select * from student";
		PreparedStatement pStatement = connect.prepareStatement(sql);
		ResultSet resultSet = pStatement.executeQuery();
		//获取结果集元数据
		ResultSetMetaData metaData = resultSet.getMetaData();
		while (resultSet.next()) {
			//通过结果集元数据，得到列的个数名称
			int count = metaData.getColumnCount();		//得到列的个数
			for (int i = 0; i < count; i++) { // 循环得到列的名称
				String columnName = metaData.getColumnName(i + 1);
				Object object = resultSet.getObject(columnName);
				System.out.print(columnName + "=" + object.toString()+",");
			}
			System.out.println();
		}
		Demo2JdbcUtil.closeC(connect, null);
	}

	
}
