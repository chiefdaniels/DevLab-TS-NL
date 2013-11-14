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

	$(".dataTable").dataTable({
		"bPaginate": false,
		"bLengthChange": false,
		"bFilter": false,
		"bInfo": false,
		"bAutoWidth": false,
		"bSort": true,
		"aaSorting":[[7, "asc"]]
	});
	
	var data = [
   		{
   			color: "#458642",
   			label: "Low Pressure target",
   			bars: {
   				show: true,
   				barWidth: 0.6,
   				align: "center",
   				horizontal: true,
   				lineWidth: 1
   			},
   			data: ${graphList.get(0).getGraphData()}
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
   			color: "#614CFF",
   			label: "Medium Pressure target",
   			bars: {
   				show: true,
   				barWidth: 0.6,
   				align: "center",
   				horizontal: true,
   				lineWidth: 1
   			},
   			data: ${graphList.get(1).getGraphData()}
   		},{
   			color: "#614CFF",
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
   		},{
   			color: "#94BA93",
   			label: "Low Pressure surrogate",
   			bars: {
   				show: true,
   				barWidth: 0.6,
   				align: "center",
   				horizontal: true,
   				lineWidth: 1
   			},
   			data: ${graphList.get(4).getGraphData()}
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
   			data: ${graphList.get(6).getGraphData()}
   		},{
   			color: "#8E9BFF",
   			label: "Medium Pressure surrogate",
   			bars: {
   				show: true,
   				barWidth: 0.6,
   				align: "center",
   				horizontal: true,
   				lineWidth: 1
   			},
   			data: ${graphList.get(5).getGraphData()}
   		},{
   			color: "#8E9BFF",
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
   			data: ${graphList.get(7).getGraphData()}
   		}
	];
	
	$.plot($("#graph1"), data, {
		yaxis: {
			mode: "categories",
			axisLabelUseCanvas: false,
			ticks: ${graphList.get(0).getYaxisLabels()}
		},
		xaxis: {
			axisLabel: 'k-value (log. mJ/cm2)',
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
					<tr>
						<td>
							<label style="float: left">
								<spring:message code="main.label.uv" /> : <spring:message code="main.select.uvType.${selectionCriteria.uvType}" />
							</label>
						</td>
					</tr>
					<tr>
						<td>
							<img src="img/model_uv_disinfection.png" width="690"/> 
						</td>
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

			<div class="form_block form_block_wide" id="formBlock">
				<div class="cluster">
					<h4><span><spring:message code="result.label.cluster.doseRequirements" /></span></h4>
					
					<table class="data dataTable">
					<thead>
						<tr>
						    <th style="width: 300px"><spring:message code="result.label.requiredInactivation"/></th>
							<th style="width: 150px"><spring:message code="main.label.target"/></th>
							<th style="width: 150px"><spring:message code="main.label.uv"/></th>
							<th style="text-align: center"><spring:message code="result.label.offsetFluence"/></th>
							<th style="text-align: center">1 Log</th>
							<th style="text-align: center">2 Log</th>
							<th style="text-align: center">3 Log</th>
							<th style="text-align: center">4 Log</th>
						</tr>
					</thead>
					<c:if  test="${!empty researchDataResult.getResearchDataList()}">
					<tbody>
						<c:forEach items="${researchDataResult.getResearchDataList()}" var="researchData">
							<tr>
							    <td><c:out value="${researchData.getOrganism()}" /></td>
							    <td><spring:message code="result.label.target.${researchData.getOrganismTarget() }"/></td>
							    <td><spring:message code="main.select.uvType.${researchData.getVirus_uvType() }"/></td>
							    <td style="text-align: center">0</td>
							    <td style="text-align: center"><fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${1 / researchData.getVirus_kValue()}" /></td>
							    <td style="text-align: center"><fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${2 / researchData.getVirus_kValue()}" /></td>
							    <td style="text-align: center"><fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${3 / researchData.getVirus_kValue()}" /></td>
							    <td style="text-align: center"><fmt:formatNumber type="number" maxFractionDigits="0" groupingUsed="false" value="${4 / researchData.getVirus_kValue()}" /></td>
							</tr>
						</c:forEach>
					</tbody>
					</c:if>
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