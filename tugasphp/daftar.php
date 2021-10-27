<!DOCTYPE html>
	<html>
	<head>
		<title>Data Mahasiswa</title>
	</head>
	<body>
		<header>
			<h1> Data Mahasiswa</h1>
		</header>

		<form action="pendaftaran.php" method="POST">

			<fieldset>
				
			<p>
				<label for="nama"> Nama: </label>
				<input type="text" name="nama" placeholder=" Isikan nama lengkap" /> 
			</p>
			<p>
				<label for="alamat"> Jurusan: </label>
				<input type="text" name="jurusan" 
				placeholder="Isikan jurusan" /> 
			</p>
			<p>
				<input type="submit" value="daftar" name="daftar" />
			</p>	
			</fieldset>
		</form>
	</body>
	</html>