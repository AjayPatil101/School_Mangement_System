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
</head>
<body>
	<div align="center">
		<h1>Enter Teacher Id To Remove</h1>
		<%
		String id = request.getParameter("id");
		int id1 = Integer.parseInt(id);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ajay");
		EntityManager em = emf.createEntityManager();
		Teacher t = em.find(Teacher.class, id1);
		%>
		<form action="UpdateTeacher" method="post">
			<table>
				<tr>
					<td>Id:</td>
					<td><input type="text" value="<%=t.getId()%>" name="id"></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" value="<%=t.getName()%>" name="name"></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><input type="text" value="<%=t.getSalary()%>"
						name="salary"></td>
				</tr>
				<tr>
					<td>Subject:</td>
					<td><input type="text" value="<%=t.getSubject()%>"
						name="subject"></td>
				</tr>

				<tr align="center">
					<td><input type="submit" value=Submit></td>
				</tr>
			</table>
		</form>

	</div>


</body>
</html>