package klassen;

import gui.Spieler1AuswahlDialog;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;

public interface iBediener {
    
    public void addSpieler(String name, FarbEnum farbe,KI ki);
    public void starteSpiel();


    public void figurSetzen();


    void gibKoordinate(String s);
//    void laufen(String aktPos, String zielPos, String figurId);
    Spielfigur gebeFigur(String figurId);
    void belegungCSV();

    
    void zugBeenden();
  
    void schlagen(String aktPos, String gegnerPos, String zielPos);


    boolean hatGewonnen();
    public Spieler getSpieler1();
    public Spieler getSpieler2();
	
	String farbePlayer();
	void laufen(String aktPos, String zielPos);
	Spieler getSpielerAmZug();
	boolean getZugOk();
	Spielfeld gibFeld(String figur);
	Spielfigur gibFigur(String feld);
	boolean istFeldBelegt(Spielfigur figur, Spielfeld feld);
	boolean istFigurDrin(String figur);
	KI bestimmeKI(String eingabe);
	FarbEnum bestimmeFarbe(String farbe);
	public void farbeSession(String farbeSess);
	String ermittleSpielerAmZugFarbe();
	String[] gibFigurWebId();
	public ArrayList<Integer> getZelle();
	String getGegner();
	void setGegner(String gegner);
	String getFarbeWeb();
	void setFarbeWeb(String farbeWeb);
	String getNameWeb();
	void setNameWeb(String nameWeb);
	String convertPos2(int s);
	String gibFarbeSession();
	Spielbrett getSpielbrett();


    

}
