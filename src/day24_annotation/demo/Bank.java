package day24_annotation.demo;

import java.lang.reflect.Method;

//银行最大转账金额为5000
public class Bank {
	
	//name1向name2转账money元		使用配置文件
	public void account1(String name1,String name2,int money){
		if(money>GobalField.MONEY){
			throw new RuntimeException("最大转账金额为"+GobalField.MONEY);
		}
		System.out.println(name1+"向"+name2+"转账"+money+"元");
	}
	
	//name1向name2转账money元		使用注解
	@BankInfo(maxMoney=5000)
	public void account2(String name1,String name2,int money) throws Exception{
		//1.获取当前方法的method对象
		Method method = this.getClass().getDeclaredMethod("account2", String.class, String.class, int.class);
		if(method.isAnnotationPresent(BankInfo.class)){	//判断这个方法上是否有BankInfo注解
			//2.通过method对象的getAnnotation(Class<T> annotationClass)方法，获取该方法注解对象
			BankInfo bankInfo = method.getAnnotation(BankInfo.class);
			if(bankInfo!=null){
				//3.通过注解对象来调用其属性
				int maxMoney = bankInfo.maxMoney();
				
				
				if(money>maxMoney){
					throw new RuntimeException("最大转账金额为"+maxMoney);
				}
				System.out.println(name1+"向"+name2+"转账"+money+"元");
			}
		}
	}
}
