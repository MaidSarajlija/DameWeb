package servlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Wait")
public class Wait extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String Wait = "/Wait.jsp";
//	ArrayList<String> list = new ArrayList<String>();
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wait() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=ISO-8859-1");
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(Wait);
		

		
		if(Index.getGame().getNameWeb()!=null){
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
//			Index.getGame().starteSpiel();
			try{
				out.println(Brett.getHeader());
				out.println(Brett.getMenu());
				out.println(Brett.getTable());
				out.println(Brett.getMenuEnd());
			}finally{
				out.println(Brett.getFooter());
				out.close();
			}
		}else{
			rd.forward(request, response);
		}
	}

	

	
	
	
}
