package daten;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import klassen.SpielBean;


public class DatenzugriffSerialisiert implements iDatenzugriff, Serializable {

	private ObjectOutputStream oos = null;
	
	
	
	/**
	 * Die Methode speichern, um das Spiel serialisiert zu speichern
	 */
	@Override
	public void speichern(Object spiel, String fileAddressSave){

		if(spiel != null && spiel instanceof SpielBean){
			
		}else{
			throw new RuntimeException("Das zu speichernde Objekt ist nicht vom Typ Spiel!");
		}
		
		try{
			oos = new ObjectOutputStream(new FileOutputStream(fileAddressSave));
			oos.writeObject(spiel);
		} catch(FileNotFoundException e){
			System.err.println("Datei konnte nicht erstellt werden!");
		} catch (IOException e) {
			System.err.println("Fehler bei Ein-/Ausgabe: " + e);
		}
		finally{
			try{
				oos.close();
			}catch(Exception e){
				System.err.println("Fehler beim Schliessen!");
			}
		}
	}
	/**
	 * Die Methode laden, um das Spiel zu de-serialisieren
	 */


	@Override
	public Object laden(String fileAddressLoad) {
		ObjectInputStream ois = null;
		SpielBean geladenesSpiel = null;
				try{
					ois=new ObjectInputStream(new FileInputStream((fileAddressLoad)));
					geladenesSpiel = (SpielBean)ois.readObject();
				}catch(FileNotFoundException e){
					System.err.println("Datei konnte nicht geladen werden!");
				} catch (IOException e) {
					System.err.println("Fehler bei Ein-/Ausgabe: " + e);
			} catch (ClassNotFoundException e) {
					System.err.println("Datei enthaelt kein Objekt von Typ Spiel!");
				}finally{
				try{
					ois.close();
				}catch(Exception e){
					System.err.println("Fehler beim Schliessen!");
				}
			}
			return geladenesSpiel;
		}
}
