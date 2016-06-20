package day24_proxy.demo1;

//代理
public class Wp implements KindWoman{
	private KindWoman woman;
	
	public Wp(KindWoman woman) {
		this.woman = woman;
	}

	@Override
	public void throwEye() {
		//在此控制是否调用真实行为
		
		woman.throwEye();
		//在此可以对真实行为执行后处理
		
	}

	@Override
	public void doSomething() {
		woman.doSomething();
	}
}
