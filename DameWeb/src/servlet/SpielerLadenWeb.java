package servlet;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import daten.DatenzugriffCSV;
import daten.DatenzugriffSerialisiert;
import daten.datenzugriffPDF;
import daten.iDatenzugriff;
import klassen.SpielBean;
import klassen.iBediener;


/**
 * Servlet implementation class SpielerLadenWeb
 */
@WebServlet("/SpielerLadenWeb")
public class SpielerLadenWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static iBediener backend;
	private static final String waitLaden = "/WaitLaden.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpielerLadenWeb() {
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
		RequestDispatcher rd2 = sc.getRequestDispatcher(waitLaden);
		
		try {
			SpielerLadenWeb.createGameLaden(request, response);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(SpielerLadenWeb.getGameLaden().bestandSpielerlist()==1){
			this.tableGame(request, response);
		}else if(SpielerLadenWeb.getGameLaden().menschDrin()==true){
			rd2.forward(request, response);
		}else if(SpielerLadenWeb.getGameLaden().menschDrin()==false){
			this.tableGame(request, response);
		}
		
	}
	
	public static void createGameLaden(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, JAXBException{
		
		iDatenzugriff ser=new DatenzugriffSerialisiert();
		iDatenzugriff csv=new DatenzugriffCSV(new SpielBean());
		iDatenzugriff pdf=new datenzugriffPDF();
//		iDatenzugriff xml=new DatenzugriffXML();
		
		String	pfad = request.getParameter("ser");
		
		if(pfad.endsWith(".pdf")){
			backend= (SpielBean)pdf.laden("C:/Users/Katherina/Desktop"+pfad);
		}
		else if(pfad.endsWith(".csv")){
			backend= (SpielBean)csv.laden("C:/Users/Katherina/Desktop"+pfad);
		}
		else if(pfad.endsWith(".ser")){
			backend= (SpielBean)ser.laden("C:/Users/Katherina/Desktop"+pfad);
		}
//		else if(pfad.endsWith(".xml")){
//			backend= (SpielBean)xml.laden("/Users/sevenvista/Desktop/"+pfad);
//		}
		
		
	}
	
	public static iBediener getGameLaden(){
	 	return backend;
	}
	
	public void tableGame(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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