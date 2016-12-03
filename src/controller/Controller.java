package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		
		//This is an example of Application wide data not only session wise, however if server is shut down then the value will reset.
		//Session wise means losing the data once the session is closed i.e. Timeout from websites
		//The below example will explore number of hits on a site which is application wide as it counts every request from every IP Address in the World
		//This is a good method but does not cover persistance. This will be looked into later under 'Databases'.
		
		//Here fetching numbers of hits on site
		Integer hits = (Integer)context.getAttribute("hits");
		
		if(hits == null) {
			hits = 0;
		}
		else {
			//We want each request to integrate each counter
			hits++;
		}
		
		//Now feeding the hits count back in as the servlet context
		context.setAttribute("hits", hits);
		
		//Fetching the number of hits
		PrintWriter out = response.getWriter();
		
		//Printing out the number of hits on screen
		out.println("Hits: " + hits);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
