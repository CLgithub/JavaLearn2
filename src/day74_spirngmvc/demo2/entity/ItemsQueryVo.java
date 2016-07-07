package day74_spirngmvc.demo2.entity;

import java.util.List;
import java.util.Map;

public class ItemsQueryVo {
	private ItemsCustom itemsCustom;
	// 定义一个list，便于参数绑定集合类型
	private List<ItemsCustom> itemsCustoms;
	
	public List<ItemsCustom> getItemsCustoms() {
		return itemsCustoms;
	}

	public void setItemsCustoms(List<ItemsCustom> itemsCustoms) {
		this.itemsCustoms = itemsCustoms;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	@Override
	public String toString() {
		return "ItemsQueryVo [itemsCustom=" + itemsCustom + ", itemsCustoms=" + itemsCustoms + "]";
	}
	
	

}
