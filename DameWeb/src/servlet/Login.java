package servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import klassen.SpielBean;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String[]x;
	
	private static final String Wait = "/Wait.jsp";
	private static final String brett = "/Brett.jsp";
	private static final String LoginGegner = "/LoginGegner.jsp";
	
	


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
		RequestDispatcher rd2 = sc.getRequestDispatcher(LoginGegner);
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
			Index.getGame().starteSpiel();
			
			this.brettRufen(request, response);
			
			rd1.forward(request, response);
		}
		// --- ki gegen mensch 1 browser 
		else if(typ1.equals("KI")&&typ2.equals("Mensch")){
			rd2.forward(request, response);
		}else{
			rd.forward(request, response);
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
	
	public void brettRufen(HttpServletRequest request, HttpServletResponse response){
		ServletContext sc = this.getServletContext();
		String ab=sc.getRealPath("/");
		Index.getGame().setRealPath(ab);
		String s="";
		if(Index.getGame().hatGewonnen()==true){
			s+="<input disabled id='refresh' type = 'submit' value = 'Lauf Ki' name='laufKi'>";
		}else{
			s+="<input id='refresh' type = 'submit' value = 'Lauf Ki' name='laufKi'>";
		}
		request.getSession().setAttribute("laufKI", s);
		
		
		ArrayList<String> ausgabe=this.ausgabe();
		request.getSession().setAttribute("ausgabe", ausgabe);
		
		int b=0;
		for(int i=0;i<12;i++){
			for(int k=0;k<12;k++){
				b++;
				String fig="";
				if(Index.getGame().hatGewonnen()==true){
					fig="<a onclick='myFunction("+b+")' href='javascript:;' class='active' >";
				}
				request.getSession().setAttribute("link", fig);
				
				if(b==2){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig1", update);
				}
				if(b==4){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig2", update);
				}
				if(b==6){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig3", update);
				}
				if(b==8){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig4", update);
				}
				if(b==10){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig5", update);
				}
				if(b==12){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig6", update);
				}
				if(b==13){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig7", update);
				}
				if(b==15){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig8", update);
				}
				if(b==17){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig9", update);
				}
				if(b==19){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig10", update);
				}
				if(b==21){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig11", update);
				}
				if(b==23){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig12", update);
				}
				if(b==26){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig13", update);
				}
				if(b==28){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig14", update);
				}
				if(b==30){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig15", update);
				}
				if(b==32){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig16", update);
				}
				if(b==34){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig17", update);
				}
				if(b==36){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig18", update);
				}
				if(b==37){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig19", update);
				}
				if(b==39){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig20", update);
				}
				if(b==41){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig21", update);
				}
				if(b==43){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig22", update);
				}
				if(b==45){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig23", update);
				}
				if(b==47){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig24", update);
				}
				if(b==50){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig25", update);
				}
				if(b==52){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig26", update);
				}
				if(b==54){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig27", update);
				}
				if(b==56){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig28", update);
				}
				if(b==58){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig29", update);
				}
				if(b==60){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig30", update);
				}
				if(b==61){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig31", update);
				}
				if(b==63){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig32", update);
				}
				if(b==65){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig33", update);
				}
				if(b==67){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig34", update);
				}
				if(b==69){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig35", update);
				}
				if(b==71){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig36", update);
				}
				if(b==74){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig37", update);
				}
				if(b==76){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig38", update);
				}
				if(b==78){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig39", update);
				}
				if(b==80){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig40", update);
				}
				if(b==82){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig41", update);
				}
				if(b==84){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig42", update);
				}
				if(b==85){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig43", update);
				}
				if(b==87){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig44", update);
				}
				if(b==89){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig45", update);
				}
				if(b==91){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig46", update);
				}
				if(b==93){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig47", update);
				}
				if(b==95){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig48", update);
				}
				if(b==98){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig49", update);
				}
				if(b==100){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig50", update);
				}
				if(b==102){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig51", update);
				}
				if(b==104){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig52", update);
				}
				if(b==106){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig53", update);
				}
				if(b==108){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig54", update);
				}
				if(b==109){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig55", update);
				}
				if(b==111){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig56", update);
				}
				if(b==113){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig57", update);
				}
				if(b==115){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig58", update);
				}
				if(b==117){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig59", update);
				}
				if(b==119){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig60", update);
				}
				if(b==122){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig61", update);
				}
				if(b==124){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig62", update);
				}
				if(b==126){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig63", update);
				}
				if(b==128){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig64", update);
				}
				if(b==130){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig65", update);
				}
				if(b==132){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig66", update);
				}
				if(b==133){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig67", update);
				}
				if(b==135){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig68", update);
				}
				if(b==137){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig69", update);
				}
				if(b==139){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig70", update);
				}
				if(b==141){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig71", update);
				}
				if(b==143){
					String update=this.updateFigur(b);
					request.getSession().setAttribute("fig72", update);
				}
			}
		}
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
	
	public ArrayList<String> ausgabe(){
		
		ArrayList<String>au=new ArrayList<String>();
		x=SpielBean.baos.toString().split("\n");
		
		for(int i=x.length-1;i>=0;i--){
			au.add(x[i]+("\n"));
		}
		
		return au;
	}
	

	
	
	
}
