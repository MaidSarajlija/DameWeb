package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrettWeb
 */
@WebServlet("/BrettWeb")
public class BrettWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String brett = "/Brett.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrettWeb() {
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
		String s="";
		s+="<input id='refresh' type = 'submit' value = 'Lauf Ki' name='laufKi'>";
		request.getSession().setAttribute("laufKI", s);
		
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(brett);
		rd.forward(request, response);
	}

}
