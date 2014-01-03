<!DOCTYPE html>
<html>
	<head>
		<title>Welcome to Grails</title>
	</head>
	<body>
		<g:form name="questionaire" controller="questionaire" action="result">
			<g:textField name="test" />
			<g:actionSubmit action="result" value="Submit"/>
		</g:form>
		<br>
		<br>
		<g:link controller="demo">Grails Demo stuff</g:link>
	</body>
</html>
