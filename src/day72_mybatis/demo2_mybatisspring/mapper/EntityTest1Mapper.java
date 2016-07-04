package day72_mybatis.demo2_mybatisspring.mapper;

import day72_mybatis.demo2_mybatisspring.entity.EntityTest1;


public interface EntityTest1Mapper {
	
	/**
	 * 增加
	 */
	public int insertE(EntityTest1 entityTest1);
	
	/**
	 * 根据id查询
	 */
	public EntityTest1 findById(int id);
}
