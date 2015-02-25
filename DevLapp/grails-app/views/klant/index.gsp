
<%@ page import="net.atos.devlapp.klant.Klant" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'klant.label', default: 'Klant')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-klant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-klant" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="klantnummer" title="${message(code: 'klant.klantnummer.label', default: 'Klantnummer')}" />
					
						<g:sortableColumn property="bedrijfsnaam" title="${message(code: 'klant.bedrijfsnaam.label', default: 'Bedrijfsnaam')}" />
					
						<g:sortableColumn property="voornaam" title="${message(code: 'klant.voornaam.label', default: 'Voornaam')}" />
					
						<g:sortableColumn property="achternaam" title="${message(code: 'klant.achternaam.label', default: 'Achternaam')}" />
					
						<g:sortableColumn property="straatnaam" title="${message(code: 'klant.straatnaam.label', default: 'Straatnaam')}" />
					
						<g:sortableColumn property="huisnummer" title="${message(code: 'klant.huisnummer.label', default: 'Huisnummer')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${klantInstanceList}" status="i" var="klantInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${klantInstance.id}">${fieldValue(bean: klantInstance, field: "klantnummer")}</g:link></td>
					
						<td>${fieldValue(bean: klantInstance, field: "bedrijfsnaam")}</td>
					
						<td>${fieldValue(bean: klantInstance, field: "voornaam")}</td>
					
						<td>${fieldValue(bean: klantInstance, field: "achternaam")}</td>
					
						<td>${fieldValue(bean: klantInstance, field: "straatnaam")}</td>
					
						<td>${fieldValue(bean: klantInstance, field: "huisnummer")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${klantInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
