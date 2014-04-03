<%@ page import="dev.lab.qmra.Critical_Condition" %>



<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'conditionId', 'error')} required">
	<label for="conditionId">
		<g:message code="critical_Condition.conditionId.label" default="Condition Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="conditionId" type="number" value="${critical_ConditionInstance.conditionId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'conditionType', 'error')} ">
	<label for="conditionType">
		<g:message code="critical_Condition.conditionType.label" default="Condition Type" />
		
	</label>
	<g:textField name="conditionType" value="${critical_ConditionInstance?.conditionType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'organismType', 'error')} ">
	<label for="organismType">
		<g:message code="critical_Condition.organismType.label" default="Organism Type" />
		
	</label>
	<g:textField name="organismType" value="${critical_ConditionInstance?.organismType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'organism', 'error')} ">
	<label for="organism">
		<g:message code="critical_Condition.organism.label" default="Organism" />
		
	</label>
	<g:textField name="organism" value="${critical_ConditionInstance?.organism}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'organismTarget', 'error')} required">
	<label for="organismTarget">
		<g:message code="critical_Condition.organismTarget.label" default="Organism Target" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="organismTarget" type="number" value="${critical_ConditionInstance.organismTarget}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'processType', 'error')} ">
	<label for="processType">
		<g:message code="critical_Condition.processType.label" default="Process Type" />
		
	</label>
	<g:textField name="processType" value="${critical_ConditionInstance?.processType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'filtrationType', 'error')} ">
	<label for="filtrationType">
		<g:message code="critical_Condition.filtrationType.label" default="Filtration Type" />
		
	</label>
	<g:textField name="filtrationType" value="${critical_ConditionInstance?.filtrationType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'desinfectionType', 'error')} ">
	<label for="desinfectionType">
		<g:message code="critical_Condition.desinfectionType.label" default="Desinfection Type" />
		
	</label>
	<g:textField name="desinfectionType" value="${critical_ConditionInstance?.desinfectionType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'subject', 'error')} ">
	<label for="subject">
		<g:message code="critical_Condition.subject.label" default="Subject" />
		
	</label>
	<g:textField name="subject" value="${critical_ConditionInstance?.subject}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'effect', 'error')} ">
	<label for="effect">
		<g:message code="critical_Condition.effect.label" default="Effect" />
		
	</label>
	<g:textField name="effect" value="${critical_ConditionInstance?.effect}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: critical_ConditionInstance, field: 'referenceInfo', 'error')} ">
	<label for="referenceInfo">
		<g:message code="critical_Condition.referenceInfo.label" default="Reference Info" />
		
	</label>
	<g:textField name="referenceInfo" value="${critical_ConditionInstance?.referenceInfo}"/>
</div>

