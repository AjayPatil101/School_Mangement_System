package SchoolManagment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherFetch")
public class TeacherFetch extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ajay");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		int number = Integer.parseInt(id);
		Query q = em.createQuery("Select a from Teacher a where a.id=?1");
		q.setParameter(1, number);
		PrintWriter pw = resp.getWriter();
		List<Teacher> pr = q.getResultList();
		if (pr.size() != 0) {
			pw.write("ID : " + pr.get(0).getId() + "\n");
			pw.write("Name : " + pr.get(0).getName() + "\n");
			pw.write("Salary : " + pr.get(0).getSalary() + "\n");
			pw.write("Subject : " + pr.get(0).getSubject());
			resp.setContentType("text/html");
			RequestDispatcher rd = req.getRequestDispatcher("Div3.html");
			rd.include(req, resp);

		} 
		else {
			pw.write("Invalid..");
			resp.setContentType("text/html");
			RequestDispatcher rd = req.getRequestDispatcher("Div3.html");
			rd.include(req, resp);
		}
	}
}
