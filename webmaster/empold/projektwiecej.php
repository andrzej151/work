<?php

	session_start();
	
	if (!isset($_SESSION['zalogowany']))
	{
		header('Location: index.php');
		exit();
	}

	require_once "connect.php";
	mysqli_report(MYSQLI_REPORT_STRICT);
		
		try 
		{

			$polaczenie = new mysqli($host, $db_user, $db_password, $db_name);

			if ($polaczenie->connect_errno!=0)
			{
				throw new Exception(mysqli_connect_errno());
			}
			else
			{

				$polaczenie->set_charset("utf8");
				$idprojektu=$_GET['projekt'];
				$urzytkownik=$_SESSION['ID'];

				$lista = $polaczenie->query("SELECT * FROM `Eprojekty`  WHERE id='$idprojektu'" ); 
				$dane = $lista->fetch_assoc();
				$lider = $dane['idlider'];
				$lista = $polaczenie->query("SELECT imie,nazwisko,email FROM `Euser`  WHERE id='$lider'" ); 
				$dlider = $lista->fetch_assoc();
					
					
			}
				
				
		}
			
		
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności!</span>';
			echo '<br />Informacja developerska: '.$e;
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
    <style >
    	.center-block
    	{
    		float: none;
    		text-align: center;
    	}
    </style>
</head>

<body ng-app='myApp'>
<div class="container">
		<div class="col-lg-12">
			<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
				<a class="navbar-brand" href="panel.php">Empier</a>
				<a href="projekty.php"><button type="button" class="btn btn-primary navbar-btn active">PROJEKTY</button></a>
				<a href="projekty_stworz.php"><button type="button" class="btn btn-success navbar-btn ">STWORZ PROJEKT</button></a>
				<a href="transakcje.php"><button type="button" class="btn btn-primary navbar-btn">TRANSAKCJE</button></a>
				<a href="panel.php"><button type="button" class="btn btn-primary navbar-btn">MOJ PANEL</button></a>
				<a href="baza_wiedzy.php"><button type="button" class="btn btn-primary navbar-btn">BAZA WIEDZY</button></a>
				<a href="logout.php"><button type="button" class="btn btn-danger  navbar-btn">WYLOGUJ SIĘ</button></a>
				
			</nav>	

</br>

		<div class="col-lg-12 center-block" ng-controller='ProjCon'>

			
				
			
				<div class="list-group-item center-block" ng-repeat="projekt in projekty| filter : wyszukiarka">
					<h2> <?php echo $dane['nazwa'];?> 
					<small><?php echo $dane['status'];?> PUNKTY <?php echo $dane['punkty'];?></small></h2>
					<h4> AUTOR: <?php echo $dlider['imie']." ".$dlider['nazwisko']." ".$dlider['email'];?>  </h4> 
					<h3> Krótki opis </h3>
					<p> <?php echo $dane['opisk'];?> </p>
					<h3> Pełny opis </h3>
					<p> <?php echo $dane['opis'];?> </p>
					<h3> Benefity </h3>
					<p> <?php echo $dane['benefity'];?> </p>

					<a href="projektwiecej.php?projekt={{projekt.id}}"><button type="button" class="btn btn-danger  ">Uwagi</button></a>
					<a href="projektwiecej.php?projekt={{projekt.id}}"><button type="button" class="btn btn-primary  ">Dotuj</button></a>
					<?php
					if($_SESSION[ID]==$lider)
					echo '<a href="projektwiecej.php?projekt={{projekt.id}}"><button type="button" class="btn btn-warning  ">Edytuj</button></a>';
					?>
				</div>
			</div>
		</div>

<?php
	
	
	/*echo "<p><b>Drewno</b>: ".$_SESSION['drewno'];
	echo " | <b>Kamień</b>: ".$_SESSION['kamien'];
	echo " | <b>Zboże</b>: ".$_SESSION['zboze']."</p>";
	
	echo "<p><b>E-mail</b>: ".$_SESSION['email'];
	echo "<br /><b>Dni premium</b>: ".$_SESSION['dnipremium']."</p>";*/
	
?>
		</div>
<div> <!-- cointeiner -->
 <!-- AngularJS -->
    <script src="js/angular.min.js"></script>
 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

   

</body>
</html>