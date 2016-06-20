package day24_proxy.demo1;

public class Xmq {
	public static void main(String[] args) {
		KindWoman kWoman=new Js();
		Wp wp=new Wp(kWoman);
		wp.throwEye();	//真实执行的是潘金莲，屏蔽了真实行为
		
	}
}
