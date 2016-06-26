<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>#进行投影过滤 </title>
</head>
<body>
	<s:debug />
	<hr>
	valueStack（中的context）中root的数据：<br>
	<s:property value="#root" />
	<hr>
	1)集合的投影(只输出部分属性)<br>
	<s:iterator value="users.{userName}" var="user">
		<s:property value="#user"/>
		<br>
	</s:iterator>
	<hr>
	2）将年龄下于24岁的人得到<br>
	<s:iterator value="users.{?#this.age<24}" var="user">
		<s:property value="#user"/>
		<br>
	</s:iterator>
	<hr>
	3）将年龄下于24岁的人的名称得到<br>
	<s:iterator value="users.{?#this.age<24}.{userName}" var="un">
		<s:property value="#un"/>
		<br>
	</s:iterator>
	<hr>
	4)使用＃来构建map集合<br>
	<s:iterator value="#{'name':'tom','age':20}" var="entry">
		<s:property value="#entry.key"/>=<s:property value="#entry.value"/>
		<br>
	</s:iterator>
	5)构建list集合<br>
	<s:iterator value="{'aa','bb','cc'}" var="v">
		<s:property value="#v"/>
		<br>
	</s:iterator>
	<hr>
	手动构建集合，经常结合 struts2 标签用来生成 select、checkbox、radio
	<s:form>
		<s:radio list="{'男','女'}" name="gerden" /><br>
		<s:radio list="#{'male':'男','female':'女'}" name="gerden2" />
		<s:select list="{'aa','bb','cc'}" />
	</s:form>
</body>
</html>