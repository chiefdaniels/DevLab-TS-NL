<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="spring"	uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="include/head.jsp" />
</head>
<body>

	<h2>
		<spring:message code="error.title" />
	</h2>

	<p class="error">
		<spring:message code="error.message" />
	</p>
	<script type="text/javascript">
		var currentTime = new Date();
		document.write(currentTime);
	</script>
	<p/>
	<a href="javascript:javascript:history.go(-1)"><spring:message code="error.page.goback" /></a>

</body>
</html>