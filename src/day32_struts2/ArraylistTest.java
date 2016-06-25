package day32_struts2;

import java.util.ArrayList;

public class ArraylistTest {
	public static void main(String[] args) {
		ArrayList<Object> list=new ArrayList<>();
		list.add(0, "aa");
		System.out.println(list);
		list.add(0, "bb");
		System.out.println(list);
	}
}
