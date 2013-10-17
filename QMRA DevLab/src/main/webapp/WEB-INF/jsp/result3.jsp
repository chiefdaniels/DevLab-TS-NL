<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>

<%@taglib prefix="spring"	uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form"		uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"		uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="include/head.jsp" />

<script type="text/javascript">
$(document).ready(function () {
	
	var data = [
		{
			color: "#458642",
			label: "Target",
			bars: {
				show: true,
				barWidth: 0.6,
				align: "center",
				horizontal: true,
				lineWidth: 1
			},
			data: ${graphList.get(0).getGraphData()}
		},{
			color: "#94BA93",
			label: "Surrogate",
			bars: {
				show: true,
				barWidth: 0.6,
				align: "center",
				horizontal: true,
				lineWidth: 1
			},
			data: ${graphList.get(1).getGraphData()}
		},{
			color: "#438642",
			points: {
				show: true,
				errorbars: 'x',
				xerr: {
					show:true,
					upperCap: '-',
					lowerCap: '-',
					radius: 5
				}	
			},
			data: ${graphList.get(2).getGraphData()}
		},{
			color: "#94BA93",
			points: {
				show: true,
				errorbars: 'x',
				xerr: {
					show:true,
					upperCap: '-',
					lowerCap: '-',
					radius: 5
				}	
			},
			data: ${graphList.get(3).getGraphData()}
		}
	];
	
	$.plot($("#graph1"), data, {
		yaxis: {
			mode: "categories",
			axisLabelUseCanvas: false,
			ticks: ${graphList.get(0).getYaxisLabels()}
		},
		xaxis: {
			axisLabel: 'DEC (log10)',
			axisLabelUseCanvas: false,
			min: 0,
			max: ${graphList.get(0).getMaxValue()}
		},
		legend: {
		    show: true,
		    position: "se"
		}					
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
					
					<c:set var="selectionCriteria" value="${researchDataResult.getSelectionCriteria() }" />
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
				
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr class="odd">
							<td style="float: left"><label>Period Years</label></td>
							<td><label>P10</label></td>
							<td><label>
								<c:catch var="exceptionYear10">
									<fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${researchDataResult.getPercentileYear(10)}" />
								</c:catch>
								<c:if test="${exceptionYear10 != null }">
									<spring:message code="error.notEnoughStudiesForPercentile" />
								</c:if>
							</label></td>							
						</tr>
						<tr class="even">
							<td />
							<td><label>P50</label></td>
							<td><label>
								<c:catch var="exceptionYear50">
									<fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${researchDataResult.getPercentileYear(50)}" />
								</c:catch>
								<c:if test="${exceptionYear50 != null }">
									<spring:message code="error.notEnoughStudiesForPercentile" />
								</c:if>
							</label></td>							
						</tr>
						<tr class="odd">
							<td />
							<td><label>P90</label></td>
							<td><label>
								<c:catch var="exceptionYear90">
									<fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${researchDataResult.getPercentileYear(90)}" />
								</c:catch>
								<c:if test="${exceptionYear90 != null }">
									<spring:message code="error.notEnoughStudiesForPercentile" />
								</c:if>
							</label></td>							
						</tr>
						<tr class="even">
							<td style="float: left"><label>Eliminiation</label></td>
							<td><label>Count studies</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${researchDataResult.getStudyCount()}" /></label>
						</tr>
						<tr class="odd">
							<td />
							<td><label>Count data</label></td>
							<td><label><fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${researchDataResult.getStudySampleCount()}" /></label>
						</tr>
						<tr class="even">
							<td />
							<td><label>DEC AVG</label></td>
							<td><label><fmt:formatNumber type="number" minFractionDigits="4" maxFractionDigits="4" groupingUsed="false" value="${researchDataResult.getAverageElimination()}" /></label>
						</tr>
						<tr class="odd">
							<td />
							<td><label>Standard deviation</label></td>
							<td><label><fmt:formatNumber type="number" minFractionDigits="4" maxFractionDigits="4" groupingUsed="false" value="${researchDataResult.getStandardDeviationElimination()}" /></label>
						</tr>
						<tr class="even">
							<td />
							<td><label>Minimum</label></td>
							<td><label><fmt:formatNumber type="number" minFractionDigits="4" maxFractionDigits="4" groupingUsed="false" value="${researchDataResult.getMinimumEliminitation()}" /></label>
						</tr>
						<tr class="odd">
							<td />
							<td><label>Maximum</label></td>
							<td><label><fmt:formatNumber type="number" minFractionDigits="4" maxFractionDigits="4" groupingUsed="false" value="${researchDataResult.getMaximumEliminitation()}" /></label>
						</tr>
						<tr class="even">
							<td />
							<td><label>P50</label></td>
							<td><label>
								<c:catch var="exceptionElemination50">
									<fmt:formatNumber type="number" minFractionDigits="4" maxFractionDigits="4" groupingUsed="false" value="${researchDataResult.getPercentileElimination(50)}" />
								</c:catch>
								<c:if test="${exceptionElemination50 != null }">
									<spring:message code="error.notEnoughStudiesForPercentile" />
								</c:if>
							</label></td>							
						<tr class="odd">
							<td />
							<td><label>P10</label></td>
							<td><label>
								<c:catch var="exceptionElemination10">
									<fmt:formatNumber type="number" minFractionDigits="4" maxFractionDigits="4" groupingUsed="false" value="${researchDataResult.getPercentileElimination(10)}" />
								</c:catch>
								<c:if test="${exceptionElemination10 != null }">
									<spring:message code="error.notEnoughStudiesForPercentile" />
								</c:if>
							</label></td>							
						</tr>
						<tr class="even">
							<td />
							<td><label>P25</label></td>
							<td><label>
								<c:catch var="exceptionElemination25">
									<fmt:formatNumber type="number" minFractionDigits="4" maxFractionDigits="4" groupingUsed="false" value="${researchDataResult.getPercentileElimination(25)}" />
								</c:catch>
								<c:if test="${exceptionElemination25 != null }">
									<spring:message code="error.notEnoughStudiesForPercentile" />
								</c:if>
							</label></td>							
						</tr>
					</table>							
				</div>	
			</div>

			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.graph" /></span></h4>
					
					<div>
   			 			<div style="width: 100%; height: 100%; ">
			 				<div id="graph1" style="width: 700px; height: 400px;"></div>
						</div>
					</div>
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