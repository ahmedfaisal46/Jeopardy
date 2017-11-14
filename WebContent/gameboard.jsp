<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheets/gameboard.css">
<link href="https://fonts.googleapis.com/css?family=Julius+Sans+One" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<h2> Hi ${Firstname}, Let's Play Jeopardy! </h2>
	
	<div id="earnings"> Earnings: $ ${score}  </div> 
	
	
	<table style="width:100%;">
		<tr>
			<th>Video Games</th>
			<th>Roller Coasters</th>
			<th>Cell Phones</th>
			<th>Movies</th>
			<th>Computers</th>
		</tr>
		<tr>
			<form action="PickQuestion" method="GET">
			<a href="PickQuestion" style="text-decoration:none;">
			<td> <input type="submit" name="videoGames" value="100" ${videoGames100}></td>
			<td><input type="submit" name="rollerCoasters" value="100" ${rollerCoasters100}></td>
			<td><input type="submit" name="cellPhones" value="100" ${cellPhones100}></td>
			<td><input type="submit" name="movies" value="100" ${movies100}></td>
			<td><input type="submit" name="computers" value="100" ${computers100}></td>
		</tr>
		<tr>
			<td> <input type="submit" name="videoGames" value="200" ${videoGames200} ></td>
			<td><input type="submit" name="rollerCoasters" value="200" ${rollerCoasters200}></td>
			<td><input type="submit" name="cellPhones" value="200" ${cellPhones200}></td>
			<td><input type="submit" name="movies" value="200" ${movies200}></td>
			<td><input type="submit" name="computers" value="200" ${computers200}></td>
		</tr >
		<tr >
			<td> <input type="submit" name="videoGames" value="300" ${videoGames300}></td>
			<td><input type="submit" name="rollerCoasters" value="300" ${rollerCoasters300}></td>
			<td><input type="submit" name="cellPhones" value="300" ${cellPhones300}></td>
			<td><input type="submit" name="movies" value="300" ${movies300}></td>
			<td><input type="submit" name="computers" value="300" ${computers300}></td>
		</tr>
		<tr >
			<td> <input type="submit" name="videoGames" value="400" ${videoGames400}></td>
			<td><input type="submit" name="rollerCoasters" value="400" ${rollerCoasters400}></td>
			<td><input type="submit" name="cellPhones" value="400" ${cellPhones400}></td>
			<td><input type="submit" name="movies" value="400" ${movies400}></td>
			<td><input type="submit" name="computers" value="400" ${computers400}></td>
		</tr>
		<tr>
			<td> <input type="submit" name="videoGames" value="500" ${videoGames500}></td>
			<td><input type="submit" name="rollerCoasters" value="500" ${rollerCoasters500}></td>
			<td><input type="submit" name="cellPhones" value="500" ${cellPhones500}></td>
			<td><input type="submit" name="movies" value="500"  ${movies500}></td>
			<td><input type="submit" name="computers" value="500" ${computers500} ></td>
		</tr>
		</form>
	</table>
	 

</body>
</html>