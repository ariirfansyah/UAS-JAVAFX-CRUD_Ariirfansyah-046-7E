<?php

include("config.php");

if(!isset($_GET['id'])){
	header('location: list.php');
}

$id = $_GET['id'];


$sql = "SELECT * FROM mahasiswa WHERE id=$id ";
$query = mysqli_query($db, $sql);
$siswa = mysqli_fetch_assoc($query);

if ( mysqli_num_rows ($query) < 1 ){
	die("Data tidak ditemukan...");
}
?>


<!DOCTYPE html>
	<html>
	<head>
		<title>Data Mahasiswa</title>
	</head>
	<body>
		<header>
			<h1> Data Mahasiswa</h1>
		</header>

		<form action="edits.php" method="POST">
			<fieldset>
				<input type="hidden" name="id" value="<?php echo $siswa['id'] ?>" />
				
			<p>
				<label for="nama"> Nama: </label>
				<input type="text" name="nama" placeholder=" Isikan nama lengkap" value="<?php echo $siswa['nama'] ?>" /> 
			</p>
			<p>
				<label for="alamat"> Jurusan: </label>
				<input type="text" name="jurusan" 
				placeholder="Isikan jurusan" value="<?php echo $siswa['jurusan'] ?>" /> 
			</p>
			<p>
				<input type="submit" value="Simpan" name="simpan" />
			</p>	
			</fieldset>
		</form>
	</body>
	</html>