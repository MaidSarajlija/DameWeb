package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import daten.DatenzugriffSerialisiert;
import daten.iDatenzugriff;


/**
 * Servlet implementation class SpeichernSER
 */
@WebServlet("/SpeichernSER")
public class SpeichernSER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpeichernSER() {
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
		String namefile =request.getParameter("textareaSER");
		
		iDatenzugriff ser = new DatenzugriffSerialisiert();
		
		if(Index.getGame()!=null){
			
			try {
				ser.speichern(Index.getGame(),"C:/Users/Katherina/Desktop"+ namefile);
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
				ser.speichern(SpielerLadenWeb.getGameLaden(),"C:/Users/Katherina/Desktop"+ namefile);
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
