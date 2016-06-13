package day19_2_listener.demo;

/*
监听器案例：
	功能：扫描session对象在指定时间内没有使用，人为销毁。

	分析：
		1.怎么知道session多长时间没有使用
			当前时间-最后使用时间（public long getLastAccessedTime()）
		2.什么时候开始扫描。扫描多长时间
			timer.schedule()
			
		1.要将所有session都得到
		2.定时扫描
*/
public class Demo2 {

}
