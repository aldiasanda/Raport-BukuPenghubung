<?php
 
$no_absen = $_GET['no_absen']; 

require_once('connect.php'); 

$sql = "SELECT * FROM tb_siswa,tb_mapel WHERE no_absen=$no_absen,nis=$nis,nama=$nama,nilai=$nilai"; 

$r = mysqli_query($con,$sql); 

$result = array(); $row = mysqli_fetch_array($r); 
array_push($result,array( "no_absen"=>$row['no_absen'],
"nis"=>$row['nis'],
"nama"=>$row['nama'],
"jurusa"=>$row['jurusan']
));
  

echo json_encode(array('result'=>$result));
mysqli_close($con);
?>