<!-- <?php 
    // header("Access-Control-Allow-Origin: *");
    // header("Content-Type: application/json; charset=UTF-8");

    // $connect = mysqli_connect("localhost", "root", "", "qlThietBi"); 
    // mysqli_query($connect, "SET NAMES 'utf8'"); 

    // // Lấy mã loại từ GET
    // $maloaimay = isset($_GET['maloaimay']) ? $_GET['maloaimay'] : '';

    // // Chỉ lọc khi có mã loại
    // $query = "SELECT * FROM thietbi WHERE maloaimay = '$maloaimay'"; 

    // $mangsanpham = array(); 
    // $data = mysqli_query($connect, $query); 

    // while ($row = mysqli_fetch_assoc($data)) { 
    //     $mangsanpham[] = $row; 
    // } 

    // echo json_encode($mangsanpham); 
?> -->

<?php
$connect = mysqli_connect("localhost", "root", "", "qlthietbi");
mysqli_query($connect, "SET NAMES 'utf8'");

// class Xe
// {
//     function __construct($maxe, $tenxe, $namsx, $maloai, $hinh)
//     {
//         $this->maxe = $maxe;
//         $this->tenxe = $tenxe;
//         $this->namsx = $namsx;
//         $this->maloai = $maloai;
//         $this->hinh = $hinh;
//     }
// }

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
