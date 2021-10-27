<?php

include("config.php");

if(isset($_GET['id'])){

$id = $_GET['id'];

$sql = "DELETE FROM mahasiswa WHERE id=$id";
$query = mysqli_query($db, $sql);

if ($query) {
 	header('location: list.php');
 } else {
 	die("Gagal menghapus...");
 }


} else {
	die("Akses dilarang...");
}

?>