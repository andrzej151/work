<?php
 
/*Załączenie pliku odpowiadającego za połączenie z bazą danych.*/
require_once('baza.php');
 
 
/*Definicja funkcji filtrującej wywoływana na zmiennej przed jej przesłaniem do bazy. 
Utworzona ze względów bezpieczeństwa.*/
 
function filtrowanie($zmienna) 
{
  $zmienna = substr($zmienna, 0, 9); // Ograniczenie ciągu do pierwszych 10 znaków
  $zmienna = trim($zmienna);
  $zmienna = stripslashes($zmienna);
  $zmienna = htmlspecialchars($zmienna); 
  return $zmienna; 
}
 
/*Przypisanie danych wysłanych przez skrypt.js do zmiennej*/
$wartosc_z_listy_post=$_POST['klucz_ajax'];
 
/*Przypisanie wyniku funkcji filtrowanie do zmiennej*/
$wartosc_z_listy_post_filtr=filtrowanie($wartosc_z_listy_post);
 
/*Zapytanie wprowadzające do kolumny nazwa_kraju, w tabeli kraje, 
wartości ze zmiennej $wartosc_z_listy_post_filtr*/
$zapytanie_wyslij = "INSERT INTO kraje (nazwa_kraju) VALUES ('$wartosc_z_listy_post_filtr')";
 
/*Wykonanie zapytania wysyłającego*/
$wynik_wyslij = mysqli_query($db, $zapytanie_wyslij);
?>