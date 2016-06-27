package day38_spring;

/*
spring的ioc
spring的AOP AspectJ
Spring的事务管理，三大框架整合

Spring框架概述
	什么是Spring
		Spring是分层的JavaSE/EE full－stack（一站式）轻量级开源框架
			分层:
				SUN提供的EE的三层结构:web层、业务层、数据访问层（持久层，集成层）
				Struts2是web层基于MVC设计模式框架.
				Hibernate是持久的一个ORM的框架.
			一站式:
				Spring框架有对三层的每层解决方案:
				web层:Spring MVC.
				持久层:JDBC Template 
				业务层:Spring的Bean管理.
	Spring的核心：
		IOC(Inverse of Control 控制反转)
			控制翻转：将对象的创建权，交个Spring完成
			底层实现思想，看图一，工厂设计模式＋配置文件＋反射
		AOP：Aspect Oriented Programming（部分面向编程）	是面向对象的功能延伸，不是替换面向对象，是用来解决面向对象中的一些问题
		
		Spring的版本:
		Spring3.x和Spring4.x  Spring4需要整合hibernate4.
		
	EJB:企业级JavaBean
		EJB:SUN公司提出EE解决方案.
		
	Spring优点:
		方便解耦，简化开发
		* Spring就是一个大工厂，可以将所有对象创建和依赖关系维护，交给Spring管理
		AOP编程的支持
		* Spring提供面向切面编程，可以方便的实现对程序进行权限拦截、运行监控等功能
		声明式事务的支持
		* 只需要通过配置就可以完成对事务的管理，而无需手动编程
		方便程序的测试
		* Spring对Junit4支持，可以通过注解方便的测试Spring程序
		方便集成各种优秀框架
		* Spring不排斥各种优秀的开源框架，其内部提供了对各种优秀框架（如：Struts、Hibernate、MyBatis、Quartz等）的直接支持
		降低JavaEE API的使用难度
		* Spring 对JavaEE开发中非常难用的一些API（JDBC、JavaMail、远程调用等），都提供了封装，使这些API应用难度大大降低
		
--------------------------------------------------------------------------------------------------------
	Spring入门程序(day38_spring.demo1)
		下载jar包：（或maven）
				https://repo.spring.io/release/
			spring-framework-3.xxx.RELEASE-dist.zip				---Spring开发包
			* docs		:spring框架api和规范
			* libs		:spring开发的jar包
			* schema		:XML的约束文档.
			spring-framework-3.xx.RELEASE-dependencies.zip		---Spring开发中的依赖包
		
		引入相应jar包:（版本忽略）
			spring-beans-3.2.0.RELEASE.jar
			spring-context-3.2.0.RELEASE.jar
			spring-core-3.2.0.RELEASE.jar
			spring-expression-3.2.0.RELEASE.jar
			开发的日志记录的包:
			com.springsource.org.apache.commons.logging-1.1.1.jar		--- 用于整合其他的日志的包(类似Hibernate中slf4j)
			com.springsource.org.apache.log4j-1.2.15.jar
		
		创建Spring的配置文件:
			在src下创建一个applicationContext.xml
		引入约束
			<beans xmlns="http://www.springframework.org/schema/beans" 
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="
			http://www.springframework.org/schema/beans
			http://www.springframework.org/schema/beans/spring-beans-4.2.xsd
			">
			
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
IOC和DI的区别?
	IOC:控制反转:将对象的创建权,由Spring管理.
	DI:依赖注入:在Spring创建对象的过程中,把对象依赖的属性注入到类中.
		面向对象中对象之间的关系;
		依赖:
			public class A{
				private B b;
			}
		继承:is a
		聚合:
			聚集:
			组合:
			
Spring框架加载配置文件:
	ApplicationContext 应用上下文，加载Spring 框架配置文件
	加载classpath：
	     new ClassPathXmlApplicationContext("applicationContext.xml");		:加载classpath下面配置文件.
	加载磁盘路径：
     	new FileSystemXmlApplicationContext("applicationContext.xml");		:加载磁盘下配置文件.
	
BeanFactory与ApplicationContext区别?
	ApplicationContext类继承了BeanFactory.
	BeanFactory在使用到这个类的时候,getBean()方法的时候才会加载这个类.（延时加载）
	ApplicationContext类加载配置文件的时候,创建所有的类.
	ApplicationContext对BeanFactory提供了扩展:
		国际化处理
		事件传递
		Bean自动装配
		各种不同应用层的Context实现
	早期开发使用BeanFactory.
	
IOC装配Bean:（day38_spring.demo2）
	Spring框架Bean实例化的方式:
	提供了三种方式来实例化Bean
		1.构造方法实例话（默认无参数）（反射）
			<!-- 默认情况下使用无参数构造方法 -->
			<bean id="bean1" class="day38_spring.demo2.Bean1" />
		2.静态工厂实例化
			<!-- 静态工厂实例化来实例化bean -->
			<bean id="bean2" class="day38_spring.demo2.Bean2Factory" factory-method="getBean2" />
		3.实例工厂实例化
			<!-- 实例工厂实例化来实例化bean -->
			<bean id="bean3Factory" class="day38_spring.demo2.Bean3Factory" /><!-- 先实例化bean3Factory -->
			<bean id="bean3" factory-bean="bean3Factory" factory-method="getBean3" />
		
Bean标签的其他配置:
	id和name的区别：
		id遵守了xml约束中的id的也是，id约束保证这个属性的值是唯一的,而且必须以字母开始，可以使用字母、数字、连字符、下划线、句话、冒号
		name没有这些要求
		注意：如果bean标签上没有配置id，那么name开源作为id。
		
	scope属性：
		配置类的作用范围
			singleton		单例的.(默认的值.)
			prototype		原型的.
			request			web开发中.创建了一个对象,将这个对象存入request范围,request.setAttribute();
			session			web开发中.创建了一个对象,将这个对象存入session范围,session.setAttribute();
			globalSession	一般用于Porlet应用环境.指的是分布式开发.如果不是porlet环境,那么globalSession等同于session;（全局session）
			
		实际开发中主要使用singleton,prototype
		
Spring 中Bean的生命周期：(day38_spring.demo4)
	配置bean的初始化和销毁的方法
	配置初始化和销毁的方法：
	在bean标签内设置init-method和destroy-method属性
	<bean id="product" scope="prototype" class="day38_spring.demo3.Product"
		init-method="setup" destroy-method="teardown"	 />
	执行销毁的时候，必须手动关闭工厂，而且只对scope="singleton"（单例）有效
	
	bean的生命周期的11个步骤：
		1.instantiate bean对象实例化
		2.populate properties 封装属性
		3.如果Bean实现BeanNameAware 执行 setBeanName
		4.如果Bean实现BeanFactoryAware 或者 ApplicationContextAware 设置工厂 setBeanFactory 或者上下文对象 setApplicationContext
		5.如果存在类实现 BeanPostProcessor（后处理Bean） ，执行postProcessBeforeInitialization
		6.如果Bean实现InitializingBean 执行 afterPropertiesSet 
		7.调用<bean init-method="init"> 指定初始化方法 init
		8.如果存在类实现 BeanPostProcessor（处理Bean） ，执行postProcessAfterInitialization
		9.执行业务处理
		10.如果Bean实现 DisposableBean 执行 destroy
		11.调用<bean destroy-method="customerDestroy"> 指定销毁方法 customerDestroy
		
		
		在CustomerService类的add方法之前进行权限校验
		
		
Bean中属性注入:(day38_spring.demo5)
	通常，有三种注入方式
		1.定义一个接口，实现这个接口，实现注入方法注入
		2.构造方法里注入
		3.set方法注入
	
	在spring中，支持构造方法注入和set方法注入 
		1.构造器的注入
			使用标签：constructor-arg
		2.set方法注入
			<property name="name" value="奥迪" />
		3.set方法注入对象属性
			<property name="myCar2" ref="car2"  />
			
			当类的属性非常多的时候，可以使用名称空间p注入属性
		4.名称空间p:注入属性
			Spring2.5版本引入了名称空间p.
				p:<属性名>="xxx" 引入常量值
				p:<属性名>-ref="xxx" 引用其它Bean对象
			1.引入名称空间:
				xmlns:p="http://www.springframework.org/schema/p"
				http://www.springframework.org/schema/beans/spring-beans.xsd
			2
				<bean id="person" class="day38_spring.demo5.Person" p:name="小红" p:myCar2-ref="car2" />
		
		5.SpEL:属性的注入：
			Spring3.0提供注入属性方式:
			语法：#{表达式}
			<bean id="" value="#{表达式}">

			<bean id="car2" class="day38_spring.demo5.Car2" >
				<property name="name" value="#{'大众'}" />
				<property name="price" value="#{'200000'}" />
			</bean>
			
			
			<bean id="person" class="day38_spring.demo5.Person">
				<!-- <property name="name" value="#{personInfo.name}" /> -->
				<property name="name" value="#{personInfo.showName()}" />
				<property name="myCar2" value="#{car2}"  />
			</bean>
			<bean id="personInfo" class="day38_spring.demo5.PersinInfo" >
				<property name="name" value="小黑" />
			</bean>
			
		集合属性的注入（day38_spring.demo6）
			详情看demo6
			<bean id="collectionBean" class="day38_spring.demo6.CollectionBean">
				<!-- 注入list集合 -->
				<property name="list1">
					<list>
						<!-- 如果是普通值用value，如果是对象用ref -->
						<value>aaa</value>
						<value>bbb</value>
						<value>付费电视</value>
					</list>
				</property>
				<!-- 注入set集合 -->
				<property name="set1">
					<set>
						<value>123</value>
						<value>864</value>
						<value>1585</value>
					</set>
				</property>
				<!-- 注入map集合 -->
				<property name="map1">
					<map>
						<entry key="aaa" value="111" />
						<entry key="bbb" value="1531" />
						<entry key="ccc" value="334" />
					</map>
				</property>
				<!-- 注入properties -->
				<property name="properties1">
					<props>
						<prop key="userName">root</prop>
						<prop key="password">123</prop>
					</props>
				</property>
			</bean>
------------------------------------------------------------------------------------------------------
加载配置文件:
一种写法:
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml","bean2.xml");
二种方法:
	<import resource="applicationContext2.xml"/>


IOC装配Bean(注解方式)（day38_spring.demo7）
	Spring的注解装配Bean
		Spring2.5 引入使用注解去定义Bean
		@Component  描述Spring框架中Bean
	在spring框架中提供了与@Component注解等效的三个注解:
		@Repository 用于对DAO实现类进行标注
		@Service 用于对Service实现类进行标注
		@Controller 用于对Controller实现类进行标注
	三个注解为了后续版本进行增强的.
	
注解方式注入属性
	详细看
		day38_spring.demo7.UserService
		
Bean其他的属性的配置:
	配置Bean初始化方法和销毁方法:
	init-method 和 destroy-method.
	@PostConstruct 初始化
	@PreDestroy  销毁
配置Bean的作用范围:
	@Scope
	
Spring3.0提供使用Java类定义Bean信息的方法(用得比较少)
	自定义一个类，让spring扫描这个类所在包，就相当于这里面得类都装置进了spring
	@Configuration
	public class BeanConfig {
		@Bean(name="car")
		public Car showCar(){
			Car car = new Car();
			car.setName("长安");
			car.setPrice(40000d);
			return car;
		}
		@Bean(name="product")
		public Product initProduct(){
			Product product = new Product();
			product.setName("空调");
			product.setPrice(3000d);
			return product;
		}
	}
	
实际开发中使用XML还是注解?
	XML:
		bean管理
	注解;
		注入属性的时候比较方便.
	两种方式结合;一般使用XML注册Bean,使用注解进行属性的注入.
	
	
	
*/
public class Doc1 {

}
