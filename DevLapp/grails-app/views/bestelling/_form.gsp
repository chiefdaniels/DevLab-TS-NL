<%@ page import="net.atos.devlapp.bestelling.Bestelling" %>



<div class="fieldcontain ${hasErrors(bean: bestellingInstance, field: 'bestelnummer', 'error')} required">
	<label for="bestelnummer">
		<g:message code="bestelling.bestelnummer.label" default="Bestelnummer" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="bestelnummer" type="number" value="${bestellingInstance.bestelnummer}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: bestellingInstance, field: 'verkoper', 'error')} required">
	<label for="verkoper">
		<g:message code="bestelling.verkoper.label" default="Verkoper" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="verkoper" name="verkoper.id" from="${net.atos.devlapp.verkoper.Verkoper.list()}" optionKey="id" required="" value="${bestellingInstance?.verkoper?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: bestellingInstance, field: 'klant', 'error')} required">
	<label for="klant">
		<g:message code="bestelling.klant.label" default="Klant" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="klant" name="klant.id" from="${net.atos.klant.Klant.list()}" optionKey="id" required="" value="${bestellingInstance?.klant?.id}" class="many-to-one"/>

</div>

