package klassen;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import daten.DatenzugriffCSV;
import daten.DatenzugriffSerialisiert;
import daten.iDatenzugriff;


public class SpielBean implements iBediener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Spieler spieler1;
	private Spieler spieler2;
	private Spieler spielerAmZug;
	private int spielerAnz = 0;
	private Spielbrett spielbrett;
	private Spielfigur figur;
	private int weissAnzahl = 0;
	private int schwarzAnzahl = 0;
	private Spielfigur[] figurWeiss = new Spielfigur[31];
	private Spielfigur[] figurSchwarz = new Spielfigur[31];
	private ArrayList<Spielfigur> figurWeiss2 = new ArrayList<Spielfigur>();
	private ArrayList<Spielfigur> figurSchwarz2 = new ArrayList<Spielfigur>();
	private boolean istZugbeginn = true;
	private boolean kannSchlagen;
	private boolean rechts = false;
	private ArrayList<String> datenSchlagen = new ArrayList<String>();
	private boolean zugOk = false;
	private static iDatenzugriff daten;
	private PrintWriter pw;
	private String[] gepusteteFigur = new String[1];
	private boolean kannLaufen = false;
	private ArrayList<Spielfeld> gegnerDame = new ArrayList<Spielfeld>();
	public static ByteArrayOutputStream baos= new ByteArrayOutputStream();
	private String farbe;
	private String[]figurWebId2=null;
	private ArrayList<Integer>zelle=new ArrayList<Integer>();
	private String gegner=null;
	private String farbeWeb=null;
	private String nameWeb=null;
	
	public SpielBean() {

	}
	
	@Override
	public String getNameWeb() {
		return nameWeb;
	}

	@Override
	public void setNameWeb(String nameWeb) {
		this.nameWeb = nameWeb;
	}
	
	@Override
	public String getFarbeWeb() {
		return farbeWeb;
	}


	@Override
	public void setFarbeWeb(String farbeWeb) {
		this.farbeWeb = farbeWeb;
	}
	
	
	@Override
	public String getGegner() {
		return gegner;
	}


	@Override
	public void setGegner(String gegner) {
		this.gegner = gegner;
	}



	@Override
	public ArrayList<Integer> getZelle() {
		return zelle;
	}

	public ArrayList<Spielfeld> getGegnerDame() {
		return gegnerDame;
	}

	public Spielfigur getFigur() {
		return figur;
	}

	@Override
	public Spielbrett getSpielbrett() {
		return spielbrett;
	}

	public ArrayList<Spielfigur> getFigurWeiss2() {
		return figurWeiss2;
	}

	public ArrayList<Spielfigur> getFigurSchwarz2() {
		return figurSchwarz2;
	}

	public Spielfigur[] getFigurWeiss() {
		return figurWeiss;
	}

	public Spielfigur[] getFigurSchwarz() {
		return figurSchwarz;
	}

	public boolean getKannLaufen() {
		return kannLaufen;
	}

	public String[] getGepusteteFigur() {
		return gepusteteFigur;
	}

	public void setGepusteteFigur() {
		this.gepusteteFigur[0] = null;
	}

	public ArrayList<String> getDatenSchlagen() {
		return datenSchlagen;
	}

	@Override
	public Spieler getSpielerAmZug() {
		return spielerAmZug;
	}
	
	@Override
	public KI bestimmeKI(String eingabe) {
		KI wert = null;
		switch (eingabe) {
		case "Mensch":
			wert = null;
			return wert;
		case "KI":
			wert = new KI_Dame(this);
			return wert;
		}
		return wert;
	}
	
	@Override
	public FarbEnum bestimmeFarbe(String farbe) {
		FarbEnum getFarbe = null;
		switch (farbe) {
		case "Weiss":
			getFarbe = FarbEnum.WEISS;
			break;
		case "Schwarz":
			getFarbe = FarbEnum.SCHWARZ;
			break;

		}
		return getFarbe;
	}

