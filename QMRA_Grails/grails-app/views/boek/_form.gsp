<%@ page import="dev.lab.tutorial.Boek" %>



<div class="fieldcontain ${hasErrors(bean: boekInstance, field: 'ISBN', 'error')} required">
	<label for="ISBN">
		<g:message code="boek.ISBN.label" default="ISBN" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ISBN" required="" value="${boekInstance?.ISBN}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: boekInstance, field: 'titel', 'error')} required">
	<label for="titel">
		<g:message code="boek.titel.label" default="Titel" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titel" required="" value="${boekInstance?.titel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: boekInstance, field: 'auteur', 'error')} required">
	<label for="auteur">
		<g:message code="boek.auteur.label" default="Auteur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="auteur" name="auteur.id" from="${dev.lab.tutorial.Auteur.list()}" optionKey="id" required="" value="${boekInstance?.auteur?.id}" class="many-to-one"/>
</div>

