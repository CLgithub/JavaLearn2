package day19_2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
元数据
	什么是元数据。又什么作用
		元数据（metaData）指数据中 库、表、列的定义信息
	1.DataBaseMetaData		数据库元数据
		问题:怎样获取一个DataBaseMetaData?
			DatabaseMetaData dMetaData = connection.getMetaData();
		问题：常用api
			数据库驱动名：		dMetaData.getDriverName()
			数据库url：		dMetaData.getURL()
			数据库用户名：		dMetaData.getUserName()
			数据库产品名称：	dMetaData.getDatabaseProductName()
			数据库产品版本：	dMetaData.getDatabaseProductVersion()
			
			获取表中主键相关描述		每个主键列描述都有以下列：
				TABLE_CAT String => 表类别（可为 null） 
				TABLE_SCHEM String => 表模式（可为 null） 
				TABLE_NAME String => 表名称 
				COLUMN_NAME String => 列名称 
				KEY_SEQ short => 主键中的序列号（值 1 表示主键中的第一列，值 2 表示主键中的第二列）。 
				PK_NAME String => 主键的名称（可为 null）
			
	2.ParameterMetaData		参数元数据
		参数元数据主要用于获取:sql语句中占位符的相关信息.
		问题:怎样获取ParameterMetaData?
			在PreparedStatement中有一个方法getParameterMetaData可以获取.
			
			
	3.ResultSetMetaData		结果集元数据
		问题:怎样获取结果集元数据?
			可以通过ResultSet的getMetaData()方法获取.

*/
public class Demo2 {
	
	//数据库元数据		DataBaseMetaData		
	@Test
	public void test1() throws Exception{
		//得到数据源
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		//得到连接
		Connection connection = cpds.getConnection();
		//得到元数据
		DatabaseMetaData dMetaData = connection.getMetaData();
		//
//		System.out.println("数据库驱动名："+dMetaData.getDriverName());
//		System.out.println("数据库url："+dMetaData.getURL());
//		System.out.println("数据库用户名："+dMetaData.getUserName());
//		System.out.println("数据库产品名称："+dMetaData.getDatabaseProductName());
//		System.out.println("数据库产品版本："+dMetaData.getDatabaseProductVersion());
		
		ResultSet resultSet = dMetaData.getPrimaryKeys(null, null, "account");		//获取表中主键相关描述
		while(resultSet.next()){
			System.out.println("表类别:"+resultSet.getString("TABLE_CAT"));
			System.out.println("表表模式:"+resultSet.getString("TABLE_SCHEM"));
			System.out.println("表名称:"+resultSet.getString("TABLE_NAME"));
			System.out.println("列名称:"+resultSet.getString("COLUMN_NAME"));
			System.out.println("主键中的序列号:"+resultSet.getShort("KEY_SEQ"));
			System.out.println("主键的名称:"+resultSet.getString("PK_NAME"));
		}
	}
	
	//参数元数据	ParameterMetaData
	@Test
	public void test2() throws Exception{
		//得到数据源
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc1"
				+ "?generateSimpleParameterMetadata=true");
		//得到连接
		Connection connection = cpds.getConnection();
		String sql="select * from account where id=? or accountName=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, 1);
		pStatement.setString(2, "bbb");
		
		//获得参数元数据
		ParameterMetaData pMetaData = pStatement.getParameterMetaData();
		int count = pMetaData.getParameterCount();
		System.out.println("参数个数："+count);
		for(int i=0;i<count;i++){
			String typeName = pMetaData.getParameterTypeName(i+1);	//获取参数类型时会参数异常，解决方案：在url后添加参数generateSimpleParameterMetadata=true
			System.out.println(typeName);		//mysql支持不好，全是varchar，
		}
	}
	
	//结果集元数据	ResultSetMetaData
	@Test
	public void test3() throws Exception{
		//得到数据源
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc1"
				+ "?generateSimpleParameterMetadata=true");
		//得到连接
		Connection connection = cpds.getConnection();
		String sql="select * from account where id=? or accountName=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, 1);
		pStatement.setString(2, "bbb");
		ResultSet resultSet = pStatement.executeQuery();
		//获得参数元数据
		ResultSetMetaData rSetMetaData = resultSet.getMetaData();
		int count = rSetMetaData.getColumnCount();		//得到列的个数
		for (int i = 0; i < count; i++) {
			String typeName = rSetMetaData.getColumnTypeName(i+1);
			System.out.print(rSetMetaData.getColumnName(i+1)+"("+typeName+")"+"\t");
		}
		System.out.println();
		while(resultSet.next()){
			for (int i = 0; i < count; i++) {
				Object object = resultSet.getObject(i+1);
				System.out.print(object.toString()+"\t\t");
			}
			System.out.println();
		}
		
		
	}
}
