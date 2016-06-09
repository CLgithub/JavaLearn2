package day19_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;



/*
dbutils工具
	题:dbutils是什么，有什么作用?
		它就是一个简单的jdbc封装工具.
		使用dbutils可以简化操作.
		要使用dbutils需要导入jar包. 
	dbutils核心
		1.QueryRunner类
			用于执行sql语句的类
			1.query 用于执行select
			2.update 用于执行update delete insert
			3.batch 批处理
		2.ResultSetHandlerh接口
			用于定义结果集封装
			提供9个实现类，可以进行不同的封装
		3.Dbtuils类
			提供关于关闭资源以及事务rollback，commit操作
	核心详细
		1.QueryRunner类
			1.QueryRunner怎样获取
				1.new QueryRunner();
					事务手动控制
				2.new QueryRunner(DataSource ds);
					事务是自动事务，即一条sql，一个事务
			2.QueryRunner中的三个核心
				query
				update
				batch
				对于上述三个方法，它们提供很多重载。
				如果QueryRunner在创建时，没有传递DataSource参数，那么在使用
				query,update,batch方法时，要传递Connection参数
				如果QueryRunner在创建时，传递了Dataource参数，好么在使用
				query,update,batch方法时，不需要传递Connection参数。
		2.ResultSetHandlerh接口
			用于封装结果集
			
*/
public class Demo3 {
	
	//QueryRunner无参构造函数
	@Test
	public void test1() throws SQLException{
		String sql="select * from account where id>=?";
		
		QueryRunner runner=new QueryRunner();	//事务手动控制
		Connection conn=MyDataSourceUtils.getConnection();
//		conn.setAutoCommit(false);
		List<Account> list = runner.query(conn, sql, new BeanListHandler<>(Account.class),2);
//		conn.commit();
		System.out.println(list);
	}
	
	//QueryRunner有参构造函数
	@Test
	public void test2() throws SQLException{
		String sql="select * from account where id=?";
		
		QueryRunner runner=new QueryRunner(MyDataSourceUtils.getDataSource());		//事务自动控制
		List<Account> list = runner.query(sql, new BeanListHandler<>(Account.class), 1);
		System.out.println(list);
	}
	
	//ResultSetHandlerh		手动封装结果集
	@Test
	public void test3() throws SQLException{
		String sql="select * from account";
		
		QueryRunner runner=new QueryRunner(MyDataSourceUtils.getDataSource());		//事务自动控制
		List<Account> list = runner.query(sql, new MyRsHandler<Account>(Account.class));
		System.out.println(list);
	}
	class MyRsHandler<T> implements ResultSetHandler<List<T>> {
		private Class<T> clazz;
		public MyRsHandler(Class<T> clazz) {
			this.clazz=clazz;
		}
		@Override
		public List<T> handle(ResultSet rs) throws SQLException {
			List<T> list=new LinkedList<>();
			try {
				ResultSetMetaData metaData = rs.getMetaData();
				int count = metaData.getColumnCount();
				while(rs.next()){
					T t = clazz.newInstance();
					for(int i=1;i<=count;i++){
						Object value = rs.getObject(i);
						String columnName = metaData.getColumnName(i);
						BeanUtils.setProperty(t, columnName, value);
					}
					list.add(t);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	}
	
	//自定义 queryRunner		update
	@Test
	public void test4() throws Exception{
		String sql="update account set money=999";
		MyQueryRunner runner=new MyQueryRunner(MyDataSourceUtils.getDataSource());
	}
	
	//自定义 queryRunner		select
	@Test
	public void test5() throws SQLException{
		String sql="select * from account where id=?";
		MyQueryRunner runner=new MyQueryRunner();		
		Connection conn=MyDataSourceUtils.getConnection();
		List<Account> list = runner.query(conn, sql, new BeanListHandler<>(Account.class), 1);
		System.out.println(list);
	}
	
}
