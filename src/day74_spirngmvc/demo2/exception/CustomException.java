package day74_spirngmvc.demo2.exception;

/**
 * 自定义异常
 * 
 * @author L
 * @date 2016年7月8日
 */
public class CustomException extends Exception {

	// 异常信息
	private String massage;

	public CustomException(String massage) {
		super(massage);
		this.massage = massage;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

}
