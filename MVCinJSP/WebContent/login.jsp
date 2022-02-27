<%@page import="mvcjsptest.*"%>
<p>You r successfully loged in</p>
<%
	MVCBean obj=(MVCBean)request.getAttribute("obj");
	String name=obj.getName();
	out.println(name);
%>