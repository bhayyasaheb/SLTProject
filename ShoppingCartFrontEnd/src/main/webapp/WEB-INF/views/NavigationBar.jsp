<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav">
			<li class="active"><a href="HomePage">Shopping Cart</a></li>
			<c:forEach var="category" items="${categoryList}">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">${category.name}<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach var="product" items="${productList}">
							<!--  get product by  category, when we click on particular category that category product display -->
							<c:if test="${product.category_id == category.id}">
								<li><a href="#">${product.name}</a></li>
							</c:if>

						</c:forEach>

						<!-- <li><a href="#">Mobile</a></li>
						<li><a href="#">Laptop</a></li>
						<li><a href="#">Printer</a></li>
						<li><a href="#">LED Light</a></li>
						<li><a href="#">Camera</a></li> -->
					</ul></li>
			</c:forEach>


			<!-- <li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Men <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Footwear</a></li>
					<li><a href="#">Watches</a></li>
					<li><a href="#">Clothing</a></li>
					<li><a href="#">Mens Grooming</a></li>

				</ul></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Books<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Entrance Exam</a></li>
					<li><a href="#">Academic</a></li>
					<li><a href="#">Indian Writing</a></li>
					<li><a href="#">Children</a></li>
				</ul></li>
 -->
		</ul>


		<ul class="nav navbar-nav navbar-right">
			<li><a href="LoginPage"><span
					class="glyphicon glyphicon-user"></span> Login</a></li>
			<li><a href="RegistrationPage"><span
					class="glyphicon glyphicon-log-in"></span> Register</a></li>
			<li><a href="AboutUsPage"><span
					class="glyphicon glyphicon-roundabout"></span> About Us</a></li>
		</ul>
	</div>
	</nav>


</body>
</html>