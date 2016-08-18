package day68webservice.demo1service;

import javax.jws.WebService;

@WebService(endpointInterface="day68webservice.demo1service.JobService")	//指定服务端点接口
public class JobServiceImpl implements JobService{

	@Override
	public String getJob() {
		return "java研发工程师|android研发工程师";
	}
	
	public void say(){
		System.out.println("hello");
	}

}
