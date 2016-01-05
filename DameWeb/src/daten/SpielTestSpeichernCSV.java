package daten;

import java.io.PrintWriter;

import klassen.FarbEnum;
import klassen.SpielBean;
import klassen.Spieler;
import klassen.iBediener;

public class SpielTestSpeichernCSV {
	public static void main(String[] args) {
		PrintWriter pw = null;
		iDatenzugriff d=new DatenzugriffSerialisiert();
		
		iBediener spiel = new SpielBean();
		
	
		
		spiel.addSpieler("Kathi", FarbEnum.SCHWARZ,null );
		spiel.addSpieler("Sarah", FarbEnum.WEISS, null);

		
		spiel.starteSpiel();
//		spiel.ermittleSpielerAmZug();
		
		spiel.laufen("H2", "G3","white 30");
		
		spiel.laufen("E11", "F10","black 30");
		
		
	
		
		
		
		
		spiel.speichernCSV("hallo");
//		s.ladenCSV("koko");
	}}
