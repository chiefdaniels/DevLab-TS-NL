
<%@ page import="dev.lab.qmra.Critical_Condition" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'critical_Condition.label', default: 'Critical_Condition')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-critical_Condition" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-critical_Condition" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="conditionId" title="${message(code: 'critical_Condition.conditionId.label', default: 'Condition Id')}" />
					
						<g:sortableColumn property="conditionType" title="${message(code: 'critical_Condition.conditionType.label', default: 'Condition Type')}" />
					
						<g:sortableColumn property="organismType" title="${message(code: 'critical_Condition.organismType.label', default: 'Organism Type')}" />
					
						<g:sortableColumn property="organism" title="${message(code: 'critical_Condition.organism.label', default: 'Organism')}" />
					
						<g:sortableColumn property="organismTarget" title="${message(code: 'critical_Condition.organismTarget.label', default: 'Organism Target')}" />
					
						<g:sortableColumn property="processType" title="${message(code: 'critical_Condition.processType.label', default: 'Process Type')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${critical_ConditionInstanceList}" status="i" var="critical_ConditionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${critical_ConditionInstance.id}">${fieldValue(bean: critical_ConditionInstance, field: "conditionId")}</g:link></td>
					
						<td>${fieldValue(bean: critical_ConditionInstance, field: "conditionType")}</td>
					
						<td>${fieldValue(bean: critical_ConditionInstance, field: "organismType")}</td>
					
						<td>${fieldValue(bean: critical_ConditionInstance, field: "organism")}</td>
					
						<td>${fieldValue(bean: critical_ConditionInstance, field: "organismTarget")}</td>
					
						<td>${fieldValue(bean: critical_ConditionInstance, field: "processType")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${critical_ConditionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
