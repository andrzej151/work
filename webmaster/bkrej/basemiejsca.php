<?php

	
	

	require_once "connect.php";
	mysqli_report(MYSQLI_REPORT_STRICT);
		
		try 
		{

			mysql_connect($host,$db_user,$db_password); 
			mysql_select_db($db_name); 
			
			if ($polaczenie->connect_errno!=0)
			{
				throw new Exception(mysqli_connect_errno());
			}
			else
			{
				
				
				$sql=mysql_query("SELECT * FROM `Bkmiejsca` WHERE zajete=0 ORDER BY sektor"); 

				while($row=mysql_fetch_assoc($sql)){ 
				$output[]=$row; 
				} 
				$dane=json_encode($output); 
				echo '{"rec":';
 				echo $dane;
				echo "}";
					
			}
				
				
		}
			
		
		catch(Exception $e)
		{
			echo '<span style="color:red;">Błąd serwera! Przepraszamy za niedogodności!</span>';
			echo '<br />Informacja developerska: '.$e;
		}



	
?>