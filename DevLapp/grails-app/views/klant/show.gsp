
<%@ page import="net.atos.klant.Klant" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'klant.label', default: 'Klant')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-klant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-klant" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list klant">
			
				<g:if test="${klantInstance?.klantnummer}">
				<li class="fieldcontain">
					<span id="klantnummer-label" class="property-label"><g:message code="klant.klantnummer.label" default="Klantnummer" /></span>
					
						<span class="property-value" aria-labelledby="klantnummer-label"><g:fieldValue bean="${klantInstance}" field="klantnummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${klantInstance?.bedrijfsnaam}">
				<li class="fieldcontain">
					<span id="bedrijfsnaam-label" class="property-label"><g:message code="klant.bedrijfsnaam.label" default="Bedrijfsnaam" /></span>
					
						<span class="property-value" aria-labelledby="bedrijfsnaam-label"><g:fieldValue bean="${klantInstance}" field="bedrijfsnaam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${klantInstance?.voornaam}">
				<li class="fieldcontain">
					<span id="voornaam-label" class="property-label"><g:message code="klant.voornaam.label" default="Voornaam" /></span>
					
						<span class="property-value" aria-labelledby="voornaam-label"><g:fieldValue bean="${klantInstance}" field="voornaam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${klantInstance?.achternaam}">
				<li class="fieldcontain">
					<span id="achternaam-label" class="property-label"><g:message code="klant.achternaam.label" default="Achternaam" /></span>
					
						<span class="property-value" aria-labelledby="achternaam-label"><g:fieldValue bean="${klantInstance}" field="achternaam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${klantInstance?.straatnaam}">
				<li class="fieldcontain">
					<span id="straatnaam-label" class="property-label"><g:message code="klant.straatnaam.label" default="Straatnaam" /></span>
					
						<span class="property-value" aria-labelledby="straatnaam-label"><g:fieldValue bean="${klantInstance}" field="straatnaam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${klantInstance?.huisnummer}">
				<li class="fieldcontain">
					<span id="huisnummer-label" class="property-label"><g:message code="klant.huisnummer.label" default="Huisnummer" /></span>
					
						<span class="property-value" aria-labelledby="huisnummer-label"><g:fieldValue bean="${klantInstance}" field="huisnummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${klantInstance?.huisnummertoevoeging}">
				<li class="fieldcontain">
					<span id="huisnummertoevoeging-label" class="property-label"><g:message code="klant.huisnummertoevoeging.label" default="Huisnummertoevoeging" /></span>
					
						<span class="property-value" aria-labelledby="huisnummertoevoeging-label"><g:fieldValue bean="${klantInstance}" field="huisnummertoevoeging"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${klantInstance?.postcode}">
				<li class="fieldcontain">
					<span id="postcode-label" class="property-label"><g:message code="klant.postcode.label" default="Postcode" /></span>
					
						<span class="property-value" aria-labelledby="postcode-label"><g:fieldValue bean="${klantInstance}" field="postcode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${klantInstance?.woonplaats}">
				<li class="fieldcontain">
					<span id="woonplaats-label" class="property-label"><g:message code="klant.woonplaats.label" default="Woonplaats" /></span>
					
						<span class="property-value" aria-labelledby="woonplaats-label"><g:fieldValue bean="${klantInstance}" field="woonplaats"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${klantInstance?.telefoonnummer}">
				<li class="fieldcontain">
					<span id="telefoonnummer-label" class="property-label"><g:message code="klant.telefoonnummer.label" default="Telefoonnummer" /></span>
					
						<span class="property-value" aria-labelledby="telefoonnummer-label"><g:fieldValue bean="${klantInstance}" field="telefoonnummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${klantInstance?.emailadres}">
				<li class="fieldcontain">
					<span id="emailadres-label" class="property-label"><g:message code="klant.emailadres.label" default="Emailadres" /></span>
					
						<span class="property-value" aria-labelledby="emailadres-label"><g:fieldValue bean="${klantInstance}" field="emailadres"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:klantInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${klantInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
