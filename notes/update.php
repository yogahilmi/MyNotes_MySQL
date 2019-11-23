<?php

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $id = $_POST['id'];
    $title = $_POST['title'];
    $note = $_POST['note'];
    $color = $_POST['color'];

    require_once("connect.php");

    $query = "SELECT * FROM db_notes";
    $query = "UPDATE 'notes' SET title='$title', note='$note', color='$color' WHERE id= '$id' ";

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