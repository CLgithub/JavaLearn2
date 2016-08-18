package day68webservice.deom1client;

import day68webservice.deom1client.stub.JobService;
import day68webservice.deom1client.stub.JobServiceImplService;

public class JobClientTest1 {
	/**
	 * 测试通过实现接口的webservice发布方式
	 */
	public static void main(String[] args) {
		JobServiceImplService jService = new JobServiceImplService();
		JobService jobService = jService.getJobServiceImplPort();
		String job = jobService.getJob();
		System.out.println(job);
	}
}
