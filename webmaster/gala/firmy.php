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
				
				
				$sql=mysql_query("SELECT * FROM `firmyo`  ORDER BY firma"); 

				while($row=mysql_fetch_assoc($sql)){ 
				$output[]=$row; 
				} 
				$dane=json_encode($output); 

					
					
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
	<title>Firmy </title>

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

<body ng-app='myApp'>
<div class="container">
		<div class="col-lg-8 center-block" ng-controller='ProjCon'>
			<h1></h1>
			<br/>
			<input type="text" class="form-control" placeholder="Czego szukasz?" ng-model="wyszukiarka">
			
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr><td>firma</td><td>branża</td> <td>czesc</td><td>sektor</td><td>obecna</td> <td>raport</td> <td>Funkcje</td></tr>
					</thead>
					<tbody>
						<tr ng-repeat="los in losowanie| filter : wyszukiarka">
					 <td>{{los.firma}}</td><td> {{los.branza}}</td><td> {{los.czesc}}</td><td> {{los.sektor}}</td><td> {{los.obecna}}</td><td>{{los.rapotr}}</td> 
						<td><a href="firmaobecna.php?o={{los.id}}"><button type="button" class="btn btn-success  ">obecna</button></a>
						<a href="firmaraport.php?o={{los.id}}"><button type="button" class="btn btn-danger  ">raport</button></a>
						</td>
						</tr>
					</tbody>
				</table>
					
		
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

    	app.controller('ProjCon',['$scope','$filter', function($scope, $filter){
    		$scope.losowanie=<?php echo $dane;?>;
    	}]);


    </script>

</body>
</html>