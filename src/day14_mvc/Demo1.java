package day14_mvc;

/*
javaBean
	javaBean 咖啡豆。javaBean是一种开发规范，可以说是一种技术
	javaBean就是一个普通的java类。只有符合以下规范才能称为javaBean
		（1）必须提供无参构造方法
		（2）类中熟悉必须私有化（private）
		（3）该类提供公开的getter和setter方法

	javaBean的作用：用于封装数据，保存数据
	
	javaBean的使用场景：
		（1）项目中用到的实体对象（entity），符合javaBean规范
		（2）el表达式访问对象属性，${student.name}调用getName()方法。符合javaBean规范
		（3）jsp标签中的属性赋值。setNum(integer num)。符合javaBean
		（4）jsp页面中使用javabean.也要符合javaBean
		
	问题：
		以下方法哪些是属于javaBean规范的方法？			答案（1，3，5，6）
		(1)getName,(2)getNmae(String name)
		(3)setName(String name),(4)setName()
		(5)setFlag(boolean flag),(6)isFlag()
	注意：boolean类型的get方法叫isXXX()方法
		


*/
public class Demo1 {
	private String name;
	private boolean flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
