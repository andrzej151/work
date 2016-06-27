
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title></title>
</head>

<body>

	<?php
		if(isset($_GET['error'])){
			echo "<pre>";
			switch ($_GET['error']) {
				case '0':
					echo "Prosze wypełnić wszystkie wymagane pola.";
					break;
				case '1':
					echo "Hasła nie są takie same";
					break;
				case '2':
					echo "Istnieje już taki użytkownik";
					break;
				case '3':
					echo "Nie istnieje taki klucz";
					break;
				case '4':
					echo "cos";
					break;
				
				default:
					echo "Nieznany błąd. Spróbuj ponownie.";
					break;
			}
			echo "</pre>";
		}

		if(isset($_GET['succes'])){
			echo "<h3>";
			switch ($_GET['succes']) {
				case '0':
					echo "Pomyślnie zarejestrowano konto. Prosze sprawdzić pocztę";
					break;
				case '1':
					echo "Aktywowano";
					break;
				case '2':
					echo "Aktywowano2";
					break;
				case '3':
					echo "Aktywowano3";
					break;
				case '4':
					echo "zalogowano";
					break;
				
				default:
					echo "Nieznany błąd. Spróbuj ponownie.";
					break;
			}
			echo "</h3>";
		}

	?>
	<h3>Zaloguj się</h3>
	<form action=login.php method="POSST">
		
		<input type="text" name="login" placeholder="E-mail/Login"/>
		<input type="password" name="pass" placeholder="Haslo"/>
		<input type="submit" value="Zaloguj się" name="log-in"/>
	</form>

	<h3>Zarejestruj się</h3>
	<form action=login.php method="POST">
		<input type="text" name="login" placeholder="login"/>
		<input type="text" name="e-mail" placeholder="e-mail"/>
		<input type="password" name="pass" placeholder="Haslo"/>
		<input type="password" name="pass2" placeholder="Powtórz Haslo"/>
		<input type="submit" value="Zarejestruj się" name="register"/>
	</form>
</body>
</html>