package day74_spirngmvc.demo2.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

/**
 * 自定义String去两端空格处理器
 * @author L
 * @date 2016年7月6日
 */
public class MyStringTrimConverter implements Converter<String, String>{

	@Override
	public String convert(String source) {
		//去掉两端空格,如果去掉后为空,返回null
		if(source!=null){
			String trim = source.trim();
			if(trim==""){
				return null;
			}else {
				return trim;
			}
		}else {
			return source;
		}
	}

	

}
