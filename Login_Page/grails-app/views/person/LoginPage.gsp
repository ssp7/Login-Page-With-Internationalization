<%--
  Created by IntelliJ IDEA.
  User: spatel
  Date: 2/4/2020
  Time: 2:29 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <asset:stylesheet src="LoginPage.css"/>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <div class="header">
        <asset:image src="Talent-plus-logo-2018.png"/>
        <content tag="nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                   aria-expanded="false"><g:message code="language" default="Languages"/> <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <navBar:localeDropdownListItems
                            uri="${request.forwardURI}">Languages</navBar:localeDropdownListItems>
                </ul>
            </li>
        </content>
    </div>

</head>

<body>
<div class="container">

    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title"><g:message code="prompt.signin"/></div>

                <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a>
                </div>
            </div>

            <div style="padding-top:30px" class="panel-body">

                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                <form id="login" class="form-horizontal" role="form" action="/person/show" method="post">

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
                            <input type="submit" name="show" class="btn btn-success"
                                   value="<g:message code="prompt.login"/>" id=""/>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-md-12 control">
                            <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                                <g:message code="prompt.donthaveanaccount"/>
                                <a href="person/create" onClick="$('#loginbox').hide();
                                $('').show()">
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

<footer class = "footer">
    <g:message code="copyright.copyright"/>
</footer>
</body>
</html>