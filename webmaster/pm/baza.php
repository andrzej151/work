<?php
 
/*Definiowanie zmiennych z danymi niezbędnymi do połączenia z bazą danych*/
$serwer = 'mysql.cba.pl';
$uzytkownik = 'andrzej151';
$haslo = 'Andrzej151';
$nazwa_bazy = 'and_t_cba_pl';
  
/*Połączenie z bazą*/
$db = mysqli_connect($serwer, $uzytkownik, $haslo, $nazwa_bazy);
 
/*Komunikat o błędzie w przypadku problemów z połączeniem*/
if (mysqli_connect_errno()) 
{
    echo 'Błąd';
    exit;   
}
else {
}
 
?>