<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>List of Leads</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        .page-header {
            margin: 20px 0;
            text-align: center;
        }
        .table-container {
            margin: 20px auto;
            max-width: 90%;
        }
        table {
            background-color: white;
            border-radius: 5px;
            overflow: hidden;
        }
        th {
            background-color: #007bff;
            color: white;
            text-align: center;
        }
        td {
            text-align: center;
        }
        .table-responsive {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .text-danger {
            font-size: 1.2rem;
        }
    </style>
</head>
<body class="bg-light">
    <div class="menu-container">
        <%-- Menu content from menu.jsp will be included here --%>
    </div>
    <div class="page-header">
        <h2>List of Leads</h2>
    </div>
    <div class="message" align="center">${msg}</div>
    <div class="table-container">
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Gender</th>
                        <th>Email ID</th>
                        <th>Mob No.</th>
                        <th>City</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="lead" items="${leads}">
                        <tr>
                            <td>${lead.firstName}</td>
                            <td>${lead.lastName}</td>
                            <td>${lead.gender}</td>
                            <td>${lead.email}</td>
                            <td>${lead.mobile}</td>
                            <td>${lead.city}</td>
                            <td>
                                <a href="deleteLead?id=${lead.id}" class="text-danger" title="Delete Lead">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
