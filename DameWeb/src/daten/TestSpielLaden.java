package daten;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.JAXBException;

import klassen.SpielBean;
import klassen.Spielbrett;
import klassen.Spieler;
import klassen.iBediener;




public class TestSpielLaden implements  Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public static void main(String []args) throws ClassNotFoundException, FileNotFoundException, IOException, JAXBException{

	iDatenzugriff d;
//	d= new DatenzugriffSerialisiert();
//	Spiel p = (Spiel) d.laden("l.ser");
//	System.out.println("Spieler:  " + p.getSpieler1()+ " nimmt teil");
//	System.out.println("Spieler:  " + p.getSpieler2()+ " nimmt teil");
//	
//	System.out.println("Geladenes Spiel:");
//	System.out.println("Spieler am Zug: "+p.getSpielerAmZug());
//	
//	
//	System.out.println(p.getFigurWeiss()[30].getFeld().getId());

	
	
	
//	Spiel p = (Spiel) d.laden("l.ser");
	SpielBean p = new SpielBean();
	
	d = new DatenzugriffCSV(p);
	System.out.println("Geladenes Spiel:");
	d.laden("o.csv");
	
	
	
	
	
	
	

		
			
		
		
		
}
}
