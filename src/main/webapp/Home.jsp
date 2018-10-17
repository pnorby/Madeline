<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
  <%@ include file="head.jsp" %>
  <head>
  <script src="tripWeather.js" type="text/javascript"></script>
  </head>
  <body>
    <div id="container">
      <%@ include file="jsp/loggedIn-tag.jsp" %>
	  <div id="main_content">
	  <div id="tripName">
	  </div>
	  <div id="tripWeather">
	  </div>
	  <div id="tripInformation">
	  </div>
	</div>
	</div>
	</body>
</html>
	  
<pre>
<c:if test="${displayResults}">
<c:import var = "data" url = "${outputFile}" scope="session"/>
<c:out value = "${data}"/>
</c:if>
</pre>
        </div>
        <%@ include file="jsp/menu.jsp" %>
        <div id="clear"></div>
      </div>
      <div id="main_content_bottom"></div>
      <%@ include file="jsp/footer-tag.jsp" %>
    </div>
  </body>
</html>

