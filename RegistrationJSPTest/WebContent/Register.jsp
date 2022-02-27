<%@include file="Admin.jsp" %>
<form action="RegisterController" method="post">
	Name : <input type="text" name="name"><br>
	Password : <input type="password" name="pass"><br>
	email : <input type="email" name="email">
	Country : <select name="country">
		<option value="India">India</option>
		<option value="US">US</option>
		<option value="Sweden">Sweden</option>
		<option value="Jermeny">Jermeny</option>
		<option value="Canada">Canada</option>
	</select>
	Contact : <input type="number" name="contact">
	<input type="submit" name="Register">
</form>


