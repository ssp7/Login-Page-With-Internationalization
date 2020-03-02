<!DOCTYPE html>
<html>
    <head>
        <asset:stylesheet src="application.css"/>
        <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
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
                        <li><a href="/person/show?lang=hi_IN">Hindi</a></li>
                        <li><a href='/person/show?lang=en'>English</a></li>
                        <li><a href='/person/show?lang=es'>Spanish</a></li>
                        <li><a href='/person/show?lang=it'>Italian</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
        <div id="show-person" class="content scaffold-show" role="main">
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
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <f:display bean="person" />
            <g:form resource="${this.person}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.person}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    <footer id="footer">
        <small id = "footerText"><g:message code="copyright.copyright"/></small>
    </footer>
    <asset:javascript src="application.js"/>
    </body>
</html>
