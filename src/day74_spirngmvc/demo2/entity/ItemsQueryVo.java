package day74_spirngmvc.demo2.entity;

public class ItemsQueryVo {
	private ItemsCustom itemsCustom;

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	@Override
	public String toString() {
		return "ItemsQueryVo [itemsCustom=" + itemsCustom + "]";
	}

}
