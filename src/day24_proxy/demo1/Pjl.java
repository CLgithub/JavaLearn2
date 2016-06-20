package day24_proxy.demo1;

//被代理
public class Pjl implements KindWoman{
	public void throwEye() {
		System.out.println("潘金莲抛媚眼");
	}
	
	public void doSomething() {
		System.out.println("潘金莲。。。");
	}
}
