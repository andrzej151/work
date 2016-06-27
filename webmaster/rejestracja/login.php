<?php

session_save_path("session/");
session_start();

include "db.php";

if(isset($_POST['log-in'])){
	$login = $_POST['login'];
	$pass = md5($_POST['pass']);

	$users = $db -> Prepare('SELECT * FROM `users` WHERE `login` = :login');
	$users -> bindParam(":login", $login, PDO::PARAM_STR);
	$users -> Eexecute();
	$users = $users -> fetch(PDO::FETCH_ASSOC);

	if (empty($users)) {
		header("Location: index.php?error=4");
		exit;
	}

	if($pass != $users['pass']){
		header("Location: index.php?error=5");
		exit;
	}

	if($kod != $users['active']){
		header("Location: index.php?error=6");
		exit;
	}

	$_SESSION['users_id'] = $users['id'];
		header("Location: index.php?succes=4");
	exit;
}

if(isset($_GET['activate'])){
	$key = $_GET['activate'];
	$users = $db -> Query('SELECT `kod` FROM `users` WHERE `kod` = "' . $key . '"');
	if(empty($users)){
		header("Location: index.php?error=3");
		exit;
	}

	$db -> Exec('UPDATE `users` SET `kod` = "active" WHERE `kod`= "' . $key . '"');
	header("Location: index.php?succes=1");
	exit;
}

if(isset($_POST['register'])){


	
	if(empty($_POST['login'])||empty($_POST['e-mail'])||empty($_POST['pass'])||empty($_POST['pass2']))
	{
		header("Location: index.php?error=0");
		exit;
	}
	
		
	$login = $_POST['login'];
	$email = $_POST['e-mail'];
	$pass = md5($_POST['pass']);
	$pass2 = md5($_POST['pass2']);
	$key = md5(mt_rand());

	if($pass != $pass2)
	{
		header("Location: index.php?error=1");
		exit;
	}

	$users = $db -> Query('SELECT `login`,`e-mail` FROM `users` WHERE `login` = "' . $login . '" OR `e-mail` = "' . $email . '"');
	$users = $users -> fetchAll();

	if(!empty($users)){
		header("Location: index.php?error=2");
		exit;
	}

	$db -> Exec('INSERT INTO `users` VALUES("", "' . $login . '", "' . $email . '", "' . $pass . '", "' . $key . '")');

	$email_active = "email_active.html";
	$messeage = file_get_contents($email_active);
	$messeage = str_replace("[login]", $login, $messeage);
	$messeage = str_replace("[key]", $key, $messeage);
	$messeage = str_replace("[url]", "http://" . $_SERVER['HTTP_HOST']. $_SERVER['PHP_SELF'], $messeage);

	$naglowki = "From: active@andr-t.cba.pl\n" .
				"Reply-To: active@andr-t.cba.pl\n" .
				"Content-type: text/html; charset=utf-8\n";

	mail($email, "Aktywacja konta",$messeage,$naglowki);	

	
	header("Location: index.php?succes=0");
	exit;
}

?>