<?php
if(isset($_SESSION["user_id"]))
	include "panel.php";
else
	include "login-page.php";

?>