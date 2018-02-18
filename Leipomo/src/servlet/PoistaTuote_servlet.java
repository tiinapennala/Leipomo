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


@WebServlet("/PoistaTuote_servlet")
public class PoistaTuote_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PoistaTuote_servlet() {
        super();
        System.out.println("PoistaTuote_servlet.PoistaTuote_servlet()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PoistaTuote_servlet.doGet()");
		int tuotenro = Integer.parseInt(request.getParameter("tuotenro"));
		Dao dao = new Dao();
		Tuote tuote = dao.haeTuote(tuotenro);
		if(tuote!=null){
			System.out.println(tuote);
			request.setAttribute("tuote", tuote);		
			String jsp = "/PoistaTuote.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
		}else{
			request.setAttribute("tuotteet", new ArrayList<Tuote>());		
			String jsp = "/Paavalikko.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
		}
	}

	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PoistaTuote_servlet.doPost()");
		int poistaTuotenro = Integer.parseInt(request.getParameter("poistaTuotenro"));
		Dao dao = new Dao();
		dao.poistaTuote(poistaTuotenro);
		
		String jsp = "/Paavalikko.jsp"; 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);			
	}

}
