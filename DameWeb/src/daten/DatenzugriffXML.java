package daten;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import klassen.FarbEnum;
import klassen.SpielBean;

public class DatenzugriffXML implements iDatenzugriff{

	@Override
	public void speichern(String filename,Object spiel ) {
		File file=null;
		try{
			file= new File(filename+".xml");
			JAXBContext context=JAXBContext.newInstance(SpielBean.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(spiel, file);
//			m.marshal(spiel, System.out);
			
		} 
		catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object laden(String filename){
		SpielBean s1 =null;
		File file=null;
		try{
			file=new File(filename);
			JAXBContext context=JAXBContext.newInstance(SpielBean.class);
			Unmarshaller um=context.createUnmarshaller();
			
			s1 = (SpielBean) um.unmarshal(file);
			
			
			
				for(int i=0;i<s1.getSpielbrett().getFelder().length;i++){
					for(int j=0;j<s1.getSpielbrett().getFelder()[i].length;j++){
						if(s1.getSpielbrett().getFelder()[i][j].getFigur()!=null){
							
							if(s1.getSpielbrett().getFelder()[i][j].getFigur().getFarbe()==FarbEnum.WEISS){
								if(s1.getSpieler1().getFarbe()==FarbEnum.WEISS){
									
									for(int k=0;k<s1.getSpieler1().getFigurArray().length;k++){
										String whiteIdSpieler1 = s1.getSpieler1().getFigurArray()[k].getId();
										String whiteIdFeld = s1.getSpielbrett().getFelder()[i][j].getFigur().getId();
										
										if(whiteIdSpieler1.equals(whiteIdFeld)){
											//spieler 1
											s1.getSpieler1().getFigurArray()[k].setSpielfeld(s1.getSpielbrett().getFelder()[i][j]);
											s1.getSpielbrett().getFelder()[i][j].setFigur(s1.getSpieler1().getFigurArray()[k]);
										}
										if(s1.getFigurWeiss2().get(k).getId().equals(whiteIdFeld)){
											//figurweiss2
											s1.getFigurWeiss2().get(k).setSpielfeld(s1.getSpielbrett().getFelder()[i][j]);
											s1.getSpielbrett().getFelder()[i][j].setFigur(s1.getFigurWeiss2().get(k));
										}
										
									}
									
								}
								
								
								
							}
							if(s1.getSpielbrett().getFelder()[i][j].getFigur().getFarbe()==FarbEnum.SCHWARZ){
								
								if(s1.getSpieler2().getFarbe()==FarbEnum.SCHWARZ){
									
									for(int k=0;k<s1.getSpieler2().getFigurArray().length;k++){
										String blackIdSpieler2 = s1.getSpieler2().getFigurArray()[k].getId();
										String blackIdFeld = s1.getSpielbrett().getFelder()[i][j].getFigur().getId();
										
										if(blackIdSpieler2.equals(blackIdFeld)){
											//spieler2
											s1.getSpieler2().getFigurArray()[k].setSpielfeld(s1.getSpielbrett().getFelder()[i][j]);
											s1.getSpielbrett().getFelder()[i][j].setFigur(s1.getSpieler2().getFigurArray()[k]);
										}
										if(s1.getFigurSchwarz2().get(k).getId().equals(blackIdFeld)){
											//figurschwarz2
											s1.getFigurSchwarz2().get(k).setSpielfeld(s1.getSpielbrett().getFelder()[i][j]);
											s1.getSpielbrett().getFelder()[i][j].setFigur(s1.getFigurSchwarz2().get(k));
										}
									}
									
								}
								
							}
							
						}
					}
				}
				
				if(s1.getSpieler1().getKi()!=null){
					s1.getSpieler1().getKi().setSpiel(s1);
				}
				if(s1.getSpieler2().getKi()!=null){
					s1.getSpieler2().getKi().setSpiel(s1);
				}
		}
		
		catch (Exception e){
			e.getMessage();
		}
		return s1;
	}
	

    
    
    
    
	
}

