<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>多文件上传</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/upload4" method="post"	enctype="multipart/form-data" >
		<table border="1">
			<tbody>
				<tr id="lastRow">
					<td><a href="#" onclick="addf()">添加</a></td><td></td>
				</tr>
			</tbody>
		</table>
		
		<input type="submit" value="上传">
	</form>
</body>
<script type="text/javascript">
	function addf() {
		var tableObject=document.getElementsByTagName("table")[0];
		var rowNumber=tableObject.rows.length;
		var rowN=tableObject.insertRow(rowNumber);
		var lie1= rowN.insertCell(0);
		var lie2=rowN.insertCell(1);
		lie1.innerHTML='<input type="file" name="f" />';
		lie2.innerHTML='<a href="#" onclick="deleteT1(this)">'+rowNumber+'删除附件</a>'; 
	}
	function deleteT1(a) {
		var i=a.parentNode.parentNode.rowIndex;
		var tableObject=document.getElementsByTagName("table")[0];
		tableObject.deleteRow(i);
	}
	
	
</script>
</html>