
<%@ page import="net.atos.devlapp.bestelling.Bestelling" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bestelling.label', default: 'Bestelling')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-bestelling" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-bestelling" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="bestelnummer" title="${message(code: 'bestelling.bestelnummer.label', default: 'Bestelnummer')}" />
					
						<th><g:message code="bestelling.verkoper.label" default="Verkoper" /></th>
					
						<th><g:message code="bestelling.klant.label" default="Klant" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bestellingInstanceList}" status="i" var="bestellingInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${bestellingInstance.id}">${fieldValue(bean: bestellingInstance, field: "bestelnummer")}</g:link></td>
					
						<td>${fieldValue(bean: bestellingInstance, field: "verkoper")}</td>
					
						<td>${fieldValue(bean: bestellingInstance, field: "klant")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bestellingInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
