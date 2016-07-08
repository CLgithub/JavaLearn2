package day74_spirngmvc.demo2.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import day74_spirngmvc.demo2.entity.Items;
import day74_spirngmvc.demo2.entity.ItemsCustom;
import day74_spirngmvc.demo2.exception.CustomException;
import day74_spirngmvc.demo2.mapper.ItemsMapper;


@Service(value="itemsService")
public class ItemsServiceImpl implements ItemsService{

	@Resource
	private ItemsMapper itemsMapper; 
	
	@Override
	public List<Items> findAll() {
		return itemsMapper.findAll();
	}

	@Override
	public ItemsCustom findbyId(int id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		//测试自定义异常
		int d=1/0;
		if(items==null){
			throw new CustomException("修改商品信息不存在");
		}
		//为了方便扩展
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(itemsCustom, items);
		return itemsCustom;
	}

	@Override
	public void doEditOrAddItems(Items items) {
		Integer id = items.getId();
		if(null==id){
			int i = itemsMapper.insert(items);
		}else {
			int i = itemsMapper.updateByPrimaryKeyWithBLOBs(items);
		}
	}

}
