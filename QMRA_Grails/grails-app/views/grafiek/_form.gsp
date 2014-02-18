<%@ page import="dev.lab.tutorial.Entry" %>



<div class="fieldcontain ${hasErrors(bean: entryInstance, field: 'dag', 'error')} required">
	<label for="dag">
		<g:message code="entry.dag.label" default="Dag" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="dag" required="" value="${entryInstance?.dag}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: entryInstance, field: 'Aantal', 'error')} required">
	<label for="aantal">
		<g:message code="entry.aantal.label" default="Aantal" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="aantal" required="" value="${entryInstance?.aantal}"/>
</div>


