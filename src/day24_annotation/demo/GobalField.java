package day24_annotation.demo;

import java.util.ResourceBundle;

public class GobalField {
	public static final int MONEY=Integer.parseInt(ResourceBundle.getBundle("day24_bank").getString("money"));
}
