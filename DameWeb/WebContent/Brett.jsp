<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="script.js"></script>
<title>Brett</title>
</head>
<body>

<center>
<div id="cssmenu">
<ul>
<li class="active"><a href="#">Speichern als</a></li>
<li><a href="/DameLokalWeb/SpeichernSER.jsp">SER</a></li>
<li><a href="/DameLokalWeb/SpeichernCSV.jsp">CSV</a></li>
<li><a href="/DameLokalWeb/SpeichernPDF.jsp">PDF</a></li>
<li><a href="/DameLokalWeb/SpeichernXML.jsp">XML</a></li>
<li><a href="/DameLokalWeb/ViewPDF">View PDF</a></li>
</ul>
</div>
</center>

<div id="steuerung">
<font color="white" face="Trebuchet MS">Steuerung</font>
<br><br>
<form action="Refresh" method="post">
<input id="refresh" type = "submit" value = "Refresh" name="refreshNormal">
</form>
<br>

<form action="LaufKi" method="post">
<%String g =(String)request.getSession().getAttribute("laufKI");
out.print(g);%>
</form>
<br>
		


</div>
<br>

<center><table width="550px" height="550px" border="1">

<% 

int b=0;
		for(int i=0;i<12;i++){
			%>
			<tr>
			<% 
			for(int k=0;k<12;k++){
				b++;
				%>
				<td width="35px" height="40px">
				<%
				String link =(String)request.getSession().getAttribute("link");
				
				String fig1 =(String)request.getSession().getAttribute("fig1");
				String fig2 =(String)request.getSession().getAttribute("fig2");
				String fig3 =(String)request.getSession().getAttribute("fig3");
				String fig4 =(String)request.getSession().getAttribute("fig4");
				String fig5 =(String)request.getSession().getAttribute("fig5");
				String fig6 =(String)request.getSession().getAttribute("fig6");
				String fig7 =(String)request.getSession().getAttribute("fig7");
				String fig8 =(String)request.getSession().getAttribute("fig8");
				String fig9 =(String)request.getSession().getAttribute("fig9");
				String fig10 =(String)request.getSession().getAttribute("fig10");
				
				String fig11 =(String)request.getSession().getAttribute("fig11");
				String fig12 =(String)request.getSession().getAttribute("fig12");
				String fig13 =(String)request.getSession().getAttribute("fig13");
				String fig14 =(String)request.getSession().getAttribute("fig14");
				String fig15 =(String)request.getSession().getAttribute("fig15");
				String fig16 =(String)request.getSession().getAttribute("fig16");
				String fig17 =(String)request.getSession().getAttribute("fig17");
				String fig18 =(String)request.getSession().getAttribute("fig18");
				String fig19 =(String)request.getSession().getAttribute("fig19");
				String fig20 =(String)request.getSession().getAttribute("fig20");
				
				String fig21 =(String)request.getSession().getAttribute("fig21");
				String fig22 =(String)request.getSession().getAttribute("fig22");
				String fig23 =(String)request.getSession().getAttribute("fig23");
				String fig24 =(String)request.getSession().getAttribute("fig24");
				String fig25 =(String)request.getSession().getAttribute("fig25");
				String fig26 =(String)request.getSession().getAttribute("fig26");
				String fig27 =(String)request.getSession().getAttribute("fig27");
				String fig28 =(String)request.getSession().getAttribute("fig28");
				String fig29 =(String)request.getSession().getAttribute("fig29");
				String fig30 =(String)request.getSession().getAttribute("fig30");
				
				String fig31 =(String)request.getSession().getAttribute("fig31");
				String fig32 =(String)request.getSession().getAttribute("fig32");
				String fig33 =(String)request.getSession().getAttribute("fig33");
				String fig34 =(String)request.getSession().getAttribute("fig34");
				String fig35 =(String)request.getSession().getAttribute("fig35");
				String fig36 =(String)request.getSession().getAttribute("fig36");
				String fig37 =(String)request.getSession().getAttribute("fig37");
				String fig38 =(String)request.getSession().getAttribute("fig38");
				String fig39 =(String)request.getSession().getAttribute("fig39");
				String fig40 =(String)request.getSession().getAttribute("fig40");
				
				String fig41 =(String)request.getSession().getAttribute("fig41");
				String fig42 =(String)request.getSession().getAttribute("fig42");
				String fig43 =(String)request.getSession().getAttribute("fig43");
				String fig44 =(String)request.getSession().getAttribute("fig44");
				String fig45 =(String)request.getSession().getAttribute("fig45");
				String fig46 =(String)request.getSession().getAttribute("fig46");
				String fig47 =(String)request.getSession().getAttribute("fig47");
				String fig48 =(String)request.getSession().getAttribute("fig48");
				String fig49 =(String)request.getSession().getAttribute("fig49");
				String fig50 =(String)request.getSession().getAttribute("fig50");
				
				String fig51 =(String)request.getSession().getAttribute("fig51");
				String fig52 =(String)request.getSession().getAttribute("fig52");
				String fig53 =(String)request.getSession().getAttribute("fig53");
				String fig54 =(String)request.getSession().getAttribute("fig54");
				String fig55 =(String)request.getSession().getAttribute("fig55");
				String fig56 =(String)request.getSession().getAttribute("fig56");
				String fig57 =(String)request.getSession().getAttribute("fig57");
				String fig58 =(String)request.getSession().getAttribute("fig58");
				String fig59 =(String)request.getSession().getAttribute("fig59");
				String fig60 =(String)request.getSession().getAttribute("fig60");
				
				String fig61 =(String)request.getSession().getAttribute("fig61");
				String fig62 =(String)request.getSession().getAttribute("fig62");
				String fig63 =(String)request.getSession().getAttribute("fig63");
				String fig64 =(String)request.getSession().getAttribute("fig64");
				String fig65 =(String)request.getSession().getAttribute("fig65");
				String fig66 =(String)request.getSession().getAttribute("fig66");
				String fig67 =(String)request.getSession().getAttribute("fig67");
				String fig68 =(String)request.getSession().getAttribute("fig68");
				String fig69 =(String)request.getSession().getAttribute("fig69");
				String fig70 =(String)request.getSession().getAttribute("fig70");
				
				String fig71 =(String)request.getSession().getAttribute("fig71");
				String fig72 =(String)request.getSession().getAttribute("fig72");
				
				
				
				
				if(b==2){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig1);%></a><%
				}
				if(b==4){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig2);%></a><%
				}
				if(b==6){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig3);%></a><%
				}
				if(b==8){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig4);%></a><%
				}
				if(b==10){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig5);%></a><%
				}
				if(b==12){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig6);%></a><%
				}
				if(b==13){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig7);%></a><%
				}
				if(b==15){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig8);%></a><%
				}
				if(b==17){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig9);%></a><%
				}
				if(b==19){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig10);%></a><%
				}
				if(b==21){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig11);%></a><%
				}
				if(b==23){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig12);%></a><%
				}
				if(b==26){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig13);%></a><%
				}
				if(b==28){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig14);%></a><%
				}
				if(b==30){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig15);%></a><%
				}
				if(b==32){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig16);%></a><%
				}
				if(b==34){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig17);%></a><%
				}
				if(b==36){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig18);%></a><%
				}
				if(b==37){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig19);%></a><%
				}
				if(b==39){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig20);%></a><%
				}
				if(b==41){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig21);%></a><%
				}
				if(b==43){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig22);%></a><%
				}
				if(b==45){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig23);%></a><%
				}
				if(b==47){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig24);%></a><%
				}
				if(b==50){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig25);%></a><%
				}
				if(b==52){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig26);%></a><%
				}
				if(b==54){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig27);%></a><%
				}
				if(b==56){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig28);%></a><%
				}
				if(b==58){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig29);%></a><%
				}
				if(b==60){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig30);%></a><%
				}
				if(b==61){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig31);%></a><%
				}
				if(b==63){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig32);%></a><%
				}
				if(b==65){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig33);%></a><%
				}
				if(b==67){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig34);%></a><%
				}
				if(b==69){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig35);%></a><%
				}
				if(b==71){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig36);%></a><%
				}
				if(b==74){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig37);%></a><%
				}
				if(b==76){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig38);%></a><%
				}
				if(b==78){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig39);%></a><%
				}
				if(b==80){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig40);%></a><%
				}
				if(b==82){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig41);%></a><%
				}
				if(b==84){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig42);%></a><%
				}
				if(b==85){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig43);%></a><%
				}
				if(b==87){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig44);%></a><%
				}
				if(b==89){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig45);%></a><%
				}
				if(b==91){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig46);%></a><%
				}
				if(b==93){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig47);%></a><%
				}
				if(b==95){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig48);%></a><%
				}
				if(b==98){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig49);%></a><%
				}
				if(b==100){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig50);%></a><%
				}
				if(b==102){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig51);%></a><%
				}
				if(b==104){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig52);%></a><%
				}
				if(b==106){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig53);%></a><%
				}
				if(b==108){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig54);%></a><%
				}
				if(b==109){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig55);%></a><%
				}
				if(b==111){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig56);%></a><%
				}
				if(b==113){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig57);%></a><%
				}
				if(b==115){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig58);%></a><%
				}
				if(b==117){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig59);%></a><%
				}
				if(b==119){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig60);%></a><%
				}
				if(b==122){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig61);%></a><%
				}
				if(b==124){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig62);%></a><%
				}
				if(b==126){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig63);%></a><%
				}
				if(b==128){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig64);%></a><%
				}
				if(b==130){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig65);%></a><%
				}
				if(b==132){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig66);%></a><%
				}
				if(b==133){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig67);%></a><%
				}
				if(b==135){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig68);%></a><%
				}
				if(b==137){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig69);%></a><%
				}
				if(b==139){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig70);%></a><%
				}
				if(b==141){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig71);%></a><%
				}
				if(b==143){
					out.print(link);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%out.print(fig72);%></a><%
				}
				%>
				</td>
				<% 
			}
			%>
			</tr>
			<%
		}
		%>
		</table></center>

<script>
function myFunction(x){
	var m=x;
	window.location.replace('Laufen?m='+m);
	}
</script>

<br><br>
<center><div id="log"><textarea readonly disabled id="logging" rows="1" cols="1">
<% ArrayList<String> ausgabe=(ArrayList<String>)request.getSession().getAttribute("ausgabe");
out.print(ausgabe);%>

</textarea></div></center>
<br><br>

</body>
</html>
