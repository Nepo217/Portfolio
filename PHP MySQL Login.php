<?php

 //Setup Login variables
  $host='127.0.0.1';  //mysql server is on localhost
  $user='eburk6';   //Login ID
  $pass='**********';   //password
  $db='eburk6';    //database name 
  
  //enable PHP error reporting
  ini_set ("display_errors", "1");
  error_reporting(E_ALL);
  
  //Login to MySQL Server
  $conn = mysqli_connect($host,$user,$pass,$db) or die(mysqli_connect_error());
#terminate if there is a connection issue 
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

    #Check if the form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Get user input
    $name = $_POST["name"];
    $callTime = date("Y-m-d H:i:s");
    $reason = $_POST["reason"];

    #Insert data into the database
    $sql = "INSERT INTO calls (name, call_time, reason) VALUES ('$name', '$callTime', '$reason')";
    if ($conn->query($sql) === TRUE) {
        echo "Call recorded successfully!";
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }
}

#Display stored records
$sql = "SELECT * FROM calls";
$result = $conn->query($sql);
?>



<!DOCTYPE html>

<!--Webpage layout and style-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Help Desk Calls</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h2 {
            text-align: center;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input,
        textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        hr {
            margin-top: 40px;
            margin-bottom: 40px;
            border: 0;
            border-top: 1px solid #ccc;
        }

        h3 {
            text-align: center;
        }

        .call-record {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<h2>Help Desk Calls</h2>

<form method="POST" action="">
    <label for="name">Name:</label>
    <input type="text" name="name" required>

    <label for="reason">Reason for Call:</label>
    <textarea name="reason" rows="4" required></textarea>

    <input type="submit" value="Submit">
</form>

<hr>

<h3>Call Records</h3>
<?php
if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        echo '<div class="call-record">';
        echo "Name: " . $row["name"] . "<br>";
        echo "Call Time: " . $row["call_time"] . "<br>";
        echo "Reason: " . $row["reason"] . "<br>";
        echo '</div>';
    }
} else {
    echo "No call records found.";
}

$conn->close();
?>

</body>
</html>


