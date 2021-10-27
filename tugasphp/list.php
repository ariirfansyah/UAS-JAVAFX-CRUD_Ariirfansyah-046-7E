<?php include("config.php"); ?>

	<!DOCTYPE html>
	<html>
	<head>

		<title>Data Mahasiswa</title>
	</head>
	<body>
		<header>
			<style>
		    	body {
        		background: #e3cef5;
    		}
    		</style>


			<h1 align="center">Mahasiswa yang sudah mendaftar</h1>
		</header>

		
		
		<br>

		<table border="1" align="center">
		<thead>
			<tr height="50">
				<th>No</th>
				<th width="100">Nama</th>
				<th width="100">Jurusan</th>
				<th width="100">Aksi</th>
			</tr>
		</thead>
		<tbody>
			
			<?php
			$sql = "SELECT * FROM mahasiswa";
			$query = mysqli_query($db, $sql);

			while($siswa = mysqli_fetch_array($query)){
				echo "<tr>";

				echo "<td>".$siswa['id']."</td>";
				echo "<td>".$siswa['nama']."</td>";
				echo "<td>".$siswa['jurusan']."</td>";
				
				echo "<td>";
				echo "<a href='edit.php?id=".$siswa['id']."'>Edit</a> | ";
				echo "<a href='hapus.php?id=".$siswa['id']."'>Hapus</a> ";
				echo "</td>";

				echo "</tr>";

			}
			?>				

		</tbody>  
		</table>
		<br>
		<nav align="center">
			<a href="daftar.php">[+] tambah baru </a>
		</nav>
		<p align="center">Total: <?php echo mysqli_num_rows($query) ?></p>

	</body>
	</html>	

