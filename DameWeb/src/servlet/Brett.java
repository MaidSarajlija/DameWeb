package servlet;



import java.util.ArrayList;




//import daten.DatenzugriffCSV;
//import daten.DatenzugriffSerialisiert;
import klassen.SpielBean;

public class Brett {
	
	public static boolean press=true;
	static String[]x;
	
	public static String getHeader(){
	return 
//	"<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>"+
	"<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>"+
	"<html>" +
	"<head>"+ 
	
	
	"<link rel='stylesheet' type='text/css' href='style1.css'>"+
	"<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>"+
	"<script src='http://code.jquery.com/jquery-latest.min.js' type='text/javascript'></script>"+
//	"<script src='click.js'></script>"+
	"<title>Spielbrett</title>"+
	
	"</head>" +
	"<body>" ;
	}
	
	
	public static  String getMenu(){
	String s="";
	

	
	s+="<center>";
	s+="<div id='cssmenu'>";
	s+="<ul>";
	s+="<li class='active'><a href='#'>Speichern als</a></li>";
	s+="<li><a href='/daten/SpeichernSER.jsp'>SER</a></li>";
	s+="<li><a href='/daten/SpeichernCSV.jsp'>CSV</a></li>";
	s+="<li><a href='/daten/SpeichernPDF.jsp'>PDF</a></li>";
	s+="<li><a href='/daten/SpeichernXML.jsp'>XML</a></li>";
	s+="<li><a href='/daten/ViewPDF'>View PDF</a></li>";
	s+="</ul>";
	s+="</div>";
	s+="</center>";

	
	s+="<div id='steuerung'>";
	s+="<font color='white' face='Trebuchet MS'>Steuerung</font>";
	s+="<br><br>";
	
	//------Refresh------
	s+="<form action='Refresh' method='post'>";
	s+="<input id='refresh' type = 'submit' value = 'Refresh' name='refreshNormal'>";
	s+="</form>";
	s+="<br>";
	
	//------LaufKi------
	s+="<form action='LaufKi' method='post'>";
	if(Index.getGame().hatGewonnen()==true){
		s+="<input disabled id='refresh' type = 'submit' value = 'Lauf Ki' name='laufKi'>";
	}else{
		s+="<input id='refresh' type = 'submit' value = 'Lauf Ki' name='laufKi'>";
	}
	s+="</form>";
	s+="<br>";
		
	//------ZugBeenden------
//	s+="<form action='Beenden' method='post'>";
//	if(Index.getGame().ermittleSpielerAmZugFarbe().equals(Index.getGame().gibFarbeSession())&&Index.getGame().hatGewonnen()==false){
//		s+="<input id='refresh' type = 'submit' value = 'Zug Beenden' name='beendenNormal'>";		
//	}else{
//		s+="<input disabled id='refresh' type = 'submit' value = 'Zug Beenden'>";
//	}
//	s+="</form>";
	
	
	s+="</div>";
	s+=	"<br>";
	
	return s;
	
	}
	
