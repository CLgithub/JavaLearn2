package day18;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import day17.Demo2JdbcUtil;

/*
插入数据，获取自增长值
需求：一张主键自增长的表，插入数据后，获取自增长的值
方法一：先插入，后更加条件查找，前提，条件字段唯一，才能找到

*/
public class Demo3 {
	@Test
	public void test1(){
		String sql="insert into student(name,gender) values(?,?);";
		Connection connection=null;
		PreparedStatement pStatement=null;
		try{
			connection = Demo2JdbcUtil.getConnect();
			//在参数中指定返回自增长列
			pStatement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pStatement.setString(1, "小黄2");
			pStatement.setString(2, "女");
//			prepareStatement.setInt(1, 5);
			int i = pStatement.executeUpdate();
			System.out.println("影响的行数："+i);
			//ResultSet getGeneratedKeys()
			//获取由于执行此 Statement 对象而创建的所有自动生成的键。如果此 Statement 对象没有生成任何键，则返回空的 ResultSet 对象。
			ResultSet resultSet = pStatement.getGeneratedKeys();
			if(resultSet.next()){
				System.out.println("刚才插入的自增长编号是："+resultSet.getObject(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Demo2JdbcUtil.closeC(connection, pStatement);
		}
	}
}
