<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="stylesheets/root.css">
<link href="https://fonts.googleapis.com/css?family=Julius+Sans+One" rel="stylesheet">
<title>Jeopardy</title>
</head>
<body>
Thank you for playing <img id="jeoGif" src="images/jeopardy.gif"> ${Firstname}!!!! <br> <br>
${result} <br> <br>
Your points: ${score} <br> <br>

<form action="Restart">
<input type="submit" value="Play Again?">
</form>
</body>
</html>