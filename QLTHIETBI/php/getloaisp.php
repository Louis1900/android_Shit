<?php
$connect=mysqli_connect("localhost","root","","QLThietBi"); 
   mysqli_query($connect,"SET NAMES 'utf8'"); 
  
   $query="SELECT * FROM loaitb"; 
   $data=mysqli_query($connect,$query); 
   $mangloaiTB=array(); 
 
while ($row=mysqli_fetch_assoc($data)) 
{ 
         $mangloaiTB[]=$row; 
} 
echo json_encode($mangloaiTB); 
class Loaisanpham
{ 
    function Loaisanpham($maloaimay, $tenloaimay) 
    { 
        $this->$maloaimay=$maloaimay; 
        $this->$tenloaimay=$tenloaimay; 
    } 
} 
?> 