<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>

<%@taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form"		uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"		uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="selectionCriteria" value="${ssfResult.getSelectionCriteria() }" />
<c:set var="slowSandFiltrationModel" value="${ssfResult.getSlowSandFiltrationModel() }" />

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
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.location" /> : <spring:message code="main.select.locationType.${slowSandFiltrationModel.getLocationType()}" />
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.schmutzdeckeAge" /> : <c:out value="a (d)" />&nbsp;<c:out value="${slowSandFiltrationModel.getSchmutzdeckeAge()}" />
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.temperature" /> : <c:out value="T oC" />&nbsp;<c:out value="${slowSandFiltrationModel.getTemperature()}" />
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<img src="img/model_ssf_filtration.png" width="690"/> 
						</td>
					</tr>
					</table>
				</div>	
			</div>
			
			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.modelData" /></span></h4>
					
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr class="even">
							<td style="float: left"><label><spring:message code="main.label.tufenkjiEta" /></label></td>
							<td><label>eta</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="6" groupingUsed="false" value="${slowSandFiltrationModel.getTufenkjiEta()}" /></label>
						</tr>
						<tr class="odd">
							<td style="float: left"><label><spring:message code="main.label.porosity" /></label></td>
							<td><label>n</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="2" groupingUsed="false" value="${slowSandFiltrationModel.getLocationType().getPorosity()}" /></label>
						</tr>
						
						<tr class="even">
							<td style="float: left"><label><spring:message code="main.label.grainSize" /></label></td>
							<td><label>dc m</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="6" groupingUsed="false" value="${slowSandFiltrationModel.getLocationType().getGrainSize()}" /></label>
						</tr>
						<tr class="odd">
							<td style="float: left"><label><spring:message code="main.label.rate" /></label></td>
							<td><label>u m/s</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="6" groupingUsed="false" value="${slowSandFiltrationModel.getLocationType().getRate()}" /></label>
						</tr>
						<tr class="even">
							<td style="float: left"><label><spring:message code="main.label.depth" /></label></td>
							<td><label>x (m)</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="2" groupingUsed="false" value="${slowSandFiltrationModel.getLocationType().getDepth()}" /></label>
						</tr>
						<tr class="odd">
							<td style="float: left"><label><spring:message code="main.label.modelSchijvenHechting" /></label></td>
							<td><label>alfa</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="6" groupingUsed="false" value="${slowSandFiltrationModel.getModelSchijvenHechting()}" /></label>
						</tr>
						<tr class="even">
							<td style="float: left"><label><spring:message code="main.label.modelSchijvenF0" /></label></td>
							<td><label>f0</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="6" groupingUsed="false" value="${slowSandFiltrationModel.getModelSchijvenF0()}" /></label>
						</tr>
						<tr class="odd">
							<td style="float: left"><label><spring:message code="main.label.modelSchijvenF1" /></label></td>
							<td><label>f1</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="6" groupingUsed="false" value="${slowSandFiltrationModel.getModelSchijvenF1()}" /></label>
						</tr>
						<tr class="even">
							<td style="float: left"><label><spring:message code="main.label.removalCalculated" /></label></td>
							<td><label>LNC/Co</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="3" groupingUsed="false" value="${slowSandFiltrationModel.getRemovalCalculatedLNC()}" /></label>
						</tr>
						<tr class="odd">
							<td style="float: left"><label><spring:message code="main.label.removalCalculated" /></label></td>
							<td><label>DEC (Log)</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="2" groupingUsed="false" value="${slowSandFiltrationModel.getRemovalCalculatedDEC()}" /></label>
						</tr>
						
					</table>							
				</div>	
			</div>
			
			<c:if test="${not empty criticalConditionResultList}">
			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.criticalConditions" /></span></h4>

					<table border="0" >
					<c:forEach items="${criticalConditionResultList}" var="criticalConditionResultCondition">
					<tr>
						<td style="vertical-align: top; padding: 0px; width: 15%"><spring:message code="main.select.criticalConditionType.${criticalConditionResultCondition.conditionType}" /></td>
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