	public static  String getTable(){
		String s="";
		
//		s+="<form action='Laufen' method='post'>";
//		s+="<input type='hidden' id='hiddenField' value='' name='hid' >";
//		s+="</form>";

		
		s+="<center><table width='550px' height='550px' border='1'>";
		
		int b=0;
		for(int i=0;i<12;i++){
			s+="<tr>";
			for(int k=0;k<12;k++){
				b++;
				String fig="";
				if(Index.getGame().hatGewonnen()==true){
					fig="<a onclick='myFunction("+ b +")' href='javascript:;' class='active' >";
				}else{
					fig="<a onclick='myFunction("+ b +")' href='javascript:;'>";
				}
				
				s+="<td width='35px' height='40px'>";
	
				if(b==2||b==4 ||b==6||b==8 ||b==10 ||b==12){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==13||b==15||b==17||b==19||b==21||b==23){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==26||b==28||b==30||b==32||b==34||b==36){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==37||b==39||b==41||b==43||b==45||b==47){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==50||b==52||b==54||b==56||b==58||b==60){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==61||b==63||b==65||b==67||b==69||b==71){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==74||b==76||b==78||b==80||b==82||b==84){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==85||b==87||b==89||b==91||b==93||b==95){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==98||b==100||b==102||b==104||b==106||b==108){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==109||b==111||b==113||b==115||b==117||b==119){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==122||b==124||b==126||b==128||b==130||b==132){
					s+=fig+updateFigur(b)+"</a>";
				}
				if(b==133||b==135||b==137||b==139||b==141||b==143){
					s+=fig+updateFigur(b)+"</a>";
				}
				s+= "</td>";
			}
			s+="</tr>";
		}
		
		
		s+="</table></center>";
		s+="<script>";
		s+="function myFunction(x){";
//		s+="alert('cell index is: ' +  x);";
		s+="var m=x;";
		s+="window.location.replace('Laufen?m='+m);";
		s+="}";
		s+="</script>";
		
		
		
		
		return s;
	}

	public static  String getMenuEnd(){
		String s="";
		
		s+="<br><br>";
		s+="<center><div id='log'><textarea readonly disabled id='logging' rows='1' cols='1'>"+
		ausgabe()+
//		SpielBean.baos.toString()+
		"</textarea></div></center>";
//		SpielBean.baos.toString()+
//		DatenzugriffSerialisiert.baos.toString()+
//		DatenzugriffCSV.baos.toString()+
		
		s+="<br><br>";
		
		return s;
	}
	
	public static String getFooter(){
		return 
		"</body>"+
		"</html>";
	}
	
	public static ArrayList<String> ausgabe(){
		
		ArrayList<String>au=new ArrayList<String>();
		x=SpielBean.baos.toString().split("\n");
		
		for(int i=x.length-1;i>=0;i--){
			au.add(x[i]+("\n"));
		}
		
		return au;
	}
	
	public static String link(String im,int l){
		String fig="";
		
		if(Index.getGame().hatGewonnen()==true){
			 fig="<a onclick='myFunction("+l+")' href='javascript:;' class='active' >";
		}else{
//			if(Index.getGame().ermittleSpielerAmZugFarbe().equals("Schwarz")){
				if(im.equals("<img src='Bilder/schwarzerStein.png'>")){
					fig="<a onclick='myFunction("+l+")' href='javascript:;'>";
				}
				if(im.equals("<img src='Bilder/leererStein.png'>")){
					fig="<a onclick='myFunction("+l+")' href='javascript:;'>";
				}
//				if(im.equals("<img src='Bilder/weissStein.png'>")){
//					fig="<a onclick='myFunction("+l+")' href='javascript:;' class='active'>";
//				}
//			}else{
//				if(im.equals("<img src='Bilder/schwarzerStein.png'>")){
//					fig="<a onclick='myFunction("+l+")' href='javascript:;' class='active'>";
//				}
//				if(im.equals("<img src='Bilder/leererStein.png'>")){
//					fig="<a onclick='myFunction("+l+")' href='javascript:;'>";
//				}
				if(im.equals("<img src='Bilder/weissStein.png'>")){
					fig="<a onclick='myFunction("+l+")' href='javascript:;'>";
				}
//			}
			
		}
		
		
		return fig;
	}
	
	public static String updateFigur(int i){
		String o="";
		
		//----Schwarz------
		if(Index.getGame().gibFigurWebId()[i]!=null&&Index.getGame().gibFigurWebId()[i]=="schwarz"){
			o="<img src='Bilder/schwarzerStein.png'>";
		}
		else{
			o="<img src='Bilder/leererStein.png'>";
		}
		
		//-----Weiss-----
		if(Index.getGame().gibFigurWebId()[i]!=null&&Index.getGame().gibFigurWebId()[i]=="weiss"){
			o="<img src='Bilder/weissStein.png'>";
		}
		return o;
		
	}
	

	
	
	
	
}
