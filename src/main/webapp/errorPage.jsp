<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="JsFiles/homeJS.js" type="text/javascript" charset="utf-8"></script>


    <!-- Custom styles for this template -->
    <link href="CSS/homeTwo.css" rel="stylesheet">

</head>
<body>
<c:choose>
<c:when test="${loggedIn}">
<%@include file="/loggedInTwo.jsp"%>

<div class="container">
    <div id="main_content">
    </div>
</div>

</c:when>
<c:otherwise>
    <H1>You must log in</H1>
    </body>
</c:otherwise>

</c:choose>
</body>
</html>
