<!doctype html>

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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Languages</a>
                    <ul class="dropdown-menu">
                        <li><a href="/person/notFound?lang=hi_IN">Hindi</a></li>
                        <li><a href='/person/notFound?lang=en'>English</a></li>
                        <li><a href='/person/notFound?lang=es'>Spanish</a></li>
                        <li><a href='/person/notFound?lang=it'>Italian</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
        <ul class="alert alert-danger" style="list-style-type: none">
            <li><g:message code="page.notfound"/></li>
            <li>Path: ${request.forwardURI}</li>
        </ul>
    <footer id="footer">
        <small id = "footerText"><g:message code="copyright.copyright"/></small>
    </footer>
    <asset:javascript src="application.js"/>
    </body>
</html>
