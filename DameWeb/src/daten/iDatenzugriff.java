package daten;

public interface iDatenzugriff {

	void speichern(String filename, Object spiel);

	Object laden(String filename);

}



