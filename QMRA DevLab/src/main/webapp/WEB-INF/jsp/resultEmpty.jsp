<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>

<%@taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form"		uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"		uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="include/head.jsp" />

<body>
	<div class="main">
		<jsp:include page="include/title.jsp" />
		
		<!-- content holder -->
		<div class="content_holder">

			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.treatment" /></span></h4>
					
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.microOrganisms" /> : <spring:message code="main.select.organismType.${selectionCriteria.organismType}" />
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.processes" /> : <spring:message code="main.select.processType.${selectionCriteria.processType}" />
							</label>
						</td>
					</tr>
					<c:if test="${selectionCriteria.getFiltrationType() != null }" >
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.filtration" /> : <spring:message code="main.select.filtrationType.${selectionCriteria.filtrationType}" />
							</label>
						</td>
					</tr>
					</c:if>
					<c:if test="${selectionCriteria.getDisinfectionType() != null }" >
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.disinfection" /> : <spring:message code="main.select.disinfectionType.${selectionCriteria.disinfectionType}" />
							</label>
						</td>
					</tr>
					</c:if>
					<c:if test="${selectionCriteria.getTargetType() != null }" >
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.target" /> : <spring:message code="main.select.targetType.${selectionCriteria.targetType}" />
							</label>
						</td>
					</tr>
					</c:if>
					<c:if test="${output != null }" >
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.output" /> : <spring:message code="main.select.outputType.${output}" />
							</label>
						</td>
					</tr>
					</c:if>
					</table>
				</div>	
			</div>
			
			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.result" /></span></h4>
					
					<table>
						<tr>
							<td>
								<label style="float: left"><spring:message code="result.label.couldNotFindResult" /></label>
							</td>
						</tr>
						<tr>
							<td>
								<label style="float: left"><spring:message code="result.label.availableTreatments" /></label>
							</td>
						</tr>
						<tr>
							<td>
								<ul>
									<li>
										<a href="/qmratreatmentcalculator/main.do?organismType=CRYPTOSPORIDIUM&processType=CONVENTIONAL&outputType=TABLE">Crypto/Conventional</a>
									</li>
									<li>
										<a href="/qmratreatmentcalculator/main.do?organismType=CRYPTOSPORIDIUM&processType=FILTRATION&filtrationType=GAC&outputType=TABLE">Crypto/Filtration/GAC</a>
									</li>
									<li>
										<a href="/qmratreatmentcalculator/main.do?organismType=GIARDIA&processType=DISINFECTION&disinfectionType=CHLORINE&outputType=MODEL">Giardia/Disinfection/Chlorine</a>
									</li>
									<li>
										<a href="/qmratreatmentcalculator/main.do?organismType=VIRUS&processType=FILTRATION&filtrationType=SSF">Viruses/Filtration/SSF (Table and model)</a>
									</li>
									<li>
										<a href="/qmratreatmentcalculator/main.do?organismType=VIRUS&processType=DISINFECTION&disinfectionType=UV&outputType=MODEL">Viruses/Disinfection/UV</a>
									</li>
									<li>
										<a href="/qmratreatmentcalculator/main.do?organismType=VIRUS&processType=DISINFECTION&disinfectionType=CHLORINE&outputType=MODEL">Viruses/Disinfection/Chlorine</a>
									</li>
									<li>
										<a href="/qmratreatmentcalculator/main.do?organismType=BACTERIA&processType=FILTRATION&filtrationType=SSF">Bacteria/Filtration/SSF (Table and model)</a>
									</li>
								</ul>
							</td>
						</tr>
					</table>
				</div>	
			</div>
			
		</div> <!-- content holder end -->
	</div> <!-- main end -->
</body>
</html>