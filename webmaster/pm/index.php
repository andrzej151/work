<!doctype html>
<html>
<?php
 
/*Załączenie pliku odpowiadającego za połączenie z bazą danych.*/
//require_once('error.php');
require_once('baza.php');
 
?>
 
<head>
<meta charset="utf-8">
<title>Ajax, PHP, Mysql</title>
 
<script src="js/jquery.js"></script>
<script src="js/skrypt.js"></script>
<link rel="stylesheet" href="css/styl.css" />
 
</head>
 
<body>
 
<br/>
     
    <!--Uproszczony formularz z listą rozwijaną i przyciskami-->
    <form>
        <select id="lista">
          <option value="Polska">Polska</option>
          <option value="Węgry">Węgry</option>
          <option value="Czechy">Czechy</option>
          <option value="Austria">Austria</option>
        </select> 
        <br/>
        <br/>
        <button id="wyslij" type="button">Wyślij</button> 
        <br/>
        <br/>
        <button id="pobierz" type="button">Pobierz wykaz</button> 
    </form>
     
    <br/>
    <br/>
     
    <!--Blok przeznaczony na przechowanie informacji pobieranych z bazy-->
    <div id="wykaz">
    </div>
 
</body>
</html>