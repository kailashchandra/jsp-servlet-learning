<%
		String status=(String)request.getSession().getAttribute("Type");
		if(status!=null&& status.equalsIgnoreCase("true")){
			%><a href = "Logout.jsp" >logout</a><br><%		
		}else{
			response.sendRedirect("Login.jsp?msg=plz login before moving forward.....");
		}
%>