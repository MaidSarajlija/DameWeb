package klassen;

import java.beans.Transient;
import java.io.Serializable;

import javax.servlet.annotation.MultipartConfig;
import javax.xml.bind.annotation.*;

/**
 * Klasse Spielfigur
 * @author B2
 *
 */
@XmlType(propOrder={"farbe","id","istDame"})
public class Spielfigur implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FarbEnum farbe;
	private String id;
	private String position;
	private Spielfeld spielfeld;
	private static int counter = 1;
	private boolean istDame=false;
	
	
	
	public Spielfigur(){
	}
	
	/**
	 * Konstruktor
	 * @param farbe der Spielfigur
	 * @param position der Figur
	 */
	
	public Spielfigur(Spielfeld feld, FarbEnum farbe, boolean istDame){
//		this.setPosition(position);
		if(counter>30){
			counter=1;
		}
		this.setFarbe(farbe);
		this.setSpielfeld(feld);
	}
	
	
	@XmlElement(name="istDame")
	public void setIstDame(boolean istDame) {
		this.istDame = istDame;
	}
	public boolean isIstDame() {
		return istDame;
	}
	
//	@XmlTransient
	public String getId(){
		return id;
	}
	
	
	/**
	 * Setzen der ID
	 * 
	 * @param id
	 * setzt die ID
	 */
	
	@XmlElement(name="Id")
	public void setId(String id){
		this.id=id;
	}
	@XmlTransient
	public void setSpielfeld(Spielfeld spielfeld){
		if (spielfeld==null){
			throw new RuntimeException(" Falsche Eingabe");
		}
		else{
			this.spielfeld=spielfeld;
			
		}
	}
//	@XmlElement(name="farbe")
	public FarbEnum getFarbe(){
		return farbe;
		
	}
	
	/**
	 * Setter mit der Ueberpruefung ob eine Farbe gesetzt wurde. Wenn nicht wird
	 * eine Fehlermeldung ausgeschmissen
	 * @param farbe setzt die Farbe der SPielfigur, zur Auswahl stehen schwarz und weiss
	 */
	@XmlElement(name="farbe")
	public void setFarbe(FarbEnum farbe){
		if(farbe==null){
			throw new RuntimeException("Fehler setter figur - keine gueltige Farbe");
		}
		this.farbe=farbe;
	}
	
	
	@XmlTransient
	public String getPosition(){
		 position=this.spielfeld.getId();
		 return position;
	}
	
	public Spielfeld getSpielfeld(){
		return spielfeld;
	}
	
	

	@Override
	public String toString() {

		return this.getId()+ " ---> " + this.getPosition() +  " ist Dame " + isIstDame();

	}


}
