<%@ page import="net.atos.klant.Klant" %>



<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'klantnummer', 'error')} required">
	<label for="klantnummer">
		<g:message code="klant.klantnummer.label" default="Klantnummer" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="klantnummer" type="number" value="${klantInstance.klantnummer}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'bedrijfsnaam', 'error')} ">
	<label for="bedrijfsnaam">
		<g:message code="klant.bedrijfsnaam.label" default="Bedrijfsnaam" />
		
	</label>
	<g:textField name="bedrijfsnaam" value="${klantInstance?.bedrijfsnaam}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'voornaam', 'error')} required">
	<label for="voornaam">
		<g:message code="klant.voornaam.label" default="Voornaam" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="voornaam" maxlength="25" required="" value="${klantInstance?.voornaam}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'achternaam', 'error')} required">
	<label for="achternaam">
		<g:message code="klant.achternaam.label" default="Achternaam" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="achternaam" maxlength="100" required="" value="${klantInstance?.achternaam}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'straatnaam', 'error')} required">
	<label for="straatnaam">
		<g:message code="klant.straatnaam.label" default="Straatnaam" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="straatnaam" maxlength="200" required="" value="${klantInstance?.straatnaam}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'huisnummer', 'error')} required">
	<label for="huisnummer">
		<g:message code="klant.huisnummer.label" default="Huisnummer" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="huisnummer" type="number" value="${klantInstance.huisnummer}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'huisnummertoevoeging', 'error')} ">
	<label for="huisnummertoevoeging">
		<g:message code="klant.huisnummertoevoeging.label" default="Huisnummertoevoeging" />
		
	</label>
	<g:textField name="huisnummertoevoeging" value="${klantInstance?.huisnummertoevoeging}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'postcode', 'error')} required">
	<label for="postcode">
		<g:message code="klant.postcode.label" default="Postcode" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="postcode" pattern="${klantInstance.constraints.postcode.matches}" required="" value="${klantInstance?.postcode}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'woonplaats', 'error')} required">
	<label for="woonplaats">
		<g:message code="klant.woonplaats.label" default="Woonplaats" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="woonplaats" maxlength="200" required="" value="${klantInstance?.woonplaats}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'telefoonnummer', 'error')} required">
	<label for="telefoonnummer">
		<g:message code="klant.telefoonnummer.label" default="Telefoonnummer" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefoonnummer" pattern="${klantInstance.constraints.telefoonnummer.matches}" required="" value="${klantInstance?.telefoonnummer}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: klantInstance, field: 'emailadres', 'error')} required">
	<label for="emailadres">
		<g:message code="klant.emailadres.label" default="Emailadres" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="emailadres" required="" value="${klantInstance?.emailadres}"/>

</div>