//	@Override
//	public void newSpieler(String name,String Farbe,String KI){
//		
//		PrintStream ps = new PrintStream(baos);
//		PrintStream old = System.out;
//		System.setOut(ps);	
//		
//		Spieler x =new Spieler(name,this.bestimmeFarbe(Farbe),this.bestimmeKI(KI)) ;
//		SpielerAmZug(x);
//		spielerAnz++;
//		System.out.println("Teilnehmer: --> "+x.getName());
//		
//		System.out.flush();
//		System.setOut(old);
//	}
	
	/**
	 * 
	 * Methode addSpieler()
	 * 
	 * Fuegt die jeweiligen Spieler ins Spiel hinzu. Der erste Spieler waehlt
	 * eine Farbei, wobei der zweite Spieler die Farbe automatisch bekommt die
	 * der erste Spieler nicht ausgewaehlt hat
	 * 
	 * @param name
	 *            Name des Spielers.
	 * @param farbe
	 *            Farbe des Spielers
	 */

	@Override
	public void addSpieler(String name, FarbEnum farbe, KI ki) {
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);	
		

		if (spielerAnz == 2) {
			throw new RuntimeException(
					"Es kann kein Spieler mehr hinzugefügt werden");
		}

		if (spielerAnz == 1) {

			// wenn spieler keine farbe gewählt hat
			if (farbe == null) {
				throw new RuntimeException("Bitte wähle eine Farbe aus !!");
			}

			Spieler sp = new Spieler(name, farbe, ki);

			if (farbe.equals(FarbEnum.SCHWARZ)) {
				this.spieler2 = sp;
				spielerAnz++;
			} else if (farbe.equals(FarbEnum.WEISS)) {
				this.spieler1 = sp;
				spielerAnz++;
			}

			System.out.println("Spieler " + sp + " wurde hinzugefügt "
					+ sp.getFarbe());
		}

		if (spielerAnz == 0) {
			Spieler sp = new Spieler(name, farbe, ki);
			if (farbe.equals(FarbEnum.WEISS)) {
				this.spieler1 = sp;
				spielerAnz++;
			} else if (farbe.equals(FarbEnum.SCHWARZ)) {
				this.spieler2 = sp;
				spielerAnz++;
			}

			System.out.println("Spieler " + sp + " wurde hinzugefügt "
					+ sp.getFarbe());
		}
			
		System.out.flush();
		System.setOut(old);
	}

	public int getSpielerAnz() {
		return spielerAnz;
	}

	@Override
	public void figurSetzen() {

		SpielerAmZug(spieler1);

		char ch = 'L';
		char ch1 = 'A';
		int x = 1;
		String str = null;
		boolean schwarz = false;
		int count = 1;

		for (int i = 0; i < spielbrett.getFelder().length; i++) {
			for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
				str = "" + ch1 + x;
				x++;

				schwarz = !schwarz;

				if (x > 12) {
					x = 1;
					ch1++;
					if (ch1 == ch) {
						str = "" + ch + x;
						schwarz = !schwarz;

						break;

					}
					schwarz = !schwarz;

				}

				if (this.spielbrett.getFelder()[i][j].getId().startsWith("A")
						|| this.spielbrett.getFelder()[i][j].getId()
								.startsWith("B")
						|| this.spielbrett.getFelder()[i][j].getId()
								.startsWith("C")
						|| this.spielbrett.getFelder()[i][j].getId()
								.startsWith("D")
						|| this.spielbrett.getFelder()[i][j].getId()
								.startsWith("E")) {
					if (this.spielbrett.getFelder()[i][j].getFarbeFeld()
							.equals(FarbEnum.SCHWARZ)) {
						figur = new Spielfigur(spielbrett.getFeld(str),
								FarbEnum.SCHWARZ, false);

						if (count == 30) {
							figurSchwarz[count] = figur;
							figur.setId(count);
							count = 0;
						} else {
							figurSchwarz[count] = figur;
							figur.setId(count);
						}
						count++;

						figur.setSpielfeld(spielbrett.getFeld(str));
						spielbrett.getFelder()[i][j].setFigur(figur);
						schwarzAnzahl++;

						spieler2.setFigurArray(figurSchwarz);

						System.out.println(figur);

					}
				} else {

					if (spielbrett.getFelder()[i][j].getId().startsWith("H")
							|| spielbrett.getFelder()[i][j].getId().startsWith(
									"I")
							|| spielbrett.getFelder()[i][j].getId().startsWith(
									"J")
							|| spielbrett.getFelder()[i][j].getId().startsWith(
									"K")
							|| spielbrett.getFelder()[i][j].getId().startsWith(
									"L")) {
						if (this.spielbrett.getFelder()[i][j].getFarbeFeld()
								.equals(FarbEnum.SCHWARZ)) {

							figur = new Spielfigur(spielbrett.getFeld(str),
									FarbEnum.WEISS, false);

							if (count == 1 && str.equals("L12")) {
								count = 1;
								figurWeiss[count] = figur;
								figur.setId(count);
							} else if (count == 1) {
								count = 30;
								figurWeiss[count] = figur;
								figur.setId(count);
							} else {
								figurWeiss[count] = figur;
								figur.setId(count);
							}
							count--;
							figur.setSpielfeld(spielbrett.getFeld(str));
							spielbrett.getFelder()[i][j].setFigur(figur);
							weissAnzahl++;

							spieler1.setFigurArray(figurWeiss);
							System.out.println(figur);
						}
					}
				}

			}// else schließen

		}// 1. if

	}

	public Spielfeld gebeFeld(String id) {
		Spielfeld feld = null;
		for (int i = 0; i < this.spielbrett.getFelder().length; i++) {
			for (int j = 0; j < this.spielbrett.getFelder()[i].length; j++) {
				if (this.spielbrett.getFelder()[i][j].getId().equals(id)) {
					feld = this.spielbrett.getFelder()[i][j];
				}
			}
		}
		return feld;
	}

	public void SpielerAmZug(Spieler spieler) {
		if (spieler != null) {
			this.spielerAmZug = spieler;
		}
	}

	@Override
	public void gibKoordinate(String s) {

		for (int i = 0; i < this.spielbrett.getFelder().length; i++) {
			for (int j = 0; j < this.spielbrett.getFelder()[i].length; j++) {
				if (this.spielbrett.getFelder()[i][j].getId().equals(s)) {

					System.out.println("i an index :" + i + "und j an index "
							+ j);
				}

			}
		}
	}

	/**
	 * 
	 * Methode starteSpiel()
	 * 
	 * Spielbrett wird erstellt und Startet das Spiel und laesst den Spieler mit
	 * den weissen Spielfiguren anfangen.
	 */
	@Override
	public void starteSpiel() {
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		System.out.println("--- Das Spiel beginnt! ---");
		System.out.println(" ");

		System.out.println(this.toString());
		System.out.println("");
		System.out.println("---Das Spielbrett wird erstellt---");
		System.out.println("");

		if (spielerAnz < 3 && spielerAnz >= 1) {

			spielbrett = new Spielbrett();
			this.setSpielerAnz(spielerAnz);
			this.figurSetzen();
			this.putArray();
			System.out.println(spieler1.getName() + " du musst anfangen :-)");
		}
		
		System.out.flush();
		System.setOut(old);
	}

	private void setSpielerAnz(int spielerAnz) {
		this.spielerAnz = spielerAnz;

	}

	@Override
	public String toString() {

		return "";
	}

	//löscht die figur aus dem Array damit die figur nicht mehr vorkommt im spiel
	public void removeFigurAusArray(Spielfigur figur) {
		if (figur != null) {
			if (figur.getFarbe().equals(FarbEnum.SCHWARZ)) {
				for (int i = 0; i < figurSchwarz2.size(); i++) {
					if (figurSchwarz2.get(i).getId().equals(figur.getId())) {
						figurSchwarz2.remove(i);

					}
				}
			} else if (figur.getFarbe().equals(FarbEnum.WEISS)) {
				for (int i = 0; i < figurWeiss2.size(); i++) {
					if (figurWeiss2.get(i).getId().equals(figur.getId())) {
						figurWeiss2.remove(i);
					}
				}
			}

		}

	}

	@Override
	public void schlagen(String aktPos, String gegnerPos, String zielPos) {
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);	

		Spielfeld aktuell = this.gebeFeld(aktPos);
		Spielfeld gegner = this.gebeFeld(gegnerPos);
		Spielfeld ziel = this.gebeFeld(zielPos);
		Spielfigur figur = this.gebeFigur(aktuell.getFigur().getId());

		if (figur.getFarbe().equals(FarbEnum.SCHWARZ)) {

			// setzt figur, die schlägt auf neue pos
			moveFigur(figur, aktuell, ziel);
			// löscht geschlagene figur
			System.out.println("Figur " + gegner.getFigur().getId()
					+ " auf Feld " + gegner.getId() + " wurde von Spieler "
					+ spielerAmZug.getName() + " geschlagen!");

			for (int i = 0; i < spielbrett.getFelder().length; i++) {
				for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
					if (spielbrett.getFelder()[i][j].equals(gegner)) {
						this.removeFigurAusArray(gegner.getFigur());
						spielbrett.getFelder()[i][j].setFigur(null);
						gegner.removeSpielfigur(gegner.getFigur());
						return;
					}
				}
			}

		} else {

			// setzt figur, die schlägt auf neue pos
			moveFigur(figur, aktuell, ziel);
			// löscht geschlagene figur
			System.out.println("Figur " + gegner.getFigur().getId()
					+ " auf Feld " + gegner.getId() + " wurde von Spieler "
					+ spielerAmZug.getName() + " geschlagen!");

			for (int i = 0; i < spielbrett.getFelder().length; i++) {
				for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
					if (spielbrett.getFelder()[i][j].equals(gegner)) {
						this.removeFigurAusArray(gegner.getFigur());
						spielbrett.getFelder()[i][j].setFigur(null);
						gegner.removeSpielfigur(gegner.getFigur());
						return;
					}
				}
			}

		}
		
		System.out.flush();
		System.setOut(old);
	}

	@Override
	public Spielfigur gebeFigur(String figurId) {
		Spielfigur f = null;
		for (Spielfigur figure : spielerAmZug.getFigurArray()) {
			if (figure == null)
				continue;
			if (figure.getId().equals(figurId)) {
				f = figure;
			}
		}
		return f;
	}

	public void moveFigur(Spielfigur figur, Spielfeld aktFeld,Spielfeld zielFeld) {
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		
		for (int i = 0; i < spielbrett.getFelder().length; i++) {
			for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
				if (spielbrett.getFelder()[i][j].equals(aktFeld)) {
					spielbrett.getFelder()[i][j].setFigur(null);
					aktFeld.removeSpielfigur(figur);

					figur.setSpielfeld(spielbrett.getFeld(zielFeld.getId()));

					zielFeld.setFigur(figur);
					System.out.println(figur.getFeld().getId());

				}

			}
		}
		
		System.out.flush();
		System.setOut(old);
	}

	public boolean istZugKorrekt(Spielfeld aktPos, Spielfeld zielPos) {
		if (spielerAmZug.getFarbe().equals(FarbEnum.SCHWARZ)) {
			if (pruefeID1(aktPos)) {
				if (!(getNachbar(aktPos.getId(), true).getId().equals(zielPos
						.getId()))) {
					return false;
				}
			} else if (pruefeID2(aktPos)) {
				if (!(getNachbar(aktPos.getId(), false).getId().equals(zielPos
						.getId()))) {
					return false;
				}
			} else {
				if ((!(getNachbar(aktPos.getId(), true).getId().equals(zielPos
						.getId())))
						&& (!(getNachbar(aktPos.getId(), false).getId()
								.equals(zielPos.getId())))) {
					return false;
				}
			}

		} else if (spielerAmZug.getFarbe().equals(FarbEnum.WEISS)) {
			if (pruefeID2(aktPos)) {
				if (!(getNachbar(aktPos.getId(), true).getId().equals(zielPos
						.getId()))) {
					return false;
				}
			} else if (pruefeID1(aktPos)) {
				if (!(getNachbar(aktPos.getId(), false).getId().equals(zielPos
						.getId()))) {
					return false;
				}
			} else {
				if ((!(getNachbar(aktPos.getId(), true).getId().equals(zielPos
						.getId())))
						&& (!(getNachbar(aktPos.getId(), false).getId()
								.equals(zielPos.getId())))) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void laufen(String aktPos, String zielPos) {
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);	
		

		spielbrett.getPositionen().clear();
		this.datenSchlagen.clear();

		Spielfeld aktFeld = this.gebeFeld(aktPos);
		Spielfeld zielFeld = this.gebeFeld(zielPos);
		Spielfigur figur = this.gebeFigur(aktFeld.getFigur().getId());

		if (figur == null) {
			System.out.println("Du bist nicht dran !");
		} else if (aktFeld.getFigur() == null && zielFeld.getFigur() == null) {
			System.out.println("Das Feld ist leer !");
		} else {
			if ((figur.getFarbe().equals(FarbEnum.SCHWARZ) && this.figur
					.istDame(figur))) {
				laufeDameSchwarz(aktPos, zielPos);
				return;
			} else if ((figur.getFarbe().equals(FarbEnum.WEISS) && this.figur
					.istDame(figur))) {
				laufeDameWeiss(aktPos, zielPos);
				return;
			}
			if (figur.getId().equals(aktFeld.getFigur().getId())) {
				figur = aktFeld.getFigur();
			} else {
				System.out
						.println("Du kannst mit dieser Figur nicht laufen!!!");
				return;
			}

			spielbrett.Umwandler(aktPos);
			spielbrett.Umwandler(zielPos);

			// ------------------------------SCHWARZ-------------------------------
			if (spielerAmZug.getFarbe().equals(FarbEnum.SCHWARZ)) {
				// Normal laufen ohne schlagen
				if (!kannSchlagen()) {
					// wenn figur schwarz ist
					if (figur.getFarbe().equals(FarbEnum.SCHWARZ)) {
						if (this.spielbrett.getPositionen().get(1) < this.spielbrett
								.getPositionen().get(3)) {
							this.rechts = true;
							Spielfeld f = getNachbar(aktPos, true);
							if (f.equals(zielFeld)
									&& zielFeld.getFigur() == null) {
								moveFigur(figur, aktFeld, zielFeld);
								System.out.println(figur);
								zugOk = true;
							}

						} else {
							this.rechts = false;
							Spielfeld f = getNachbar(aktPos, false);
							if (f.equals(zielFeld)
									&& zielFeld.getFigur() == null) {
								moveFigur(figur, aktFeld, zielFeld);
								System.out.println(figur);
								zugOk = true;
							}
						}
					}

				}
				// ------------schlagen-------------
				else {
					System.out.println(spielerAmZug.getName()
							+ " du musst schlagen!!!");
					if ((kannSchlagenLinksSchwarz(aktFeld)
							&& (zielFeld.getFigur() != null) && (!(zielFeld
							.getFigur().getFarbe().equals(FarbEnum.SCHWARZ))))) {
						schlagen(aktFeld.getId(), zielFeld.getId(),
								getNachbar(zielPos, false).getId());
						zugOk = true;
					} else if ((kannSchlagenRechtsSchwarz(aktFeld)
							&& (zielFeld.getFigur() != null) && (!(zielFeld
							.getFigur().getFarbe().equals(FarbEnum.SCHWARZ))))) {
						schlagen(aktFeld.getId(), zielFeld.getId(),
								getNachbar(zielPos, true).getId());
						zugOk = true;
					} else if ((datenSchlagen.get(0).equals(aktPos)
							&& (zielFeld.getFigur() != null) && (!(zielFeld
							.getFigur().getFarbe().equals(FarbEnum.SCHWARZ))))) {
						schlagen(datenSchlagen.get(0), datenSchlagen.get(1),
								datenSchlagen.get(2));
						zugOk = true;
					} else if (kannSchlagen() == true
							&& zielFeld.getFigur() == null
							&& istZugKorrekt(aktFeld, zielFeld) == true) {

						Spielfeld feld = this.gebeFeld(datenSchlagen.get(0));
						// gepusteteFigur[0]=feld.getFigur().getId();
						gepusteteFigur[0] = feld.getId();
						// gepusteteFigur[0]=null;
						System.out.println("Die Figur "
								+ feld.getFigur().getId()
								+ " wurde weggepustet!!!");
						feld.setFigur(null);
						zugOk = true;

					} else {
						System.out
								.println("Du kannst deine eigene Figur nicht schlagen");
					}
				}
			}
			// ------------------------------WEISS-------------------------------
			else if (spielerAmZug.getFarbe().equals(FarbEnum.WEISS)) {
				if (!kannSchlagen()) {
					// wenn figur weiss ist
					if (figur.getFarbe().equals(FarbEnum.WEISS)) {
						if (this.spielbrett.getPositionen().get(1) > this.spielbrett
								.getPositionen().get(3)) {
							this.rechts = true;
							Spielfeld f = getNachbar(aktPos, true);
							if (f.equals(zielFeld)
									&& zielFeld.getFigur() == null) {
								moveFigur(figur, aktFeld, zielFeld);
								System.out.println(figur);
								zugOk = true;
							}

						} else {
							this.rechts = false;
							Spielfeld f = getNachbar(aktPos, false);
							if (f.equals(zielFeld)
									&& zielFeld.getFigur() == null) {
								moveFigur(figur, aktFeld, zielFeld);
								System.out.println(figur);
								zugOk = true;
							}
						}
					}

				}
				// ------------schlagen-------------
				else {
					System.out.println(spielerAmZug.getName()
							+ " du musst schlagen!!!");
					if ((kannSchlagenLinksWeiss(aktFeld)
							&& (zielFeld.getFigur() != null) && (!(zielFeld
							.getFigur().getFarbe().equals(FarbEnum.WEISS))))) {
						schlagen(aktFeld.getId(), zielFeld.getId(),
								getNachbar(zielPos, false).getId());
						zugOk = true;
					} else if ((kannSchlagenRechtsWeiss(aktFeld)
							&& (zielFeld.getFigur() != null) && (!(zielFeld
							.getFigur().getFarbe().equals(FarbEnum.WEISS))))) {
						schlagen(aktFeld.getId(), zielFeld.getId(),
								getNachbar(zielPos, true).getId());
						zugOk = true;
					} else if ((datenSchlagen.get(0).equals(aktPos)
							&& (zielFeld.getFigur() != null) && (!(zielFeld
							.getFigur().getFarbe().equals(FarbEnum.WEISS))))) {
						schlagen(datenSchlagen.get(0), datenSchlagen.get(1),
								datenSchlagen.get(2));
						zugOk = true;

					} else if (kannSchlagen() == true
							&& zielFeld.getFigur() == null
							&& istZugKorrekt(aktFeld, zielFeld) == true) {
						Spielfeld feld = this.gebeFeld(datenSchlagen.get(0));
						// gepusteteFigur[0]=feld.getFigur().getId();
						gepusteteFigur[0] = feld.getId();
						// gepusteteFigur[0]=null;
						System.out.println("Die Figur "
								+ feld.getFigur().getId()
								+ " wurde weggepustet!!!");
						feld.setFigur(null);
						zugOk = true;

					} else {
						System.out
								.println("Du kannst deine eigene Figur nicht schlagen");
					}

				}

			}
			for (int i = 0; i < this.spielbrett.getFelder().length; i++) {
				for (int j = 0; j < this.spielbrett.getFelder()[i].length; j++) {
					if (this.spielbrett.getFelder()[i][j].getFigur() == null) {
						continue;
					} else {
						this.werdeDame(this.spielbrett.getFelder()[i][j]
								.getFigur());
					}
				}
			}

			if (zugOk == true) {
				zugBeenden();
				zugOk = false;

			} else {
				System.out.println("Zug nicht korrekt !");
			}

		}
			
		System.out.flush();
		System.setOut(old);

	}

	public void werdeDame(Spielfigur figur) {
		if (figur.getId().startsWith("w")) {
			if (figur.getPosition().contains("A")) {
				figur.setDame(true);

			}
		}
		if (figur.getId().startsWith("b")) {
			if (figur.getPosition().contains("L")) {
				figur.setDame(true);
			}
		}
	}

	@Override
	public boolean getZugOk() {
		return zugOk;
	}

	@Override
	public void zugBeenden() {
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);	
		
		if (this.spielerAmZug.equals(spieler1)) {
			SpielerAmZug(spieler2);
			System.out
					.println("Spieler " + spielerAmZug + " ist an der Reihe!");
		} else {
			SpielerAmZug(spieler1);
			System.out
					.println("Spieler " + spielerAmZug + " ist an der Reihe!");
		}

		kannLaufen = true;
		
		System.out.flush();
		System.setOut(old);
	}

	public Spielfeld getNachbar(String feld, boolean rechts) {
		Spielfeld fe = null;
		// Spielfeld spielfeld = this.gebeFeld(feld);
		// Spielfigur figur = spielfeld.getFigur();

		if (spielerAmZug.getFarbe().equals(FarbEnum.SCHWARZ)) {
			// laufe rechts schwarz
			if (rechts) {
				for (int i = 0; i < spielbrett.getFelder().length; i++) {
					for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
						if (spielbrett.getFelder()[i][j].getId().equals(feld)) {
							fe = spielbrett.getFelder()[i + 1][j + 1];
							return fe;
						}
					}
				}
			} else {
				// laufe links schwarz
				for (int i = 0; i < spielbrett.getFelder().length; i++) {
					for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {

						if (spielbrett.getFelder()[i][j].getId().equals(feld)) {
							fe = spielbrett.getFelder()[i + 1][j - 1];
							return fe;
						}
					}
				}

			}
		} else {
			// laufe rechts weiss
			if (spielerAmZug.getFarbe().equals(FarbEnum.WEISS)) {
				if (rechts) {
					for (int i = spielbrett.getFelder().length - 1; i >= 0; i--) {
						for (int j = spielbrett.getFelder().length - 1; j >= 0; j--) {
							if (spielbrett.getFelder()[i][j].getId().equals(
									feld)) {
								fe = spielbrett.getFelder()[i - 1][j - 1];
								return fe;
							}
						}
					}
				} else {
					// laufe links weiss
					for (int i = spielbrett.getFelder().length - 1; i >= 0; i--) {
						for (int j = spielbrett.getFelder().length - 1; j >= 0; j--) {
							if (spielbrett.getFelder()[i][j].getId().equals(
									feld)) {

								fe = spielbrett.getFelder()[i - 1][j + 1];
								return fe;
							}
						}
					}
				}
			}
		}
		return fe;
	}

	public void laufeDameSchwarz(String aktPos, String zielPos) {
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);	

		Spielfeld aktFeld = this.gebeFeld(aktPos);
		Spielfeld zielFeld = this.gebeFeld(zielPos);
		Spielfigur figur = this.gebeFigur(aktFeld.getFigur().getId());
		Spielfeld nachbar = null;
		Spielfeld nachbar2 = null;
		gegnerDame.clear();

		spielbrett.Umwandler(aktPos);
		spielbrett.Umwandler(zielPos);

