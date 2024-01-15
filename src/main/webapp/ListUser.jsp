<%@ page import="java.util.ArrayList" %>
<%@ page import="com.gestiondeproduits.UserBeans" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.gestiondeproduits.metier.User" %>
<%@ page import="com.gestiondeproduits.UserBeans" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <a href="AddUser.jsp" class="btn btn-primary m-2">Ajout</a>

    <table class="table table-bordered">
        <thead class="table-dark">
        <tr>
            <th>Id</th>
            <th>Username</th>
            <th>Password</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            UserBeans authBeans = (UserBeans) request.getAttribute("modele");
            Iterator<User> users = authBeans.getUsers().iterator();
            while(users.hasNext()) {
                User u = users.next();
        %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getUsername() %></td>
            <td><%= u.getPassword() %></td>
            <td>
                <button class="btn btn-danger" onclick="confirmDelete(<%= u.getId() %>)">Supprimer</button>
                <a href="updateUser?userId=<%= u.getId() %>" class="btn btn-warning">Modifier</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<script>
    function confirmDelete(userId) {
        var confirmation = confirm("Are you sure you want to delete user with ID: " + userId + "?");

        if (confirmation) {
            window.location.href = "deleteUser?userId=" + userId;
        }
    }
</script>
<!-- Include Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
