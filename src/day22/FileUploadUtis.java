package day22;

import java.util.Arrays;


public class FileUploadUtis {

	//hashconde	目录分离算法
	public static String getRandomDirectory(String fileName){
		int hashCode = fileName.hashCode();
//		System.out.println(hashCode);
		
		//int在内存中占4个字节，32位,转换成16进制数，就得到8个16进制数
//		String hex = Integer.toHexString(hashCode);
//		int length = hex.length();
//		for(int i=0;i<(8-length);i++){
//			hex="0"+hex;
//		}
//		StringBuffer sBuffer=new StringBuffer();
//		char[] charArray = hex.toCharArray();
//		for(int i=0;i<charArray.length;i++){
//			sBuffer.append("/");
//			sBuffer.append(charArray[i]);
//		}
//		System.out.println(sBuffer.toString());
////		return sBuffer.toString();
		
		String str="";
		for(int i=2;i>0;i--){
			str="/"+Integer.toHexString(hashCode&0xf)+str;//0xf	十六进制1111，与hashCode做位与，即取出了hashCode的低4位
			hashCode=hashCode>>>4;
		}
		System.out.println(str);
		
		return str;
	}
	
	public static void main(String[] args) {
		String path=getRandomDirectory("a.txt");
	}
}
