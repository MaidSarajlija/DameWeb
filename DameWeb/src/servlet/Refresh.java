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
 * Servlet implementation class Refresh
 */
@WebServlet("/Refresh")
public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String brett = "/Brett.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Refresh() {
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
//		if(request.getParameter("refreshLaden")!=null){
//			
//			SpielerLadenWeb.getGameLaden().farbeSession(SpielerLadenWeb.getGameLaden().ermittleSpielerAmZugFarbe());
//		
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			try{
//				out.println(BrettLaden.getHeader());
//				out.println(BrettLaden.getMenu());
//				out.println(BrettLaden.getTable());
//				out.println(BrettLaden.getMenuEnd());
//			}finally{
//				out.println(BrettLaden.getFooter());
//				out.close();
//			}
//			
//		}else 
			if(request.getParameter("refreshNormal")!=null){
				
			
			String farbe=(String)request.getSession().getAttribute("farbe1");
			String farbeNext=(String)request.getSession().getAttribute("farbe2");
			
			if(Index.getGame().ermittleSpielerAmZugFarbe().equals(farbe)){
				Index.getGame().farbeSession(farbe);
			}else{
				Index.getGame().farbeSession(farbeNext);
			}
			
			if(farbeNext==null){
				Brett.press=true;
			}
			
//			rd.forward(request, response);
			
			
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

}
