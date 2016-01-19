<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<script type="text/javascript">


function validateForm() {
    var x = document.forms["myForm"]["name"].value;
    if (x == null || x == "") {
        alert("Bitte Namen eingeben !");
        return false;
    }
}

</script>

</head>
<body>
<br>
 <h1>Spieler 1 Daten eingeben</h1>

 <form name="myForm" action="Login" method="post" onsubmit="return validateForm()" >

   <div id="form">
   
  <label id="labels1">Bitte gib deinen Namen ein:</label> 
  <input id="name" name="name" type="text">
  
   <br>
   <br>

<label id="labels1">Wähle deine Farbe aus:</label> 
<select id ="farbe" name="farbeSpieler">
	<option value="Weiss">Weiss</option>
	<option value="Schwarz">Schwarz</option>
</select>
   <br>
   <br>
   
 <label id="labels1">Wähle deinen Typ aus:</label> 
<select id ="spielerart" name ="spielerart1">
	<option value="Mensch">Mensch</option>
	<option value="KI">KI</option>
</select>
   <br>
   <br>
   
 <label id="labels1">Wähle deinen Gegner aus:</label> 
<select id ="spielerart" name ="spielerart2">
	<option value="KI">KI</option>
	<option value="Mensch">Mensch</option>
	
</select>
   <br>
   <br>
   
   <br>



<input id="spielerAnlegen" name="spielerAnlegen" type="submit" value="Spieler anlegen" >


  
   </div>
    </form>

</body>
</html>