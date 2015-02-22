
<%@ page import="net.atos.devlapp.artikel.Artikel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'artikel.label', default: 'Artikel')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-artikel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-artikel" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="artikelNummer" title="${message(code: 'artikel.artikelNummer.label', default: 'Artikel Nummer')}" />
					
						<g:sortableColumn property="artikelNaam" title="${message(code: 'artikel.artikelNaam.label', default: 'Artikel Naam')}" />
					
						<g:sortableColumn property="artikelOmschrijving" title="${message(code: 'artikel.artikelOmschrijving.label', default: 'Artikel Omschrijving')}" />
					
						<g:sortableColumn property="categorieCode" title="${message(code: 'artikel.categorieCode.label', default: 'Categorie Code')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${artikelInstanceList}" status="i" var="artikelInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${artikelInstance.id}">${fieldValue(bean: artikelInstance, field: "artikelNummer")}</g:link></td>
					
						<td>${fieldValue(bean: artikelInstance, field: "artikelNaam")}</td>
					
						<td>${fieldValue(bean: artikelInstance, field: "artikelOmschrijving")}</td>
					
						<td>${fieldValue(bean: artikelInstance, field: "categorieCode")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${artikelInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
