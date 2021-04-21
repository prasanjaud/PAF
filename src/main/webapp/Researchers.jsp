<%@page import="com.gb.model.Researcher"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gb.service.ResearcherImp"%>
<%@page import="com.gb.service.IResearcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<title>Researchers</title>
</head>
<body>
<h2>Researchers Information</h2>
<div style=" position: absolute; right: 10px; margin-bottom: 20px; top:25px;">
	<a href="Addresearchers.jsp" > <button style="cursor: pointer;padding: 3px;">+ Add new Researcher</button></a>
</div>

<table style="width:100%">
  <tr>
    <th>#</th>
    <th>Id</th>
    <th>name</th> 
    <th>Project Type</th>
    <th>Payment</th>
    <th>Contact number</th>
    <th colspan="2">option</th>
  </tr>
  <%
  	IResearcher service = new ResearcherImp();
    int i =0;
  	ArrayList<Researcher> researcherList = service.getReacherList();
  	for(Researcher researcher : researcherList){
  	i ++;	
  %>
  <tr>
    <td><%=i %></td>
    <td><%=researcher.getId() %></td>
    <td><%=researcher.getName() %></td>
    <td><%=researcher.getProjectType() %></td>
    <td><%=researcher.getPayment() %>0</td>
    <td><%=researcher.getContact()%></td>
    <td>
		<a  href="Addresearchers.jsp?id=<%=researcher.getId() %>" >update</a>
	</td>
     <td>
		<a  href="deleteReasearcher?id=<%=researcher.getId() %>"  style="color:red;">Delete</a>
	</td>
  </tr>
  <%} %>

</table>

</body>
</html>
