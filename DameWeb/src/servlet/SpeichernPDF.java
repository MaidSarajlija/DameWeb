package servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import daten.datenzugriffPDF;
import daten.iDatenzugriff;



/**
 * Servlet implementation class Ser
 */
@WebServlet("/SpeichernPDF")
public class SpeichernPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

   
    public SpeichernPDF() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		String namefile =request.getParameter("textareaPDF");
		request.getSession().setAttribute("filePDF", namefile);
		
		iDatenzugriff pdf= new datenzugriffPDF();
		
		if(Index.getGame()!=null){
			
			try {
				pdf.speichern(Index.getGame(),"C:/Users/Katherina/Desktop"+ namefile);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
			
		}else if(SpielerLadenWeb.getGameLaden()!=null){
			try {
				pdf.speichern(SpielerLadenWeb.getGameLaden(),"C:/Users/Katherina/Desktop"+ namefile);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
