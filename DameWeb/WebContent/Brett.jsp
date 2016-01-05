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
<input id="refresh" type = "submit" value = "Lauf Ki" name="laufKi">
</form>
<br>
		
<form action="ZugBeenden" method="post">
<input id="refresh" type = "submit" value = "Zug Beenden" name="zugBeenden">
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
				<td onclick="myFunction(this)" width="35px" height="40px">
				
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
	alert("cell index is: " +  x.cellIndex);
	var b=x.cellIndex;
	request.getSession().setAttribute("b", b);
	}
</script>

<br><br>
<center><div id="log"><textarea readonly disabled id="logging" rows="1" cols="1">
</textarea></div></center>
<br><br>

</body>
</html>
