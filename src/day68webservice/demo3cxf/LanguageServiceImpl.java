package day68webservice.demo3cxf;

import org.apache.cxf.frontend.ServerFactoryBean;

public class LanguageServiceImpl implements LanguageSerivce{

	@Override
	public String getLanguage(int i) {
		String language=null;
		switch (i) {
		case 1:
			language="java";
			break;
		case 2:
			language="C";
			break;
		case 3:
			language="Object-c";
			break;
		case 4:
			language="C#";
			break;
		default:
			break;
		}
		return language;
	}
	
	//发布
	public static void main(String[] args) {
		LanguageSerivce lSerivce=new LanguageServiceImpl();
		ServerFactoryBean bean=new ServerFactoryBean();
		//endpoint:地址、实现类
		bean.setAddress("http://127.0.0.1:8092/ws/cxf/languageService");
		bean.setServiceClass(LanguageSerivce.class);//对外提供webservice的业务类或接口
		bean.setServiceBean(lSerivce);
		bean.create();	//创建发布webservice
	}

}
