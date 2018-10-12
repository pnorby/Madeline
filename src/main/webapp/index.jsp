<%@include file="head.jsp"%>
<html>
<header>
    <nav class="navbar navbar-inverse" id="theNav">
        <div class="container-fluid">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavBar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="myNavBar">
                <ul class="nav navbar-nav">
                    <li><a href="index.html">Home</a></li>
                    <li><a href="About.html">About</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">SampleDropdown<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="Samples.html">Samples</a></li>
                            <li><a href="MoreSamples.html">more</a></li>
                        </ul>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">

                    <li><a href="mailto:paulnorby@me.com"><span class="glyphicon glyphicon-envelope"></span> paulnorby@me.com</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<body>
<h2>User Display Exercise - Week 1</h2>
<a href = "allUsers">Go to the User Search</a>
</body>
</html>