<?php

	session_start();
	
	if (!isset($_SESSION['zalogowany']))
	{
		header('Location: index.php');
		exit();
	}
	
?>
<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Empaier </title>

	 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/simple-sidebar.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div class="container">
		<div class="col-lg-12">
			<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
				<a class="navbar-brand" href="panel.php">Empier</a>
				<a href="projekty.php"><button type="button" class="btn btn-primary navbar-btn ">PROJEKTY</button></a>
				<a href="projekty_stworz.php"><button type="button" class="btn btn-success navbar-btn active">STWORZ PROJEKT</button></a>
				<a href="transakcje.php"><button type="button" class="btn btn-primary navbar-btn">TRANSAKCJE</button></a>
				<a href="panel.php"><button type="button" class="btn btn-primary navbar-btn">MOJ PANEL</button></a>
				<a href="baza_wiedzy.php"><button type="button" class="btn btn-primary navbar-btn">BAZA WIEDZY</button></a>
				<a href="logout.php"><button type="button" class="btn btn-danger  navbar-btn">WYLOGUJ SIĘ</button></a>

			</nav>	

			<form action="przetworz_projekt.php" method="POST" role="form">
				
				<label for="nazwa">Nazwa</label><input type="text" id="nazwa" name="nazwa" class="form-control input-lg">
				
				<label for="krotkiopis">Krótki Opis</label><input type="text" id="krotkiopis" name="krotkiopis" class="form-control input-lg">
				
				<label for="area">Pełny opis projektu</label>
				<textarea name="pelnyopis" class="form-control">Opisz projekt!</textarea>
				<label for="area">Benefity</label>
				<textarea name="benefity" class="form-control">Opisz co mogę zyskać!</textarea>

				<button type="submit" class="btn btn-primary">Wyślij!</button>
			</form>
		</div>
<div> <!-- cointeiner -->
 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>