package daten;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.Properties;
import klassen.iBediener;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Diese Klasse bildet die PDF ab.

 */
public class datenzugriffPDF implements iDatenzugriff,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Document document = null;
	PdfWriter writer = null;
	Font font = null;
	PdfPTable tab = null;
	/**
	 * das aktuelle Spiel wird als PDF Datei gespeichert
	 * die implemntierte interface methode zum speichern nur fuer pdf
	 */
	@Override
	public void speichern(Object spiel,String filename) {
		try {
			document = new Document(PageSize.A4);
			writer = PdfWriter.getInstance(document, new FileOutputStream(filename + ".pdf"));
			document.open();
			Image image = Image.getInstance("brett.png");
			Paragraph title = new Paragraph("Dame Spiel", new Font(Font.FontFamily.HELVETICA, 20)); 
			
			title.setAlignment(Element.ALIGN_CENTER);
			title.setSpacingAfter(10);
			
			image.scaleToFit(300,300);
			image.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
//			document.add(new Paragraph("Spielbrettbelegung "  + " :"));
			
			image.setSpacingBefore(10);
			image.setWidthPercentage(100);
			
			document.add(image);
			
			image.setSpacingAfter(10);
			
			
			

		} catch (FileNotFoundException e) {
			document.close();
			System.err.println(filename + ".pdf konnte nicht erzeugt werden");
			
		} catch (DocumentException e) {
			document.close();
			System.err.println("Das Dokument wurde bereits geschlossen oder ist nicht offen");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			
		finally{
			document.close();
		}
	}
	@Override
	public Object laden(String dateipfad) {
		// TODO Auto-generated method stub
		return null;
	}

}


	


