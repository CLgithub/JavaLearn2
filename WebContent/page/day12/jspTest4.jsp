<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    buffer="1kb"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp内置对象</title>
</head>
<body>
	<%
		session.getId();
		request.getSession();
	%>
	<!-- out对象测试 -->
	<%
	//	out.write("abc");	//只写前面的头信息，深779
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<778;i++){
			sb.append("a");
		}
		out.write(sb.toString());
		
	//	out.flush();//手动刷新
		
		//查看当前缓冲区总大小
		System.out.println("缓冲区总大小:"+out.getBufferSize());
		//查看当前缓冲区剩余大小
		System.out.println("缓冲区区剩余大小:"+out.getRemaining());
		
		response.getWriter().write("123");
	%>
</body>
</html>