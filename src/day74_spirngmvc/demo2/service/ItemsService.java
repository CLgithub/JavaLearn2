package day74_spirngmvc.demo2.service;

import java.util.List;

import day74_spirngmvc.demo2.entity.Items;
import day74_spirngmvc.demo2.entity.ItemsCustom;

public interface ItemsService {

	List<Items> findAll();
	
	ItemsCustom findbyId(int id) throws Exception;

	/**
	 * 新增或修改商品信息，id为null新增，否则为修改
	 * @author L
	 * @date 2016年7月6日
	 * @param items
	 */
	void doEditOrAddItems(Items items);
}
