package daten;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import klassen.FarbEnum;
import klassen.SpielBean;
import klassen.Spieler;
import klassen.iBediener;

public class TestSpielSpeichern implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String []args) throws IOException{

	
	
				SpielBean s = new SpielBean();
				s.addSpieler("Kathi", FarbEnum.WEISS, null);
				s.addSpieler("Sarah", FarbEnum.SCHWARZ,null);
				
				s.starteSpiel();
				s.laufen("H2", "G3");
				s.laufen("E1", "F2");
				
				
				
				iDatenzugriff ser = new DatenzugriffSerialisiert();
				iDatenzugriff csv = new DatenzugriffCSV(s);
			
				
				//Als .ser speichern
				ser.speichern((SpielBean)s, "l.ser");
				
				//Als .csv speichern
				csv.speichern((SpielBean)s, "o");
				
				
				
			
				
	
				
	  
	  
		
		
	}
}
