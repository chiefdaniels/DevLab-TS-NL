
<%@ page import="dev.lab.Auteur" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'auteur.label', default: 'Auteur')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-auteur" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-auteur" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list auteur">
			
				<g:if test="${auteurInstance?.achternaam}">
				<li class="fieldcontain">
					<span id="achternaam-label" class="property-label"><g:message code="auteur.achternaam.label" default="Achternaam" /></span>
					
						<span class="property-value" aria-labelledby="achternaam-label"><g:fieldValue bean="${auteurInstance}" field="achternaam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${auteurInstance?.voornaam}">
				<li class="fieldcontain">
					<span id="voornaam-label" class="property-label"><g:message code="auteur.voornaam.label" default="Voornaam" /></span>
					
						<span class="property-value" aria-labelledby="voornaam-label"><g:fieldValue bean="${auteurInstance}" field="voornaam"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${auteurInstance?.id}" />
					<g:link class="edit" action="edit" id="${auteurInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
