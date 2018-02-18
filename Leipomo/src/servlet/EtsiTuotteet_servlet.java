package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Tuote;
import dao.Dao;


@WebServlet("/EtsiTuotteet_servlet")
public class EtsiTuotteet_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EtsiTuotteet_servlet() {
        super();
        System.out.println("EtsiTuotteet_servlet.EtsiTuotteet_servlet()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EtsiTuotteet_servlet.doGet()");
		ArrayList<Tuote> tuotteet = new ArrayList<Tuote>();

		request.setAttribute("tuotteet", tuotteet);		
		String jsp = "/Paavalikko.jsp"; 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EtsiTuotteet_servlet.doPost()");
		String hakusana = request.getParameter("hakusana");
		Dao dao = new Dao();
		try {
			ArrayList<Tuote> tuotteet= dao.etsiTuotteet(hakusana);
						
			request.setAttribute("tuotteet", tuotteet);		
			String jsp = "/Paavalikko.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
