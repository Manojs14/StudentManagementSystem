<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Student Form</title>
<style>
  
 
    .custom-navbar {
        background-color: #5D6D7E  ; 
        border-radius:5px;
    }
    .custom-navbar .nav-link {
        color: #fff; 
    }
    .custom-navbar .nav-link.active {
        color: #fff;
    }
    h1 {
  text-align: center;
}
</style>
 


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>





<!-- nav bar to navigate from addpage to viewpage -->
	<nav class="navbar navbar-expand-lg custom-navbar">
		<div class="container-fluid">

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">AddStudent</a></li>
					<li class="nav-item"><a class="nav-link" href="ReadServlet">ViewStudents</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	
	
	
<!-- Form which uses bootstrap rows and colm for form placement -->
 <div class="row">
    <div class="col-4">
    </div>
    <div class="col-4" style="padding:50px">
        <h1 >Add Student</h1>
        
        
        <!-- form is mapped to createservlet using @WebServlet -->
     <form action="CreateServlet" method="post">
  <div class="mb-3">
    <label for="username" class="form-label">Name </label>
    <input type="text" class="form-control" id="name1" name="name" aria-describedby="text" placeholder="Enter The Student's Name" required>
  </div>
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" name="email" required id="email" aria-describedby="emailHelp" placeholder="Enter The Email Address" required>
  </div>
  <div class="mb-3">
    <label for="number" class="form-label">Age</label>
    <input type="number" class="form-control" name="age" required id="age" placeholder="Enter The age" required>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div> 
</div> 







 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
 
</body>
