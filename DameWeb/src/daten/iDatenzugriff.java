package daten;




public interface iDatenzugriff {

	public void speichern(Object spiel, String dateipfad);
			

	public Object laden(String dateipfad);

}
