package com.gb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gb.service.IResearcher;
import com.gb.service.ResearcherImp;

/**
 * Servlet implementation class deleteReseacher
 */
@WebServlet("/deleteReseacher")
public class deleteReseacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteReseacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		// create boolean variable for get out put of query
		boolean isTrue;
		//create interface object
		IResearcher service = new ResearcherImp();
		
		
		
		//call function
		try {
			isTrue = service.deleteResearcher(id) ;
			
			if(isTrue == true) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("researchers.jsp");
				dispatcher.forward(request, response);
				
			}
			else { 
				 
				 
				RequestDispatcher dispatcher = request.getRequestDispatcher("researchers.jsp");
				dispatcher.forward(request, response);
				
			}
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
