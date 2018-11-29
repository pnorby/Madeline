<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"

    <!-- Custom styles for this template -->
    <link href="CSS/home.css" rel="stylesheet">

</head>
<body>
<c:choose>
    <c:when test="${loggedIn}">
<%@include file="/loggedIn.jsp"%>

<div id="container" class="container">
    <div id="main_content">

    </div>
</div>

</body>
    </c:when>
    <c:otherwise>
        <H1>You must log in</H1>
        </body>
    </c:otherwise>

</c:choose>

</html>
	  


