package daten;

import klassen.FarbEnum;
import klassen.SpielBean;
import klassen.Spieler;
import klassen.iBediener;

public class TestSpielSpeichernSerial {
	public static void main(String []args){

		
		iBediener i = new SpielBean();
		
		i.addSpieler("kathi", FarbEnum.SCHWARZ, null);
		i.addSpieler("hannah", FarbEnum.WEISS, null);
		
		
		i.starteSpiel();
		
		i.speichernSerial("spiel");
		
//		i.ladenSerial("spiel.ser");
		
		
	}
}
