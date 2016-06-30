package day40_spring_tx.demo1;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/*

spring的事务管理
	spring的管理分成两类：
		编程式事务管理
			手动编写代码完成事务管理
		声明式事务管理
			不需要手动编写代码配置
创建表
CREATE TABLE account (
	id int(11) NOT NULL AUTO_INCREMENT,
	name varchar(20) NOT NULL,
	money double DEFAULT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO account VALUES (1, 'aaa', 1000);
INSERT INTO account VALUES (2, 'bbb', 1000);
INSERT INTO account VALUES (3, 'ccc', 1000);

spring事务管理：
	手动编码的方式完成事务管理
		需要事务管理器：真正管理事务对象
			spring提供了事务管理的模板（工具类）
		步骤：
			1.注册事务管理器
				PlatformTransactionManager
			2.注册事务模板
				在模板中设置事务管理器变量
			3.在service成注入事务管理模板，用事务管理模板的方法类执行业务逻辑
	手动编码缺点：代码量增加，代码有侵入性

*/
public class SpringTest1 {
	private static ApplicationContext applicationContext;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext_day40_tx1.xml");
	}
	
	@Test
	public void test1(){
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.transfer("aaa", "bbb", 100.0);
	}
}
