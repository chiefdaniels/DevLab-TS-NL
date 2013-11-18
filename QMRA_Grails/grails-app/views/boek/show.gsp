
<%@ page import="dev.lab.Boek" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'boek.label', default: 'Boek')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-boek" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-boek" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list boek">
			
				<g:if test="${boekInstance?.ISBN}">
				<li class="fieldcontain">
					<span id="ISBN-label" class="property-label"><g:message code="boek.ISBN.label" default="ISBN" /></span>
					
						<span class="property-value" aria-labelledby="ISBN-label"><g:fieldValue bean="${boekInstance}" field="ISBN"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${boekInstance?.auteur}">
				<li class="fieldcontain">
					<span id="auteur-label" class="property-label"><g:message code="boek.auteur.label" default="Auteur" /></span>
					
						<span class="property-value" aria-labelledby="auteur-label"><g:link controller="auteur" action="show" id="${boekInstance?.auteur?.id}">${boekInstance?.auteur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${boekInstance?.titel}">
				<li class="fieldcontain">
					<span id="titel-label" class="property-label"><g:message code="boek.titel.label" default="Titel" /></span>
					
						<span class="property-value" aria-labelledby="titel-label"><g:fieldValue bean="${boekInstance}" field="titel"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${boekInstance?.id}" />
					<g:link class="edit" action="edit" id="${boekInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
