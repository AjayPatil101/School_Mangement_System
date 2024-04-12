<%@page import="SchoolManagment.Student"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Student Data</h1>
		<form action="Div4.html" method="post">
			<%
			String id = request.getParameter("id");
			int id1 = Integer.parseInt(id);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ajay");
			EntityManager em = emf.createEntityManager();
			Student t = em.find(Student.class, id1);
			%>
			<table align="center" cellpadding="10px" border="10">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
				</tr>
				<tr>
					<td><%= t.getId()%></td>
					<td><%= t.getName()%></td>
					<td><%= t.getEmail()%></td>
					<td><%= t.getPassword()%></td>
				</tr>
			</table><br><br>
			<input type="submit" value=Home>
		</form>

	</div>


</body>
</html>