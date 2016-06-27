<?php

	session_start();
	
	if (!isset($_SESSION['zalogowany']))
	{
		header('Location: log.php');
		exit();
	}
?>

<!DOCTYPE HTML>
<html lang="pl">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Gra networkingowa</title>
	<link rel="stylesheet" type="text/css" href="gra.css">
	<script src="gra.js" type="text/javascript"></script>
</head>
<?php

$Komp=5;
$Runda=$_SESSION['runda'];
$Stan=$_SESSION['stan'];

$Pytanie='"'.$_SESSION['pytanie'].'"';
$Kto=$_SESSION['kto'];
$Kim=$_SESSION['kim'];
$Mysl=$_SESSION['mysl'];

$fa = fopen("config.txt", "r");
$os=fread($fa, 3);
$CZM=fread($fa, 3);
$CR=fread($fa, 3);
$CO1=fread($fa, 3);
$CO2=fread($fa, 3);

$fo = "formularz.html";
$FORMULARZ=file_get_contents($fo);
?>
<body>
	<div id="pojemnik">
		<div id="menu">
			<div id="pytanie">
				
			</div>
			
			
			<div id="m2">
				<div id="mysl">
					<?php
						echo($Mysl);
					?>
				</div>
				<div id="czas">
					
				</div>
				<div id="runda">
					RUNDA </br><?php echo($Runda);?>
				</div>
				<div id="stop" onclick="stop()">
					S</br>T</br>O</br>P
				</div>

			
				
			</div>
			
			
		</div>
		<div style = "clear:both;"></div>

		<div id="text">
			
			<div id="pole3">
			</br>
			<?php
				echo($Kto);
			?>
			
			</div>
			<div id="pole4">
			</br>
			<?php
				echo($Kim);
			?>
			
			</div>
			
		</div>
		<div style = "clear:both;"></div>
	
	</div>


</body>
</html>

<script>

var czas;
var status;
var st;
var pt;
var formularz

function start()
{
	st=false;
	status=<?php echo($Stan);?>;
	pt=<?php echo($Pytanie);?>;
	o1=<?php echo('"'.$Kto.' napisz do '.$Kim.'"');?>;
	o2=<?php echo('"'.$Kim.' napisz do '.$Kto.'"');?>;
	formularz=<?php echo($FORMULARZ);?>
	zmienstan();
}

function zmienstan()
{
	switch(status)
	{
		case '1':
			{
				//zmieniamy miejsca
				document.getElementById("pytanie").innerHTML = "ZMIENIAMY MIEJSCA";
				czas=<?php echo($CZM);?>;
				zmien();
			}
				break;
				
		case '2':
			{
				//rozmowa
				document.getElementById("pytanie").innerHTML =pt; 
				czas=<?php echo($CR);?>;
				zmien();
			}
				break;
				
		case '3':
			{
				//formularz 1
				document.getElementById("pytanie").innerHTML =o1; 
				document.getElementById("text").innerHTML =formularz; 
				czas=<?php echo($CO1);?>;
				zmien();
			}
				break;
		case '4':
			{
				
				document.getElementById("inf").submit(); 
				
			}
				break;
				
		case '5':
			{
				//formularz 2
				document.getElementById("pytanie").innerHTML =o2; 
				document.getElementById("text").innerHTML =formularz; 
				czas=<?php echo($CO2);?>;
				zmien();
			}
				break;
		case '6':
			{
				
				document.getElementById("inf").submit(); 
				
			}
				break;
	
	}
	
}

function stop()
{	
	if(st==true)
	{
		st=false;
		document.getElementById("stop").innerHTML ="S</br>T</br>O</br>P";
		zmien();
	}
	else
	{
		st=true;
		document.getElementById("stop").innerHTML ='<div id="start">S</br>T</br>A</br>R</br>T</div>';
	}
}
function zmien()
{
	if(st==false){
		if(czas>0)
		{			
			czas--;
			if(czas<6)
			{
				document.getElementById("czas").innerHTML = '<div id="r">'+czas+'</div>';
			}
			else
			{
				if(czas<16)
				{
					document.getElementById("czas").innerHTML = '<div id="y">'+czas+'</div>';
				}
				else
				{
					document.getElementById("czas").innerHTML = '<div id="g">'+czas+'</div>';
				}
			}
			
			setTimeout("zmien()",1000);
		}
		else
		{
			status++;
			zmienstan();
		}
	}
}

window.onload = start;
</script>