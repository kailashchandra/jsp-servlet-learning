<%@include file="Admin.jsp"%>
<%@page import="bean.*;"%>
<%
	Login bean=(Login)request.getAttribute("login");
%>
<form action="UpdateController" method="post">
<input type="hidden" name="id" value=<%=bean.getId() %>>
Name : <input type="text" name="name" value=<%=bean.getName() %>><br>
	Password : <input type="text" name="pass" value=<%=bean.getPassword() %>><br>
	email : <input type="email" name="email" value=<%=bean.getEmail() %>>
	Country : <select name="country" value=<%=bean.getCountry() %>>
		<option value="India">India</option>
		<option value="US">US</option>
		<option value="Sweden">Sweden</option>
		<option value="Jermeny">Jermeny</option>
		<option value="Canada">Canada</option>
	</select>
	Contact : <input type="number" name="contact" value=<%=bean.getNum() %>>
	<input type="submit" name="Update">
</form>