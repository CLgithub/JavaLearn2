package day19_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbutils.ResultSetHandler;

public class MyQueryRunner {

	private DataSource dataSource;
	
	public MyQueryRunner(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	public MyQueryRunner() {

	}
	
	private PreparedStatement parpareStat(Connection connection, String sql, Object... params) throws SQLException {
		PreparedStatement pStatement = connection.prepareStatement(sql);
		for(int i=1;i<=params.length;i++){
			pStatement.setObject(i, params[i-1]);
		}
		return pStatement;
	}

	//执行查询操作
	public <T>T query(Connection conn, String sql, ResultSetHandler<T> resultSetHandler, Object...params) throws SQLException {
		PreparedStatement pStatement = this.parpareStat(conn, sql, params);
		ResultSet resultSet = pStatement.executeQuery();
		T t = resultSetHandler.handle(resultSet);
		//关闭资源
		pStatement.close();
		resultSet.close();
		return t;
	}
	
	//执行查询操作
	public  <T> T query(String sql, ResultSetHandler<T> resultSetHandler, Object...params) throws SQLException {
		Connection conn = dataSource.getConnection();
		T t = this.query(conn, sql, resultSetHandler, params);
		//关闭资源
		conn.close();
		return t;
	}

	//执行update操作
	public int update(Connection conn, String sql, Object...params) throws SQLException {
		PreparedStatement pStatement = this.parpareStat(conn, sql, params);
		int row = pStatement.executeUpdate();
		//关闭资源
		pStatement.close();
		return row;
	}

	//执行update操作
	public int update(String sql, Object...params) throws SQLException {
		Connection conn = dataSource.getConnection();
		int row = update(conn, sql, params);
		//关闭资源
		conn.close();
		return row;
	}

	

}
