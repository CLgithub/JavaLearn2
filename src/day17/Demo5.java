package day17;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import org.junit.Test;

//使用CallableStatement调用存储过程
public class Demo5 {
	
	//调用无输出参数的存储过程
	@Test
	public void test1(){
		String sql="call pro_findById(?)";	//CallableStatement是PreparedStatement的子接口
		Connection connection=null;
		Statement statement=null;
		try{
			connection = Demo2JdbcUtil.getConnect();
			CallableStatement cStatement = connection.prepareCall(sql);
			cStatement.setInt(1, 2);
			ResultSet resultSet = cStatement.executeQuery();		//所有调用存储过程的语句都使用executeQuery执行
			while(resultSet.next()){
				int id = resultSet.getInt("id");	
				String name = resultSet.getString("name");
				String password = resultSet.getString("password");
				System.out.println(id+","+name+","+password);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Demo2JdbcUtil.closeC(connection, statement);
		}
	}
	
	//调用有输出参数的存储过程
	@Test
	public void test2(){
		String sql="call pro_findById2(?,?)";	
		//call pro_findById2(1,@uname);
		Connection connection=null;
		Statement statement=null;
		try{
			connection = Demo2JdbcUtil.getConnect();
			CallableStatement cStatement = connection.prepareCall(sql);
			//设置输入参数
			cStatement.setInt(1, 2);
			//设置输出参数
				//注册输出参数		第一个参数为参数的位置，第二个参数是存储过程的类型
			cStatement.registerOutParameter(2, Types.VARCHAR);
			cStatement.executeQuery();	//该存储过程没有结果集，结果是返回到输出参数中
			//得到输出参数的值
			String name = cStatement.getString(2);//此处的索引值是存储过程中输出参数的索引
			System.out.println("name="+name);
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			Demo2JdbcUtil.closeC(connection, statement);
		}
	}
}
