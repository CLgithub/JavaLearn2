package day14;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4Tagotherwise extends SimpleTagSupport{
	
	@Override
	public void doTag() throws JspException, IOException {
		//获取when标签体的test内容，然后确定是否输出标签体内容
		
		//获取父标签
		Demo4Tagchoose choose = (Demo4Tagchoose) this.getParent();
		
		if(!choose.isTest()){
			this.getJspBody().invoke(null);
		}
		
	}
}
