package day74_spirngmvc.demo2.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

/*
 * 自定义属性编辑器
 */
public class MyCustomPropertyEditor implements PropertyEditorRegistrar{

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));
	}

}
