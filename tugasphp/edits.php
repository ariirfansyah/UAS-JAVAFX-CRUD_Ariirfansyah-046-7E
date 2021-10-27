<?php

include("config.php");

if(isset($_POST['simpan'])){

$id = $_POST['id'];
$nama = $_POST['nama'];
$jurusan = $_POST['jurusan'];

$sql = "UPDATE mahasiswa SET nama='$nama', jurusan='$jurusan' WHERE id=$id";
$query = mysqli_query($db, $sql);

if ($query) {
 	header('location: list.php');
 } else {
 	die("Gagal menyimpan perubahan...");
 }


} else {
	die("Akses dilarang...");
}

?>