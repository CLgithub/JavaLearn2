package day68webservice.demo1service;

import javax.jws.WebService;

/**
 * 面向接口的webService发布方式
 * @author L
 * @date 2016年8月18日
 */
@WebService
public interface JobService {
	
	public String getJob();
}
