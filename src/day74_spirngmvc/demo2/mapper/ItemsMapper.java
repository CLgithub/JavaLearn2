package day74_spirngmvc.demo2.mapper;

import java.util.List;

import day74_spirngmvc.demo2.entity.Items;

public interface ItemsMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);

    /*
     * 查询所有
     */
	List<Items> findAll();
}