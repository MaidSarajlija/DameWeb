package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Laufen
 */
@WebServlet("/Laufen")
public class Laufen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer>datenLaufenWeb=new ArrayList<Integer>();
	private static final String brett = "/Brett.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Laufen() {
        super();
        // TODO Auto-generated constructor stub
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
		
		int feld1=Integer.parseInt(request.getParameter("m"));
		datenLaufenWeb.add(feld1);
		if(datenLaufenWeb.size()==2){
			Index.getGame().laufen(Index.getGame().convertPos2(datenLaufenWeb.get(0)),Index.getGame().convertPos2(datenLaufenWeb.get(1)));
			datenLaufenWeb.clear();
		}
		
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
