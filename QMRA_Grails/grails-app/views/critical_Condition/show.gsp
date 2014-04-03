
<%@ page import="dev.lab.qmra.Critical_Condition" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'critical_Condition.label', default: 'Critical_Condition')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-critical_Condition" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-critical_Condition" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list critical_Condition">
			
				<g:if test="${critical_ConditionInstance?.conditionId}">
				<li class="fieldcontain">
					<span id="conditionId-label" class="property-label"><g:message code="critical_Condition.conditionId.label" default="Condition Id" /></span>
					
						<span class="property-value" aria-labelledby="conditionId-label"><g:fieldValue bean="${critical_ConditionInstance}" field="conditionId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${critical_ConditionInstance?.conditionType}">
				<li class="fieldcontain">
					<span id="conditionType-label" class="property-label"><g:message code="critical_Condition.conditionType.label" default="Condition Type" /></span>
					
						<span class="property-value" aria-labelledby="conditionType-label"><g:fieldValue bean="${critical_ConditionInstance}" field="conditionType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${critical_ConditionInstance?.organismType}">
				<li class="fieldcontain">
					<span id="organismType-label" class="property-label"><g:message code="critical_Condition.organismType.label" default="Organism Type" /></span>
					
						<span class="property-value" aria-labelledby="organismType-label"><g:fieldValue bean="${critical_ConditionInstance}" field="organismType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${critical_ConditionInstance?.organism}">
				<li class="fieldcontain">
					<span id="organism-label" class="property-label"><g:message code="critical_Condition.organism.label" default="Organism" /></span>
					
						<span class="property-value" aria-labelledby="organism-label"><g:fieldValue bean="${critical_ConditionInstance}" field="organism"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${critical_ConditionInstance?.organismTarget}">
				<li class="fieldcontain">
					<span id="organismTarget-label" class="property-label"><g:message code="critical_Condition.organismTarget.label" default="Organism Target" /></span>
					
						<span class="property-value" aria-labelledby="organismTarget-label"><g:fieldValue bean="${critical_ConditionInstance}" field="organismTarget"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${critical_ConditionInstance?.processType}">
				<li class="fieldcontain">
					<span id="processType-label" class="property-label"><g:message code="critical_Condition.processType.label" default="Process Type" /></span>
					
						<span class="property-value" aria-labelledby="processType-label"><g:fieldValue bean="${critical_ConditionInstance}" field="processType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${critical_ConditionInstance?.filtrationType}">
				<li class="fieldcontain">
					<span id="filtrationType-label" class="property-label"><g:message code="critical_Condition.filtrationType.label" default="Filtration Type" /></span>
					
						<span class="property-value" aria-labelledby="filtrationType-label"><g:fieldValue bean="${critical_ConditionInstance}" field="filtrationType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${critical_ConditionInstance?.desinfectionType}">
				<li class="fieldcontain">
					<span id="desinfectionType-label" class="property-label"><g:message code="critical_Condition.desinfectionType.label" default="Desinfection Type" /></span>
					
						<span class="property-value" aria-labelledby="desinfectionType-label"><g:fieldValue bean="${critical_ConditionInstance}" field="desinfectionType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${critical_ConditionInstance?.subject}">
				<li class="fieldcontain">
					<span id="subject-label" class="property-label"><g:message code="critical_Condition.subject.label" default="Subject" /></span>
					
						<span class="property-value" aria-labelledby="subject-label"><g:fieldValue bean="${critical_ConditionInstance}" field="subject"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${critical_ConditionInstance?.effect}">
				<li class="fieldcontain">
					<span id="effect-label" class="property-label"><g:message code="critical_Condition.effect.label" default="Effect" /></span>
					
						<span class="property-value" aria-labelledby="effect-label"><g:fieldValue bean="${critical_ConditionInstance}" field="effect"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${critical_ConditionInstance?.referenceInfo}">
				<li class="fieldcontain">
					<span id="referenceInfo-label" class="property-label"><g:message code="critical_Condition.referenceInfo.label" default="Reference Info" /></span>
					
						<span class="property-value" aria-labelledby="referenceInfo-label"><g:fieldValue bean="${critical_ConditionInstance}" field="referenceInfo"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${critical_ConditionInstance?.id}" />
					<g:link class="edit" action="edit" id="${critical_ConditionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
