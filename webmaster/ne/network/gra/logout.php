<?php

	session_start();
	
	session_unset();
	
	header('Location: log.php');

?>