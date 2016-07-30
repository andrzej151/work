/*Ustawienie wykonania działań wówczas, gdy strona jest całkowicie wczytana */
$(document).ready(function(){
     
    /*WYSYŁANIE DANYCH DO BAZY*/
    $('#wyslij').click(function() { /*Zdefiniowanie zdarzenia inicjującego 
    - kliknięcie przycisku wyślij*/
     
        /*Funkcja pobierająca wartość opcji z listy, w tym przypadku nazwa kraju, 
        która następnie zapisywana jest do zmiennej*/
        var wartosc_z_listy = $('#lista').val();
         
        $.ajax({
            type:"POST", /*Informacja o tym, że dane będą wysyłane*/
            url:"wyslij.php", /*Informacja, o tym jaki plik będzie przy tym wykorzystywany*/
            data: {klucz_ajax:wartosc_z_listy}, /*Zdefiniowanie jakie dane będą wysyłane na zasadzie 
            pary klucz-wartość np: wartosc_z_listy_ajax=Polska*/
                 
                /*Działania wykonywane w przypadku sukcesu*/
                success:function() {
 
                    /*Zdefiniowanie tzw. alertu (prostej informacji) w sytacji sukcesu wysyłania. 
                    Za pomocą alertów możemy diagnozować poprawne działania funkcji. 
                    Jest to bardzo przydatne w sytacji problemów z dziłaniem programu.*/
                    alert("Wysłano do bazy danych"); 
                     
                    /*Dezaktywacja na określony czas przycisku wysyłającego - ten krok można pomninąć*/
                    $("#wyslij").attr("disabled", true);
                    setTimeout(function(){
                        $("#wyslij").attr("disabled", false); 
                    }, 10000);  
             
                },
 
                /*Działania wykonywane w przypadku błędu*/
                error: function(blad) {
                    alert( "Wystąpił błąd");
                    console.log(blad); /*Funkcja wyświetlająca informacje 
                    o ewentualnym błędzie w konsoli przeglądarki*/
                }
        });
 
    });
 
    /*POBRANIE DANYCH Z BAZY*/
    $('#pobierz').click(function() { /*Zdefiniowanie zdarzenia inicjującego 
    - kliknięcie przycisku pobierz*/
     
        $.ajax({
            type:"GET", /*Informacja o tym, że dane będą pobierane*/
            url:"pobierz.php", /*Informacja, o tym jaki plik będzie przy tym wykorzystywany*/
            contentType:"application/json; charset=utf-8", /*Informacja o formacie transferu danych*/
            dataType:'json', /*Informacja o formacie transferu danych*/
             
                /*Działania wykonywane w przypadku sukcesu*/
                success: function(json) { /*Funkcja zawiera parametr*/
                     
                    /*Pętla typu for...in języka Javascript na danych w formacie JSON*/
                    for (var klucz in json)
                        {
                            var wiersz = json[klucz];  /*Kolejne przebiegi pętli wstawiają nowy klucz*/     
                            var id = wiersz[0];
                            var nazwakraju = wiersz[1];
                             
                            /*Ustalenie sposobu wyświetlania pobranych danych w bloku div*/
                            $("<span>id: "+id+" nazwa: "+nazwakraju+"</span>")
                            .appendTo('#wykaz')
                            .append("<hr>")
                        } 
                     
                     
                    /*Dezaktywacja na określony czas przycisku wysyłającego - ten krok można pomninąć*/
                    $("#pobierz").attr("disabled", true);
                    setTimeout(function(){
                        $("#pobierz").attr("disabled", false); 
                    }, 10000);  
                 
                },
                 
                 
                /*Działania wykonywane w przypadku błędu*/
                error: function(blad) {
                    alert( "Wystąpił błąd");
                    console.log(blad); /*Funkcja wyświetlająca informacje 
                    o ewentualnym błędzie w konsoli przeglądarki*/
                }
             
        });
     
    });
 
 
    /*USUWANIE DANYCH Z BAZY*/
 
    $('#wyslij, #pobierz').click(function() { /*Zdefiniowanie zdarzenia inicjującego 
    - kliknięcie przycisku pobierz lub wyślij*/
         
        $.ajax({
            type:"POST", /*Informacja o tym, że dane będą wysyłane*/
            url:"usun.php", /*Informacja, o tym jaki plik będzie przy tym wykorzystywany*/
 
                /*Działania wykonywane w przypadku sukcesu*/
                success : function() {
                /*Tu można przykładowo wstawić: alert( "Usuwam"), aby uzyskać potwierdzenie;*/
                },
                 
                 
                /*Działania wykonywane w przypadku błędu*/ 
                error: function(blad) {
                    alert( "Wystąpił błąd");
                    console.log(blad); /*Funkcja wyświetlająca informacje o ewentualnym błędzie 
                    w konsoli przeglądarki*/
                }
        });
 
    });
 
 
 
     
}); /*Klamra zamykająca $(document).ready(function(){*/
