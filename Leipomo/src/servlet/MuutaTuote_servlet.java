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


@WebServlet("/MuutaTuote_servlet")
public class MuutaTuote_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MuutaTuote_servlet() {
        super();
        System.out.println("MuutaTuote_servlet.MuutaTuote_servlet()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MuutaTuote_servlet.doGet()");
		int tuotenro = Integer.parseInt(request.getParameter("tuotenro"));
		Dao dao = new Dao();
		Tuote tuote = dao.haeTuote(tuotenro);
		if(tuote!=null){
			System.out.println(tuote);
			request.setAttribute("tuote", tuote);		
			String jsp = "/MuutaTuote.jsp"; 
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
		System.out.println("MuutaTuote_servlet.doPost()");
		Tuote tuote = new Tuote();
		tuote.setNimi(request.getParameter("nimi"));
		tuote.setTyyppi(request.getParameter("tyyppi"));
		tuote.setHinta(Double.parseDouble(request.getParameter("hinta")));
		tuote.setKuvaus(request.getParameter("kuvaus"));
		int vanhaTuotenro = Integer.parseInt(request.getParameter("vanhaTuotenro"));
		Dao dao = new Dao();
		dao.muutaTuote(tuote, vanhaTuotenro);
		
		Tuote t = dao.haeTuote(vanhaTuotenro);
		if(t!=null){
			ArrayList<Tuote> tuotteet = new ArrayList<Tuote>();
			tuotteet.add(t);
			request.setAttribute("tuotteet", tuotteet);		
			String jsp = "/Paavalikko.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);			
		}else{
			response.sendRedirect("Paavalikko");
		}
		
	}

}
