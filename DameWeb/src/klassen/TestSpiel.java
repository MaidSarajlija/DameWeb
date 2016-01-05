package klassen;

import java.util.Random;

import klassen.FarbEnum;
import klassen.SpielBean;
import klassen.iBediener;

public class TestSpiel {

	public static void main(String[] args) {

		SpielBean i= new SpielBean();
		
		
		i.addSpieler("Weiss", FarbEnum.WEISS,new KI_Dame(i));
		i.addSpieler("Schwarz", FarbEnum.SCHWARZ,new KI_Dame(i));
		
		i.starteSpiel();
		

		
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
////	i.laufen("G3","F2");
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));
//		i.laufen(i.getSpielerAmZug().getKi().startZiel().get(0),i.getSpielerAmZug().getKi().ziel.get(1));

	
	
//	i.laufen("H2","G3");
//	i.laufen("E1","F2");
//	
//	i.laufen("G3","F2");
//	i.laufen("E3","F4");
//	i.laufen("H4","G3");
//	i.laufen("D2","E3");
//	i.laufen("H12","G11");
//	i.laufen("D2","E3");
//	i.laufen("E1","D2");
//	i.laufen("E3","F4");
//	i.laufen("D2","C3");
//	i.laufen("E3","F4");
//	i.laufen("C3","B4");
//	i.laufen("E3","F4");
//	i.laufen("B4","A5");
//	i.laufen("E3","F4");
//	i.laufen("A5","E1");
//	i.laufen("E5","F6");
//	i.laufen("H10","G9");
//	i.laufen("E5","F6");
//	i.laufen("E1","C3");
//	i.laufen("F6","G7");
//	i.laufen("C3","D4");
//	i.laufen("E11","F12");
//	i.laufen("E5","F4");

	
	
		
		
	
	
		
		
		
		

	}

}
