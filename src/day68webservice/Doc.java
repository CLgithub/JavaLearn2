package day68webservice;

/*

2.四个概念
	soap
		简单对象访问协议 http+xml
	Soa
		面向服务的架构，它是一种思想，IBM公司大力倡导这种思想，希望以组装pc的方式来开发
			组成：
				1.面向web的服务，面向web的组件（硬盘、cpu、内存条）：webService
				2.企业服务总线，（类似主板）enterprise service bus ：ESB
	wsdl
		webService 描述语言
	uddi
		Universal Description Discovery and Integration
		统一描述、发现、集成
		它是目录服务、通过该服务可以注册和发布webservice，以便第三方的调用者统一调用
		
3.两个思考
	思考：webservice在web应用的三层框架中，位于哪一层中？
		属于业务层  Service 
		
	思考：你觉得webService有严格的客户端和服务端吗
		没有，客户端和服务端是相对的
		
通过jdk
	声明：@Webservice
	发布：EndPoint
	不足：希望tomcat启动时，webservice服务就能够开启，最好与spring集成
		希望有一个webservice的服务列表
	通过webservice框架来实现：axis2、xfire
	
使用CXF框架，发布webservice服务，并使用客户端远程访问webservice(详情查看webservice1CXF工程)
  1. CXF介绍 ：soa的框架
    * cxf 是 Celtrix （ESB框架）和 XFire（webserivice） 合并而成，并且捐给了apache  
    * CxF的核心是org.apache.cxf.Bus(总线)，类似于Spring的 ApplicationContext
    * CXF默认是依赖于Spring的
    * Apache CXF 发行包中的jar，如果全部放到lib中，需要 JDK1.6 及以上，否则会报JAX-WS版本不一致的问题
    * CXF 内置了Jetty服务器 ，它是servlet容器，好比tomcat
  2.CXF特点
    1. 与Spring、Servlet做了无缝对接，cxf框架里面集成了Servlet容器Jetty 
    2. 支持注解的方式来发布webservice
    3. 能够显示一个webservice的服务列表
    4. 能够添加拦截器：输入拦截器、输出拦截器 ：
         输入日志信息拦截器、输出日志拦截器、用户权限认证的拦截器
         
 Spring+CXF整合来管理webservice
 	实现步骤：
 		1.添加cxf.jar包（集成了spring.jar），spring.jar包，servlet.jar包
 		2.编写业务类，通过CXF来发布webservice
 		3.添加一个CXF请求的servlet，用来过滤webservlet的请求
 			过滤的地址/ws/*
		4.配置spring的配置文件：applicationContext.xml，把cxf的bean的spring配置
		5.在web.xml中配置CXF的servlet，添加spring的监听
		6.通过wsimport生产本地代理，访问webservice
	

*/
public class Doc {

}
