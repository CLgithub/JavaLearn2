package day72_mybatis.demo2_mybatisspring.mapper;

import day72_mybatis.demo2_mybatisspring.entity.EntityTest2;

public interface EntityTest2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EntityTest2 record);

    int insertSelective(EntityTest2 record);

    EntityTest2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EntityTest2 record);

    int updateByPrimaryKey(EntityTest2 record);
}