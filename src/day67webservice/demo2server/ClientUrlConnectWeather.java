package day67webservice.demo2server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import day1.introspector.Demo1;

public class ClientUrlConnectWeather {
	public static void main(String[] args) throws Exception {
		//创建url对象
		URL url=new URL("http://www.webservicex.net/globalweather.asmx?WSDL");
		//根据url对象得到连接对象
		URLConnection uConnection = url.openConnection();
		//强转成httpUrlConnection对象
		HttpURLConnection httpuc=(HttpURLConnection) uConnection;
		//开启输入输出
		httpuc.setDoInput(true);//开启doInput
		httpuc.setDoOutput(true);//开启doOutput
		//设置请求方式
		httpuc.setRequestMethod("POST");
		//设置请求参数 requestPorperty
		httpuc.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
		//组装消息体
		String data="<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
				+"<soap:Body>"
				+"<GetWeather xmlns=\"http://www.webserviceX.NET\">"
				+"<CityName>guiyang</CityName>"
				+"<CountryName>"+"</CountryName>"
				+"</GetWeather>"
				+"</soap:Body>"
				+"</soap:Envelope>";
		//得到输出流
		OutputStream oStream = httpuc.getOutputStream();
		//用输出流写出消息体
		oStream.write(data.getBytes());
		
		//如果httpuc的状态码为200，说明请求成功
		if(httpuc.getResponseCode()==200){
			//接收响应参数
			InputStream iStream = httpuc.getInputStream();
			
			/*int i=0;
			byte[] buf=new byte[1024];
			while((i=iStream.read(buf))>0){
				System.out.println(new String(buf,0,i));
			}*/
			
			BufferedReader bReader=new BufferedReader(new InputStreamReader(iStream));
			String line=null;
			StringBuffer sBuffer=new StringBuffer();
			while((line=bReader.readLine())!=null){
				sBuffer.append(line);
			}
			System.out.println(sBuffer);
//			Document document = new SAXReader().read(iStream);
//			System.out.println(document);
		}
		
	}
}
