<%--@ page errorPage="error.jsp" --%>
<%
	int num1=Integer.parseInt(request.getParameter("n1"));
	int num2=Integer.parseInt(request.getParameter("n2"));
	int c=num1/num2;
	out.print("result :"+c);
%>