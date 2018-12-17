<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Admin Portal</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <script src="JsFiles/loadAdminData.js" type="text/javascript"></script>

    <!-- Bootstrap core CSS -->

    <!-- Custom styles for this template -->
    <link href="CSS/admin.css" rel="stylesheet">

</head>
<body>
<div class="container">
<h1>Administration Portal</h1>

<div class="row">

<div id="uButton" class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
    <input type="button" id="allUsers" value="Users" onclick="totalUsers()"/>
</div>

<div id="tButton" class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
    <input type="button" id="allTrips" value="Trips" onclick="totalTrips()"/>
</div>

<div id="lButton" class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
    <input type="button" id="allLocations" value="Locations" onclick="totalLocations()"/>
</div>

</div>

<div class="row">
    <p>Add New <img src="images/add.jpg"/></p>
</div>

<div id="adminData" class="row">

</div>

</div>
</body>
</html>
