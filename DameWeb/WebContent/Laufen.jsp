<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Laufen</title>
</head>
<body>

<%
   // New location to be redirected
   String site = new String("/DameLokalWeb/Laufen");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site);
   
%>

<script>
function myFunction(x){
	alert("cell index is: " +  x);
}
</script>


</body>
</html>