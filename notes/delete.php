<?php
include('connect.php');

if($_SERVER['REQUEST_METHOD'] == 'POST'){
    
	$id = $_POST['id'];

	$query = "DELETE FROM notes WHERE `id` = '$id' ";

    if ($conn->query($query)) {
        $response['success'] = true;
        $response['message'] = "Successfully";
    } else {
        $response['success'] = false;
        $response['message'] = "Failure";
    }

} else {
    $response['success'] = false;
    $response['message'] = "Failure";
}

echo json_encode($response);
?>
