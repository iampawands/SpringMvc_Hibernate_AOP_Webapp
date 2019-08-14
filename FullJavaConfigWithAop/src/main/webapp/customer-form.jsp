<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
</div>
</div>

<div class="container">
<form:form action="processForm" modelAttribute="customer" method="POST">
  <div class="form-group">
    <label for="firstname">Email address</label>
    <form:input path="firstName" class="form-control" id="firstname" aria-describedby="emailHelp" placeholder="Enter first name"/>
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="lastname">Enter last name</label>
    <form:input path="lastName" class="form-control" id="lastname" placeholder="Enter last name"/>
  </div>
    <div class="form-group">
    <label for="emailpart">Enter email</label>
    <form:input path="email" class="form-control" id="emailpart" placeholder="Enter email"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
<br><br>
<p class="lead">
    <a class="btn btn-primary btn-md" href="customer/list" role="button">&larr; Back to list</a>
  </p>
</div>

<script src="${pageContext.request.contextPath}/resources/css/jquery.js" ></script>
<script src="${pageContext.request.contextPath}/resources/css/popper.min.js" ></script>
<script src="${pageContext.request.contextPath}/resources/css/bootstrap.js"></script>
</body>
</html>