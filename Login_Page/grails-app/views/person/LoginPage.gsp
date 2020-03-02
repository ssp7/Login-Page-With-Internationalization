<%--
  Created by IntelliJ IDEA.
  User: spatel
  Date: 2/4/2020
  Time: 2:29 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en" class="no-js">
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
                <a href="/person/LoginPage" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Languages</a>
                <ul class="dropdown-menu">
                    <li><a href="/?lang=hi_IN">Hindi</a></li>
                    <li><a href='/?lang=en'>English</a></li>
                    <li><a href='/?lang=es'>Spanish</a></li>
                    <li><a href='/?lang=it'>Italian</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <g:if test="${flash.message}">
            <div class="alert alert-danger" role="status">${flash.message}</div>
        </g:if>
        <g:hasErrors bean="${this.person}">
            <ul class="alert alert-danger" role="alert" style="list-style-type: none">
                <g:eachError bean="${this.person}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
        </g:hasErrors>
    </div>
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title"><g:message code="prompt.signin"/></div>

              <div style="float:right; font-size: 80%; position: relative; top:-10px">
                </div>
            </div>

            <div style="padding-top:30px" class="panel-body">

                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                <form id="login" class="form-horizontal" role="form" action="/person/LoginPage" method="post">

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="userName" type="text" class="form-control" name="userName"
                               placeholder="<g:message code="prompt.signin"/>">
                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="password" type="password" class="form-control" name="password"
                               placeholder="<g:message code="prompt.password"/>">
                    </div>


                    <div class="input-group">
                        <div class="checkbox">
                            <label>
                                <input id="login-remember" type="checkbox" name="remember" value="1"> <g:message
                                    code="prompt.rememberme"/>
                            </label>
                        </div>
                    </div>


                    <div style="margin-top:10px" class="form-group">
                        <!-- Button -->

                        <div class="col-sm-12 controls">
                            <input type="submit"  class="btn btn-success"
                                   value="<g:message code="prompt.login"/>" id=""/>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-md-12 control">
                            <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                                <g:message code="prompt.donthaveanaccount"/>
                                <a href="/person/create">
                                    <g:message code="prompt.signup"/>
                                </a>

                            </div>
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