//		for (int i = 0; i < spielbrett.getFelder().length; i++) {
//			for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {

				// ObenRechts
				if ((this.spielbrett.getPositionen().get(0) < this.spielbrett.getPositionen().get(2))
						&& (this.spielbrett.getPositionen().get(1) < this.spielbrett.getPositionen().get(3))) {
					while (aktFeld.getId() != zielFeld.getId()) {
						nachbar = getNachbarDame(aktPos, true, true);
						// im Falle wenn die eigene Figur auf dem Weg ist
						if ((nachbar.getFigur() != null) && (nachbar.getFigur().getFarbe().equals(FarbEnum.SCHWARZ))) {
							System.out.println("Du kannst nicht weiter laufen weil die Spielfigur "+ nachbar.getFigur().getId()+ " auf dem Feld "+ nachbar.getId()
											+ " deinen weg kreuzt.");
							zugBeenden();
							return;
							// im Falle wenn eine gegnerische Figur auf dem Weg ist
						} else if ((nachbar.getFigur() != null)&&(nachbar.getFigur().getFarbe().equals(FarbEnum.WEISS))) {
							nachbar2 = getNachbarDame(nachbar.getId(), true,true);
							if (nachbar2.getFigur() == null) {
								aktPos = nachbar2.getId();
								moveFigur(figur, aktFeld, nachbar2);
								aktFeld = nachbar2;
								gegnerDame.add(nachbar);
								this.removeFigurAusArray(nachbar.getFigur());
								nachbar.setFigur(null);
								zugBeenden();
								return;
							} else {
								System.out
										.println("Du kannst nicht schlagen weil die Figur "
												+ nachbar2.getFigur().getId()
												+ " dir im Weg steht.");
								zugBeenden();
								return;
							}
						}
						aktPos = nachbar.getId();
						moveFigur(figur, aktFeld, nachbar);
						aktFeld = nachbar;
					}

					// ObenLinks
				} else if ((this.spielbrett.getPositionen().get(0) < this.spielbrett
						.getPositionen().get(2))
						&& (this.spielbrett.getPositionen().get(1) > this.spielbrett
								.getPositionen().get(3))) {
					while (aktFeld.getId() != zielFeld.getId()) {
						nachbar = getNachbarDame(aktPos, false, true);
						if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.SCHWARZ))) {
							System.out
									.println("Du kannst nicht weiter laufen weil die Spielfigur "
											+ nachbar.getFigur().getId()
											+ " auf dem Feld "
											+ nachbar.getId()
											+ " deinen weg kreuzt.");
							zugBeenden();
							return;
						} else if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.WEISS))) {
							nachbar2 = getNachbarDame(nachbar.getId(), false,
									true);
							if (nachbar2.getFigur() == null) {
								aktPos = nachbar2.getId();
								moveFigur(figur, aktFeld, nachbar2);
								aktFeld = nachbar2;
								gegnerDame.add(nachbar);
								this.removeFigurAusArray(nachbar.getFigur());
								nachbar.setFigur(null);
								zugBeenden();
								return;
							} else {
								System.out
										.println("Du kannst nicht schlagen weil die Figur "
												+ nachbar2.getFigur().getId()
												+ " dir im Weg steht.");
								zugBeenden();
								return;
							}
						}
						aktPos = nachbar.getId();
						moveFigur(figur, aktFeld, nachbar);
						aktFeld = nachbar;
					}

					// UntenRechts
				} else if ((this.spielbrett.getPositionen().get(0) > this.spielbrett
						.getPositionen().get(2))
						&& (this.spielbrett.getPositionen().get(1) < this.spielbrett
								.getPositionen().get(3))) {
					while (aktFeld.getId() != zielFeld.getId()) {
						nachbar = getNachbarDame(aktPos, true, false);
						if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.SCHWARZ))) {
							System.out
									.println("Du kannst nicht weiter laufen weil die Spielfigur "
											+ nachbar.getFigur().getId()
											+ " auf dem Feld "
											+ nachbar.getId()
											+ " deinen weg kreuzt.");
							zugBeenden();
							return;
						} else if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.WEISS))) {
							nachbar2 = getNachbarDame(nachbar.getId(), true,
									false);
							if (nachbar2.getFigur() == null) {
								aktPos = nachbar2.getId();
								moveFigur(figur, aktFeld, nachbar2);
								aktFeld = nachbar2;
								gegnerDame.add(nachbar);
								this.removeFigurAusArray(nachbar.getFigur());
								nachbar.setFigur(null);
								zugBeenden();
								return;
							} else {
								System.out
										.println("Du kannst nicht schlagen weil die Figur "
												+ nachbar2.getFigur().getId()
												+ " dir im Weg steht.");
								zugBeenden();
								return;
							}
						}
						aktPos = nachbar.getId();
						moveFigur(figur, aktFeld, nachbar);
						aktFeld = nachbar;
					}

					// UntenLinks
				} else if ((this.spielbrett.getPositionen().get(0) > this.spielbrett
						.getPositionen().get(2))
						&& (this.spielbrett.getPositionen().get(1) > this.spielbrett
								.getPositionen().get(3))) {
					while (aktFeld.getId() != zielFeld.getId()) {
						nachbar = getNachbarDame(aktPos, false, false);
						if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.SCHWARZ))) {
							System.out
									.println("Du kannst nicht weiter laufen weil die Spielfigur "
											+ nachbar.getFigur().getId()
											+ " auf dem Feld "
											+ nachbar.getId()
											+ " deinen weg kreuzt.");
							zugBeenden();
							return;
						} else if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.WEISS))) {
							nachbar2 = getNachbarDame(nachbar.getId(), false,
									false);
							if (nachbar2.getFigur() == null) {
								aktPos = nachbar2.getId();
								moveFigur(figur, aktFeld, nachbar2);
								aktFeld = nachbar2;
								gegnerDame.add(nachbar);
								this.removeFigurAusArray(nachbar.getFigur());
								nachbar.setFigur(null);
								zugBeenden();
								return;
							} else {
								System.out
										.println("Du kannst nicht schlagen weil die Figur "
												+ nachbar2.getFigur().getId()
												+ " dir im Weg steht.");
								zugBeenden();
								return;
							}
						}
						aktPos = nachbar.getId();
						moveFigur(figur, aktFeld, nachbar);
						aktFeld = nachbar;
					}

				}
