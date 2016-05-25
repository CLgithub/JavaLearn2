package day14;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.crypto.Mac;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Demo4TagotheforEach extends SimpleTagSupport {
//	private Collection<Object> items;
	private Object items;
	private String var;

	public void setItems(Object items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Collection jh = null;
		if(items instanceof Collection){		//如果是单列集合
			jh=(Collection) items;
		}else if(items instanceof Map){			//如果是map
			jh = ((Map) items).entrySet();
		}
		PageContext pageContext = (PageContext) this.getJspContext();
		for(Object obj:jh){
			//把每个元素对象放到域对象中
			pageContext.setAttribute(var, obj);
			//输出标签体内容
			this.getJspBody().invoke(null);
		}
	}
}
