
<%@ page import="net.atos.devlapp.verkoper.Verkoper" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'verkoper.label', default: 'Verkoper')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-verkoper" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-verkoper" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="verkoperID" title="${message(code: 'verkoper.verkoperID.label', default: 'Verkoper ID')}" />
					
						<g:sortableColumn property="voornaam" title="${message(code: 'verkoper.voornaam.label', default: 'Voornaam')}" />
					
						<g:sortableColumn property="achternaam" title="${message(code: 'verkoper.achternaam.label', default: 'Achternaam')}" />
					
						<g:sortableColumn property="telefoonnummer" title="${message(code: 'verkoper.telefoonnummer.label', default: 'Telefoonnummer')}" />
					
						<g:sortableColumn property="emailadres" title="${message(code: 'verkoper.emailadres.label', default: 'Emailadres')}" />
					
						<g:sortableColumn property="geboortedatum" title="${message(code: 'verkoper.geboortedatum.label', default: 'Geboortedatum')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${verkoperInstanceList}" status="i" var="verkoperInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${verkoperInstance.id}">${fieldValue(bean: verkoperInstance, field: "verkoperID")}</g:link></td>
					
						<td>${fieldValue(bean: verkoperInstance, field: "voornaam")}</td>
					
						<td>${fieldValue(bean: verkoperInstance, field: "achternaam")}</td>
					
						<td>${fieldValue(bean: verkoperInstance, field: "telefoonnummer")}</td>
					
						<td>${fieldValue(bean: verkoperInstance, field: "emailadres")}</td>
					
						<td><g:formatDate format="dd MMM yyyy" date="${verkoperInstance.geboortedatum}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${verkoperInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
