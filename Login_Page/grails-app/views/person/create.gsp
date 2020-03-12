<%--
  Created by IntelliJ IDEA.
  User: spatel
  Date: 2/4/2020
  Time: 2:29 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en" class="no-js" xmlns:margin-top="http://www.w3.org/1999/xhtml">
<head>
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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Languages</a>
                <ul class="dropdown-menu">
                    <li><a href="/person/create?lang=hi_IN">Hindi</a></li>
                    <li><a href='/person/create?lang=en'>English</a></li>
                    <li><a href='/person/create?lang=es'>Spanish</a></li>
                    <li><a href='/person/create?lang=it'>Italian</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <g:if test="${flash.message}">
                <div class="alert alert-error" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.person}">
                <ul class="alert alert-success" role="alert" style="list-style-type: none">
                    <g:eachError bean="${this.person}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
        </div>

    <div id="signupbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title"><g:message code="prompt.signuponly"/></div>
                <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="/person/LoginPage"><g:message code="prompt.signin"/></a></div>
            </div>
            <div class="panel-body" >
                <form id="signupform" class="form-horizontal" role="form" action="/person/save" method="post">

                    <div id="signupalert" style="display:none" class="alert alert-danger">
                        <p>Error:</p>
                        <span></span>
                    </div>
                    <div class="form-group">
                        <label for="firstname" class="col-md-3 control"><g:message code="prompt.firstName"/></label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="firstName" placeholder="<g:message code="prompt.firstName"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-md-3 control"><g:message code="prompt.lastName"/></label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="lastName" placeholder="<g:message code="prompt.lastName"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-md-3 control"><g:message code="prompt.email"/></label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="emailAddress" placeholder="<g:message code="prompt.emailPlaceHolder"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="userName" class="col-md-3 control"><g:message code="prompt.userName"/></label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="userName" placeholder="<g:message code="prompt.userName"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-md-3 control"><g:message code="prompt.password"/></label>
                        <div class="col-md-8">
                            <input type="password" class="form-control" name="password" placeholder="<g:message code="prompt.password"/>">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword" class="col-md-3 control"><g:message code="prompt.retypepassword"/></label>
                        <div class="col-md-8">
                            <input type="password" class="form-control" name="confirmPassword" placeholder="<g:message code="prompt.retypepassword"/>">
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <button id="btn-signup" type="submit" name="create" id="create" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp<g:message code="prompt.signuponly"/></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<footer id="footer">
    <small id = "footerText"><g:message code="copyright.copyright"/></small>
</footer>
<asset:javascript src="application.js"/>
</body>
</html>