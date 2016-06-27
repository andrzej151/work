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
					
				$polaczenie->close();
			}
				
				
		}
			
		
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności!</span>';
			echo '<br />Informacja developerska: '.$e;
		}

		try 
		{

			mysql_connect($host,$db_user,$db_password); 
			mysql_select_db($db_name); 
			//$polaczenie = new mysqli($host, $db_user, $db_password, $db_name);
			mysql_set_charset("utf8");
			if ($polaczenie->connect_errno!=0)
			{
				throw new Exception(mysqli_connect_errno());
			}
			else
			{
				
				$idprojektu=$_GET['projekt'];
				$sql=mysql_query("SELECT Z.id, Z.status, Z.zadanie, Z.ilepkt, U.imie, U.nazwisko FROM `Ezadania` AS Z, Euser AS U WHERE idprojektu='$idprojektu' AND U.id=Z.ktowziol"); 

				while($row=mysql_fetch_assoc($sql)){ 
				$output[]=$row; 
				} 
				$zadania=json_encode($output); 


					
					
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
    <link href="css/styl.css" rel="stylesheet">

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

		<div class="col-lg-12 center-block" >

			
				
			
				<div class="list-group-item center-block" >
					<h2> <?php echo $dane['nazwa'];?> 
					<small><?php echo $dane['status'];?> </br>
					PUNKTY <?php echo $dane['punkty'];?></small></h2>
					<h4> AUTOR: <?php echo $dlider['imie']." ".$dlider['nazwisko']." ".$dlider['email'];?>  </h4> 
					<h3> Krótki opis </h3>
					<p> <?php echo $dane['opisk'];?> </p>
					<h3> Pełny opis </h3>
					<p> <?php echo $dane['opis'];?> </p>
					<h3> Benefity </h3>
					<p> <?php echo $dane['benefity'];?> </p>

					<a href="uwagi.php?projekt=<?php echo $idprojektu;?>"><button type="button" class="btn btn-danger  ">Uwagi</button></a>
					<?php 
					if($dane['status']=="Dotowanie")
					echo'<a href="dotuj.php?projekt='.$idprojektu.'&&nazwa='.$dane['nazwa'].'"><button type="button" class="btn btn-primary  ">Dotuj</button></a>';
					

					if($_SESSION[ID]==$lider)
					{
						echo '<a href="edytuj.php?projekt='.$idprojektu.'"><button type="button" class="btn btn-warning  ">Edytuj</button></a>';
						if($dane['status']=="Realizacja")
							{
								echo '<a href="dodajzadanie.php?projekt='.$idprojektu.'&&nazwa'.$dane['nazwa'].'"><button type="button" class="btn btn-warning  ">Dodaj zadanie</button></a>';
								echo '<a href="zakoncz.php?projekt='.$idprojektu.'"><button type="button" class="btn btn-danger  ">Zakoncz Projekt</button></a>';
							}
					}
					?>
				</div>
			</div>

			<div class="col-lg-10 center-block" ng-controller='ZAD'>
			<h1>Zadania</h1>
			<br/>
			
			<div class="row center-block">
			
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr><td>zadanie</td><td>status</td><td>Kto wzioł</td><td>Punkty</td> <td>Funkcje</td></tr>
					</thead>
					<tbody>
						<tr ng-repeat="zad in zadania">
							<td>{{zad.zadanie}}</td>
							<td>{{zad.status}}</td>
							<td>{{zad.imie}} {{ zad.nazwisko}}</td>
							<td>{{zad.ilepkt}}</td>
							<td>
								<a href="uwagi.php?=<?php echo $idprojektu.'&&zadanie=';?>{{zad.id}}"><button type="button" class="btn btn-danger  ">Uwagi</button></a>
								<?php 
								echo'<a href="wezzadanie.php?projekt='.$idprojektu.'&&zadanie={{zad.id}}"><button type="button" class="btn btn-primary  ">Przyjmij</button></a>';
								if($_SESSION[ID]==$lider)
								{
									echo'<a href="edytujzadanie.php?projekt='.$idprojektu.'&&zadanie={{zad.id}}"><button type="button" class="btn btn-warning  ">Edytuj</button></a>';
								}


								?>
								


							</td>
						</tr>
					</tbody>

				</table>
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

 	<script >
	var app=angular.module('myApp',[]);

    	app.controller('ZAD',['$scope', function($scope){
    		$scope.zadania=<?php echo $zadania;?>;
    	}]);


    </script>
   

</body>
</html>