//			}
//		}
		zugBeenden();
			
		System.out.flush();
		System.setOut(old);
	}

	public void laufeDameWeiss(String aktPos, String zielPos) {
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);	

		Spielfeld aktFeld = this.gebeFeld(aktPos);
		Spielfeld zielFeld = this.gebeFeld(zielPos);
		Spielfigur figur = this.gebeFigur(aktFeld.getFigur().getId());
		Spielfeld nachbar = null;
		Spielfeld nachbar2 = null;
		gegnerDame.clear();

		spielbrett.Umwandler(aktPos);
		spielbrett.Umwandler(zielPos);

//		for (int i = 0; i < spielbrett.getFelder().length; i++) {
//			for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {

				// ObenRechts
				if ((this.spielbrett.getPositionen().get(0) < this.spielbrett
						.getPositionen().get(2))
						&& (this.spielbrett.getPositionen().get(1) < this.spielbrett
								.getPositionen().get(3))) {
					while (aktFeld.getId() != zielFeld.getId()) {
						nachbar = getNachbarDame(aktPos, true, true);
						if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.WEISS))) {
							System.out
									.println("Du kannst nicht weiter laufen weil die Spielfigur "
											+ nachbar.getFigur().getId()
											+ " auf dem Feld "
											+ nachbar.getId()
											+ " deinen weg kreuzt.");
							zugBeenden();
							return;
						} else if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.SCHWARZ))) {
							nachbar2 = getNachbarDame(nachbar.getId(), true,
									true);
							if (nachbar2.getFigur() == null) {
								aktPos = nachbar2.getId();
								moveFigur(figur, aktFeld, nachbar2);
								aktFeld = nachbar2;
								gegnerDame.add(nachbar);
								this.removeFigurAusArray(nachbar.getFigur());
								nachbar.setFigur(null);
								zugBeenden();
								return;
							} else {
								System.out
										.println("Du kannst nicht schlagen weil die Figur "
												+ nachbar2.getFigur().getId()
												+ " dir im Weg steht.");
								zugBeenden();
								return;
							}
						}
						aktPos = nachbar.getId();
						moveFigur(figur, aktFeld, nachbar);
						aktFeld = nachbar;
					}

					// ObenLinks
				} else if ((this.spielbrett.getPositionen().get(0) < this.spielbrett
						.getPositionen().get(2))
						&& (this.spielbrett.getPositionen().get(1) > this.spielbrett
								.getPositionen().get(3))) {
					while (aktFeld.getId() != zielFeld.getId()) {
						nachbar = getNachbarDame(aktPos, false, true);
						if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.WEISS))) {
							System.out
									.println("Du kannst nicht weiter laufen weil die Spielfigur "
											+ nachbar.getFigur().getId()
											+ " auf dem Feld "
											+ nachbar.getId()
											+ " deinen weg kreuzt.");
							zugBeenden();
							return;
						} else if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.SCHWARZ))) {
							nachbar2 = getNachbarDame(nachbar.getId(), false,
									true);
							if (nachbar2.getFigur() == null) {
								aktPos = nachbar2.getId();
								moveFigur(figur, aktFeld, nachbar2);
								aktFeld = nachbar2;
								gegnerDame.add(nachbar);
								this.removeFigurAusArray(nachbar.getFigur());
								nachbar.setFigur(null);
								zugBeenden();
								return;
							} else {
								System.out
										.println("Du kannst nicht schlagen weil die Figur "
												+ nachbar2.getFigur().getId()
												+ " dir im Weg steht.");
								zugBeenden();
								return;
							}
						}
						aktPos = nachbar.getId();
						moveFigur(figur, aktFeld, nachbar);
						aktFeld = nachbar;
					}

					// UntenRechts
				} else if ((this.spielbrett.getPositionen().get(0) > this.spielbrett
						.getPositionen().get(2))
						&& (this.spielbrett.getPositionen().get(1) < this.spielbrett
								.getPositionen().get(3))) {
					while (aktFeld.getId() != zielFeld.getId()) {
						nachbar = getNachbarDame(aktPos, true, false);
						if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.WEISS))) {
							System.out
									.println("Du kannst nicht weiter laufen weil die Spielfigur "
											+ nachbar.getFigur().getId()
											+ " auf dem Feld "
											+ nachbar.getId()
											+ " deinen weg kreuzt.");
							zugBeenden();
							return;
						} else if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.SCHWARZ))) {
							nachbar2 = getNachbarDame(nachbar.getId(), true,
									false);
							if (nachbar2.getFigur() == null) {
								aktPos = nachbar2.getId();
								moveFigur(figur, aktFeld, nachbar2);
								aktFeld = nachbar2;
								gegnerDame.add(nachbar);
								this.removeFigurAusArray(nachbar.getFigur());
								nachbar.setFigur(null);
								zugBeenden();
								return;
							} else {
								System.out
										.println("Du kannst nicht schlagen weil die Figur "
												+ nachbar2.getFigur().getId()
												+ " dir im Weg steht.");
								zugBeenden();
								return;
							}
						}
						aktPos = nachbar.getId();
						moveFigur(figur, aktFeld, nachbar);
						aktFeld = nachbar;
					}

					// UntenLinks
				} else if ((this.spielbrett.getPositionen().get(0) > this.spielbrett
						.getPositionen().get(2))
						&& (this.spielbrett.getPositionen().get(1) > this.spielbrett
								.getPositionen().get(3))) {
					while (aktFeld.getId() != zielFeld.getId()) {
						nachbar = getNachbarDame(aktPos, false, false);
						if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.WEISS))) {
							System.out
									.println("Du kannst nicht weiter laufen weil die Spielfigur "
											+ nachbar.getFigur().getId()
											+ " auf dem Feld "
											+ nachbar.getId()
											+ " deinen weg kreuzt.");
							zugBeenden();
							return;
						} else if ((nachbar.getFigur() != null)
								&& (nachbar.getFigur().getFarbe()
										.equals(FarbEnum.SCHWARZ))) {
							nachbar2 = getNachbarDame(nachbar.getId(), false,
									false);
							if (nachbar2.getFigur() == null) {
								aktPos = nachbar2.getId();
								moveFigur(figur, aktFeld, nachbar2);
								aktFeld = nachbar2;
								gegnerDame.add(nachbar);
								this.removeFigurAusArray(nachbar.getFigur());
								nachbar.setFigur(null);
								zugBeenden();
								return;
							} else {
								System.out
										.println("Du kannst nicht schlagen weil die Figur "
												+ nachbar2.getFigur().getId()
												+ " dir im Weg steht.");
								zugBeenden();
								return;
							}
						}
						aktPos = nachbar.getId();
						moveFigur(figur, aktFeld, nachbar);
						aktFeld = nachbar;
					}

				}
