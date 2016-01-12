package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LaufKi
 */
@WebServlet("/LaufKi")
public class LaufKi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String brett = "/Brett.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaufKi() {
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
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(brett);
		
		Index.getGame().laufen(Index.getGame().getSpielerAmZug().getKi().startZiel().get(0),Index.getGame().getSpielerAmZug().getKi().getZiel().get(1));
		
//		rd.forward(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try{
			out.println(Brett.getHeader());
			out.println(Brett.getMenu());
			out.println(Brett.getTable());
			out.println(Brett.getMenuEnd());
		}finally{
			out.println(Brett.getFooter());
			out.close();
		}
	}

}
