package klassen;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

/**
 * Die Klasse Spieler
 * @author B2
 *
 */
@XmlType(propOrder={"name","farbe","figurArray","ki","kidame"})
public class Spieler implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Spielfigur figur;
	private FarbEnum farbe;
	private KI ki;
	private static final int spielfigurMax =31;
//	private ArrayList<Spielfigur> spielfiguren = new ArrayList<Spielfigur>();
	private Spielfigur[] figurArray = new Spielfigur[spielfigurMax];
	private int spielfigurAnz=0;
	private KI_Dame kidame;


	public Spieler(){
	}
	
	/**
	 * Der Konstruktor der Klasse Spieler
	 * @param name ist der Name der Spielers
	 * @param farbe für die spielfiguren
	 */
	public Spieler(String name, FarbEnum farbe, KI ki){
		this.setName(name);
		this.setFarbe(farbe);
		this.setKi(ki);
	}
	
	
	
//	@XmlElement(name="figurArray")
	public Spielfigur[] getFigurArray() {
		return figurArray;
	}

	@XmlElement(name="figurArray")
	public void setFigurArray(Spielfigur[] figurArray) {
		this.figurArray = figurArray;
	}

	@XmlElement(name="ki")
	public void setKi(KI ki){
		this.ki=ki;
	}
//	@XmlElement(name="ki")
	public KI getKi() {
		return ki;
	}
	
//	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	/**
	 * Setter mit Ueberpruefung ob ein Name existiert oder der Name zu kurz ist
	 * @param name setzt den namen des Spielers
	 */
	@XmlElement(name="name")
	public void setName(String name) {
		if((name.length()<2)||(name==null)){
			throw new RuntimeException("Name ist zu kurz");
		}
		this.name = name;
	}
//	@XmlElement(name="figur")
	public Spielfigur getFigur() {
		return figur;
	}
	@XmlTransient
	public void setFigur(Spielfigur figur) {
		this.figur = figur;
	}
//	@XmlElement(name="farbe")
	public FarbEnum getFarbe() {
		return farbe;
	}
	@XmlElement(name="farbe")
	public void setFarbe(FarbEnum farbe) {
		if(farbe==null){
			throw new RuntimeException("Waehle eine Farbe aus!!");
		}
		this.farbe = farbe;
	}
//	@XmlElement
	public KI_Dame getKidame() {
		return kidame;
	}
	@XmlElement
	public void setKidame(KI_Dame kidame) {
		this.kidame = kidame;
	}
	
	
	/**
	 * Getter
	 * @return Gibt die Anzahl der Spielfiguren im Spiefiguren Array zurueck
	 */
	@XmlTransient
	public int getAnzahlFiguren() {
		return spielfigurAnz;
	}
	
	//fuer csv speichern
//	@XmlElement(name="ki")
	public String generiereCSV(){
		String ki = "";
		if(this.ki==null){
			ki=" Mensch";
		}
		else{
			ki=" Computer";
		}
		return "" + name + " mit der Farbe" + farbe + " ist ein"  +ki ;
	}
	
	/**
	 * toString-Methode mit der Ausgabe der Attribute Name, Farbe und Figur
	 */
	@Override 
	public String toString(){
		return getName() + "";

				
				
	}
	
	

}
