package day22;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Demo6 {
	public static void main(String[] args) {
		method1(new File("E:/bbb"));
		method2(new File("E:/bbb"));
	}
	
	//使用递归得到某目录下的所有文件的绝对路径
	//纵向
	//递归缺点：层级太多，可能会内存溢出
	public static void method1(File dir) {
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isFile()){
//				file.delete();
				System.out.println(file.getAbsolutePath());
			}else {
				method1(file);
			}
		}
		dir.delete();
	}
	
	//使用队列得到某目录下的所有文件的绝对路径
	//queue(排队)接口，实现类linkedList
	//队列中，插入offer,获取poll
	//横向
	//一层中文件太多，不合适
	public static void method2(File dir){
		Queue<File> queue=new LinkedList<>();
		queue.offer(dir);
		while(!queue.isEmpty()){	//如果queue不为空，就一直做
			File file = queue.poll();	//从队列中取出一个file
			if(file.isFile()){//如果是文件
				//
				System.out.println(file.getAbsolutePath());
			}else {
				File[] fs = file.listFiles();
				for(int i=0;i<fs.length;i++){
					queue.offer(fs[i]);
				}
			}
		}
	}
}
