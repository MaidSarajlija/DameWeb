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
	private static final String brett = "/Brett.jsp";
	
	


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
		RequestDispatcher rd1 = sc.getRequestDispatcher(brett);
		// gegner
		String typ2=request.getParameter("spielerart2");
		request.getSession().setAttribute("gegner", typ2);
		Index.getGame().setGegner(typ2);
		
		String name = request.getParameter("name");	
		String farbe = request.getParameter("farbeSpieler");
		String typ1 = request.getParameter("spielerart1");	
		request.getSession().setAttribute("farbe1", farbe);
		Index.getGame().setFarbeWeb(farbe);
		
//		String s="";
//		if(Index.getGame().hatGewonnen()==true){
//			s+="<input disabled id='refresh' type = 'submit' value = 'Lauf Ki' name='laufKi'>";
//		}else{
//			s+="<input id='refresh' type = 'submit' value = 'Lauf Ki' name='laufKi'>";
//		}
//		request.getSession().setAttribute("laufKI", s);
		
		
		
		Index.getGame().addSpieler(name, Index.getGame().bestimmeFarbe(farbe), Index.getGame().bestimmeKI(typ1));
		
		if(typ2.equals("KI")){
			Index.getGame().addSpieler("Computer", Index.getGame().bestimmeFarbe(this.farbeKI(request, response)), Index.getGame().bestimmeKI("KI"));
			this.tableGame(request, response);
			
//			Index.getGame().starteSpiel();
			
//			int b=0;
//			for(int i=0;i<12;i++){
//				for(int k=0;k<12;k++){
//					b++;
//					String fig="";
//					if(Index.getGame().hatGewonnen()==true){
//						fig="<a onclick='myFunction("+b+")' href='javascript:;' class='active' >";
//					}
//					request.getSession().setAttribute("link", fig);
//					if(b==2||b==4 ||b==6||b==8 ||b==10 ||b==12){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==13||b==15||b==17||b==19||b==21||b==23){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==26||b==28||b==30||b==32||b==34||b==36){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==37||b==39||b==41||b==43||b==45||b==47){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==50||b==52||b==54||b==56||b==58||b==60){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==61||b==63||b==65||b==67||b==69||b==71){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==74||b==76||b==78||b==80||b==82||b==84){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==85||b==87||b==89||b==91||b==93||b==95){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==98||b==100||b==102||b==104||b==106||b==108){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==109||b==111||b==113||b==115||b==117||b==119){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==122||b==124||b==126||b==128||b==130||b==132){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//					if(b==133||b==135||b==137||b==139||b==141||b==143){
//						String update=this.updateFigur(b);
//						request.getSession().setAttribute("fig", update);
//					}
//				}
//			}
			
			
//			rd1.forward(request, response);
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
	
	public String updateFigur(int i){
		String o="";
		
		//----Schwarz------
		if(Index.getGame().gibFigurWebId()[i]!=null&&Index.getGame().gibFigurWebId()[i]=="schwarz"){
			o="<img src='Bilder/schwarzerStein.png'>";
		}
		else{
			//----leere Figur---
			o="<img src='Bilder/leererStein.png'>";
		}
		
		//-----Weiss-----
		if(Index.getGame().gibFigurWebId()[i]!=null&&Index.getGame().gibFigurWebId()[i]=="weiss"){
			o="<img src='Bilder/weissStein.png'>";
		}
		return o;
		
	}
	

	
	
	
}
