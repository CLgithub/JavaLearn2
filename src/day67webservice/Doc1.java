package day67webservice;

/*

WebService定义: 顾名思义就是基于Web的服务。它使用Web(HTTP)方式，
	接收和响应外部系统的某种请求。从而实现远程调用
	
	SOAP（原为Simple Object Access Protocol的首字母缩写，即简单对象访问协议）是交
		换数据的一种协议规范，使用在计算机网络Web服务（web service）中，交换带结构信息

	
学习webservice调用的预备知识
	名词1：XML. Extensible Markup Language －扩展性标记语言
		XML，用于传输格式化的数据，是Web服务的基础。
		namespace-命名空间
		xmlns=“http://xxxx.cn” 使用默认命名空间。
		xmlns:xxx=“http://xxx.cn”使用指定名称的命名空间。
	名词2：WSDL – WebService Description Language – Web服务描述语言。
		通过XML形式说明服务在什么地方－地址。
		通过XML形式说明服务提供什么样的方法 – 如何调用。
	名词3：SOAP-Simple Object Access Protocol(简单对象访问协议)
		SOAP作为一个基于XML语言的协议用于有网上传输数据。
		SOAP = 在HTTP的基础上+XML数据。
		SOAP是基于HTTP的。
		SOAP的组成如下：
			Envelope – 必须的部分。以XML的根元素出现。
			Headers – 可选的。
			Body – 必须的。在body部分，包含要执行的服务器的方法。和发送到服务器的数据。
			
webservice服务网址
	http://www.webservicex.net/globalweather.asmx
WSDL解析(http://www.webservicex.net/globalweather.asmx?WSDL)
	Wsdl文档从下往上读
		Types - 数据类型定义的容器，它使用某种类型系统(一般地使用XML Schema中的类型系统)。（入参和出参的数据类型） 
		Message - 通信消息的数据结构的抽象类型化定义。使用Types所定义的类型来定义整个消息的数据结构（入参和出参）。 
		Operation - 对服务中所支持的操作的抽象描述，一般单个Operation描述了一个访问入口的请求/响应消息对（方法）。 
		PortType - 对于某个访问入口点类型所支持的操作的抽象集合，这些操作可以由一个或多个服务访问点来支持（服务类）。 
		Binding - 特定服务访问点与具体服务类的绑定（不看内容，看关系）。 
		Port - 定义为webservice单个服务访问点。
		
生成客户端代码
	使用jdk自带的wsimport生成
	生产java源文件和.class文件	wsimport.exe -s . http://www.webservicex.net/globalweather.asmx?WSDL
	自定义包名生成：
	


	
	
	
*/
public class Doc1 {

}
