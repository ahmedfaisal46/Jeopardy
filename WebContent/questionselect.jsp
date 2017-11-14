<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="stylesheets/question.css">
<link href="https://fonts.googleapis.com/css?family=Julius+Sans+One"
	rel="stylesheet">
	
	<style type="text/css">
		#regularQuestion {
			display: ${displayRegular};
		}
		#dailyDouble {
			display: ${displayDaily};
		}
	</style>

<title>Jeopardy</title>
</head>
<body>
	<div id="regularQuestion">
	
		<form id="myForm" action="Answer">
			<div style="text-align: center;">${question}</div>
			<br>
			<table style="width: 40%;margin-left: auto;margin-right: auto;font-size: 25px;">
				<tr>
					<td><input type="radio" id="answer1" name="answer"
						value=${answer1} required> ${answer1}</td>
					<td><input type="radio" id="answer2" name="answer"
						value=${answer2} required> ${answer2}</td>
				</tr>
				<td><input type="radio" id="answer3" name="answer"
					value=${answer3} required> ${answer3}</td>
				<td><input type="radio" id="answer4 " name="answer"
					value=${answer4} required> ${answer4}</td>
				<input type="text" id="correctAnswer" name="correctAnswer"
					style="display: none;" value=${correctAnswer} >
				<input type="text" name="value" style="display: none;" value=${value} >
			</table>
			<br> <div style="font-size:20px; color: red;" > ${err} </div> <br><input type="submit" id="submit" value="Submit Answer"> <br>
	
			Skip this question with no penalty by clicking<a href=${skiplink}>
				Here </a>
		</form>
		
	</div>


	<div id="dailyDouble">
		<h1>**Daily Double**</h1>
		<form id="myForm" action="Answer">
			<div style="text-align: center;">${question}</div>
			<input type="number" name="value" placeholder="Enter a value to bet">
			 <div style="font-size:20px; color: red;" >  
			 ${inputError} 
			 </div>
			 <br>
			
			<table style="width: 40%;margin-left: auto;margin-right: auto;font-size: 25px;">
				<tr>
					<td><input type="radio" id="answer1" name="answer"
						value=${answer1} required> ${answer1}</td>
					<td><input type="radio" id="answer2" name="answer"
						value=${answer2} required> ${answer2}</td>
				</tr>
				<td><input type="radio" id="answer3" name="answer"
					value=${answer3} required> ${answer3}</td>
				<td><input type="radio" id="answer4 " name="answer"
					value=${answer4} required> ${answer4}</td>
				<input type="text" id="correctAnswer" name="correctAnswer"
					style="display: none;" value=${correctAnswer} >
			</table>
			 <div style="font-size:20px; color: red;" > ${err} </div> <br><input type="submit" id="submit" value="Submit Answer"> <br>
	
			Skip this question with no penalty by clicking<a href=${skiplink}>
				Here </a>
				
			<input type="hidden" name="variables"
				value="${question},${answer1},${answer2},${answer3},${answer4},${correctAnswer}"
			>
		</form>
		
	</div>		
</body>
</html>