<%@ page import="net.atos.devlapp.verkoper.Verkoper" %>



<div class="fieldcontain ${hasErrors(bean: verkoperInstance, field: 'verkoperID', 'error')} required">
	<label for="verkoperID">
		<g:message code="verkoper.verkoperID.label" default="Verkoper ID" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="verkoperID" type="number" value="${verkoperInstance.verkoperID}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: verkoperInstance, field: 'voornaam', 'error')} required">
	<label for="voornaam">
		<g:message code="verkoper.voornaam.label" default="Voornaam" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="voornaam" maxlength="25" required="" value="${verkoperInstance?.voornaam}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: verkoperInstance, field: 'achternaam', 'error')} required">
	<label for="achternaam">
		<g:message code="verkoper.achternaam.label" default="Achternaam" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="achternaam" maxlength="100" required="" value="${verkoperInstance?.achternaam}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: verkoperInstance, field: 'telefoonnummer', 'error')} required">
	<label for="telefoonnummer">
		<g:message code="verkoper.telefoonnummer.label" default="Telefoonnummer" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefoonnummer" pattern="${verkoperInstance.constraints.telefoonnummer.matches}" required="" value="${verkoperInstance?.telefoonnummer}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: verkoperInstance, field: 'emailadres', 'error')} required">
	<label for="emailadres">
		<g:message code="verkoper.emailadres.label" default="Emailadres" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="emailadres" required="" value="${verkoperInstance?.emailadres}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: verkoperInstance, field: 'geboortedatum', 'error')} required">
	<label for="geboortedatum">
		<g:message code="verkoper.geboortedatum.label" default="Geboortedatum" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="geboortedatum" precision="day"  value="${verkoperInstance?.geboortedatum}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: verkoperInstance, field: 'salaris', 'error')} required">
	<label for="salaris">
		<g:message code="verkoper.salaris.label" default="Salaris" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="salaris" value="${fieldValue(bean: verkoperInstance, field: 'salaris')}" required=""/>

</div>

