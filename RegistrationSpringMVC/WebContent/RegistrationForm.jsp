<%@ taglib uri= "http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="Common.jsp" %>
<h2>${msg}</h2>

<h1>Add Details for User</h1>

<form:form method="post" action="save">
	<table>
		<tr>
			<td>Name : </td>
			<td><form:input path="usrname"/></td>
		</tr>
		<tr>
			<td>Password : </td>
			<td><form:password path="usrpwd"/></td>
		</tr>
		<tr>
			<td>Email : </td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td>Country : </td>
			<td><form:input path="country"/></td>
		</tr>
		<tr>
			<td>Contact : </td>
			<td><form:input path="contact"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Register"/></td>
		</tr>
	</table>	
</form:form>