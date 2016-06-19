package day24_annotation;

/*

1.注解
	什么是注解，有什么作用
		@xxx就是一个注解，
		注释：描述代码功能，给人看的
		注解：描述程序如何运行，是给编译器，解释器，jvm使用的
	
	jdk中自带的三个注解（demo1）
		1.@Override
			给编译器使用，用于描述当前的方法是一个重写的方法
			注意：在jdk1.5和jdk1.6中有区别
				jdk1.5中只能描述继承中的重写
				jdk1.6中不仅可以描述继承中的重写，还能描述实现中的重写
		 2.@Deprecated
		 	描述某方法或接口过时
			问题：什么时候过时？
				1.有新的版本替换旧版本方法。
				2.在旧版本中存在安全隐患的方法
		3.@SuppressWarnings
			去除程序中的警告信息
			unused 变量未使用
			deprecation 使用了不赞成使用的类或方法时的警告
			unchecked 执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型。
			fallthrough 当 Switch 程序块直接通往下一种情况而没有 Break 时的警告。
			path 在类路径、源文件路径等中有不存在的路径时的警告。?
			serial 当在可序列化的类上缺少 serialVersionUID 定义时的警告。?
			finally 任何 finally 子句不能正常完成时的警告。
			all 关于以上所有情况的警告。
			
－－－－－－－－－－－－－－－－－－－－－－－－－－－－
	关于自定义注解（demo2）
		1.定义注解
			声明一个注解：@interface 注解名{}
			
			问题：声明一个注解的本质是什么
				@interface MyAnnotation{}
				它的本质就是（反编译）
				import java.lang.annotation.Annotation;
				interface MyAnnotation extends Annotation{
				}
				注解的本质就是一个接口，继承了Annotation
				所有的注解都实现了这个接口，但是不能手动实现
				注解是jdk1.5以后的新特性
				
		2.注解中的成员
			接口中的成员：
				属性特点：public static final
				方法特点：public abstract
				
			注解成员：
				1.可以有属性
					但是基本不使用
				2.可以有方法
					在开发中，一般使用注解时，只研究其方法，我们一般叫他注解中的属性
			
			1.关于注解中的属性的类型问题（注解接口中的方法的返回值类型）
				它的类型只能时以下几种：
					1.基本类型
						数组型：
							整型：byte(8),short(16),int(32),long(64)
							浮点型:float(32)	double(64)
						布尔型：boolean
						字符型：char
					2.String
					3.Class（范型要复习一下）
					4.enum
					5.Annotation
					6.以上类型的一维数组
					
				
			2.关于注解中有属性（方法），使用的问题(demo3)
				如果一个注解中有属性，并且属性没用默认值，那么我们在使用注解时，必须给属性赋值（类似实现接口）
				关于这个属性赋值方式：
					1.默认值问题
						String st2() default "abc";
					2.如果是单值
						注解名称(属性名称＝值)
					3.如果是数组
						如果是数组：int[] i2();
						使用时赋值：i2={2,3,5}
						注解名称(属性名称={值1,值2,...})
					4.关于属性名称value问题
						如果属性名称是"value"，且只有一个属性时，使用是可以省略属性名称，有其他属性，属性名称（value）不能省略
						例如：
							String value();
							使用时：@MyAnnotation4("a")
						如果value属性是一个数组
							String[] value();
							@MyAnnotation4({"a","b"})
						

*/
public class Doc1 {
	
}
