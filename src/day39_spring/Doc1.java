package day39_spring;

/*
什么是AOP:
	 AOP Aspect Oriented Programing 面向切面编程
	 AOP采取横向抽取机制，取代了传统纵向继承体系重复性代码（性能监视、事务管理、安全检查、缓存）
	 Spring AOP使用纯Java实现，不需要专门的编译过程和类加载器，在运行期通过代理方式向目标类织入增强代码
	 AspecJ是一个基于Java语言的AOP框架，Spring2.0开始，Spring AOP引入对Aspect的支持，AspectJ扩展了Java语言，提供了一个专门的编译器，在编译时提供横向代码的织入
AOP底层原理;
	就是代理机制:
	* 动态代理:(JDK中使用)
	* JDK的动态代理,对实现了接口的类生成代理.

AOP的术语:（结合图二 AOP的术语.bmp来看）
	Joinpoint(连接点):所谓连接点是指那些被拦截到的点。在spring中,这些点指的是方法,因为spring只支持方法类型的连接点.
		哪些地方（方法）可以被切开
	Pointcut(切入点):所谓切入点是指我们要对哪些Joinpoint进行拦截的定义.
		真正切入的地方（方法）
	Advice(通知/增强):所谓通知是指拦截到Joinpoint之后所要做的事情就是通知.通知分为前置通知,后置通知,异常通知,最终通知,环绕通知(切面要完成的功能)
		就是增强(切面要完成的功能)，一般是方法级别增强
	Introduction(引介):引介是一种特殊的通知在不修改类代码的前提下, Introduction可以在运行期为类动态地添加一些方法或Field.
		一种特殊的增强（）类级别的增强
	Target(目标对象):代理的目标对象
	Weaving(织入):是指把增强应用到目标对象来创建新的代理对象的过程.
		spring采用动态代理织入，而AspectJ采用编译期织入和类装在期织入
	Proxy（代理）:一个类被AOP织入增强后，就产生一个结果代理类
	Aspect(切面): 是切入点和通知（引介）的结合
		允许有多个切点和多个通知组合





*/
public class Doc1 {

}
