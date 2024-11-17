<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lead Details</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Background color for the whole page */
        body {
            background-color: #f0f2f5; /* Light background color */
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        /* Container for lead details */
        .form-container {
            background-color: #ffffff;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 600px;
        }

        /* Styling for message */
        .message {
            color: blue;
            font-weight: bold;
            text-align: center;
            margin-bottom: 1.5rem;
        }

        /* Styling for table-like layout without borders */
        .details-table {
            width: 100%;
        }
        .details-table td {
            padding: 0.5rem;
        }
        .label {
            font-weight: bold;
            color: #555;
        }

        /* Back button styling */
        .back-button {
            margin-top: 1.5rem;
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="menu-container">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="container mt-5 d-flex justify-content-center align-items-center">
        <div class="form-container">
            <h2 class="text-center mb-4">Lead Details</h2>
            
            <!-- Display message -->
            <div class="message">${msg}</div>

            <!-- Lead details in a table format without borders -->
            <table class="details-table">
                <tr>
                    <td class="label">First Name</td>
                    <td>${lead.firstName}</td>
                </tr>
                <tr>
                    <td class="label">Last Name</td>
                    <td>${lead.lastName}</td>
                </tr>
                <tr>
                    <td class="label">Gender</td>
                    <td>${lead.gender}</td>
                </tr>
                <tr>
                    <td class="label">Email ID</td>
                    <td>${lead.email}</td>
                </tr>
                <tr>
                    <td class="label">Mob No.</td>
                    <td>${lead.mobile}</td>
                </tr>
                <tr>
                    <td class="label">City</td>
                    <td>${lead.city}</td>
                </tr>
            </table>

            <!-- Back button -->
            <div class="back-button">
                <a href="newLead.jsp" class="btn btn-secondary">Back</a>
            </div> 
        </div>
    </div>
</body>
</html>
