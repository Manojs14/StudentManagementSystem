<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Display Data</title>
    
    <style>
       body {
            font-family: Arial, sans-serif;
             background-color: #D6DBDF;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        
        th {
            background-color: #95A5A6;
        }
        tr:nth-child(even) {
            background-color: #D5DBDB;
        }
           tr:hover {
            background-color: #f1f1f1; /* Hover effect for rows */
        }
        
        .actions {
            white-space: nowrap;
        }
  .Edit{
  background-color:rgb(60, 179, 113);
  cursor: pointer;
  border-radius: 5px;
  width: 3.5rem;
  height: 1.7rem;
  }
  .delete{
  background-color:rgb(255, 51, 51);
  cursor: pointer;
  border-radius: 5px;
  width: 4.2rem;
  height: 1.7rem;
  }
    .custom-navbar {
        background-color: #5D6D7E  ; 
        border-radius:5px;
    }
    .custom-navbar .nav-link {
        color: #fff; 
    }
    .custom-navbar .nav-link.active {
        color: #d4d4d4;
    }
    h2 {
  text-align: center;
}
  
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>







<%System.out.println("Firest line iif list.jsp"); %>

<!--  nav bar to navigate from addpage to viewpage  -->
	<nav class="navbar navbar-expand-lg custom-navbar">
		<div class="container-fluid">

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">AddStudent</a></li>
					<li class="nav-item"><a class="nav-link" >ViewStudents</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	
	
	
	
	
<!-- The displaying of data  after receiving the userdatalist from the request -->

    <h2 >Student Data from Database</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
             <c:forEach var="row" items="${data}">
                <tr>
                    <td>${row.id}</td>
                    <td>${row.name}</td>
                    <td>${row.email}</td>
                    <td>${row.age}</td>
                    <td class="actions">
                        <button class="Edit" onclick="editRecord('${row.id}', '${row.name}', '${row.email}', '${row.age}')">Edit</button>
                        <button class="delete" onclick="deleteRow('${row.id}')">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    
    
  <!-- function is written to handle the event to forward the parameters   --> 
    <script>
    function editRecord(id, name, email, age) {
        // Navigate to UpdateServlet with parameters
        window.location.href = 'update.jsp?id=' + id +
                                '&name=' + encodeURIComponent(name) +
                                '&email=' + encodeURIComponent(email) +
                                '&age=' + age;
    }
        function deleteRow(id) {
            // Redirect to UpdateServlet with the id parameter
            window.location.href = 'DeleteServlet?id=' + id;
        }
    </script>
    
</body>
      
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
 
</html>
