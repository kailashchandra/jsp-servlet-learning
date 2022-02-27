<%
	String msg=request.getParameter("msg");
	if(msg!=null){
		out.println(msg);
	}
%>
<form action="LoginCotroller" method="post"> 
Name : <input type = "text" name="name">
Password : <input type ="password" name ="password">
<input type ="submit" value="Login">
</form>
