<!DOCTYPE html>
<html>
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
        <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
    <asset:image src="Talent-plus-logo-2018.png"/>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
        <ul class="nav navbar-nav ml-auto">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Languages <span class="caret"></span></a>
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
</header>
<div id="create-person" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.person}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.person}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.person}" method="POST">
                <fieldset class="form">
                    <f:all bean="person"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
<asset:javascript src="application.js"/>
    </body>
</html>
