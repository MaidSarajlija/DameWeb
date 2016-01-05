package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginGegner")
public class LoginGegner extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginGegner() {
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
		String name = request.getParameter("name2");
		String farbe = this.farbeGegner(request, response);
		request.getSession().setAttribute("farbe2", farbe);
		Index.getGame().setNameWeb(name);
		
		Index.getGame().addSpieler(name, Index.getGame().bestimmeFarbe(farbe), Index.getGame().bestimmeKI("Mensch"));
		this.tableGame(request, response);
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
	
	public String farbeGegner(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String farbe =Index.getGame().getFarbeWeb();
		String farbeKI = null;
		if(farbe.equals("Weiss")){
			farbeKI="Schwarz";	
		}else if (farbe.equals("Schwarz")){
			farbeKI="Weiss";	
		}
		return farbeKI;
		
	}
	
	

	
	
	
}
