
<%@ page import="net.atos.devLapp.artikel.Artikel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'artikel.label', default: 'Artikel')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-artikel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-artikel" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list artikel">
			
				<g:if test="${artikelInstance?.artikelNummer}">
				<li class="fieldcontain">
					<span id="artikelNummer-label" class="property-label"><g:message code="artikel.artikelNummer.label" default="Artikel Nummer" /></span>
					
						<span class="property-value" aria-labelledby="artikelNummer-label"><g:fieldValue bean="${artikelInstance}" field="artikelNummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artikelInstance?.artikelNaam}">
				<li class="fieldcontain">
					<span id="artikelNaam-label" class="property-label"><g:message code="artikel.artikelNaam.label" default="Artikel Naam" /></span>
					
						<span class="property-value" aria-labelledby="artikelNaam-label"><g:fieldValue bean="${artikelInstance}" field="artikelNaam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artikelInstance?.artikelOmschrijving}">
				<li class="fieldcontain">
					<span id="artikelOmschrijving-label" class="property-label"><g:message code="artikel.artikelOmschrijving.label" default="Artikel Omschrijving" /></span>
					
						<span class="property-value" aria-labelledby="artikelOmschrijving-label"><g:fieldValue bean="${artikelInstance}" field="artikelOmschrijving"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${artikelInstance?.categorieCode}">
				<li class="fieldcontain">
					<span id="categorieCode-label" class="property-label"><g:message code="artikel.categorieCode.label" default="Categorie Code" /></span>
					
						<span class="property-value" aria-labelledby="categorieCode-label"><g:fieldValue bean="${artikelInstance}" field="categorieCode"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:artikelInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${artikelInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
