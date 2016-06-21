package day24_fanxinfanshe.demo1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*

问题：如何得到T泛型的Class对象
	

*/
public class BaseDaoImal<T> implements BaseDao<T> {

	private Class<T> clazz;
	private QueryRunner runner;

	public BaseDaoImal() {
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc1?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&useServerPrepStmts=true&cachePrepStmts=true&rewriteBatchedStatements=true");
		cpds.setUser("L");
		cpds.setPassword("123456");
		this.runner=new QueryRunner(cpds);
		
		
		//得到当前类上的泛型--父类型
		//getGenericSuperclass得到泛型的父，type
		//这里的this相当于具体的某个dao（UserDao），他的父的泛型BaseDaoImal<User>，即User
		Type type = this.getClass().getGenericSuperclass();
		//得到当前类上所有的泛型类型Class
		Type[] params = ((ParameterizedType) type).getActualTypeArguments();		
		clazz=(Class<T>) params[0];
		
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
		System.out.println(clazz);
		return null;
	}

	@Override
	public List<T> findAllT() {
		return null;
	}

	@Override
	public void batchEntityBySQL(String sql, Object[][] objects) {
		try {
			runner.batch(sql, objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public List<T> findListT(String sql, Object... objects) {
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
	public List<Map<String,Object>> getListBySQl(String sql, Object... objects) {
		List<Map<String, Object>> list=new ArrayList<>();
		try {
			list = runner.query(sql, new MapListHandler(), objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
