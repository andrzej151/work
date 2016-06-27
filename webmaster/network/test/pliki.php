                  
<?


  $i=0;                
while ( $i<100) {


// Konfiguracja

// Nazwa pliku zawierającego licznik - względna do katalogu, w którym
// jest strona na której ma być licznik

$df  = "test.txt";

// Próba otwarcia pliku do odczytu

if(!($fp=@fopen($df, "r"))){

// Jeśli plik jeszcze nie istnieje, to jest inicjowany wartością 0
   
   $count=0;
}
else { // jeśli istnieje, to jego wartość jest odczytywana a plik zamykany
   $count = fgets($fp, 100);
   fclose($fp);
}

// Zwiększenie licznika o 1

$count+=1;

// Otwarcie pliku do zapisu

$fp = fopen($df, "w");

// Blokada - jeśli plik już jest zablokowany, to skrypt go zamyka i kończy
// działanie

if(!flock($fp, LOCK_EX)){
   fclose($fp);
   return;
} else { // Jeśli nie jest zablokowany, to następuje blokada i zapis danych
   fputs($fp, $count);
   flock($fp, LOCK_UN);
   fclose($fp);
}

// Wyświetlenie stanu licznika

echo $count."</br>";
$i=$i+1;
}

?>


