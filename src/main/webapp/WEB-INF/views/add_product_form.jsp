<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./All-js-css.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<h1 class="text-center mb-3">Fill the product detail</h1>

				<form action="handle-product" method="post">
					<div class="form-group">
						<label for="name"  >Product Name</label> <input type="text" required="required"
							class="form-control" id="name" name="name" aria-describedby="emailHelp"
							name="name" placeholder="Enter the Product name here">
					</div>
					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea class="form-control" id="description" name="description" aria-describedby="emailHelp"
							rows="4" name="name" placeholder="Enter the Product description here"
							></textarea>
					</div>
					<div class="form-group">

						<label class="price">Product price</label> <input type="text"
							class="form-control" id="price" name="price" required="required"
							>
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath}"  class="btn btn-danger">Back</a>
						
						<button type="submit" class="btn btn-primary">ADD</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>