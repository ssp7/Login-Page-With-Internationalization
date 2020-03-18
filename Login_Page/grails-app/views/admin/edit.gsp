<%@ page import="org.springframework.validation.FieldError" %>
<!DOCTYPE html>
<html>
    <head>
        <asset:stylesheet src="application.css"/>
        <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />

        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>

<body>

<div id="edit-person" class="content scaffold-edit" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.person}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.person}" var="error">
                <li <g:if test="${error in FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
        <g:form controller="admin" action="update"  method="PUT">
        <g:hiddenField name="id" value="${this.person?.id}" />
        <fieldset class="form">
            <f:all bean="person"/>
        </fieldset>
        <fieldset class="buttons">
            <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
        </fieldset>
    </g:form>
        </div>
    </body>
</html>
