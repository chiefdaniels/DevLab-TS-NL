<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Enums</title>
    <meta name="layout" content="main"/>
</head>

<body>
    YesNoType:
	
	<g:select  name="janee" 
		valueMessagePrefix="dev.lab.qmra.enums.YesNoType"
		from="${dev.lab.qmra.enums.YesNoType}"
    />
    <br/><br/>
    vaste waarde:<g:message code="dev.lab.qmra.enums.YesNoType.YES" />
	<br/><br/>
	UvType: 
	<g:select from="${dev.lab.qmra.enums.UvType }" name="UvType"/>
	<br>
</body>
</html>