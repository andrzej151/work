<?php
 
/*Załączenie pliku odpowiadającego za połączenie z bazą danych.*/
require_once('baza.php');
 
/*Zapytanie usuwające rekordy z bazy wówczas, gdy od ich utworzenia upłynęło 5 minut. 
W tym wypadku czas utworzenia rekordów porównywany jest z aktualnym czasem, 
tj. z momentem wykonania zapytania*/
$zapytanie_delete = "DELETE FROM kraje WHERE czas < (NOW() - INTERVAL 1 MINUTE)";
 
/*Wykonanie zapytania usuwającego dane*/
$wynik = mysqli_query($db, $zapytanie_delete);
 
?>