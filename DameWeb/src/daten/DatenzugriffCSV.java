package daten;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

import klassen.FarbEnum;
import klassen.KI;
import klassen.KI_Dame;
import klassen.SpielBean;
import klassen.Spieler;
import klassen.Spielfigur;

import com.itextpdf.text.log.SysoLogger;


public class DatenzugriffCSV  implements iDatenzugriff{
	
	
	
	private SpielBean s=new SpielBean();
	
	private BufferedWriter br;
	private FileWriter file;
	private BufferedReader rd;
	private FileReader reader;
	public static ByteArrayOutputStream baos = new ByteArrayOutputStream();
	
	
	@Override
	public void speichern(String filename,Object o){
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		
		
		this.s=(SpielBean)o;
		
		try{
			br= new BufferedWriter(new FileWriter(filename+".csv"));
		} catch (IOException e2){
			e2.printStackTrace();
		}
		try{
			Spieler sp1=s.getSpieler1();
			Spieler sp2=s.getSpieler2();
				//Spieler 1 wird gespeichert
				if((sp1.getKi()==null)){
					if(sp1.getFarbe().equals(FarbEnum.WEISS)){
						br.write("Spieler: "+sp1.getName()+ ";" + "Weiss"+ ";" + "Mensch");
						br.newLine();
					}
				}
				else if(sp1.getKi() instanceof KI_Dame){
					if(sp1.getFarbe().equals(FarbEnum.WEISS)){
						br.write("Spieler: "+sp1.getName()+ ";" + "Weiss"+ ";" + "KI");
						br.newLine();
					}
				}
				//Spieler 2 wird gespeichert
				if((sp2.getKi()==null)){
					if(sp2.getFarbe().equals(FarbEnum.SCHWARZ)){
						br.write("Spieler: "+sp2.getName()+ ";" + "Schwarz"+ ";" + "Mensch");
						br.newLine();
					}
				}
				else if(sp2.getKi() instanceof KI_Dame){
					if(sp2.getFarbe().equals(FarbEnum.SCHWARZ)){
						br.write("Spieler: "+sp2.getName()+ ";" + "Schwarz"+ ";" + "KI");
						br.newLine();
					}
				}
				br.write("SpielerAmZug: "+s.getSpielerAmZug().getName()+";"+s.getSpielerAmZug().getFarbe()+";"+"null");
				br.newLine();
			
			//Felder werden gespeichert
			for(int i=0;i<s.getSpielbrett().getFelder().length;i++){
				for(int j=0;j<s.getSpielbrett().getFelder()[i].length;j++){
					if(s.getSpielbrett().getFelder()[i][j].getFigur()==null){
						br.write(s.getSpielbrett().getFelder()[i][j].getId()+ ";"+s.getSpielbrett().getFelder()[i][j].getFarbeFeld()+ ";" +"null"+";"+"null"+";"+"false");
						br.newLine();
					}else if(s.getSpielbrett().getFelder()[i][j].getFigur()!=null){
						br.write(s.getSpielbrett().getFelder()[i][j].getId()+ ";"+s.getSpielbrett().getFelder()[i][j].getFarbeFeld()+ ";" +s.getSpielbrett().getFelder()[i][j].getFigur().getId()+";"+s.getSpielbrett().getFelder()[i][j].getFigur().getFarbe()+";"+s.getSpielbrett().getFelder()[i][j].getFigur().isIstDame());
						br.newLine();
					}
				}
			}
			
			
			System.out.println("SPIEL CSV WURDE ERFOLGREICH GESPEICHERT !!!");
		}
		catch(IOException e1){
			e1.printStackTrace();
		}
		finally{
			try{
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		System.out.flush();
		System.setOut(old);
		
	}
	
	
	@Override
	public Object laden(String filename){
		try{
			
			rd= new BufferedReader(new FileReader(filename));
			String line= null;
			int k=1;
			int l=1;
			
			while((line= rd.readLine())!= null){ 
				if(line.startsWith("Spieler")){	
					
			  		String[] F = line.split(";");
			  		String name = F[0];
			  		String farbe = F[1];
			  		String KI = F[2];
			  		
			  		if(KI.equals("Mensch")){	
			    	  this.s.addSpieler(name.substring(9),this.bestimmeFarbeSpieler(farbe), s.bestimmeKI(KI));
			  		}
			  		else if(KI.equals("KI")){
			  			this.s.addSpieler(name.substring(9),this.bestimmeFarbeSpieler(farbe), s.bestimmeKI(KI));
			  			
			  		}else{
			  			if(this.s.getSpieler1().getFarbe().equals(this.bestimmeFarbeFigur(farbe))){
			  				this.s.setSpielerAmZug(this.s.getSpieler1());
			  				
			  			}
			  			if(this.s.getSpieler2().getFarbe().equals(this.bestimmeFarbeFigur(farbe))){
			  				this.s.setSpielerAmZug(this.s.getSpieler2());
			  				
			  			}
			  			
			  			
			  		}
			  	}
				//------------Weg------------
				else{
					String[] F = line.split(";");  
					String feldId = F[0];
					String feldFarbe = F[1];
					String figurId = F[2];
				    String figurFarbe = F[3];
					String istDame=F[4];
					
					
					
					if( (!figurId.equals("null"))){
						for(int i=0;i<s.getSpielbrett().getFelder().length;i++){
							for(int j=0;j<s.getSpielbrett().getFelder()[i].length;j++){
								if(s.getSpielbrett().getFelder()[i][j].getId().equals(feldId) && (!figurId.equals("null"))){
									Spielfigur x = new Spielfigur(s.getSpielbrett().getFelder()[i][j],this.bestimmeFarbeFigur(figurFarbe),this.istDameCSV(istDame));
									s.getSpielbrett().getFelder()[i][j].setFigur(x);
									if(s.getSpieler1().getFarbe().equals(this.bestimmeFarbeFigur(figurFarbe))){
										if(k<=31){
											x.setId(figurId);
											s.getFigurWeiss()[k]=x;
											s.getSpieler1().getFigurArray()[k]=x;
											
											
										}
										s.getSpieler1().getFigurArray()[k].setSpielfeld(s.getSpielbrett().getFelder()[i][j]);
										s.getSpielbrett().getFelder()[i][j].setFigur(s.getSpieler1().getFigurArray()[k]);
										k++;
									}
									if(s.getSpieler2().getFarbe().equals(this.bestimmeFarbeFigur(figurFarbe))){
										if(l<=31){
											x.setId(figurId);
											s.getFigurSchwarz()[l]=x;
											s.getSpieler2().getFigurArray()[l]=x;
											
										}
										s.getSpieler2().getFigurArray()[l].setSpielfeld(s.getSpielbrett().getFelder()[i][j]);
										s.getSpielbrett().getFelder()[i][j].setFigur(s.getSpieler2().getFigurArray()[l]);
										l++;
									}
								}
							}
						}
					}
				}
				}
			
			s.putArray();
			}	       
		catch(IOException e){
			try {
				throw new IOException ("not found ");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return s;
	    
	}
	
	public int gebeIntSchwarz(String s){
		int a = 0;
		switch (s) {
		case "black 1":
			a = 1;
			break;
		case "black 2":
			a = 2;
			break;
		case "black 3":
			a = 3;
			break;
		case "black 4":
			a = 4;
			break;
		case "black 5":
			a = 5;
			break;
		case "black 6":
			a = 6;
			break;
		case "black 7":
			a = 7;
			break;
		case "black 8":
			a = 8;
			break;
		case "black 9":
			a = 9;
			break;
		case "black 10":
			a = 10;
			break;
		case "black 11":
			a = 11;
			break;
		case "black 12":
			a = 12;
			break;
		case "black 13":
			a = 13;
			break;
		case "black 14":
			a = 14;
			break;
		case "black 15":
			a = 15;
			break;
		case "black 16":
			a = 16;
			break;
		case "black 17":
			a = 17;
			break;
		case "black 18":
			a = 18;
			break;
		case "black 19":
			a = 19;
			break;
		case "black 20":
			a = 20;
			break;
		case "black 21":
			a = 21;
			break;
		case "black 22":
			a = 22;
			break;
		case "black 23":
			a = 23;
			break;
		case "black 24":
			a = 24;
			break;
		case "black 25":
			a = 25;
			break;
		case "black 26":
			a = 26;
			break;
		case "black 27":
			a = 27;
			break;
		case "black 28":
			a = 28;
			break;
		case "black 29":
			a = 29;
			break;
		case "black 30":
			a = 30;
			break;
		}
		return a; 
		
	}
	
	public int gebeIntWeiss(String s){
		int a = 0;
		switch (s) {
		case "white 1":
			a = 1;
			break;
		case "white 2":
			a = 2;
			break;
		case "white 3":
			a = 3;
			break;
		case "white 4":
			a = 4;
			break;
		case "white 5":
			a = 5;
			break;
		case "white 6":
			a = 6;
			break;
		case "white 7":
			a = 7;
			break;
		case "white 8":
			a = 8;
			break;
		case "white 9":
			a = 9;
			break;
		case "white 10":
			a = 10;
			break;
		case "white 11":
			a = 11;
			break;
		case "white 12":
			a = 12;
			break;
		case "white 13":
			a = 13;
			break;
		case "white 14":
			a = 14;
			break;
		case "white 15":
			a = 15;
			break;
		case "white 16":
			a = 16;
			break;
		case "white 17":
			a = 17;
			break;
		case "white 18":
			a = 18;
			break;
		case "white 19":
			a = 19;
			break;
		case "white 20":
			a = 20;
			break;
		case "white 21":
			a = 21;
			break;
		case "white 22":
			a = 22;
			break;
		case "white 23":
			a = 23;
			break;
		case "white 24":
			a = 24;
			break;
		case "white 25":
			a = 25;
			break;
		case "white 26":
			a = 26;
			break;
		case "white 27":
			a = 27;
			break;
		case "white 28":
			a = 28;
			break;
		case "white 29":
			a = 29;
			break;
		case "white 30":
			a = 30;
			break;
		}
		return a; 
		
	}

	
	public boolean istDameCSV(String s){
		boolean istDame=false;
		if(s.equals("true")){
			istDame=true;
		}else{
			istDame=false;
		}
		return istDame;
	}
	
	public FarbEnum bestimmeFarbeSpieler(String farbe) {
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
	
	public FarbEnum bestimmeFarbeFigur(String farbe) {
		FarbEnum getFarbe = null;
		switch (farbe) {
		case "WEISS":
			getFarbe = FarbEnum.WEISS;
			break;
		case "SCHWARZ":
			getFarbe = FarbEnum.SCHWARZ;
			break;

		}
		return getFarbe;
	}
	
	



	
	

	
	
	

	

}
