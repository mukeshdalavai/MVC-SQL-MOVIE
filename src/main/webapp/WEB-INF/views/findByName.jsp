<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
<style type="text/css">
div{
	box-shadow: 4px 4px 10px 10px rgba(0,0,0,0.2);
	background-image: linear-gradient(to right, #3f3789 , #C0B9FA);
	font-family: 'Maiden Orange', cursive;
	font-size: 60px;
	margin:0px 30% 40px 30%;
	color: #eff4f4;
	text-align: center;
}
div:hover{
font-weight: bolder;
}
input[type=text], select,input[type=submit] {
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
ul{

	padding: 0px;
	position: absolute;
	margin: 0px;
}
ul li{
    box-shadow: 0px 0px 4px 4px rgba(0,0,0,0.1);
	background-color: #f8ebd8;
	border-style: solid;
    border-color: #7264B7;
    padding: 25px 20px 25px 20px;
	font-style: italic;
    list-style: none;
	list-style: inline;
    float: left;
    padding-right: 30px;
    color: #7264B7;
    font-size: 20px;
    }
ul li:hover{
    font-style: italic;
    background-color: #7264B7;
    color: #eff4f4;
    font-weight: bolder;
    }
.findMovie{
    padding:5px 0px;
    border-style:solid;
    border-radius: 20px;
    border-color: #7264B7;
    font-family: sans-serif;
    font-size: 25px;
    font-style: italic;
    color: #7264B7;
    width: 17%;
    text-align: center;
}
.findMovie:hover{
background-color: #7264B7;
color: #eff4f4;
}
.modifiedNotes{
	padding-top: 100px;
	font-size: 40px;
}
label{
	font-family: sans-serif;
	padding-left: 5px;
}
.MovieList{
margin-top: 100px;
}
body{
    background-color: #f8ebd8;
 	width: 100%;
	margin: 0px;


</style>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send
		 button. Handle errors like empty fields -->
	<div>Movies</div>
	<p class="findMovie">Find Movie by Name</p>
        <form class="delform" name="MovieFind" action="findMovieByName" method="get">
        		<ul>
        	    <li>Movie Name: <input type="text" name="name" /></li>
        		<li><input type="submit" value="Go"/></li></ul>
        	</form><br>

	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->

	<div class="MovieList">Movie List</div>

	<ul class="ulNew">
	<c:forEach var="movie" items="${movies}">
			<li>
				<label>Movie Id: <label>
				<label>${movie.getId()}</label>
			</li>
			<li>
				<label>Title: </label>
				<label>${movie.getName()}</label>
			</li>
			<li>
				<label>Genre: </label>
				<label>${movie.getGenre()}</label>
			</li>
			<li>
				<label>Language: </label>
				<label>${movie.getLanguage()}</label>
			</li>
			</c:forEach>
	</ul>

</body>
</html>