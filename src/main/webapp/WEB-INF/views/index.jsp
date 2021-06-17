<html>
<head>
<%@include file="./All-js-css.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome To Product</h1>
				<table class="table table-striped table-secondary">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Product Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="p">
							<tr>
								<th scope="row">${p.id }</th>
								<td>${p.name }</td>
								<td>${p.description }</td>
								<td class="font-weight-bold">&#x20B9; ${p.price }</td>
								<td>
								<a href="delete/${p.id }" onclick="myFunction()"><i class="fas fa-trash-alt" style="font-size:30px;color:red
								"></i></a>
								<a href="update/${p.id }"><i class="fas fa-pen-nib" style="font-size:30px;color:blue
								"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="container text-center ">
					<div class="container text-center ">
							<a href="add-Product"  class="btn btn-primary"><b>ADD Product</b></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
