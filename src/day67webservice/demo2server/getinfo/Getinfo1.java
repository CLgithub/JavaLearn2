package day67webservice.demo2server.getinfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * 根据网页地址，获取信息
 * @author L
 * @date 2016年8月18日
 */
public class Getinfo1 {
	public static void main(String[] args) throws Exception {
		//创建url对象
		URL url=new URL("http://sports.sina.com.cn/g/pl/table.html");
		//根据url对象得到连接对象
		URLConnection uConnection = url.openConnection();
		//强转成httpUrlConnection对象
		HttpURLConnection httpuc=(HttpURLConnection) uConnection;
		//开启输入输出
		httpuc.setDoInput(true);//开启doInput
		httpuc.setDoOutput(true);//开启doOutput
		//设置请求方式
		httpuc.setRequestMethod("GET");
		
		//如果httpuc的状态码为200，说明请求成功
		if(httpuc.getResponseCode()==200){
			//接收响应参数
			InputStream iStream = httpuc.getInputStream();
			
			int i=0;
			byte[] buf=new byte[1024];
			while((i=iStream.read(buf))>0){
				System.out.println(new String(buf,0,i));
			}
			
			/*BufferedReader bReader=new BufferedReader(new InputStreamReader(iStream));
			String line=null;
			StringBuffer sBuffer=new StringBuffer();
			while((line=bReader.readLine())!=null){
				sBuffer.append(line);
			}
			System.out.println(sBuffer);*/
		}
		
	}
}
