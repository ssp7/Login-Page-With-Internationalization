<%--
  Created by IntelliJ IDEA.
  User: spatel
  Date: 2/18/2020
  Time: 11:18 AM
--%>
<!DOCTYPE html>
<%@ page import="login_page.PersonController" contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
    <title>Persons</title>
</head>

<body>

    <table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
    <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>User Name</th>
    <th>Email Address</th>
    <th>Password</th>
</tr>
    </thead>>
        <tbody>
<g:each in = "${list}" var = "person" status="i">
      <tr>
          <td>${person.firstName}</td>
          <td>${person.lastName}</td>
          <td>${person.userName}</td>
          <td>${person.emailAddress}</td>
          <td>${person.password}</td>

      </tr>
</g:each>
    </tbody>
    </table>
<script src ="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src = "https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src = "https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script>
<script>
    var ready = $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
</body>
</html>
