<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="nl.watershare.qmra.form.types.ChlorinationType"%>

<%@taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form"		uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"		uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="include/head.jsp" />

<script type="text/javascript">
$(document).ready(function () {

	$(".dataTable").dataTable({
		"bPaginate": false,
		"bLengthChange": false,
		"bFilter": false,
		"bInfo": false,
		"bAutoWidth": false,
		"bSort": false,
	});
	
});
</script>

<body>
	<div class="main">
		<jsp:include page="include/title.jsp" />
		
		<!-- content holder -->
		<div class="content_holder">

			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.treatment" /></span></h4>
					
					<c:set var="selectionCriteria" value="${cdResult.getSelectionCriteria() }" />
					<c:set var="chlorineDisinfectionModel" value="${cdResult.getChlorineDisinfectionModel() }" />

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
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.chlorinationType" /> : <spring:message code="main.select.chlorinationType.${chlorineDisinfectionModel.getChlorinationType()}" />
							</label>
						</td>
					</tr>
					<c:if test="${chlorineDisinfectionModel.getChlorinationType() == 'PLUGFLOW' }" >
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.hrt" /> : 
								<c:out value="${chlorineDisinfectionModel.getHrt()}"/>
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.residualC" /> : 
								<c:out value="${chlorineDisinfectionModel.getResidualC()}"/>
							</label>
						</td>
					</tr>
					</c:if>
					<c:if test="${chlorineDisinfectionModel.getChlorinationType() == 'CSTR' }" >
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.cstr" /> : 
								<c:out value="${chlorineDisinfectionModel.getCstr()}"/>
							</label>
						</td>
					</tr>
					</c:if>
					<tr>
						<td>
							<img src="img/model_chlorine_disinfection.png" width="690"/> 
						</td>
					</tr>
					</table>
				</div>	
			</div>
			
			<c:if test="${cdResult.isShowInactivation() }">
			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.modelData" /></span></h4>
					
					<table class="data dataTable">
					<thead>
						<tr>
						    <th style="width: 200px">T oC</th>
							<c:forEach items="${temperatureList}" var="temperature">
							<th style="text-align: center">
								<fmt:formatNumber type="number" maxFractionDigits="1" groupingUsed="false" value="${temperature }" />
							</th>
							</c:forEach>						    
						</tr>
					</thead>
					<tbody>
						<tr>
						    <td>R (J/mol/K)</td>
							<c:forEach items="${temperatureList}" var="temperature">
							<td style="text-align: center">
								<fmt:formatNumber type="number" maxFractionDigits="3" groupingUsed="false" value="${chlorineDisinfectionModel.getR() }" />
							</td>
							</c:forEach>						    
						</tr>
						<tr>
						    <td>E (J/mol)</td>
							<c:forEach items="${temperatureList}" var="temperature">
							<td style="text-align: center">
								<fmt:formatNumber type="number" maxFractionDigits="1" groupingUsed="false" value="${chlorineDisinfectionModel.getE() }" />
							</td>
							</c:forEach>						    
						</tr>
						<tr>
						    <td>A (l/mg. min)</td>
							<c:forEach items="${temperatureList}" var="temperature">
							<td style="text-align: center">
								<fmt:formatNumber type="number" maxFractionDigits="1" groupingUsed="false" value="${chlorineDisinfectionModel.getA() }" />
							</td>
							</c:forEach>						    
						</tr>
						<tr>
						    <td>K-Value</td>
							<c:forEach items="${temperatureList}" var="temperature">
							<td style="text-align: center">
								<fmt:formatNumber type="number" maxFractionDigits="2" groupingUsed="false" 
								value="${chlorineDisinfectionModel.getKValue(temperature) }" />
							</td>
							</c:forEach>						    
						</tr>
					</tbody>
					</table>

				</div>	
			</div>

			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.inactivationCapacity" />&nbsp;(Chloor pH = 7.2, T = 10 oC)</span></h4>
					
					<table class="data dataTable">
					<thead>
						<tr>
						    <th style="text-align: center">R=</th>
							<th style="text-align: center">E</th>
							<th style="text-align: center">A</th>
							<th style="text-align: center">ke</th>
							<th style="text-align: center">
						    <c:choose>
						    	<c:when test="${chlorineDisinfectionModel.getChlorinationType() == 'PLUGFLOW' }">
   							    	Ct
								</c:when>
						    	<c:when test="${chlorineDisinfectionModel.getChlorinationType() == 'CSTR' }">
									CSTR
						    	</c:when>
						    </c:choose>
						    </th>
							<th style="text-align: center">Log inact.</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						    <td style="text-align: center">
						    	<fmt:formatNumber type="number" maxFractionDigits="3" groupingUsed="false" value="${chlorineDisinfectionModel.getR() }" />
						    </td>
						    <td style="text-align: center">
						    	<fmt:formatNumber type="number" maxFractionDigits="1" groupingUsed="false" value="${chlorineDisinfectionModel.getE() }" />
						    </td>
						    <td style="text-align: center">
						    	<fmt:formatNumber type="number" maxFractionDigits="1" groupingUsed="false" value="${chlorineDisinfectionModel.getA() }" />
						    </td>
						    <td style="text-align: center">
						    	<fmt:formatNumber type="number" maxFractionDigits="6" groupingUsed="false" value="${chlorineDisinfectionModel.getKValue(10) }" />
						    </td>
						    <td style="text-align: center">
						    <c:choose>
						    	<c:when test="${chlorineDisinfectionModel.getChlorinationType() == 'PLUGFLOW' }">
   							    	<fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" 
						    		value="${chlorineDisinfectionModel.getHrt() * chlorineDisinfectionModel.getResidualC() }" />
								</c:when>						    	
						    	<c:when test="${chlorineDisinfectionModel.getChlorinationType() == 'CSTR' }">
							    	<fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${chlorineDisinfectionModel.getCstr() }" />
						    	</c:when>
						    </c:choose>
						    </td>
						    <td style="text-align: center">
						    	<fmt:formatNumber type="number" maxFractionDigits="2" groupingUsed="false" value="${chlorineDisinfectionModel.getLogInactivation() }" />
						    </td>
						</tr>
					</tbody>
					</table>

				</div>	
			</div>
			</c:if>
			
			<c:if test="${cdResult.isShowCTRequirements() }">
			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.ctRequirements" /></span></h4>

					<c:forEach items="${logList}" var="logReduction">

					<table class="data dataTable">
					<thead>
						<tr>
						    <th colspan="3"><spring:message code="result.label.logInactivation" />&nbsp;<fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${logReduction }" /></th>
						</tr>
					</thead>
					</table>

					<table class="data dataTable">
					<thead>
						<tr>
						    <th style="text-align: center">Temp</th>
							<th style="text-align: center">kValue</th>
							<th style="text-align: center">Ct</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${temperatureList}" var="temperature">
						<tr>
						    <td style="text-align: center">
						    	<fmt:formatNumber type="number" maxFractionDigits="1" groupingUsed="false" value="${temperature }" />
						    </td>
						    <td style="text-align: center">
						    	<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" groupingUsed="false" value="${chlorineDisinfectionModel.getKValue(temperature) }" />
						    </td>
						    <td style="text-align: center">
						    	<fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" groupingUsed="false" value="${chlorineDisinfectionModel.getCTValue(logReduction, temperature, 0, 0) }" />
						    </td>
						</tr>
						</c:forEach>
					</tbody>
					</table>
					
					</c:forEach>

				</div>	
			</div>
			</c:if>
			
			<c:if test="${not empty criticalConditionResultList}">
			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.criticalConditions" /></span></h4>

					<table border="0" >
					<c:forEach items="${criticalConditionResultList}" var="criticalConditionResultCondition">
					<tr>
						<td style="vertical-align: top; padding: 0px; width: 15%">
							<spring:message code="main.select.criticalConditionType.${criticalConditionResultCondition.conditionType}" />
						</td>
						<td style="vertical-align: top; padding: 0px; width: 85%">
							<table  border="0">
							<c:forEach items="${criticalConditionResultCondition.getCriticalConditionResultSubjectList()}" var="criticalConditionResultSubject">
							<tr>
								<td style="vertical-align: top; padding: 0px; width: 20%">${criticalConditionResultSubject.getSubject()}</td>
								<td style="vertical-align: top; padding: 0px; width: 80%">
									<table border="0">
									<c:forEach items="${criticalConditionResultSubject.getCriticalConditionResultEffectList()}" var="CriticalConditionResultEffect">
									<tr>
										<td style="vertical-align: top; padding: 0px; width: 250px">${CriticalConditionResultEffect.getEffect()}</td>
										<td style="vertical-align: top; padding: 0px; width: 250px">${CriticalConditionResultEffect.getReference()}</td>
									</tr>
									</c:forEach>
									</table>
								</td>
							</tr>
							</c:forEach>
							</table>
						</td>
					</tr>
					</c:forEach>
					</table>
				</div>	
			</div>
			</c:if>
			
		</div> <!-- content holder end -->
	</div> <!-- main end -->
</body>
</html>