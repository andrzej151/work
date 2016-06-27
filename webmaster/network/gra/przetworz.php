<?php

	session_start();
	
	if (!isset($_SESSION['zalogowany']))
	{
		header('Location: log.php');
		exit();
	}
	
	require_once "conect.php";

	$polaczenie = @new mysqli($host, $db_user, $db_password, $db_name);
	
	$login = htmlentities($login, ENT_QUOTES, "UTF-8");
	
	
	
	$kom = $_SESSION['nazwakom'];
	$runda = $_SESSION['runda'];
	$spotkanie = $_SESSION['spotkanie'];
	$kim = $_SESSION['kim'];
	$kto = $_SESSION['kto'];
	//echo($kim." ".$kto);
	$pytanie = $_SESSION['pytanie'];
	$ocena = $_POST['ocena'];
	$owiecej = $_POST['ocenaw'];
	
	if(isset($_POST['telefon']))
	{
		$telefon = 1;
	}
	else
	{
		$telefon = 0;
	}
	
	if(isset($_POST['mail']))
	{
		$mail = 1;
	}
	else
	{
		$mail = 0;
	}
	
	if(isset($_POST['fb']))
	{
		$fb = 1;
	}
	else
	{
		$fb = 0;
	}

	$zalety = $_POST['ocenazalety'];
	$poprawic = $_POST['ocenapoprawic'];
	$mile = $_POST['ocenamile'];
	$status="false";
	
		if ($polaczenie->connect_errno!=0)
	{
		echo "Error: ".$polaczenie->connect_errno;
	}
	else
	{
		$polaczenie->set_charset("utf8");
		if($_SESSION['stan']==1) 
		{
			$polaczenie->query("INSERT INTO Ngra VALUES (NULL, '$kom', '$runda', '$spotkanie', '$kto', '$kim', '$pytanie', '$ocena', '$owiecej', '$telefon', '$mail', '$fb', '$zalety', '$poprawic', '$mile', '$status')");
			$_SESSION['stan']=5;
			header('Location: gra.php');
			exit();
		}
		else
		{
			$polaczenie->query("INSERT INTO Ngra VALUES (NULL, '$kom', '$runda', '$spotkanie', '$kim', '$kto', '$pytanie', '$ocena', '$owiecej', '$telefon', '$mail', '$fb', '$zalety', '$poprawic', '$mile', '$status')");
			header('Location: nowarunda.php');
			exit();
		}
	}
?>

