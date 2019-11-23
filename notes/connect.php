<?php

$severname = "localhost";
$user = "tasx3851";
$pass = "tasanah27";
$db = "tasx3851_db_notes";
$conn = new mysqli("$severname","$user","$pass","$db");

if (!$conn) {
    echo 'Error';
}


?>