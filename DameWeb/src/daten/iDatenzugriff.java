package daten;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;




public interface iDatenzugriff {

	public void speichern(Object spiel, String dateipfad) throws IOException, JAXBException;
			

	public Object laden(String dateipfad) throws JAXBException, FileNotFoundException;

}
