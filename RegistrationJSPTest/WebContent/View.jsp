<%@include file="Admin.jsp" %>
<%@page import ="java.util.*" %>
<%@page import ="bean.*" %>
<%
	ArrayList<Login> login=(ArrayList<Login>)request.getAttribute("arraylist");
	Iterator<Login> itr= login.iterator();
%>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
th,td {
    text-align: center;
}
</style>
<table>
	  <tr>
	    <th>Name</th>
	    <th>Password</th>
	    <th>Email</th>
	    <th>Country</th>
	    <th>Mobile Number</th>
	    <th>Delete</th>
	    <th>Update</th>
	  </tr>
<%	
Login loginBean;
while(itr.hasNext()){
		loginBean=itr.next();
%>
<tr>
    <td><%=loginBean.getName()%></td>
    <td><%=loginBean.getPassword()%></td>
    <td><%=loginBean.getEmail()%></td>
    <td><%=loginBean.getCountry()%></td>
    <td><%=loginBean.getNum()%></td>
    <td><a href="DeleteController?msg=<%=loginBean.getId()%>">Delete</a></td>
    <td><a href="UpdateController?msg=<%=loginBean.getId()%>">Update</a></td>
</tr>
<%}%>
</table>