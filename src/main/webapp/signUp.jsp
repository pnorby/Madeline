<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Sign Up</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="CSS/signUp.css" rel="stylesheet">
</head>

<body class="text-center">

<form class="form" action="register" method="post" >

    <h1 class="h3 mb-3 font-weight-normal">Sign Up</h1>
    <label for="inputEmail" class="sr-only">Email</label>
    <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email" required autofocus>
    <label for="inputFirstName" class="sr-only">First Name</label>
    <input type="text" id="inputFirstName" class="form-control" name="firstName" placeholder="First Name" required>
    <label for="inputLastName" class="sr-only">Last Name</label>
    <input type="text" id="inputLastName" class="form-control" name="lastName" placeholder="Last Name" required>
    <label for="inputUsername" class="sr-only">Username</label>
    <input type="text" id="inputUsername" class="form-control" name="userName" placeholder="Username" required>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" name="pWord" placeholder="Password" required>
    <label for="inputPasswordConfirm" class="sr-only">Confirm Password</label>
    <input type="password" id="inputPasswordConfirm" class="form-control" name="pWordConfirm" placeholder="Password Confirmation" required>

    <c:if test="${joiningTrip}">
        <input type="hidden" id="firstTrip" name="tripId" value="${theTrip}"/>
    </c:if>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
</form>
</body>

