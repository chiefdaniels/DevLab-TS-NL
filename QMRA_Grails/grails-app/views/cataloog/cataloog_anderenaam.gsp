<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
	</head>
	<body>
		<div style="margin:1em 2em">
            <h1>Cataloog</h1>
			<ul>
				<g:each var="boek" in="${cataloog}">
					<li>${boek.description()} <g:link controller="boek" action="edit" id="${boek?.id}"><small>Pas aan</small></g:link></li>

				</g:each>
			</ul>
		</div>
	</body>
</html>