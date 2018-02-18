package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Tuote;
import dao.Dao;


@WebServlet("/Lisaa_servlet")
public class Lisaa_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Lisaa_servlet() {
        super();
        System.out.println("Lisaa_servlet.Lisaa_servlet()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Lisaa_servlet.doGet()");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Lisaa_servlet.doPost()");
		String n = request.getParameter("nimi");
		String h = request.getParameter("hinta");
		String t = request.getParameter("tyyppi");
		String k = request.getParameter("kuvaus");
		
		if (n == null || n.trim().isEmpty() || t == null || t.trim().isEmpty() || h == null || h.trim().isEmpty()) {
			String jsp = "/Paavalikko.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
		} else {
			Tuote uusi = new Tuote();
			uusi.setNimi(n);
			uusi.setHinta(Double.parseDouble(h));
			uusi.setTyyppi(t);
			uusi.setKuvaus(k);
			Dao dao = new Dao();
			dao.lisaaTuote(uusi);
			
			//response.sendRedirect("Paavalikko?hakusana=" + request.getParameter("nimi"));
			String jsp = "/Paavalikko.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
		}
	}

}
