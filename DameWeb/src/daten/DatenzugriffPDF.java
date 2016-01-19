package daten;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;

import klassen.FarbEnum;
import klassen.SpielBean;
import klassen.Spielbrett;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class DatenzugriffPDF implements iDatenzugriff, Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Document document=null;
	private PdfWriter writer=null;
	
	private ArrayList<String>felder=new ArrayList<String>();


@Override
public void speichern(String filename,Object spiel) {
	try {
		
		SpielBean s=(SpielBean)spiel;
		String realPath=s.getRealPath()+"/Bilder/";
		
		document = new Document(PageSize.A4);
		writer = PdfWriter.getInstance(document, new FileOutputStream(filename + ".pdf"));
		document.open();
		Image image = Image.getInstance(realPath+"brettNeu.png");
		Paragraph title = new Paragraph("Dame\nSpielstand", new Font(Font.FontFamily.HELVETICA, 20)); 
		
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingAfter(10);
		
		image.scaleToFit(510,510);
		image.setAlignment(Element.ALIGN_CENTER);
		document.add(title);
		
		image.setSpacingBefore(10);
		image.setWidthPercentage(100);
		
		document.add(image);
		image.setSpacingAfter(10);
		PdfContentByte over = writer.getDirectContent();
		over.saveState();
		felder(s);
		
		//------Felder erstellen-----------
		//------------Reihe 1-------------
		Image feld1 = Image.getInstance(realPath+felder.get(0));
		Image feld2 = Image.getInstance(realPath+felder.get(1));
		Image feld3 = Image.getInstance(realPath+felder.get(2));
		Image feld4 = Image.getInstance(realPath+felder.get(3));
		Image feld5 = Image.getInstance(realPath+felder.get(4));
		Image feld6 = Image.getInstance(realPath+felder.get(5));
		//------------Reihe 2-------------
		Image feld7 = Image.getInstance(realPath+felder.get(6));
		Image feld8 = Image.getInstance(realPath+felder.get(7));
		Image feld9 = Image.getInstance(realPath+felder.get(8));
		Image feld10 = Image.getInstance(realPath+felder.get(9));
		Image feld11 = Image.getInstance(realPath+felder.get(10));
		Image feld12 = Image.getInstance(realPath+felder.get(11));
		//------------Reihe 3-------------
		Image feld13 = Image.getInstance(realPath+felder.get(12));
		Image feld14 = Image.getInstance(realPath+felder.get(13));
		Image feld15 = Image.getInstance(realPath+felder.get(14));
		Image feld16 = Image.getInstance(realPath+felder.get(15));
		Image feld17 = Image.getInstance(realPath+felder.get(16));
		Image feld18 = Image.getInstance(realPath+felder.get(17));
		//------------Reihe 4-------------
		Image feld19 = Image.getInstance(realPath+felder.get(18));
		Image feld20 = Image.getInstance(realPath+felder.get(19));
		Image feld21 = Image.getInstance(realPath+felder.get(20));
		Image feld22 = Image.getInstance(realPath+felder.get(21));
		Image feld23 = Image.getInstance(realPath+felder.get(22));
		Image feld24 = Image.getInstance(realPath+felder.get(23));
		//------------Reihe 5-------------
		Image feld25 = Image.getInstance(realPath+felder.get(24));
		Image feld26 = Image.getInstance(realPath+felder.get(25));
		Image feld27 = Image.getInstance(realPath+felder.get(26));
		Image feld28 = Image.getInstance(realPath+felder.get(27));
		Image feld29 = Image.getInstance(realPath+felder.get(28));
		Image feld30 = Image.getInstance(realPath+felder.get(29));
		//------------Reihe 6-------------
		Image feld31 = Image.getInstance(realPath+felder.get(30));
		Image feld32 = Image.getInstance(realPath+felder.get(31));
		Image feld33 = Image.getInstance(realPath+felder.get(32));
		Image feld34 = Image.getInstance(realPath+felder.get(33));
		Image feld35 = Image.getInstance(realPath+felder.get(34));
		Image feld36 = Image.getInstance(realPath+felder.get(35));
		//------------Reihe 7-------------
		Image feld37 = Image.getInstance(realPath+felder.get(36));
		Image feld38 = Image.getInstance(realPath+felder.get(37));
		Image feld39 = Image.getInstance(realPath+felder.get(38));
		Image feld40 = Image.getInstance(realPath+felder.get(39));
		Image feld41 = Image.getInstance(realPath+felder.get(40));
		Image feld42 = Image.getInstance(realPath+felder.get(41));
		//------------Reihe 8-------------
		Image feld43 = Image.getInstance(realPath+felder.get(42));
		Image feld44 = Image.getInstance(realPath+felder.get(43));
		Image feld45 = Image.getInstance(realPath+felder.get(44));
		Image feld46 = Image.getInstance(realPath+felder.get(45));
		Image feld47 = Image.getInstance(realPath+felder.get(46));
		Image feld48 = Image.getInstance(realPath+felder.get(47));
		//------------Reihe 9-------------
		Image feld49 = Image.getInstance(realPath+felder.get(48));
		Image feld50 = Image.getInstance(realPath+felder.get(49));
		Image feld51 = Image.getInstance(realPath+felder.get(50));
		Image feld52 = Image.getInstance(realPath+felder.get(51));
		Image feld53 = Image.getInstance(realPath+felder.get(52));
		Image feld54 = Image.getInstance(realPath+felder.get(53));
		//------------Reihe 10-------------
		Image feld55 = Image.getInstance(realPath+felder.get(54));
		Image feld56 = Image.getInstance(realPath+felder.get(55));
		Image feld57 = Image.getInstance(realPath+felder.get(56));
		Image feld58 = Image.getInstance(realPath+felder.get(57));
		Image feld59 = Image.getInstance(realPath+felder.get(58));
		Image feld60 = Image.getInstance(realPath+felder.get(59));
		//------------Reihe 11-------------
		Image feld61 = Image.getInstance(realPath+felder.get(60));
		Image feld62 = Image.getInstance(realPath+felder.get(61));
		Image feld63 = Image.getInstance(realPath+felder.get(62));
		Image feld64 = Image.getInstance(realPath+felder.get(63));
		Image feld65 = Image.getInstance(realPath+felder.get(64));
		Image feld66 = Image.getInstance(realPath+felder.get(65));
		//------------Reihe 12-------------
		Image feld67 = Image.getInstance(realPath+felder.get(66));
		Image feld68 = Image.getInstance(realPath+felder.get(67));
		Image feld69 = Image.getInstance(realPath+felder.get(68));
		Image feld70 = Image.getInstance(realPath+felder.get(69));
		Image feld71 = Image.getInstance(realPath+felder.get(70));
		Image feld72 = Image.getInstance(realPath+felder.get(71));
		
	
		
		
		
		//-------Felder setzen-----------
		//(x,y);
		//------------Reihe 1-------------
		feld1.setAbsolutePosition(45,215);  // 1
		over.addImage(feld1);
		feld2.setAbsolutePosition(130, 215); // 2
		over.addImage(feld2);
		feld3.setAbsolutePosition(215, 215); // 3
		over.addImage(feld3);
		feld4.setAbsolutePosition(300, 215); // 4
		over.addImage(feld4);
		feld5.setAbsolutePosition(385, 215); // 5
		over.addImage(feld5);
		feld6.setAbsolutePosition(470, 215); // 6
		over.addImage(feld6);
		//------------Reihe 2-------------
		feld7.setAbsolutePosition(88, 258); // 7
		over.addImage(feld7);
		feld8.setAbsolutePosition(173, 258); // 8
		over.addImage(feld8);
		feld9.setAbsolutePosition(258, 258); // 9
		over.addImage(feld9);
		feld10.setAbsolutePosition(343, 258); // 10
		over.addImage(feld10);
		feld11.setAbsolutePosition(428, 258); // 11
		over.addImage(feld11);
		feld12.setAbsolutePosition(513, 258); // 12
		over.addImage(feld12);
		//------------Reihe 3-------------
		feld13.setAbsolutePosition(45, 301); // 13
		over.addImage(feld13);
		feld14.setAbsolutePosition(130, 301); // 14
		over.addImage(feld14);
		feld15.setAbsolutePosition(215, 301); // 15
		over.addImage(feld15);
		feld16.setAbsolutePosition(300, 301); // 16
		over.addImage(feld16);
		feld17.setAbsolutePosition(385, 301); // 17
		over.addImage(feld17);
		feld18.setAbsolutePosition(470, 301); // 18
		over.addImage(feld18);
		//------------Reihe 4-------------
		feld19.setAbsolutePosition(88, 344); // 19
		over.addImage(feld19);
		feld20.setAbsolutePosition(173, 344); // 20
		over.addImage(feld20);
		feld21.setAbsolutePosition(258, 344); // 21
		over.addImage(feld21);
		feld22.setAbsolutePosition(343, 344); // 22
		over.addImage(feld22);
		feld23.setAbsolutePosition(428, 344); // 23	
		over.addImage(feld23);
		feld24.setAbsolutePosition(513, 344); // 24
		over.addImage(feld24);
		//------------Reihe 5-------------
		feld25.setAbsolutePosition(45, 387); // 25
		over.addImage(feld25);
		feld26.setAbsolutePosition(130, 387); // 26
		over.addImage(feld26);
		feld27.setAbsolutePosition(215, 387); // 27
		over.addImage(feld27);
		feld28.setAbsolutePosition(300, 387); // 28
		over.addImage(feld28);
		feld29.setAbsolutePosition(385, 387); // 29
		over.addImage(feld29);
		feld30.setAbsolutePosition(470, 387); // 30
		over.addImage(feld30);
		//------------Reihe 6-------------
		feld31.setAbsolutePosition(88, 430); // 31
		over.addImage(feld31);
		feld32.setAbsolutePosition(173, 430); // 32
		over.addImage(feld32);
		feld33.setAbsolutePosition(258, 430); // 33
		over.addImage(feld33);
		feld34.setAbsolutePosition(343, 430); // 34
		over.addImage(feld34);
		feld35.setAbsolutePosition(428, 430); // 35
		over.addImage(feld35);
		feld36.setAbsolutePosition(513, 430); // 36
		over.addImage(feld36);
		//------------Reihe 7-------------
		feld37.setAbsolutePosition(45, 473);  // 37
		over.addImage(feld37);
		feld38.setAbsolutePosition(130, 473); // 38
		over.addImage(feld38);
		feld39.setAbsolutePosition(215, 473); // 39
		over.addImage(feld39);
		feld40.setAbsolutePosition(300, 473); // 40
		over.addImage(feld40);
		feld41.setAbsolutePosition(385, 473); // 41
		over.addImage(feld41);
		feld42.setAbsolutePosition(470, 473); // 42
		over.addImage(feld42);
		//------------Reihe 8-------------
		feld43.setAbsolutePosition(88, 516);  // 43
		over.addImage(feld43);
		feld44.setAbsolutePosition(173, 516); // 44
		over.addImage(feld44);
		feld45.setAbsolutePosition(258, 516); // 45
		over.addImage(feld45);
		feld46.setAbsolutePosition(343, 516); // 46
		over.addImage(feld46);
		feld47.setAbsolutePosition(428, 516); // 47
		over.addImage(feld47);
		feld48.setAbsolutePosition(513, 516); // 48
		over.addImage(feld48);
		//------------Reihe 9-------------
		feld49.setAbsolutePosition(45, 559);  // 49
		over.addImage(feld49);
		feld50.setAbsolutePosition(130, 559); // 50
		over.addImage(feld50);
		feld51.setAbsolutePosition(215, 559); // 51
		over.addImage(feld51);
		feld52.setAbsolutePosition(300, 559); // 52
		over.addImage(feld52);
		feld53.setAbsolutePosition(385, 559); // 53
		over.addImage(feld53);
		feld54.setAbsolutePosition(470, 559); // 54
		over.addImage(feld54);
		//------------Reihe 10-------------
		feld55.setAbsolutePosition(88, 602);  // 55
		over.addImage(feld55);
		feld56.setAbsolutePosition(173, 602); // 56
		over.addImage(feld56);
		feld57.setAbsolutePosition(258, 602); // 57
		over.addImage(feld57);
		feld58.setAbsolutePosition(343, 602); // 58
		over.addImage(feld58);
		feld59.setAbsolutePosition(428, 602); // 59
		over.addImage(feld59);
		feld60.setAbsolutePosition(513, 602); // 60
		over.addImage(feld60);
		//------------Reihe 11-------------
		feld61.setAbsolutePosition(45, 645);  // 61
		over.addImage(feld61);
		feld62.setAbsolutePosition(130, 645); // 62
		over.addImage(feld62);
		feld63.setAbsolutePosition(215, 645); // 63
		over.addImage(feld63);
		feld64.setAbsolutePosition(300, 645); // 64
		over.addImage(feld64);
		feld65.setAbsolutePosition(385, 645); // 65
		over.addImage(feld65);
		feld66.setAbsolutePosition(470, 645); // 66
		over.addImage(feld66);
		//------------Reihe 12-------------
		feld67.setAbsolutePosition(88, 688);  // 67
		over.addImage(feld67);
		feld68.setAbsolutePosition(173, 688); // 68
		over.addImage(feld68);
		feld69.setAbsolutePosition(258, 688); // 69
		over.addImage(feld69);
		feld70.setAbsolutePosition(343, 688); // 70
		over.addImage(feld70);
		feld71.setAbsolutePosition(428, 688); // 71
		over.addImage(feld71);
		feld72.setAbsolutePosition(513, 688); // 72
		over.addImage(feld72);
		

		
		
		
		
		over.restoreState();
		
	} catch (FileNotFoundException e) {
		document.close();
		System.err.println(filename + ".pdf konnte nicht erzeugt werden");
		
	} catch (DocumentException e) {
		document.close();
		System.err.println("Das Dokument wurde bereits geschlossen oder ist nicht offen");
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	finally{
		document.close();
	}
	
}

public void felder(SpielBean s){
//	felder = new ArrayList<String>();
	Spielbrett sb=s.getSpielbrett();
			
			//-----Reihe 1-------------------------------------
			if(sb.getFelder()[0][0].getFigur()!=null || sb.getFelder()[0][0].getFigur()==null){
				if(sb.getFelder()[0][0].getFigur()!=null){
					if(sb.getFelder()[0][0].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[0][0].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[0][2].getFigur()!=null || sb.getFelder()[0][2].getFigur()==null){
				if(sb.getFelder()[0][2].getFigur()!=null){
					if(sb.getFelder()[0][2].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[0][2].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[0][4].getFigur()!=null || sb.getFelder()[0][4].getFigur()==null){
				if(sb.getFelder()[0][4].getFigur()!=null){
					if(sb.getFelder()[0][4].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[0][4].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[0][6].getFigur()!=null || sb.getFelder()[0][6].getFigur()==null){
				if(sb.getFelder()[0][6].getFigur()!=null){
					if(sb.getFelder()[0][6].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[0][6].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[0][8].getFigur()!=null || sb.getFelder()[0][8].getFigur()==null){
				if(sb.getFelder()[0][8].getFigur()!=null){
					if(sb.getFelder()[0][8].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[0][8].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[0][10].getFigur()!=null || sb.getFelder()[0][10].getFigur()==null){
				if(sb.getFelder()[0][10].getFigur()!=null){
					if(sb.getFelder()[0][10].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[0][10].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 2-------------------------------------
			if(sb.getFelder()[1][1].getFigur()!=null || sb.getFelder()[1][1].getFigur()==null){
				if(sb.getFelder()[1][1].getFigur()!=null){
					if(sb.getFelder()[1][1].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[1][1].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[1][3].getFigur()!=null || sb.getFelder()[1][3].getFigur()==null){
				if(sb.getFelder()[1][3].getFigur()!=null){
					if(sb.getFelder()[1][3].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[1][3].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[1][5].getFigur()!=null || sb.getFelder()[1][5].getFigur()==null){
				if(sb.getFelder()[1][5].getFigur()!=null){
					if(sb.getFelder()[1][5].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[1][5].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[1][7].getFigur()!=null || sb.getFelder()[1][7].getFigur()==null){
				if(sb.getFelder()[1][7].getFigur()!=null){
					if(sb.getFelder()[1][7].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[1][7].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[1][9].getFigur()!=null || sb.getFelder()[1][9].getFigur()==null){
				if(sb.getFelder()[1][9].getFigur()!=null){
					if(sb.getFelder()[1][9].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[1][9].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[1][11].getFigur()!=null || sb.getFelder()[1][11].getFigur()==null){
				if(sb.getFelder()[1][11].getFigur()!=null){
					if(sb.getFelder()[1][11].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[1][11].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 3-------------------------------------
			if(sb.getFelder()[2][0].getFigur()!=null || sb.getFelder()[2][0].getFigur()==null){
				if(sb.getFelder()[2][0].getFigur()!=null){
					if(sb.getFelder()[2][0].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[2][0].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[2][2].getFigur()!=null || sb.getFelder()[2][2].getFigur()==null){
				if(sb.getFelder()[2][2].getFigur()!=null){
					if(sb.getFelder()[2][2].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[2][2].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[2][4].getFigur()!=null || sb.getFelder()[2][4].getFigur()==null){
				if(sb.getFelder()[2][4].getFigur()!=null){
					if(sb.getFelder()[2][4].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[2][4].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[2][6].getFigur()!=null || sb.getFelder()[2][6].getFigur()==null){
				if(sb.getFelder()[2][6].getFigur()!=null){
					if(sb.getFelder()[2][6].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[2][6].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[2][8].getFigur()!=null || sb.getFelder()[2][8].getFigur()==null){
				if(sb.getFelder()[2][8].getFigur()!=null){
					if(sb.getFelder()[2][8].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[2][8].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[2][10].getFigur()!=null || sb.getFelder()[2][10].getFigur()==null){
				if(sb.getFelder()[2][10].getFigur()!=null){
					if(sb.getFelder()[2][10].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[2][10].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 4-------------------------------------
			if(sb.getFelder()[3][1].getFigur()!=null || sb.getFelder()[3][1].getFigur()==null){
				if(sb.getFelder()[3][1].getFigur()!=null){
					if(sb.getFelder()[3][1].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[3][1].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[3][3].getFigur()!=null || sb.getFelder()[3][3].getFigur()==null){
				if(sb.getFelder()[3][3].getFigur()!=null){
					if(sb.getFelder()[3][1].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[3][3].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[3][5].getFigur()!=null || sb.getFelder()[3][5].getFigur()==null){
				if(sb.getFelder()[3][5].getFigur()!=null){
					if(sb.getFelder()[3][5].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[3][5].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[3][7].getFigur()!=null || sb.getFelder()[3][7].getFigur()==null){
				if(sb.getFelder()[3][7].getFigur()!=null){
					if(sb.getFelder()[3][7].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[3][7].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[3][9].getFigur()!=null || sb.getFelder()[3][9].getFigur()==null){
				if(sb.getFelder()[3][9].getFigur()!=null){
					if(sb.getFelder()[3][9].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[3][9].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[3][11].getFigur()!=null || sb.getFelder()[3][11].getFigur()==null){
				if(sb.getFelder()[3][11].getFigur()!=null){
					if(sb.getFelder()[3][11].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[3][11].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 5-------------------------------------
			if(sb.getFelder()[4][0].getFigur()!=null || sb.getFelder()[4][0].getFigur()==null){
				if(sb.getFelder()[4][0].getFigur()!=null){
					if(sb.getFelder()[4][0].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[4][0].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[4][2].getFigur()!=null || sb.getFelder()[4][2].getFigur()==null){
				if(sb.getFelder()[4][2].getFigur()!=null){
					if(sb.getFelder()[4][2].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[4][2].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[4][4].getFigur()!=null || sb.getFelder()[4][4].getFigur()==null){
				if(sb.getFelder()[4][4].getFigur()!=null){
					if(sb.getFelder()[4][4].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[4][4].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[4][6].getFigur()!=null || sb.getFelder()[4][6].getFigur()==null){
				if(sb.getFelder()[4][6].getFigur()!=null){
					if(sb.getFelder()[4][6].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[4][6].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[4][8].getFigur()!=null || sb.getFelder()[4][8].getFigur()==null){
				if(sb.getFelder()[4][8].getFigur()!=null){
					if(sb.getFelder()[4][8].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[4][8].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[4][10].getFigur()!=null || sb.getFelder()[4][10].getFigur()==null){
				if(sb.getFelder()[4][10].getFigur()!=null){
					if(sb.getFelder()[4][10].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[4][10].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 6-------------------------------------
			if(sb.getFelder()[5][1].getFigur()!=null || sb.getFelder()[5][1].getFigur()==null){
				if(sb.getFelder()[5][1].getFigur()!=null){
					if(sb.getFelder()[5][1].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[5][1].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[5][3].getFigur()!=null || sb.getFelder()[5][3].getFigur()==null){
				if(sb.getFelder()[5][3].getFigur()!=null){
					if(sb.getFelder()[5][3].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[5][3].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[5][5].getFigur()!=null || sb.getFelder()[5][5].getFigur()==null){
				if(sb.getFelder()[5][5].getFigur()!=null){
					if(sb.getFelder()[5][5].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[5][5].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[5][7].getFigur()!=null || sb.getFelder()[5][7].getFigur()==null){
				if(sb.getFelder()[5][7].getFigur()!=null){
					if(sb.getFelder()[5][7].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[5][7].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[5][9].getFigur()!=null || sb.getFelder()[5][9].getFigur()==null){
				if(sb.getFelder()[5][9].getFigur()!=null){
					if(sb.getFelder()[5][9].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[5][9].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[5][11].getFigur()!=null || sb.getFelder()[5][11].getFigur()==null){
				if(sb.getFelder()[5][11].getFigur()!=null){
					if(sb.getFelder()[5][11].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[5][11].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 7-------------------------------------
			if(sb.getFelder()[6][0].getFigur()!=null || sb.getFelder()[6][0].getFigur()==null){
				if(sb.getFelder()[6][0].getFigur()!=null){
					if(sb.getFelder()[6][0].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[6][0].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[6][2].getFigur()!=null || sb.getFelder()[6][2].getFigur()==null){
				if(sb.getFelder()[6][2].getFigur()!=null){
					if(sb.getFelder()[6][2].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[6][2].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[6][4].getFigur()!=null || sb.getFelder()[6][4].getFigur()==null){
				if(sb.getFelder()[6][4].getFigur()!=null){
					if(sb.getFelder()[6][4].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[6][4].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[6][6].getFigur()!=null || sb.getFelder()[6][6].getFigur()==null){
				if(sb.getFelder()[6][6].getFigur()!=null){
					if(sb.getFelder()[6][6].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[6][6].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[6][8].getFigur()!=null || sb.getFelder()[6][8].getFigur()==null){
				if(sb.getFelder()[6][8].getFigur()!=null){
					if(sb.getFelder()[6][8].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[6][8].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[6][10].getFigur()!=null || sb.getFelder()[6][10].getFigur()==null){
				if(sb.getFelder()[6][10].getFigur()!=null){
					if(sb.getFelder()[6][10].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[6][10].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 8-------------------------------------
			if(sb.getFelder()[7][1].getFigur()!=null || sb.getFelder()[7][1].getFigur()==null){
				if(sb.getFelder()[7][1].getFigur()!=null){
					if(sb.getFelder()[7][1].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[7][1].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[7][3].getFigur()!=null || sb.getFelder()[7][3].getFigur()==null){
				if(sb.getFelder()[7][3].getFigur()!=null){
					if(sb.getFelder()[7][3].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[7][3].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[7][5].getFigur()!=null || sb.getFelder()[7][5].getFigur()==null){
				if(sb.getFelder()[7][5].getFigur()!=null){
					if(sb.getFelder()[7][5].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[7][5].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[7][7].getFigur()!=null || sb.getFelder()[7][7].getFigur()==null){
				if(sb.getFelder()[7][7].getFigur()!=null){
					if(sb.getFelder()[7][7].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[7][7].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[7][9].getFigur()!=null || sb.getFelder()[7][9].getFigur()==null){
				if(sb.getFelder()[7][9].getFigur()!=null){
					if(sb.getFelder()[7][9].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[7][9].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[7][11].getFigur()!=null || sb.getFelder()[7][11].getFigur()==null){
				if(sb.getFelder()[7][11].getFigur()!=null){
					if(sb.getFelder()[7][11].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[7][11].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 9-------------------------------------
			if(sb.getFelder()[8][0].getFigur()!=null || sb.getFelder()[8][0].getFigur()==null){
				if(sb.getFelder()[8][0].getFigur()!=null){
					if(sb.getFelder()[8][0].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[8][0].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[8][2].getFigur()!=null || sb.getFelder()[8][2].getFigur()==null){
				if(sb.getFelder()[8][2].getFigur()!=null){
					if(sb.getFelder()[8][2].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[8][2].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[8][4].getFigur()!=null || sb.getFelder()[8][4].getFigur()==null){
				if(sb.getFelder()[8][4].getFigur()!=null){
					if(sb.getFelder()[8][4].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[8][4].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[8][6].getFigur()!=null || sb.getFelder()[8][6].getFigur()==null){
				if(sb.getFelder()[8][6].getFigur()!=null){
					if(sb.getFelder()[8][6].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[8][6].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[8][8].getFigur()!=null || sb.getFelder()[8][8].getFigur()==null){
				if(sb.getFelder()[8][8].getFigur()!=null){
					if(sb.getFelder()[8][8].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[8][8].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[8][10].getFigur()!=null || sb.getFelder()[8][10].getFigur()==null){
				if(sb.getFelder()[8][10].getFigur()!=null){
					if(sb.getFelder()[8][10].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[8][10].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 10-------------------------------------
			if(sb.getFelder()[9][1].getFigur()!=null || sb.getFelder()[9][1].getFigur()==null){
				if(sb.getFelder()[9][1].getFigur()!=null){
					if(sb.getFelder()[9][1].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[9][1].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[9][3].getFigur()!=null || sb.getFelder()[9][3].getFigur()==null){
				if(sb.getFelder()[9][3].getFigur()!=null){
					if(sb.getFelder()[9][3].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[9][3].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[9][5].getFigur()!=null || sb.getFelder()[9][5].getFigur()==null){
				if(sb.getFelder()[9][5].getFigur()!=null){
					if(sb.getFelder()[9][5].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[9][5].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[9][7].getFigur()!=null || sb.getFelder()[9][7].getFigur()==null){
				if(sb.getFelder()[9][7].getFigur()!=null){
					if(sb.getFelder()[9][7].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[9][7].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[9][9].getFigur()!=null || sb.getFelder()[9][9].getFigur()==null){
				if(sb.getFelder()[9][9].getFigur()!=null){
					if(sb.getFelder()[9][9].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[9][9].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[9][11].getFigur()!=null || sb.getFelder()[9][11].getFigur()==null){
				if(sb.getFelder()[9][11].getFigur()!=null){
					if(sb.getFelder()[9][11].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[9][11].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 11-------------------------------------
			if(sb.getFelder()[10][0].getFigur()!=null || sb.getFelder()[10][0].getFigur()==null){
				if(sb.getFelder()[10][0].getFigur()!=null){
					if(sb.getFelder()[10][0].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[10][0].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[10][2].getFigur()!=null || sb.getFelder()[10][2].getFigur()==null){
				if(sb.getFelder()[10][2].getFigur()!=null){
					if(sb.getFelder()[10][2].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[10][2].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[10][4].getFigur()!=null || sb.getFelder()[10][4].getFigur()==null){
				if(sb.getFelder()[10][4].getFigur()!=null){
					if(sb.getFelder()[10][4].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[10][4].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[10][6].getFigur()!=null || sb.getFelder()[10][6].getFigur()==null){
				if(sb.getFelder()[10][6].getFigur()!=null){
					if(sb.getFelder()[10][6].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[10][6].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[10][8].getFigur()!=null || sb.getFelder()[10][8].getFigur()==null){
				if(sb.getFelder()[10][8].getFigur()!=null){
					if(sb.getFelder()[10][0].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[10][8].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[10][10].getFigur()!=null || sb.getFelder()[10][10].getFigur()==null){
				if(sb.getFelder()[10][10].getFigur()!=null){
					if(sb.getFelder()[10][10].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[10][10].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			//-----Reihe 12-------------------------------------
			if(sb.getFelder()[11][1].getFigur()!=null || sb.getFelder()[11][1].getFigur()==null){
				if(sb.getFelder()[11][1].getFigur()!=null){
					if(sb.getFelder()[11][1].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[11][1].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[11][3].getFigur()!=null || sb.getFelder()[11][3].getFigur()==null){
				if(sb.getFelder()[11][3].getFigur()!=null){
					if(sb.getFelder()[11][3].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[11][3].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[11][5].getFigur()!=null || sb.getFelder()[11][5].getFigur()==null){
				if(sb.getFelder()[11][5].getFigur()!=null){
					if(sb.getFelder()[11][5].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[11][5].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[11][7].getFigur()!=null || sb.getFelder()[11][7].getFigur()==null){
				if(sb.getFelder()[11][7].getFigur()!=null){
					if(sb.getFelder()[11][7].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[11][7].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[11][9].getFigur()!=null || sb.getFelder()[11][9].getFigur()==null){
				if(sb.getFelder()[11][9].getFigur()!=null){
					if(sb.getFelder()[11][9].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[11][9].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
			
			if(sb.getFelder()[11][11].getFigur()!=null || sb.getFelder()[11][11].getFigur()==null){
				if(sb.getFelder()[11][11].getFigur()!=null){
					if(sb.getFelder()[11][11].getFigur().getFarbe().equals(FarbEnum.SCHWARZ)){
						felder.add("schwarzerStein.png");
					}
					if(sb.getFelder()[11][11].getFigur().getFarbe().equals(FarbEnum.WEISS)){
						felder.add("weissStein.png");
					}
				}else{
					felder.add("leererStein.png");
				}
			}
//	return felder;
	
}


@Override
public Object laden(String filename) {
	// TODO Auto-generated method stub
	return null;
}



}