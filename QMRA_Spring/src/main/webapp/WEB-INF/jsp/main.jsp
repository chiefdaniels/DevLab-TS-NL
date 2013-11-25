<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="nl.watershare.qmra.form.MainForm"%>
<%@page import="nl.watershare.qmra.form.types.OrganismType"%>
<%@page import="nl.watershare.qmra.form.types.ProcessType"%>
<%@page import="nl.watershare.qmra.form.types.FiltrationType"%>
<%@page import="nl.watershare.qmra.form.types.DisinfectionType"%>
<%@page import="nl.watershare.qmra.form.types.TargetType"%>
<%@page import="nl.watershare.qmra.form.types.OutputType"%>
<%@page import="nl.watershare.qmra.form.types.LocationType"%>
<%@page import="nl.watershare.qmra.form.types.ChlorinationType"%>
<%@page import="nl.watershare.qmra.form.types.UvType"%>
<%@page import="nl.watershare.qmra.form.types.YesNoType"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="include/head.jsp" />

<body>
	<div class="main">
		<jsp:include page="include/title.jsp" />
		
		<!-- content holder -->
		<div class="content_holder">

			<form:form id="mainForm" action="submitMainForm.do" method="post" enctype="multipart/form-data" modelAttribute="mainForm">
				<div class="form_block form_block_wide" id="formBlock">
					<div class="cluster">
						<h4><span><spring:message code="main.label.cluster.treatment" /></span></h4>
						
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td style="width: 180px">
								<form:label path="organismType"><spring:message code="main.label.microOrganisms" /></form:label>
							</td>
							<td>
								<form:select id="organismType" path="organismType" >
									<c:forEach items="<%= OrganismType.values() %>" var="organism">
										<form:option value="${organism}"><spring:message code="main.select.organismType.${organism}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="organismType">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr>
							<td>
								<form:label path="processType"><spring:message code="main.label.processes" /></form:label>
							</td>
							<td>
								<form:select id="processType" path="processType" >
									<c:forEach items="<%= ProcessType.values() %>" var="process">
										<form:option value="${process}"><spring:message code="main.select.processType.${process}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="processType">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr id="filtrationRow">
							<td>
								<form:label path="filtrationType"><spring:message code="main.label.filtration" />
									<a class="tooltip" href="#"> ?<span class="classic"><spring:message code="main.label.filtration.tooltip" /></span></a>
								</form:label>
							</td>
							<td>
								<form:select id="filtrationType" path="filtrationType" >
									<c:forEach items="<%= FiltrationType.values() %>" var="filtration">
										<form:option value="${filtration}"><spring:message code="main.select.filtrationType.${filtration}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="filtrationType">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr id="disinfectionRow">
							<td>
								<form:label path="disinfectionType"><spring:message code="main.label.disinfection" /></form:label>
							</td>
							<td>
								<form:select id="disinfectionType" path="disinfectionType" >
									<c:forEach items="<%= DisinfectionType.values() %>" var="disinfection">
										<form:option value="${disinfection}"><spring:message code="main.select.disinfectionType.${disinfection}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="disinfectionType">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						</table>
					</div>
				</div>

				<div class="form_block form_block_wide" id="formBlock2">
					<div class="cluster">
						<h4><span><spring:message code="main.label.cluster.output" /></span></h4>
						
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr id="outputRow">
							<td style="width: 180px">
								<form:label path="outputType"><spring:message code="main.label.output" />
									<a class="tooltip" href="#"> ?<span class="classic"><spring:message code="main.label.output.tooltip" /></span></a>
								</form:label>
							</td>
							<td>
								<form:select id="outputType" path="outputType" >
									<c:forEach items="<%= OutputType.values() %>" var="output">
										<form:option value="${output}"><spring:message code="main.select.outputType.${output}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="outputType">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr id="targetRow">
							<td style="width: 180px">
								<form:label path="targetType"><spring:message code="main.label.target" />
									<a class="tooltip" href="#"> ?<span class="classic"><spring:message code="main.label.target.tooltip" /></span></a>
								</form:label>
							</td>
							<td>
								<form:select id="targetType" path="targetType" >
									<c:forEach items="<%= TargetType.values() %>" var="target">
										<form:option value="${target}"><spring:message code="main.select.targetType.${target}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="targetType">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						</table>
					</div>
				</div>

				<div class="form_block form_block_wide" id="uvTableParameters">
					<div class="cluster">
						<h4><span><spring:message code="main.label.cluster.uv" /></span></h4>
						
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td style="width: 180px">
								<form:label path="uvType"><spring:message code="main.label.uv" />
									<a class="tooltip" href="#"> ?<span class="classic"><spring:message code="main.label.uv.tooltip" /></span></a>
								</form:label>
							</td>
							<td>
								<form:select id="uvType" path="uvType" >
									<c:forEach items="<%= UvType.values() %>" var="uv">
										<form:option value="${uv}"><spring:message code="main.select.uvType.${uv}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="uvType">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						</table>
					</div>
				</div>

				<div class="form_block form_block_wide" id="chlorineModelParameters">
					<div class="cluster">
						<h4><span><spring:message code="main.label.cluster.modelData" /></span></h4>
						
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td style="width: 180px">
								<form:label path="chlorinationType"><spring:message code="main.label.chlorinationType" />
									<a class="tooltip" href="#"> ?<span class="classic"><spring:message code="main.label.chlorinationType.tooltip" /></span></a>
								</form:label>
							</td>
							<td>
								<form:select id="chlorinationType" path="chlorinationType" >
									<c:forEach items="<%= ChlorinationType.values() %>" var="chlorination">
										<form:option value="${chlorination}"><spring:message code="main.select.chlorinationType.${chlorination}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="chlorinationType">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr>
							<td>
								<form:label path="showInactivation"><spring:message code="main.label.inactivationCapacity" /></form:label>
							</td>
							<td>
								<form:select id="showInactivation" path="showInactivation" >
									<c:forEach items="<%= YesNoType.values() %>" var="yesNo">
										<form:option value="${yesNo}"><spring:message code="main.select.yesNoType.${yesNo}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="showInactivation">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr>
							<td>
								<form:label path="showCTRequirements"><spring:message code="main.label.ctRequirementTable" />
									<a class="tooltip" href="#"> ?<span class="classic"><spring:message code="main.label.ctRequirementTable.tooltip" /></span></a>
								</form:label>
							</td>
							<td>
								<form:select id="showCTRequirements" path="showCTRequirements" >
									<c:forEach items="<%= YesNoType.values() %>" var="yesNo">
										<form:option value="${yesNo}"><spring:message code="main.select.yesNoType.${yesNo}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="showCTRequirements">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr id="hrtRow">
							<td>
								<form:label path="hrt"><spring:message code="main.label.hrt" />
									<a class="tooltip" href="#"> ?<span class="classic"><spring:message code="main.label.hrt.tooltip" /></span></a>
								</form:label>
							</td>
							<td>
								<div class="input_bg_small">
									<form:input id="hrt" path="hrt" type="text" />
								</div>
								<label style="float: left">&nbsp;(min)</label>
							</td>
							<form:errors path="hrt">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr id="residualCRow">
							<td>
								<form:label path="residualC"><spring:message code="main.label.residualC" />
									<a class="tooltip" href="#"> ?<span class="classic"><spring:message code="main.label.residualC.tooltip" /></span></a>
								</form:label>
							</td>
							<td>
								<div class="input_bg_small">
									<form:input id="residualC" path="residualC" type="text" />
								</div>
								<label style="float: left">&nbsp;(mg/l)</label>
							</td>
							<form:errors path="residualC">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr id="cstrRow">
							<td>
								<form:label path="cstr"><spring:message code="main.label.cstr" /></form:label>
							</td>
							<td>
								<div class="input_bg_small">
									<form:input id="cstr" path="cstr" type="text" />
								</div>
							</td>
							<form:errors path="cstr">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						</table>
					</div>
				</div>


				<div class="form_block form_block_wide" id="ssfModelParameters">
					<div class="cluster">
						<h4><span><spring:message code="main.label.cluster.modelData" /></span></h4>
						
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td style="width: 180px">
								<form:label path="locationType"><spring:message code="main.label.location" /></form:label>
							</td>
							<td>
								<form:select id="locationType" path="locationType" >
									<c:forEach items="<%= LocationType.values() %>" var="location">
										<form:option value="${location}"><spring:message code="main.select.locationType.${location}" /></form:option>
									</c:forEach>
								</form:select>
							</td>
							<form:errors path="locationType">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr>
							<td>
								<form:label path="schmutzdeckeAge"><spring:message code="main.label.schmutzdeckeAge" /></form:label>
							</td>
							<td>
								<div class="input_bg_small">
									<form:input path="schmutzdeckeAge" type="text" />
								</div>
								<label style="float: left">&nbsp;a (d)</label>
							</td>
							<form:errors path="schmutzdeckeAge">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						<tr>
							<td>
								<form:label path="temperature"><spring:message code="main.label.temperature" /></form:label>
							</td>
							<td>
								<div class="input_bg_small">
									<form:input path="temperature" type="text" />
								</div>
								<label style="float: left">&nbsp;T oC</label>
							</td>
							<form:errors path="temperature">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						</table>
					</div>
				</div>

				<div></div>

				<form:errors path="*">
					<spring:bind path="*">
						<div class="warning_block" id="errors">
							<strong>Oops, something<br />went wrong!
							</strong>
							<div>
								<p>Regretfully the form could not be processed. Please correct the following to continue:</p>
								<ul>
									<c:forEach items="${status.errorMessages}" var="error">
									<li>&bull; ${error}</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</spring:bind>
				</form:errors>
				
				<div class="form_block form_block_wide" id="formBlock">
					<div class="next">
						<a href="#" class="btn" id="searchButton">
							<span><img src="img/icon_next.gif" alt="" /><spring:message code="main.button.search" /></span>
						</a>
					</div>
				</div>				
				
			</form:form>	
		</div> <!-- content holder end -->
	</div> <!-- main end -->
</body>
</html>