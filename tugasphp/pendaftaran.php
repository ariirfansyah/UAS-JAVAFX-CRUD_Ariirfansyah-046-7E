<?php

include("config.php");

if(isset($_POST['daftar'])){

$nama = $_POST['nama'];
$jurusan = $_POST['jurusan'];

$sql = "INSERT INTO mahasiswa (nama, jurusan) VALUE ('$nama', '$jurusan')";
$query = mysqli_query($db, $sql);

if ($query) {
 	header('location: index.php?status=sukses');
 } else {
 	header('location: index.php?status=gagal');
 }


} else {
	die("Akses dilarang...");
}

?>