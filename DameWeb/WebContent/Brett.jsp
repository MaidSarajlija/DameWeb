<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<li><a href="/daten/SpeichernSER.jsp">SER</a></li>
<li><a href="/daten/SpeichernCSV.jsp">CSV</a></li>
<li><a href="/daten/SpeichernPDF.jsp">PDF</a></li>
<li><a href="/daten/SpeichernXML.jsp">XML</a></li>
<li><a href="/daten/ViewPDF">View PDF</a></li>
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
out.print(g);
System.out.println(g);
System.out.println("hJHVGHFUD");%>
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
				String l =(String)request.getSession().getAttribute("link");
				String u =(String)request.getSession().getAttribute("fig");
				
				if(b==2||b==4 ||b==6||b==8 ||b==10 ||b==12){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println("hi");%></a><% 
				}
				if(b==13||b==15||b==17||b==19||b==21||b==23){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
				}
				if(b==26||b==28||b==30||b==32||b==34||b==36){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
				}
				if(b==37||b==39||b==41||b==43||b==45||b==47){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
				}
				if(b==50||b==52||b==54||b==56||b==58||b==60){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
				}
				if(b==61||b==63||b==65||b==67||b==69||b==71){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
				}
				if(b==74||b==76||b==78||b==80||b==82||b==84){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
				}
				if(b==85||b==87||b==89||b==91||b==93||b==95){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
				}
				if(b==98||b==100||b==102||b==104||b==106||b==108){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
				}
				if(b==109||b==111||b==113||b==115||b==117||b==119){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
				}
				if(b==122||b==124||b==126||b==128||b==130||b==132){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
				}
				if(b==133||b==135||b==137||b==139||b==141||b==143){
					out.print(l);%><a onclick="myFunction(<%out.print(b); %>)" href='javascript:;'><%System.out.println(u);%></a><% 
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

</textarea></div></center>
<br><br>

</body>
</html>
