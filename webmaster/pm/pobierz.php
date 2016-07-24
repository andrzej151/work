<?php
 
/*Nagłówek pliku informujacy o tym, że dane będą przekazywane w formacie JSON (JavaScript Object Notation) 
- jest to format transferu danych, w praktyce wyglądać będzie on finalnie w następujacy sposób: 
[["66","Austria"],["65","Polska"],["64","Czechy"]]
*/
header('Content-type: application/json');
 
/*Załączenie pliku odpowiadającego za połączenie z bazą danych.*/
require_once('baza.php');
 
/*Zapytanie typu SELECT - należy je czytać w następujacy sposób: 
pobierz z tabeli o nazwie kraje kolumny: id i nazwa kraju*/
$zapytanie_pobierz = "SELECT id, nazwa_kraju FROM kraje";
/*Wykonanie zapytania SELECT*/
$wynik_pobierz = mysqli_query($db, $zapytanie_pobierz);
/*Przygotowanie tablicy, która będzie przechowywać dane z bazy*/
$pobrane_dane = array();
 
/*Pętla typu "while" oparta o funkcję mysqli_fetch_row, 
wykonująca się na wyniku zapytania w celu zorganizowania pobranych danych w tabelę */
while ($wiersz = mysqli_fetch_row($wynik_pobierz)) 
{
  $pobrane_dane[] = $wiersz;
}
 
/*Wywołanie tabeli danych jako danych w formacie JSON. 
W istocie działania podjęte w tym pliku tworzą pakiet danych JSON, 
który będzie możliwy do zinterpretowania w pliku skrypt.js*/
echo json_encode($pobrane_dane);
 
?>