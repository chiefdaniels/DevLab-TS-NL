<%@ page import="dev.lab.Boek" %>



<div class="fieldcontain ${hasErrors(bean: boekInstance, field: 'ISBN', 'error')} ">
	<label for="ISBN">
		<g:message code="boek.ISBN.label" default="ISBN" />
		
	</label>
	<g:textField name="ISBN" value="${boekInstance?.ISBN}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: boekInstance, field: 'auteur', 'error')} required">
	<label for="auteur">
		<g:message code="boek.auteur.label" default="Auteur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="auteur" name="auteur.id" from="${dev.lab.Auteur.list()}" optionKey="id" required="" value="${boekInstance?.auteur?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: boekInstance, field: 'titel', 'error')} ">
	<label for="titel">
		<g:message code="boek.titel.label" default="Titel" />
		
	</label>
	<g:textField name="titel" value="${boekInstance?.titel}"/>
</div>

