package day19_2.exercise.base;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseDaoImal<T> implements BaseDao<T> {

	private Class<T> clazz;
	private QueryRunner runner;

	public BaseDaoImal() {
		// 获取泛型参数
//		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
//		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc1?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&useServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true");
		this.runner=new QueryRunner(cpds);
	}

	@Override
	public void saveEntity(T t) {
		
	}

	@Override
	public void deleteEntity(T t) {
		
	}

	@Override
	public void addOrUpdate(T t) {
		
	}

	@Override
	public T findById(Integer id) {
		return null;
	}

	@Override
	public List<T> findAllT() {
		return null;
	}

	@Override
	public void batchEntityBySQL(String sql, Object... objects) {
		
	}

	@Override
	public void executeSql(String sql, Object... objects) {
		try {
			int i = runner.update(sql,objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<T> findListT(Class<T> clazz, String sql, Object... objects) {
		List<T> list=new ArrayList<>();
		try {
			list=runner.query(sql, new BeanListHandler<T>(clazz),objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
		
	}

	@Override
	public List<Map> getListBySQl(String sql, Object... objects) {
		
		return null;
	}

	

}
