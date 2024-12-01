<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Leads</title>
<link
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    rel="stylesheet">
<link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    rel="stylesheet">
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

.pagination {
    display: flex;
    justify-content: center;
    margin: 20px 0;
}
.pagination a {
    color: #007bff;
    padding: 8px 12px;
    text-decoration: none;
    border: 1px solid #ddd;
    margin: 0 2px;
    border-radius: 5px;
}
.pagination a.active {
    background-color: #007bff;
    color: white;
    border: 1px solid #007bff;
}
.pagination a:hover {
    background-color: #ddd;
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
                        <th>Full Name</th>
                        <th>Edit</th>
                        <th>Remove</th>
                        <th>Export</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="lead" items="${leads}">
                        <tr>
                            <td><a href="leadInfo?id=${lead.id}">${lead.firstName} ${lead.lastName}</a></td>
                            <td><a href="updateLead?id=${lead.id}" class="text-primary"
                                title="Update Lead"> <i class="fas fa-pencil-alt"></i>
                            </a></td>
                            <td><a href="deleteLead?id=${lead.id}" class="text-danger"
                                title="Delete Lead"> <i class="fas fa-trash-alt"></i>
                            </a></td>
                            <td><a href="exportToPdf?id=${lead.id}"
                                class="btn btn-success btn-sm" title="Export to PDF"> <i
                                    class="fas fa-file-pdf"></i> Export to PDF
                            </a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Pagination Controls -->
    <div class="pagination">
        <c:if test="${currentPage > 0}">
            <a href="?page=${currentPage - 1}&size=4">&laquo; Previous</a>
        </c:if>
        <c:forEach var="i" begin="0" end="${totalPages - 1}">
            <a href="?page=${i}&size=4" class="${i == currentPage ? 'active' : ''}">
                ${i + 1}
            </a>
        </c:forEach>
        <c:if test="${currentPage < totalPages - 1}">
            <a href="?page=${currentPage + 1}&size=4">Next &raquo;</a>
        </c:if>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
