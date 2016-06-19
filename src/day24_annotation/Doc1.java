package day24_annotation;

/*

1.注解
	什么是注解，有什么作用
		@xxx就是一个注解，
		注释：描述代码功能，给人看的
		注解：描述程序如何运行，是给编译器，解释器，jvm使用的
	
	jdk中自带的三个注解
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

*/
public class Doc1 {

}
