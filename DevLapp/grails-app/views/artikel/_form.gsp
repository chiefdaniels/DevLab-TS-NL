<%@ page import="net.atos.devLapp.artikel.Artikel" %>



<div class="fieldcontain ${hasErrors(bean: artikelInstance, field: 'artikelNummer', 'error')} required">
	<label for="artikelNummer">
		<g:message code="artikel.artikelNummer.label" default="Artikel Nummer" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="artikelNummer" type="number" value="${artikelInstance.artikelNummer}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: artikelInstance, field: 'artikelNaam', 'error')} required">
	<label for="artikelNaam">
		<g:message code="artikel.artikelNaam.label" default="Artikel Naam" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="artikelNaam" maxlength="25" required="" value="${artikelInstance?.artikelNaam}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: artikelInstance, field: 'artikelOmschrijving', 'error')} required">
	<label for="artikelOmschrijving">
		<g:message code="artikel.artikelOmschrijving.label" default="Artikel Omschrijving" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="artikelOmschrijving" cols="40" rows="5" maxlength="500" required="" value="${artikelInstance?.artikelOmschrijving}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: artikelInstance, field: 'categorieCode', 'error')} required">
	<label for="categorieCode">
		<g:message code="artikel.categorieCode.label" default="Categorie Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="categorieCode" from="${artikelInstance.constraints.categorieCode.inList}" required="" value="${artikelInstance?.categorieCode}" valueMessagePrefix="artikel.categorieCode"/>

</div>

