<%--
  Created by IntelliJ IDEA.
  User: spatel
  Date: 2/18/2020
  Time: 11:18 AM
--%>
<!DOCTYPE html>
<%@ page import="loginpage.AdminController; org.springframework.validation.FieldError;" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <asset:stylesheet src="application.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
    <title>Persons</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:stylesheet src="grails.css.css"/>
    <asset:stylesheet src="main.css"/>
    <asset:stylesheet src="mobile.css"/>
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="LoginPage.css"/>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <asset:javascript src="application.js"/>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
    <asset:image src="Talent-plus-logo-2018.png"/>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
        <ul class="nav navbar-nav ml-auto">
            <li class="dropdown">
                <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Languages</a>
                <ul class="dropdown-menu">
                    <li><a href="/admin/List?lang=hi_IN">Hindi</a></li>
                    <li><a href='/admin/List?lang=en'>English</a></li>
                    <li><a href='/admin/List?lang=es'>Spanish</a></li>
                    <li><a href='/admin/List?lang=it'>Italian</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
<div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="nav" role="navigation">
        <ul>
            <li><g:link class="create" controller="admin"  action="create"><g:message code="default.create.label" args="['User']"/></g:link></li>
        </ul>
    </div>
    <g:if test="${flash.message}">
        <div class="alert alert-success" role="status">${flash.message}</div>
    </g:if>
</div>
</div>
    <table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
    <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>User Name</th>
    <th>Email Address</th>
    <th>Password</th>
</tr>
    </thead>
        <tbody>
<g:each in = "${list}" var = "person" status="i">
      <tr>
          <td>${person.firstName}</td>
          <td>${person.lastName}</td>
          <td>${person.username}</td>
          <td>${person.emailAddress}</td>
          <td>${person.password}</td>

      </tr>
</g:each>
        <script src = "https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
        <script src = "https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script>
        <script>
            var ready = $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
    </tbody>
    </table>
</body>
</html>
