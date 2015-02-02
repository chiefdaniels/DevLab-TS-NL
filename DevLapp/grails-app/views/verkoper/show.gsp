
<%@ page import="net.atos.devlapp.verkoper.Verkoper" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'verkoper.label', default: 'Verkoper')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-verkoper" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-verkoper" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list verkoper">
			
				<g:if test="${verkoperInstance?.verkoperID}">
				<li class="fieldcontain">
					<span id="verkoperID-label" class="property-label"><g:message code="verkoper.verkoperID.label" default="Verkoper ID" /></span>
					
						<span class="property-value" aria-labelledby="verkoperID-label"><g:fieldValue bean="${verkoperInstance}" field="verkoperID"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${verkoperInstance?.voornaam}">
				<li class="fieldcontain">
					<span id="voornaam-label" class="property-label"><g:message code="verkoper.voornaam.label" default="Voornaam" /></span>
					
						<span class="property-value" aria-labelledby="voornaam-label"><g:fieldValue bean="${verkoperInstance}" field="voornaam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${verkoperInstance?.achternaam}">
				<li class="fieldcontain">
					<span id="achternaam-label" class="property-label"><g:message code="verkoper.achternaam.label" default="Achternaam" /></span>
					
						<span class="property-value" aria-labelledby="achternaam-label"><g:fieldValue bean="${verkoperInstance}" field="achternaam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${verkoperInstance?.telefoonnummer}">
				<li class="fieldcontain">
					<span id="telefoonnummer-label" class="property-label"><g:message code="verkoper.telefoonnummer.label" default="Telefoonnummer" /></span>
					
						<span class="property-value" aria-labelledby="telefoonnummer-label"><g:fieldValue bean="${verkoperInstance}" field="telefoonnummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${verkoperInstance?.emailadres}">
				<li class="fieldcontain">
					<span id="emailadres-label" class="property-label"><g:message code="verkoper.emailadres.label" default="Emailadres" /></span>
					
						<span class="property-value" aria-labelledby="emailadres-label"><g:fieldValue bean="${verkoperInstance}" field="emailadres"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${verkoperInstance?.geboortedatum}">
				<li class="fieldcontain">
					<span id="geboortedatum-label" class="property-label"><g:message code="verkoper.geboortedatum.label" default="Geboortedatum" /></span>
																					
						<span class="property-value" aria-labelledby="geboortedatum-label"><g:formatDate format="dd MMM yyyy" date="${verkoperInstance?.geboortedatum}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${verkoperInstance?.salaris}">
				<li class="fieldcontain">
					<span id="salaris-label" class="property-label"><g:message code="verkoper.salaris.label" default="Salaris" /></span>
					
						<span class="property-value" aria-labelledby="salaris-label"><g:fieldValue bean="${verkoperInstance}" field="salaris"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:verkoperInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${verkoperInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
