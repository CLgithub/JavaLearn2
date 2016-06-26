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
			
		
	
		

*/
public class Doc1 {

}
