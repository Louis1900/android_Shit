<?php 
    // $connect=mysqli_connect("localhost","root","","qlxe"); 
    // mysqli_query($connect,"SET NAMES 'utf8'"); 
    // class Xe 
    // { 
    //     function Xe($maxe,$tenxe,$namsx,$maloai,$hinh) 
    //     { 
    //         $this->$maxe=$maxe; 
    //         $this->$tenxe=$tenxe; 
    //         $this->$namsx=$namsx; 
    //         $this->$maloai=$maloai; 
    //         $this->$hinh=$hinh; 
    //     } 
    // } 
    //  $query="SELECT * FROM xe"; 
    //   $mangxe=array(); 
    //   $data=mysqli_query($connect,$query); 
    // while ($row=mysqli_fetch_assoc($data)) 
    //   { 
    //          $mangxe[]=$row; 
    //   } 
    //   echo json_encode($mangxe); 
?>
<?php 
    // header("Access-Control-Allow-Origin: *");
    // header("Content-Type: application/json; charset=UTF-8");

    // $connect = mysqli_connect("localhost", "root", "", "qlxe"); 
    // mysqli_query($connect, "SET NAMES 'utf8'"); 

    // // Lấy mã loại từ GET
    // $maloai = isset($_GET['maloai']) ? $_GET['maloai'] : '';

    // // Chỉ lọc khi có mã loại
    // $query = "SELECT * FROM xe WHERE maloai = '$maloai'"; 

    // $mangxe = array(); 
    // $data = mysqli_query($connect, $query); 

    // while ($row = mysqli_fetch_assoc($data)) { 
    //     $mangxe[] = $row; 
    // } 

    // echo json_encode($mangxe); 
?>
<?php
$connect = mysqli_connect("localhost", "root", "", "qlxe");
mysqli_query($connect, "SET NAMES 'utf8'");

class Xe
{
    function __construct($maxe, $tenxe, $namsx, $maloai, $hinh)
    {
        $this->maxe = $maxe;
        $this->tenxe = $tenxe;
        $this->namsx = $namsx;
        $this->maloai = $maloai;
        $this->hinh = $hinh;
    }
}

// Get maloai from the URL parameters
$maloai = $_GET['maloai'];

$query = "SELECT * FROM xe WHERE maloai = '$maloai'";
$data = mysqli_query($connect, $query);

$mangxe = array();
while ($row = mysqli_fetch_assoc($data)) {
    $mangxe[] = new Xe($row['maxe'], $row['tenxe'], $row['namsx'], $row['maloai'], $row['hinh']);
}

// Return JSON response
echo json_encode($mangxe);
?>

