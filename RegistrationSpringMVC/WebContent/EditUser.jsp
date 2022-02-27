<%@ taglib uri= "http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="Common.jsp" %>

<h1>Edit User Details</h1>

<form:form method="post" action="/RegistrationSpringMVC/edit">
	<table>
		<tr>
			<td><form:hidden path="usrid"/></td>
		</tr>
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
			<td><input type="submit" value="Update"/></td>
		</tr>
	</table>	
</form:form>