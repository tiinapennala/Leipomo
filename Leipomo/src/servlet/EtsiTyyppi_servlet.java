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


@WebServlet("/EtsiTyyppi_servlet")
public class EtsiTyyppi_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public EtsiTyyppi_servlet() {
        super();
        System.out.println("EtsiTyyppi_servlet.EtsiTyyppi_servlet()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EtsiTyyppi_servlet.doGet()");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EtsiTyyppi_servlet.doPost()");
		String hakusana = request.getParameter("hakusana");
		Dao dao = new Dao();
		try {
			ArrayList<Tuote> tuotteet= dao.etsiTyyppi(hakusana);
						
			request.setAttribute("tuotteet", tuotteet);		
			String jsp = "/Paavalikko.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

	}


