package day19_2;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

/*
ResultSetHandler接口的9个实现类
	ArrayHandler, 将结果集中第一条记录封装到Object[],数组中的每一个元素就是记录中的字段值。
	ArrayListHandler, 将结果集中每一条记录封装到Object[],数组中的每一个元素就是记录中的字段值。在将这些数组装入到List集合。
	
	BeanHandler（重点）, 将结果集中第一条记录封装到一个javaBean中。
	BeanListHandler(重点), 将结果集中每一条记录封装到javaBean中，在将javaBean封装到List集合.
	 
	ColumnListHandler, 将结果集中指定列的值封装到List集合.
	 
	MapHandler, 将结果集中第一条记录封装到Map集合中，集合的 key就是字段名称，value就是字段值
	MapListHandler, 将结果集中每一条记录封装到Map集合中，集合的 key就是字段名称，value就是字段值，在将这些Map封装到List集合
	 
	KeyedHandler,在使用指定的列的值做为一个Map集合的key,值为每一条记录的Map集合封装。
	ScalarHandler 进行单值查询 select count(*) from account;
*/

public class Demo4 {
	
	//
	@Test
	public void test1() throws SQLException{
		String sql="select * from account";
		QueryRunner runner=new QueryRunner(MyDataSourceUtils.getDataSource());
		
		//ArrayHandler	将结果集中的第一条记录封装到Object[]中，数组的每个元素是记录的值
//		Object[] objects = runner.query(sql, new ArrayHandler());	
//		System.out.println(Arrays.toString(objects));
		
		//ArrayListHandler, 将结果集中每一条记录封装到Object[],数组中的每一个元素就是记录中的字段值。在将这些数组装入到List集合。
//		List<Object[]> list = runner.query(sql, new ArrayListHandler());
//		System.out.println(list);
//		for(Object[] objects:list){
//			System.out.println(Arrays.toString(objects));
//		}
		
		
		//BeanHandler（重点）, 将结果集中第一条记录封装到一个javaBean中。
//		Account account = runner.query(sql, new BeanHandler<>(Account.class));
//		System.out.println(account);
		
		//BeanListHandler(重点), 将结果集中每一条记录封装到javaBean中，在将javaBean封装到List集合.
		List<Account> list = runner.query(sql, new BeanListHandler<>(Account.class));
		System.out.println(list);
		
		//ColumnListHandler 将结果集中指定字段的值封装到List集合.
//		List<Object> list= runner.query(sql, new ColumnListHandler<Object>("accountName"));
//		System.out.println(list);
		
		//将第一条记录的每个字段名称作为key，字段值作为value，封装成map
//		Map<String, Object> map = runner.query(sql, new MapHandler());
//		System.out.println(map);
		
		//将每个字段名称作为key，字段值作为value，封装成map，再将所有的map封装成list
//		List<Map<String,Object>> list = runner.query(sql, new MapListHandler());
//		System.out.println(list);
		
		//将指定字段的值作为key，将这条记录map作为value，封装成map
//		Map<Object, Map<String, Object>> map = runner.query(sql, new KeyedHandler<>("accountName"));
//		System.out.println(map);
		
		//ScalarHandler 进行单值查询 select count(1) from account";
//		sql="select count(1) from account";
//		Object object = runner.query(sql, new ScalarHandler<>());
//		System.out.println(object);

		//自定义ResultSetHandler接口实现类
//		List<Account> list = runner.query(sql, new MyBeanListHandler<>(Account.class));
//		System.out.println(list);
		
		//自定义ResultSetHandler接口实现类
//		Account account = runner.query(sql, new MyBeanHandler<>(Account.class));
//		System.out.println(account);
	}
	
}


class MyBeanListHandler<T> implements ResultSetHandler<List<T>> {
	private Class<T> clazz;
	public MyBeanListHandler(Class<T> clazz) {
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

class MyBeanHandler<T> implements ResultSetHandler<T>{
	private Class<T> clazz;
	public MyBeanHandler(Class<T> clazz) {
		this.clazz=clazz;
	}
	@Override
	public T handle(ResultSet rs) throws SQLException {
		try {
			T t=clazz.newInstance();
			//利用元数据和BeanUtils封装
//			ResultSetMetaData metaData = rs.getMetaData();
//			int count = metaData.getColumnCount();
//			if(rs.next()){
//				for(int i=1;i<=count;i++){
//					Object value = rs.getObject(i);
//					String columnName = metaData.getColumnName(i);
//					BeanUtils.setProperty(t, columnName, value);
//				}
//			}
			//利用内省封装
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] pDescriptors = beanInfo.getPropertyDescriptors();
			if(rs.next()){
				for(PropertyDescriptor pDescriptor:pDescriptors){
 					String columnName = pDescriptor.getName();
					Method getMethod = pDescriptor.getWriteMethod();
					if(getMethod!=null){
						Object object = rs.getObject(columnName);
						getMethod.invoke(t, object);
					}
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

