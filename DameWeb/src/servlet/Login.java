package servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String Wait = "/Wait.jsp";
	
	


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
//		System.out.println("bla: "+request.getSession().getAttribute("x"));
//		HttpSession session = request.getSession();
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(Wait);
		// gegner
		String typ2=request.getParameter("spielerart2");
		request.getSession().setAttribute("gegner", typ2);
		Index.getGame().setGegner(typ2);
		
		String name = request.getParameter("name");	
		String farbe = request.getParameter("farbeSpieler");
		String typ1 = request.getParameter("spielerart1");	
		request.getSession().setAttribute("farbe1", farbe);
		Index.getGame().setFarbeWeb(farbe);
		
		Index.getGame().addSpieler(name, Index.getGame().bestimmeFarbe(farbe), Index.getGame().bestimmeKI(typ1));
			
		if(typ2.equals("KI")){
			Index.getGame().addSpieler("Computer", Index.getGame().bestimmeFarbe(this.farbeKI(request, response)), Index.getGame().bestimmeKI("KI"));
			this.tableGame(request, response);
		}else{
			rd.forward(request, response);
		}

		
		
	}
	
	public void tableGame(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Index.getGame().starteSpiel();
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
	
	public String farbeKI(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String farbe = request.getParameter("farbeSpieler");
		String farbeKI = null;
		if(farbe.equals("Weiss")){
			farbeKI="Schwarz";	
		}else if (farbe.equals("Schwarz")){
			farbeKI="Weiss";	
		}
		return farbeKI;
		
	}
	

	
	
	
}
