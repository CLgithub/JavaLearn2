package day21;

/*
Filter过滤器
	1.Filter介绍以及相关配置api
	2.Filter实例
		1.自动登录
		2.url级别权限控制
		3.全局编码过滤器

1.filter介绍
	问题：filter是什么，有什么作用
		过滤器，能拦截请求和响应，完成一些特定的功能（如权限判断，过滤敏感词，压缩相应信息，加密，标记过滤等）
		
		从技术角度来说：javax.servlet.filter也是一个接口,
			这个接口中有一个方法doFilter方法，它是真正用于进行过滤的方法
			filter也需要在web.xml中配置
			
	filter入门：
		问题：filter怎么创建？
			1.创建一个类，实现 javax.servlet.Filter接口
			2.重写接口中的方法
			3.在web.xml文件中配置
	filter怎么实现过滤器操作
		1.<url-pattern>设置要过滤的路径
		2.在doFilter方法中的第三个参数FilterChain，它是用于控制是否可以访问资源的
			
*/
public class Doc1 {

}
