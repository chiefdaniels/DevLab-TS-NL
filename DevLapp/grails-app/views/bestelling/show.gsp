
<%@ page import="net.atos.devlapp.bestelling.Bestelling" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bestelling.label', default: 'Bestelling')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bestelling" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bestelling" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bestelling">
			
				<g:if test="${bestellingInstance?.bestelnummer}">
				<li class="fieldcontain">
					<span id="bestelnummer-label" class="property-label"><g:message code="bestelling.bestelnummer.label" default="Bestelnummer" /></span>
					
						<span class="property-value" aria-labelledby="bestelnummer-label"><g:fieldValue bean="${bestellingInstance}" field="bestelnummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bestellingInstance?.verkoper}">
				<li class="fieldcontain">
					<span id="verkoper-label" class="property-label"><g:message code="bestelling.verkoper.label" default="Verkoper" /></span>
					
						<span class="property-value" aria-labelledby="verkoper-label"><g:link controller="verkoper" action="show" id="${bestellingInstance?.verkoper?.id}">${bestellingInstance?.verkoper?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${bestellingInstance?.klant}">
				<li class="fieldcontain">
					<span id="klant-label" class="property-label"><g:message code="bestelling.klant.label" default="Klant" /></span>
					
						<span class="property-value" aria-labelledby="klant-label"><g:link controller="klant" action="show" id="${bestellingInstance?.klant?.id}">${bestellingInstance?.klant?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:bestellingInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${bestellingInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
