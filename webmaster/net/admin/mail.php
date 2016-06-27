<?php

$od  = "From: uzytkownik@kursphp.com \r\n";
$od .= 'MIME-Version: 1.0'."\r\n";
$od .= 'Content-type: text/html; charset=iso-8859-2'."\r\n";
$adres = "andrzej.dabrowski94@gmail.com";
$tytul = "Tytuł wiadomości";
$wiadomosc = "<html>
<head>
<link rel='stylesheet' type='text/css' href='list.css'>
</head>
<body>
   <b>Witam serdecznie!</b><br/>
   Zapraszam na stronę: <a href='http://kursphp.com'>Kurs PHP</a>   
   <div class='kontakt'>
   małgoska tam i ti </br>
   fnejnffen
   </div>
</body>
</html>";

// użycie funkcji mail
mail($adres, $tytul, $wiadomosc, $od);

?>