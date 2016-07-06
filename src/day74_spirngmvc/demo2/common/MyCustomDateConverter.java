package day74_spirngmvc.demo2.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

/**
 * 自定义日期类型转换器
 * @author L
 * @date 2016年7月6日
 */
public class MyCustomDateConverter implements Converter<String, Date>{//原始类型string,目标类型Date

	@Override
	public Date convert(String source) {
		try {
			//进行日期转换
			return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
