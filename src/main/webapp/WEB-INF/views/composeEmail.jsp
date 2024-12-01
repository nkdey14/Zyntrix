<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compose Email</title>
<link
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    rel="stylesheet">
<link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    rel="stylesheet">
<style>
body {
    background: linear-gradient(135deg, #f3e7e9 0%, #e3eeff 100%);
    min-height: 100vh;
    font-family: 'Arial', sans-serif;
}

.menu-container {
    width: 100%; /* Ensures the menu spans the full width */
}

.page-header {
    text-align: center;
    margin-top: 100px;
    color: #333;
    text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
}

.form-container {
    width: 50%;
    background-color: #fff;
    padding: 20px 30px;
    border-radius: 10px;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.btn-send {
    background-color: #007bff;
    color: #fff;
    transition: background-color 0.3s ease;
}

.btn-send:hover {
    background-color: #0056b3;
    color: #fff;
}

label {
    font-weight: bold;
    color: #555;
}

textarea, input {
    background-color: #f9f9f9;
    border: 1px solid #ddd;
    transition: box-shadow 0.3s ease;
}

textarea:focus, input:focus {
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.8);
    border-color: #007bff;
}

.message {
    color: #28a745;
    font-weight: bold;
}
</style>
</head>
<body>
    <!-- Include the navbar (menu.jsp) -->
    <div class="menu-container">
        <%-- Menu content from menu.jsp will be included here --%>
    </div>

    <!-- Form container for the Compose Email page -->
    <div class="form-container">
        <div class="page-header">
            <h2>Compose Email</h2>
        </div>
        <div class="message text-center">${msg}</div>
        <form action="composeEmail" method="post">
            <div class="form-group">
                <label for="email"><i class="fas fa-envelope"></i> To:</label>
                <input type="email" id="email" name="email" class="form-control" value="${email}" required>
            </div>
            <div class="form-group">
                <label for="subject"><i class="fas fa-heading"></i> Subject:</label>
                <input type="text" id="subject" name="subject" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="content"><i class="fas fa-pencil-alt"></i> Message:</label>
                <textarea id="content" name="content" rows="5" class="form-control" required></textarea>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-send"><i class="fas fa-paper-plane"></i> Send</button>
            </div>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
