<!DOCTYPE html>
<html>
<head>
    <title>QMRA Treatment Calculator</title>
</head>
<body>

<g:form name="questionaire" controller="questionaire" action="result">
	<g:select from="${dev.lab.qmra.enums.OrganismType }" name="OrganismType"/>
    <g:actionSubmit action="result" value="Submit"/>
    
    
</g:form>

</body>
</html>
