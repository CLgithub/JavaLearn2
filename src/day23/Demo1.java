package day23;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo1 {
	public static void main(String[] args) {
//		ResourceBundle bundle=ResourceBundle.getBundle("message");
		ResourceBundle bundle=ResourceBundle.getBundle("message",Locale.US);
		String msg = bundle.getString("msg");
		System.out.println(msg);
	}
}
