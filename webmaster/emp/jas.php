<?php 
	$host = "mysql.cba.pl";
	$user = "andrzej94";
	$pass = "Andrzej151";
	$baza = "andr_t_cba_pl";

$tabela = "Euser"; //tabela 

mysql_connect($host,$user,$pass); 

mysql_select_db($baza); 
$sql=mysql_query("select * from $tabela"); 

while($row=mysql_fetch_assoc($sql)){ 
$output[]=$row; 
} 
print(json_encode($output)); 
mysql_close(); 

?>