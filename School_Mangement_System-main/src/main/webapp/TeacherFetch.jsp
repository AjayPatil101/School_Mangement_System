<%@page import="SchoolManagment.Teacher"%>
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
</head><div align="center">
		<h1>Teacher Data</h1>
		<form action="Div3.html" method="post">
			<%
			String id = request.getParameter("id");
			int id1 = Integer.parseInt(id);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ajay");
			EntityManager em = emf.createEntityManager();
			Teacher t = em.find(Teacher.class, id1);
			%>
			<table align="center" cellpadding="10px" border="10">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Salary</th>
					<th>Subject</th>
				</tr>
				<tr>
					<td><%= t.getId()%></td>
					<td><%= t.getName()%></td>
					<td><%= t.getSalary()%></td>
					<td><%= t.getSubject()%></td>
				</tr>
			</table><br><br>
			<input type="submit" value=Home>
		</form>

	</div>

</body>
</html>