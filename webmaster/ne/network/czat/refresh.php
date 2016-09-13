<?
session_start();
require_once("chat.php");
$refresh = new chat();
require_once("chat.php");
$query="select * from chat";
$a=$refresh->connect_easy($query);
$refresh->show($a);
?>