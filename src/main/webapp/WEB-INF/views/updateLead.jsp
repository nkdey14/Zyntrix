<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lead Details</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
/* Style for the navbar */
.navbar {
	background-color: #007bff; /* Primary color */
}

.navbar-brand, .nav-link {
	color: white !important;
}

.nav-link:hover {
	background-color: rgba(255, 255, 255, 0.2);
	border-radius: 4px;
}

/* Main content area */
.main-content {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: calc(100vh - 56px); /* Adjusted for navbar height */
	background-color: #f0f2f5; /* Light gray background */
}

/* Form container styles */
.form-container {
	background-color: #ffffff;
	padding: 2rem;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

/* Text styling */
h2, label {
	color: #333;
}
</style>
</head>
<body>
	<!-- Main Content -->
	<div class="main-content">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 form-container">
					<h2 class="text-center mb-4">Update Lead Details</h2>
					<form action="updateLeadData" method="post" enctype="multipart/form-data">

						<div class="form-group">
							 <input type="hidden"
								class="form-control" id="id" name="id"
								value="${lead.id}">
						</div>
						
						<div class="form-group">
							<label for="firstName">First Name</label> 
							<input type="text"
								class="form-control" id="firstName" name="firstName"
								value="${lead.firstName}" required>
						</div>

						<div class="form-group">
							<label for="lastName">Last Name</label> 
							<input type="text"
								class="form-control" id="lastName" name="lastName" value="${lead.lastName}" required>
						</div>

						<div class="form-group">
							<label for="gender">Gender</label> 
							<input type="text"
								class="form-control" id="gender" name="gender" value="${lead.gender}" required>
						</div>

						<div class="form-group">
							<label for="email">Email ID</label> 
							<input type="email"
								class="form-control" id="email" name="email" value="${lead.email}" required>
						</div>

						<div class="form-group">
							<label for="mobile">Mob No.</label> 
							<input type="text"
								class="form-control" id="mobile" name="mobile" value="${lead.mobile}" required>
						</div>

						<div class="form-group">
							<label for="city">City</label> 
							<input type="text"
								class="form-control" id="city" name="city" value="${lead.city}" required>
						</div>

						<div class="d-flex justify-content-between">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
