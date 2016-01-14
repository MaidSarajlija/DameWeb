package daten;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import klassen.SpielBean;

public class DatenzugriffXML implements iDatenzugriff{

	@Override
	public void speichern(Object spiel, String dateipfad) throws IOException, JAXBException {
		FileWriter fw = null;
		try{
			JAXBContext context = JAXBContext.newInstance( SpielBean.class );
			Marshaller m = context.createMarshaller();
			m.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
			//m.marshal( s, System.out );
			fw=new FileWriter(dateipfad + ".xml");
			m.marshal(spiel, fw);
		}
		finally {
			try{
				fw.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Object laden(String dateipfad) throws JAXBException, FileNotFoundException {
		JAXBContext context=JAXBContext.newInstance(SpielBean.class);
		Unmarshaller um = context.createUnmarshaller();
		SpielBean s = (SpielBean)um.unmarshal(new FileReader(dateipfad));
		
		
		
		return s;
	}

}
