package day38_spring.demo9;

import org.junit.runner.RunWith;

/*

Spring集成JUnit测试:
程序中有Junit环境.
导入一个jar包.spring与junit整合jar包.
* spring-test-3.2.0.RELEASE.jar
测试代码:
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void demo1(){
		userService.sayHello();
	}
}

 */
public class Test1 {

}
