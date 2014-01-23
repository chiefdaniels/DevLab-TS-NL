
<%@ page import="dev.lab.tutorial.Boek" %>
<!DOCTYPE html>
<html>
	<head>
        <meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'boek.label', default: 'Boek')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-boek" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-boek" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="ISBN" title="${message(code: 'boek.ISBN.label', default: 'ISBN')}" />
					
						<g:sortableColumn property="titel" title="${message(code: 'boek.titel.label', default: 'Titel')}" />
					
						<th><g:message code="boek.auteur.label" default="Auteur" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${boekInstanceList}" status="i" var="boekInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${boekInstance.id}">${fieldValue(bean: boekInstance, field: "ISBN")}</g:link></td>
					
						<td>${fieldValue(bean: boekInstance, field: "titel")}</td>
					
						<td>${fieldValue(bean: boekInstance, field: "auteur")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${boekInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
