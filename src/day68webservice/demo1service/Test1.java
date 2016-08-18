package day68webservice.demo1service;

import javax.xml.ws.Endpoint;

/**
 * 发布测试
 * @author L
 * @date 2016年8月18日
 */
public class Test1 {
	public static void main(String[] args) {
		String address="http://192.168.1.101:8092/job";
		JobService jobService=new JobServiceImpl();
		Endpoint.publish(address, jobService);
	}
}
