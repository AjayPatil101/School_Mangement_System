package SchoolManagment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherData")
public class TeacherData extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String Name = req.getParameter("name");
		String salary = req.getParameter("salary");
		String Subject = req.getParameter("subject");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ajay");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		double Salary = Double.parseDouble(salary);
		int number = Integer.parseInt(id);

		Teacher p = new Teacher();
		p.setId(number);
		p.setName(Name);
		p.setSalary(Salary);
		p.setSubject(Subject);

		et.begin();
		em.persist(p);
		et.commit();
		em.close();

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("Teacher Added Successfully");

		RequestDispatcher rd = req.getRequestDispatcher("Div3.html");
		rd.include(req, resp);
	}
}
