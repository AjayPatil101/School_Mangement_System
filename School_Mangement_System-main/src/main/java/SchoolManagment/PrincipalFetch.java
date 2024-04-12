package SchoolManagment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Principanfetch")
public class PrincipalFetch extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO Auto-generated method stub
		String email = req.getParameter("eamil");
		String Pass = req.getParameter("password");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ajay");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("Select a from Principal a where a.email=?1 and a.Password=?2");
		q.setParameter(1, email);
		q.setParameter(2, Pass);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		List<Principal> pr = q.getResultList();
		System.out.println(pr);
		if(pr.size()!=0) { 
			pw.write("Principal Login Successfull");
			RequestDispatcher rd = req.getRequestDispatcher("Div2.html");
			rd.include(req, resp);
		}
		else {
			pw.write("Invalid..");
			RequestDispatcher rd = req.getRequestDispatcher("Div1.html");
			rd.include(req, resp);
		}
	}
}
