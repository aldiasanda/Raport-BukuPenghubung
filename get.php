<?php
 
$no_absen = $_GET['no_absen']; 
require_once('connect.php'); 

$sql = "SELECT * FROM tb_siswa,tb_mapel WHERE no_absen=$no_absen,nis=$nis,nama=$nama,pai=$pai,pkn=$pkn,bi=$bi,mat=$mat,si=$si,bing=$bing,sbk=$sbk,pkwu=$pkwu,penjas=$penjas,adser=$adser,rbj=$rbj,web=$web,grafik=$grafik,pbb=$pbb,adbasdat=$sdbasdat"; 

$r = mysqli_query($con,$sql); 

$result = array(); $row = mysqli_fetch_array($r); 
array_push($result,array( "no_absen"=>$row['no_absen'],
"nis"=>$row['nis'],
"nama"=>$row['nama'],
"pai"=>$row['pai']
"pkn"=>$row['pkn']
"bi"=>$row['bi']
"mat"=>$row['mat']
"bing"=>$row['bing']
"sbk"=>$row['sbk']
"pkwu"=>$row['pkwu']
"penjas"=>$row['penjas']
"adser"=>$row['adser']
"rbj"=>$row['rbj']
"web"=>$row['web']
"grafik"=>$row['grafik']
"pbb"=>$row['pbb']
"adbasdat"=>$row['adbasdat']

));
  

echo json_encode(array('result'=>$result));
mysqli_close($con);
?>