<%@ page language="java" import="java.util.*" pageEncoding="BIG5"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>讀卡機測試網頁</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form id="form" name="form" method="post" action="./getReader">
		<table>
    		<tr>
    			<td>讀卡機IP</td>
    			<td><input name="cardIP" type="text" /></td>
    			<td>傳送指令</td>
    			<td><input name="cmd" type="text" /></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="送出"/></td>
				<td colspan="2"><input type="reset" value="重選"/></td>
    		</tr>
    	</table>
    	</form>
  </body>
</html>
