<?php
//Importing Database Script 
require_once('connect.php'); 
//Creating sql query 
$sql = "SELECT * FROM tb_siswa"; 
//getting result 
$r = mysqli_query($con,$sql); 
//creating a blank array 
$result = array(); 
//looping through all the records fetched 
while($row = mysqli_fetch_array($r)){ 
//Pushing name and id in the blank array created 
array_push($result,array( 
"no_absen"=>$row['no_absen'],
"nis"=>$row['nis']
"nama_siswa"=>$row['nama_siswa']
"kelas"=>$row['kelas']
));
}
//Displaying the array in json format
echo json_encode(array('result'=>$result));
mysqli_close($con);
?>