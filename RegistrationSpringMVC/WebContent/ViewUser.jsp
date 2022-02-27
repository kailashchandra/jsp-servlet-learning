<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="Common.jsp" %>
<h2>${msg}</h2>
<h1>List of the Users</h1>

<table>
	<tr>
		<th>ID</th><th>User Name</th><th>Email Id</th><th>Contact</th><th>Country</th>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.usrid}</td>
			<td>${user.usrname}</td>
			<td>${user.email}</td>
			<td>${user.contact}</td>
			<td>${user.country}</td>
			<td><a href="editUser/${user.usrid}">Edit</a></td>
			<td><a href="deleteUser/${user.usrid}">Delete</a></td>
		</tr>
	
	</c:forEach>
</table>
