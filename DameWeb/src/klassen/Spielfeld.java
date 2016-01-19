package klassen;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Klasse Spielfeld
 * @author B2
 *
 */
@XmlType(propOrder={"id","farbeFeld","figur"})
public class Spielfeld implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Spielfigur figur;
	private boolean hatSpielfigur = false;
	private Spielbrett spielbrett;
	private FarbEnum farbeFeld;
//	private boolean istSchwarz;
	private int x; 
	private int y;

	public Spielfeld() {
	}
	
	/**
	 * Konstruktor der Klasse Spielfeld
	 * 
	 * @param id
	 *            ist das Feld auf dem sich die einzelnen Spielfiguren befinden
	 */
	public Spielfeld(Spielbrett brett, String id, boolean schwarz) {
		setId(id);
		if (schwarz) {
			setFarbeFeld(FarbEnum.SCHWARZ);
		} else {
			setFarbeFeld(FarbEnum.WEISS);
		}
//		this.istSchwarz = schwarz;
		this.spielbrett = brett;
	
	}
	
	
	
//	@XmlAttribute(name="id")
	public String getId() {
		return id;
	}

	/**
	 * Setter mit Ueberpruefung ob die Id zwischen 0 und 100 liegt
	 * 
	 * @param id
	 *            setzt die id eines Spielfeldes
	 */
	@XmlAttribute(name="id")
	public void setId(String id) {

		this.id = id;
	}
	
//	@XmlElement(name="figur")
	public Spielfigur getFigur() {
		return figur;
	}

	
	/**
	 * Setter fuer die Ueberpruefung ob auf einem Feld eine Figur ist
	 * 
	 * @param figur
	 */
	@XmlElement(name="figur")
	public void setFigur(Spielfigur figur) {
		this.figur = figur;
			
	}
	@XmlElement(name="farbe")
	public void setFarbeFeld(FarbEnum farbeFeld) {
		this.farbeFeld = farbeFeld;
	}

//	@XmlElement(name="farbe")
	public FarbEnum getFarbeFeld() {
//		if (istSchwarz == true) {
//			return FarbEnum.SCHWARZ;
//		}
//		return FarbEnum.WEISS;
		return farbeFeld;
	}

	/**
	 * Entfernt die Spielfigur vom Spielfeld
	 * 
	 */

	public void removeSpielfigur(Spielfigur figur) {
		System.out.println("Die Figur "+ figur +" auf Feld " + this.getId() + " wurde entfernt!");
	
			this.setFigur(null);
			
	}

	/**
	 * Prueft ob Feld belegt ist
	 * 
	 * @return false Gibt false zurueck, wenn Spielfeld nicht belegt ist.
	 * @return true Gibt true zurueck, wenn auf einem Spielfeld bereits eine
	 *         Figur steht.
	 */
	public boolean istFeldBelegt() {
		if (this.hatSpielfigur == true) {
			return true;
		}
		return false;
	}
	
	@XmlTransient
	public int getX(){
		return x;
	}
	@XmlTransient
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.x=y;
	}

	
	//nach Datentyp nochmal schauen -- vll doch void?
	public Spielfigur entferneFigur(){
		return figur=null;
	}

	
	public int farbe(){
		int zahl=0;
		if(this.getFigur()!=null){
			if(this.getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
			zahl=FarbEnum.SCHWARZ.ordinal();
			}else{
				if(this.getFigur().getFarbe().equals(FarbEnum.WEISS)){
					zahl= FarbEnum.WEISS.ordinal();
					}
			}
			
		}
		return zahl;
	}
	@XmlTransient
	public void getF(){
	 System.out.println(farbe());
		
	}
	
	
	
	/**
	 * Setzt eine Spielfigur auf ein Spielfeld
	 * 
	 * @param sfigur
	 *            Uebergabewert vom Typ Spielfigur
	 */

	/**
	 * toString-Methode mit der AUgabe der Attribute Id und Figur
	 */
	@Override
	public String toString() {
		String s = "";
		s += "Spielfeld " + this.getId() + " - Farbe " + this.getFarbeFeld() ;
		if (figur != null) {
			s += " - Figur" + getFigur() +"\n";
			s+="\n";
		}
		if (this.getId().contains("12")) {

			s += "\n";

		}
		return s;
	}
}