//			}
//		}
		zugBeenden();
		
		
		System.out.flush();
		System.setOut(old);
	}

	public Spielfeld getNachbarDame(String feld, boolean rechts, boolean oben) {
		Spielfeld fe = null;
		Spielfeld field=this.gebeFeld(feld);
		// Spielfeld spielfeld = this.gebeFeld(feld);
		
//		wenn das feld am rand ist soll kein nachbar gegettet werden
//		if(pruefeID1(field)||pruefeID2(field)||pruefeOben(field)||pruefeUnten(field)){
//			return fe;
//		}

		// rechtsOben
		if ((rechts) && (oben)) {
			for (int i = 0; i < spielbrett.getFelder().length; i++) {
				for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
					if (spielbrett.getFelder()[i][j].getId().equals(feld)) {
						fe = spielbrett.getFelder()[i + 1][j + 1];
						return fe;
					}
				}
			}

			// rechtsUnten
		} else if ((rechts) && ((!oben))) {
			for (int i = 0; i < spielbrett.getFelder().length; i++) {
				for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
					if (spielbrett.getFelder()[i][j].getId().equals(feld)) {
						fe = spielbrett.getFelder()[i - 1][j + 1];
						return fe;
					}
				}
			}

			// linksOben
		} else if ((!(rechts)) && (oben)) {
			for (int i = 0; i < spielbrett.getFelder().length; i++) {
				for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
					if (spielbrett.getFelder()[i][j].getId().equals(feld)) {
						fe = spielbrett.getFelder()[i + 1][j - 1];
						return fe;
					}
				}
			}

			// linksUnten
		} else if ((!(rechts)) && (!(oben))) {
			for (int i = 0; i < spielbrett.getFelder().length; i++) {
				for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
					if (spielbrett.getFelder()[i][j].getId().equals(feld)) {
						fe = spielbrett.getFelder()[i - 1][j - 1];
						return fe;
					}
				}
			}

		}
		return fe;
	}

	public boolean pruefeID1(Spielfeld feld) {
		boolean a = false;
		switch (feld.getId()) {
		case "A1":
			a = true;
			break;
		case "C1":
			a = true;
			break;
		case "E1":
			a = true;
			break;
		case "G1":
			a = true;
			break;
		case "I1":
			a = true;
			break;
		case "K1":
			a = true;
			break;
		default:
			return false;

		}
		return a;
	}

	public boolean pruefeID2(Spielfeld feld) {
		boolean a = false;
		switch (feld.getId()) {
		case "B12":
			a = true;
			break;
		case "D12":
			a = true;
			break;
		case "F12":
			a = true;
			break;
		case "H12":
			a = true;
			break;
		case "J12":
			a = true;
			break;
		case "L12":
			a = true;
			break;
		default:
			return false;

		}
		return a;
	}

	public boolean pruefeUnten(Spielfeld feld) {
		boolean a = false;
		switch (feld.getId()) {
		case "A1":
			a = true;
			break;
		case "A3":
			a = true;
			break;
		case "A5":
			a = true;
			break;
		case "A7":
			a = true;
			break;
		case "A9":
			a = true;
			break;
		case "A11":
			a = true;
			break;
		default:
			return false;

		}
		return a;
	}

	public boolean pruefeOben(Spielfeld feld) {
		boolean a = false;
		switch (feld.getId()) {
		case "L2":
			a = true;
			break;
		case "L4":
			a = true;
			break;
		case "L6":
			a = true;
			break;
		case "L8":
			a = true;
			break;
		case "L10":
			a = true;
			break;
		case "L12":
			a = true;
			break;
		default:
			return false;

		}
		return a;
	}

	public boolean kannSchlagenRechtsSchwarz(Spielfeld feld) {

		kannSchlagen = false;
		if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
			if (feld.getFigur() != null) {

				if (pruefeID2(feld)) {
					return kannSchlagen = false;
				} else if (pruefeOben(feld)) {
					return kannSchlagen = false;
				} else if (feld.getFigur().getFarbe().equals(FarbEnum.SCHWARZ)) {
					Spielfeld feld2 = getNachbar(feld.getId(), true);

					if (pruefeID2(feld2)) {
						kannSchlagen = false;
					} else {
						if (pruefeOben(feld2)) {
							kannSchlagen = false;
						} else

						if ((feld2.getFigur() != null)
								&& (feld2.getFigur().getFarbe()
										.equals(FarbEnum.WEISS))) {
							Spielfeld feld3 = getNachbar(feld2.getId(), true);

							if (feld3.getFigur() == null) {
								kannSchlagen = true;
								datenSchlagen.add(feld.getId());
								datenSchlagen.add(feld2.getId());
								datenSchlagen.add(feld3.getId());
							} else {
								kannSchlagen = false;
							}
						} else {
							kannSchlagen = false;
						}
					}
				}
			}
		}
		return kannSchlagen;

	}

	public boolean kannSchlagenLinksSchwarz(Spielfeld feld) {

		kannSchlagen = false;
		if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
			if (feld.getFigur() != null) {

				if (pruefeID1(feld)) {
					return kannSchlagen = false;
				} else if (pruefeOben(feld)) {
					return kannSchlagen = false;

				} else if (feld.getFigur().getFarbe().equals(FarbEnum.SCHWARZ)) {

					Spielfeld feld2 = getNachbar(feld.getId(), false);

					if (pruefeID1(feld2)) {
						kannSchlagen = false;
					} else {
						if (pruefeOben(feld2)) {
							kannSchlagen = false;
						} else

						if ((feld2.getFigur() != null)
								&& (feld2.getFigur().getFarbe()
										.equals(FarbEnum.WEISS))) {
							Spielfeld feld3 = getNachbar(feld2.getId(), false);
							if (feld3.getFigur() == null) {
								kannSchlagen = true;
								datenSchlagen.add(feld.getId());
								datenSchlagen.add(feld2.getId());
								datenSchlagen.add(feld3.getId());
							} else {
								kannSchlagen = false;
							}
						} else {
							kannSchlagen = false;
						}
					}
				}
			}
		}
		return kannSchlagen;

	}

	public boolean kannSchlagenRechtsWeiss(Spielfeld feld) {

		kannSchlagen = false;
		if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
			if (feld.getFigur() != null) {

				if (pruefeID1(feld)) {
					return kannSchlagen = false;
				} else if (pruefeUnten(feld)) {
					return kannSchlagen = false;
				} else if (feld.getFigur().getFarbe().equals(FarbEnum.WEISS)) {
					Spielfeld feld2 = getNachbar(feld.getId(), true);

					if (pruefeID1(feld2)) {
						kannSchlagen = false;
					} else {
						if (pruefeUnten(feld2)) {
							kannSchlagen = false;
						} else

						if ((feld2.getFigur() != null)
								&& (feld2.getFigur().getFarbe()
										.equals(FarbEnum.SCHWARZ))) {
							Spielfeld feld3 = getNachbar(feld2.getId(), true);
							if (feld3.getFigur() == null) {
								kannSchlagen = true;
								datenSchlagen.add(feld.getId());
								datenSchlagen.add(feld2.getId());
								datenSchlagen.add(feld3.getId());
							} else {
								kannSchlagen = false;
							}
						} else {
							kannSchlagen = false;
						}
					}
				}
			}
		}
		return kannSchlagen;

	}

	public boolean kannSchlagenLinksWeiss(Spielfeld feld) {

		kannSchlagen = false;

		if (feld.getFarbeFeld().equals(FarbEnum.SCHWARZ)) {
			if (feld.getFigur() != null) {

				if (pruefeID2(feld)) {
					return kannSchlagen = false;
				} else if (pruefeUnten(feld)) {
					return kannSchlagen = false;
				} else if (feld.getFigur().getFarbe().equals(FarbEnum.WEISS)) {
					Spielfeld feld2 = getNachbar(feld.getId(), false);

					if (pruefeID2(feld2)) {
						kannSchlagen = false;
					} else {
						if (pruefeUnten(feld2)) {
							kannSchlagen = false;
						} else

						if ((feld2.getFigur() != null)
								&& (feld2.getFigur().getFarbe()
										.equals(FarbEnum.SCHWARZ))) {
							Spielfeld feld3 = getNachbar(feld2.getId(), false);
							if (feld3.getFigur() == null) {
								kannSchlagen = true;
								datenSchlagen.add(feld.getId());
								datenSchlagen.add(feld2.getId());
								datenSchlagen.add(feld3.getId());
							} else {
								kannSchlagen = false;
							}
						} else {
							kannSchlagen = false;
						}
					}
				}
			}
		}
		return kannSchlagen;

	}

	public boolean kannSchlagen() {
		FarbEnum farbe = spielerAmZug.getFarbe();
		switch (farbe) {
		case WEISS:
			for (int i = spielbrett.getFelder().length - 1; i >= 0; i--) {

				for (int j = spielbrett.getFelder().length - 1; j >= 0; j--) {

					if (kannSchlagenLinksWeiss(spielbrett.getFelder()[i][j])
							|| kannSchlagenRechtsWeiss(spielbrett.getFelder()[i][j])) {

						return true;
					}

				}
			}
			break;
		case SCHWARZ:
			for (int i = 0; i < spielbrett.getFelder().length; i++) {
				for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {

					if (kannSchlagenLinksSchwarz(spielbrett.getFelder()[i][j])
							|| kannSchlagenRechtsSchwarz(spielbrett.getFelder()[i][j])) {
						return true;
					}
				}
			}
			break;
		}
		return false;

	}

	public boolean istOK(Spielfeld feld) {

		int dx = feld.getX() - spielbrett.getSpielfeld().getX();
		int dy = feld.getY() - spielbrett.getSpielfeld().getY();

		if (Math.abs(dx) != Math.abs(dy)) {
			return false;
		} else if (Math.abs(dx) == 0 || (Math.abs(dx) > 2)) {
			return false;
		} else if (spielbrett.getSpielfeld().getFarbeFeld()
				.equals(FarbEnum.SCHWARZ)
				&& (dy > 0)
				|| !spielbrett.getSpielfeld().getFarbeFeld()
						.equals(FarbEnum.SCHWARZ) && (dy < 0)) {
			return false;
		}

		return true;

	}

	@Override
	public boolean hatGewonnen() {
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);	
		
		if (figurWeiss2.size() == 0) {
			System.out.println("Schwarz gewonnen!");
			return true;
		}
		if (figurSchwarz2.size() == 0) {
			System.out.println("Weiss gewonnen!");
			return true;
		}
			
		System.out.flush();
		System.setOut(old);
		return false;
	}

	public boolean getZugBeginn() {
		return istZugbeginn;
	}

	public void merkeBeginn() {
		istZugbeginn = false;
	}


	public Spieler getSpieler1() {
		return spieler1;
	}

	public Spieler getSpieler2() {
		return spieler2;
	}

	@Override
	public String farbePlayer() {
		// System.out.println("spieler: "+spielerAmZug);
		// System.out.println("farbe: "+spielerAmZug.getFarbe());
		FarbEnum player = spielerAmZug.getFarbe();

		String pl = null;
		switch (player) {
		case SCHWARZ:
			pl = "Schwarz";
			return pl;
		case WEISS:
			pl = "Weiss";
			return pl;
		}

		return pl;

	}

	/**
	 * Speichert die aktuelle Belegung des Spielbretts in CSV-Notation.
	 */
	@Override
	public void belegungCSV() {

		try {
			pw = new PrintWriter(new FileWriter("speichern/belegung.csv"));
		} catch (FileNotFoundException e) {
			System.err.println("DATEI ZUM SPEICHERN NICHT GEFUNDEN!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Spielfeld[][] belegung = spielbrett.getFelder();
		char ch = 'L';
		char ch1 = 'A';
		int x = 1;
		String str = null;
		boolean schwarz = true;

		for (int i = 0; i < spielbrett.getFelder().length; i++) {

			for (int j = 0; j < belegung[i].length; j++) {
				str = "" + ch1 + x;
				x++;

				pw.print(belegung[i][j] = new Spielfeld(spielbrett, str,
						schwarz));

				schwarz = !schwarz;

				if (x > 12) {
					x = 1;
					ch1++;
					if (ch1 == ch) {
						str = "" + ch + x;
						schwarz = !schwarz;

						break;

					}
					schwarz = !schwarz;

				}

			}
			pw.println();
		}

		pw.close();
	}

	

	

	@Override
	public Spielfeld gibFeld(String figur) {
		Spielfeld feld = null;
		for (int i = 0; i < spielbrett.getFelder().length; i++) {
			for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
				if (spielbrett.getFelder()[i][j].getFigur() != null) {
					if (spielbrett.getFelder()[i][j].getFigur().getId()
							.equals(figur)) {
						feld = spielbrett.getFelder()[i][j];
					}
				}
			}
		}
		return feld;
	}

	@Override
	public Spielfigur gibFigur(String feld) {
		Spielfigur f = null;

		for (int i = 0; i < spielbrett.getFelder().length; i++) {
			for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
				if (spielbrett.getFelder()[i][j].getFigur() == null) {
					continue;
				} else {
					if (spielbrett.getFelder()[i][j].getId().equals(feld)) {
						f = spielbrett.getFelder()[i][j].getFigur();
					}
				}
			}
		}
		return f;
	}

	@Override
	public boolean istFeldBelegt(Spielfigur figur, Spielfeld feld) {

		if (feld.getFigur().equals(figur)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean istFigurDrin(String figur) {
		for (int i = 0; i < spielbrett.getFelder().length; i++) {
			for (int j = 0; j < spielbrett.getFelder()[i].length; j++) {
				if (spielbrett.getFelder()[i][j].getFigur() != null) {
					if (spielbrett.getFelder()[i][j].getFigur().getId()
							.equals(figur)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public void putArray() {
		for (Spielfigur each : figurWeiss) {
			figurWeiss2.add(each);
		}
		figurWeiss2.remove(0);
		for (Spielfigur each : figurSchwarz) {
			figurSchwarz2.add(each);
		}
		figurSchwarz2.remove(0);
	}

	public int anzahlFigur() {
		int counter = 0;

		// if(binDrin==false){
		// putArray();
		// }

		if (spielerAmZug.getFarbe().equals(FarbEnum.WEISS)) {
			// binDrin=true;
			counter = this.getFigurWeiss2().size();
		} else if (spielerAmZug.getFarbe().equals(FarbEnum.SCHWARZ)) {
			// binDrin=true;
			counter = this.getFigurSchwarz2().size();
		}

		return counter;

	}
	
	@Override
	public void farbeSession(String farbeSess){
		farbe=farbeSess;
	}
	
	@Override
	public String gibFarbeSession(){
		return farbe;
	}
	
	
	@Override
	public String ermittleSpielerAmZugFarbe(){
		String i="";
		if(spielerAmZug.getFarbe()==FarbEnum.WEISS){
			i="Weiss";
		}
		else if(spielerAmZug.getFarbe()==FarbEnum.SCHWARZ){
			i="Schwarz";
		}
		return i;
	}

	@Override
	public String[] gibFigurWebId(){
		
		figurWebId2=new String [144];
		
		for(int i=0;i<spielbrett.getFelder().length;i++){
			for(int j=0;j<spielbrett.getFelder()[i].length;j++){
				Spielfeld f=spielbrett.getFelder()[i][j];
				
				if(f.getFigur()!=null&&f.getFigur().getFarbe()==FarbEnum.SCHWARZ){
					figurWebId2[convertPos(f)]="schwarz";
				}else if(f.getFigur()!=null&&f.getFigur().getFarbe()==FarbEnum.WEISS){
					figurWebId2[convertPos(f)]="weiss";
				}
			}
		}
		return figurWebId2;
	}
	
	public int convertPos(Spielfeld s){
		int i=0;
		String pos=s.getId();
		
		switch(pos){
		//--------------L---------------
		case "L2":
			i=2;
			return i;
		case "L4":
			i=4;
			return i;
		case "L6":
			i=6;
			return i;
		case "L8":
			i=8;
			return i;
		case "L10":
			i=10;
			return i;
		case "L12":
			i=12;
			return i;
		//--------------K---------------
		case "K1":
			i=13;
			return i;
		case "K3":
			i=15;
			return i;
		case "K5":
			i=17;
			return i;
		case "K7":
			i=19;
			return i;
		case "K9":
			i=21;
			return i;
		case "K11":
			i=23;
			return i;
		//--------------J---------------
		case "J2":
			i=26;
			return i;
		case "J4":
			i=28;
			return i;
		case "J6":
			i=30;
			return i;
		case "J8":
			i=32;
			return i;
		case "J10":
			i=34;
			return i;
		case "J12":
			i=36;
			return i;
		//--------------I---------------
		case "I1":
			i=37;
			return i;
		case "I3":
			i=39;
			return i;
		case "I5":
			i=41;
			return i;
		case "I7":
			i=43;
			return i;
		case "I9":
			i=45;
			return i;
		case "I11":
			i=47;
			return i;
		//--------------H---------------
		case "H2":
			i=50;
			return i;
		case "H4":
			i=52;
			return i;
		case "H6":
			i=54;
			return i;
		case "H8":
			i=56;
			return i;
		case "H10":
			i=58;
			return i;
		case "H12":
			i=60;
			return i;
		//--------------G---------------
		case "G1":
			i=61;
			return i;
		case "G3":
			i=63;
			return i;
		case "G5":
			i=65;
			return i;
		case "G7":
			i=67;
			return i;
		case "G9":
			i=69;
			return i;
		case "G11":
			i=71;
			return i;
		//--------------F---------------
		case "F2":
			i=74;
			return i;
		case "F4":
			i=76;
			return i;
		case "F6":
			i=78;
			return i;
		case "F8":
			i=80;
			return i;
		case "F10":
			i=82;
			return i;
		case "F12":
			i=84;
			return i;
		//--------------E---------------
		case "E1":
			i=85;
			return i;
		case "E3":
			i=87;
			return i;
		case "E5":
			i=89;
			return i;
		case "E7":
			i=91;
			return i;
		case "E9":
			i=93;
			return i;
		case "E11":
			i=95;
			return i;
		//--------------D---------------
		case "D2":
			i=98;
			return i;
		case "D4":
			i=100;
			return i;
		case "D6":
			i=102;
			return i;
		case "D8":
			i=104;
			return i;
		case "D10":
			i=106;
			return i;
		case "D12":
			i=108;
			return i;
		//--------------C---------------
		case "C1":
			i=109;
			return i;
		case "C3":
			i=111;
			return i;
		case "C5":
			i=113;
			return i;
		case "C7":
			i=115;
			return i;
		case "C9":
			i=117;
			return i;
		case "C11":
			i=119;
			return i;
		//--------------B---------------
		case "B2":
			i=122;
			return i;
		case "B4":
			i=124;
			return i;
		case "B6":
			i=126;
			return i;
		case "B8":
			i=128;
			return i;
		case "B10":
			i=130;
			return i;
		case "B12":
			i=132;
			return i;
		//--------------A---------------
		case "A1":
			i=133;
			return i;
		case "A3":
			i=135;
			return i;
		case "A5":
			i=137;
			return i;
		case "A7":
			i=139;
			return i;
		case "A9":
			i=141;
			return i;
		case "A11":
			i=143;
			return i;
		
		}
		return i;
	}
	
	@Override
	public String convertPos2(int s){
		String i=null;
		
		switch(s){
		//--------------L---------------
		case 2:
			i="L2";
			return i;
		case 4:
			i="L4";
			return i;
		case 6:
			i="L6";
			return i;
		case 8:
			i="L8";
			return i;
		case 10:
			i="L10";
			return i;
		case 12:
			i="L12";
			return i;
		//--------------K---------------
		case 13:
			i="K1";
			return i;
		case 15:
			i="K3";
			return i;
		case 17:
			i="K5";
			return i;
		case 19:
			i="K7";
			return i;
		case 21:
			i="K9";
			return i;
		case 23:
			i="K11";
			return i;
		//--------------J---------------
		case 26:
			i="J2";
			return i;
		case 28:
			i="J4";
			return i;
		case 30:
			i="J6";
			return i;
		case 32:
			i="J8";
			return i;
		case 34:
			i="J10";
			return i;
		case 36:
			i="J12";
			return i;
		//--------------I---------------
		case 37:
			i="I1";
			return i;
		case 39:
			i="I3";
			return i;
		case 41:
			i="I5";
			return i;
		case 43:
			i="I7";
			return i;
		case 45:
			i="I9";
			return i;
		case 47:
			i="I11";
			return i;
		//--------------H---------------
		case 50:
			i="H2";
			return i;
		case 52:
			i="H4";
			return i;
		case 54:
			i="H6";
			return i;
		case 56:
			i="H8";
			return i;
		case 58:
			i="H10";
			return i;
		case 60:
			i="H12";
			return i;
		//--------------G---------------
		case 61:
			i="G1";
			return i;
		case 63:
			i="G3";
			return i;
		case 65:
			i="G5";
			return i;
		case 67:
			i="G7";
			return i;
		case 69:
			i="G9";
			return i;
		case 71:
			i="G11";
			return i;
		//--------------F---------------
		case 74:
			i="F2";
			return i;
		case 76:
			i="F4";
			return i;
		case 78:
			i="F6";
			return i;
		case 80:
			i="F8";
			return i;
		case 82:
			i="F10";
			return i;
		case 84:
			i="F12";
			return i;
		//--------------E---------------
		case 85:
			i="E1";
			return i;
		case 87:
			i="E3";
			return i;
		case 89:
			i="E5";
			return i;
		case 91:
			i="E7";
			return i;
		case 93:
			i="E9";
			return i;
		case 95:
			i="E11";
			return i;
		//--------------D---------------
		case 98:
			i="D2";
			return i;
		case 100:
			i="D4";
			return i;
		case 102:
			i="D6";
			return i;
		case 104:
			i="D8";
			return i;
		case 106:
			i="D10";
			return i;
		case 108:
			i="D12";
			return i;
		//--------------C---------------
		case 109:
			i="C1";
			return i;
		case 111:
			i="C3";
			return i;
		case 113:
			i="C5";
			return i;
		case 115:
			i="C7";
			return i;
		case 117:
			i="C9";
			return i;
		case 119:
			i="C11";
			return i;
		//--------------B---------------
		case 122:
			i="B2";
			return i;
		case 124:
			i="B4";
			return i;
		case 126:
			i="B6";
			return i;
		case 128:
			i="B8";
			return i;
		case 130:
			i="B10";
			return i;
		case 132:
			i="B12";
			return i;
		//--------------A---------------
		case 133:
			i="A1";
			return i;
		case 135:
			i="A3";
			return i;
		case 137:
			i="A5";
			return i;
		case 139:
			i="A7";
			return i;
		case 141:
			i="A9";
			return i;
		case 143:
			i="A11";
			return i;
		
		}
		return i;
	}

}
