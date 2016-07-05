<?php

	session_start();
	
	
?>

<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Empire - załóż darmowe konto!</title>
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
	<style>
		.error
		{
			color:red;
			margin-top: 10px;
			margin-bottom: 10px;
		}
	</style>
</head>

<body>
	<div class="container">
		<div class="col-lg-3">
		

			<form  method="POST" role="form" action="f2.php">
				
		<div class="form-group">
			<label for="nick">
			Login: </label> <input type="text" class="form-control input-lg" value="<?php
				if (isset($_SESSION['fr_nick']))
				{
					echo $_SESSION['fr_nick'];
					unset($_SESSION['fr_nick']);
				}
			?>" name="nick" /><br />
		
		<?php
			if (isset($_SESSION['e_nick']))
			{
				echo '<div class="error">'.$_SESSION['e_nick'].'</div>';
				unset($_SESSION['e_nick']);
			}
		?>
		</div>
		Imię: <br /> <input type="text" class="form-control input-lg" value="<?php
			if (isset($_SESSION['fr_imie']))
			{
				echo $_SESSION['fr_imie'];
				unset($_SESSION['fr_imie']);
			}
		?>" name="imie" /><br />

		
		
		<button type="submit" class="btn btn-primary">Zarejestruj się!</button>
		
	</form>
<div> <!-- cointeiner -->
 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>