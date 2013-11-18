<ul>
	<g:each var="boek" in="${cataloog}">
		<li>${boek.description()} <g:link controller="boek" action="edit" id="${boek?.id}">Pas aan</g:link></li>
	</g:each>
</ul>