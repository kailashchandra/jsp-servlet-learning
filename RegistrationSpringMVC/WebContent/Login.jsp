<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
${msg}
<form:form method="post" action="login">
	<table>
		<tr>
			<td>Name:</td>
			<td><form:input path="usrname"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><form:password path="usrpwd"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="login"/></td>
		</tr>
	</table>
</form:form>
