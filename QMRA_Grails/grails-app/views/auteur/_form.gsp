<%@ page import="dev.lab.Auteur" %>



<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'achternaam', 'error')} ">
	<label for="achternaam">
		<g:message code="auteur.achternaam.label" default="Achternaam" />
		
	</label>
	<g:textField name="achternaam" value="${auteurInstance?.achternaam}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: auteurInstance, field: 'voornaam', 'error')} ">
	<label for="voornaam">
		<g:message code="auteur.voornaam.label" default="Voornaam" />
		
	</label>
	<g:textField name="voornaam" value="${auteurInstance?.voornaam}"/>
</div>

