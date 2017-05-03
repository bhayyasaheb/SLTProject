<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Bootstrap Case</title>
<meta charset="utf-8">
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">

				<li class="active"><a href="#">Home</a></li>
				<c:forEach var="category" items="${categoryList}">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">${category.name}<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Mobile</a></li>
							<li><a href="#">TV</a></li>
							<li><a href="#">Refrigetor</a></li>
						</ul></li>

				</c:forEach>

				<!-- <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Appliances <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Mobile</a></li>
          <li><a href="#">TV</a></li>
          <li><a href="#">Refrigetor</a></li>
        </ul>
      </li>

<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Books <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Mobile</a></li>
          <li><a href="#">TV</a></li>
          <li><a href="#">Refrigetor</a></li>
        </ul>
      </li>
 -->
			</ul>
		</div>
	</nav>

	
</body>
</html>
