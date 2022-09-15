<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="multipart/form-data; charset=UTF-8">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
function loadDoc() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     document.getElementById("demo").innerHTML = this.responseText;
	    }
	  };
	  var name = document.getElementById("name").value;
	  
	 
	  xhttp.open("POST", "/vals", true);
	  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	  xhttp.send("name=" + name);
	  //xhttp.send();
	}
</script>
</head>
<title>Spring Boot App that behaves like a stateless app</title>
</head>
<body>

<input type="text" id="name" name="name"/>
<input id="send" type="submit" onclick="loadDoc()"/>
 
 Values in the session
 <div id="demo">
 <c:if test="${sessionvalues != null}">
 <ol>
 <c:forEach var="val" items="${sessionvalues}">
 <li> ${val} </li>
 </c:forEach>
 </ol>
 </c:if>
</div>

</body>
</html>