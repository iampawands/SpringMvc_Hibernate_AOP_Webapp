<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>CRM</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body>

<div class="jumbotron py-3">
<div class="container">
  <h1 class="heading">Customer Relationship Manager</h1> 
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="showFormForAdd" role="button">Add Customer &rarr;</a>
  </p>
</div>
</div>

<div class="container">
<table class="table table-striped border border-outline">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="customer" items="${customers}">
    
    <c:url var="updateLink" value="/customer/showFormForUpdate">
    <c:param name="customerId" value="${customer.id}"></c:param>
    </c:url>
    
    <c:url var="deleteLink" value="/customer/delete">
    <c:param name="customerId" value="${customer.id}"></c:param>
    </c:url>
    
	<tr>
	   <td>${customer.firstName}</td>
	   <td>${customer.lastName }</td>
	   <td>${customer.email}</td>
	   <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
	</tr>
	</c:forEach>
  </tbody>
</table>

</div>

<script src="${pageContext.request.contextPath}/resources/css/jquery.js" ></script>
<script src="${pageContext.request.contextPath}/resources/css/popper.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/css/bootstrap.js"></script>
</body>
</html>