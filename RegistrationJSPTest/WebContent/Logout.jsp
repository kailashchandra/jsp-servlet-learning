<%  
response.setHeader("Cache-Control","no-store");   
response.setHeader("Pragma","no-cache");   
response.setHeader ("Expires", "0"); //prevents caching at the proxy server  
%>  
<% 
	session.invalidate();
	//out.println("your r successfully logout"+request.getSession().getAttribute("Type"));
	//request.getRequestDispatcher("Login.jsp").include(request,response);
	response.sendRedirect("Login.jsp");
%>