<?php
	session_start();
	
	/*if (!isset($_SESSION['zalogowany']))
	{
		header('Location: index.php');
		exit();
	}*/
	
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
				$output[]="f ";
				$polaczenie->set_charset("utf8");
				$sql=mysql_query("SELECT * FROM rozmowy"); 
				while($row=mysql_fetch_assoc($sql)){ 
				$output[]=$row; 
				} 
				$polaczenie->close();
			}
				
				
		}
			
		
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności!</span>';
			echo '<br />Informacja developerska: '.$e;
		}
/*
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
				
				$urzytkownik=$_SESSION['ID'];
				$sql=mysql_query("SELECT id, nazwa, status, opisk FROM `Eprojekty` WHERE idlider='$urzytkownik' ORDER BY czas DESC"); 

				while($row=mysql_fetch_assoc($sql)){ 
				$output[]=$row; 
				} 
				$proj=json_encode($output); 


					
					
			}
				
				
		}
			
		
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności!</span>';
			echo '<br />Informacja developerska: '.$e;
		}
*/
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

</head>

<body ng-app='myApp'>
	<div class="col-lg-12">
		<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
			<a class="navbar-brand" href="panel.php">Empier</a>
			<a href="projekty.php"><button type="button" class="btn btn-primary navbar-btn">PROJEKTY</button></a>
			<a href="transakcje.php"><button type="button" class="btn btn-primary navbar-btn">TRANSAKCJE</button></a>
			<a href="panel.php"><button type="button" class="btn btn-primary navbar-btn active">MOJ PANEL</button></a>
			<a href="baza_wiedzy.php"><button type="button" class="btn btn-primary navbar-btn">BAZA WIEDZY</button></a>
			<a href="logout.php"><button type="button" class="btn btn-danger  navbar-btn">WYLOGUJ SIĘ</button></a>

		</nav>	
	<?php  echo($output);?>

		
		</div>
	</div>

  <!-- AngularJS -->
    <script src="js/angular.min.js"></script>
 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <script >
	var app=angular.module('myApp',[]);

    	app.controller('ProjCon',['$scope','$filter', function($scope, $filter){
    		$scope.projekty=<?php echo $proj;?>;
    	}]);


    </script>
</body>
</html>