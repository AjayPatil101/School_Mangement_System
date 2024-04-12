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

@WebServlet("/RemoveTecher")
public class TeacherDeleted extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ajay");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		int number = Integer.parseInt(id);
		Query q = em.createQuery("Select a from Teacher a where a.id=?1");
		q.setParameter(1, number);
		PrintWriter pw = resp.getWriter();
		List<Teacher> pr = q.getResultList();
		System.out.println(pr);
		if(pr.size()!=0) { 
			et.begin();
			em.remove(pr.get(0));
			et.commit();
			pw.write("Teacher Deieted Successfully..");
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
