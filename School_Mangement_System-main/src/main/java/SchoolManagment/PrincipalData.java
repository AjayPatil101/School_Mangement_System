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

@WebServlet("/AddPrincipanl")
public class PrincipalData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String Name = req.getParameter("name");
		String email = req.getParameter("email");
		String Pass = req.getParameter("password");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ajay");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		int number = Integer.parseInt(id);
		
		Principal p = new Principal();
		p.setId(number);
		p.setName(Name);
		p.setEmail(email);
		p.setPassword(Pass);
		
		et.begin();
		em.persist(p);
		et.commit();
		em.close();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter() ;
		pw.write("Principal Account Cereat Successfull");

		RequestDispatcher rd = req.getRequestDispatcher("PrincipalLogin.html");
		rd.include(req, resp);
	}
}
