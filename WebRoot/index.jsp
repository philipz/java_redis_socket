<%@ page language="java" import="java.util.*" pageEncoding="BIG5"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Ū�d�����պ���</title>
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
    			<td>Ū�d��IP</td>
    			<td><input name="cardIP" type="text" /></td>
    			<td>�ǰe���O</td>
    			<td><input name="cmd" type="text" /></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="�e�X"/></td>
				<td colspan="2"><input type="reset" value="����"/></td>
    		</tr>
    	</table>
    	</form>
  </body>
</html>
