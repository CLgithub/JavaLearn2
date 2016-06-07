package day19.exercise.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;

import day17.Demo2JdbcUtil;
import day19.exercise.entity.Contact19;

public class BaseDaoImal<T> implements BaseDao<T> {

	private Class<T> clazz;

	public BaseDaoImal() {
		// 获取泛型参数
//		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
//		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
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
		Connection connection = Demo2JdbcUtil.getConnect();
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				pStatement.setObject(i + 1, objects[i]);
			}
			int i = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Demo2JdbcUtil.closeC(connection, pStatement);
		}
	}

	@Override
	public List<T> findListT(Class<T> clazz,String sql, Object... objects) {
		Connection connection = Demo2JdbcUtil.getConnect();
		ResultSet resultSet = null;
		PreparedStatement pStatement = null;
		List<T> list = new ArrayList<>();
		try {
			pStatement = connection.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				pStatement.setObject(i + 1, objects[i]);
			}
			resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				T t = clazz.newInstance();
				ResultSetMetaData metaData = resultSet.getMetaData();
				int count = metaData.getColumnCount();
				for (int i = 0; i < count; i++) {
					String columnName = metaData.getColumnName(i + 1);
					Object columnValue = resultSet.getObject(columnName);
					if(columnValue!=null){
						BeanUtils.setProperty(t, columnName, columnValue);
					}
				}
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Demo2JdbcUtil.closeC(connection, pStatement, resultSet);
			return list;
		}
	}

	@Override
	public List<Map> getListBySQl(String sql, Object... objects) {
		return null;
	}

}
