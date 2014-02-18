
<%@ page import="dev.lab.tutorial.Entry" %>
<!DOCTYPE html>
<html>
	<head>
        <meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'entry.label', default: 'Entry')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<g:javascript src="jquery.js"/>
   	 	<g:javascript src="jquery.flot.js"/>
   	 	<g:javascript src="grafiek_functions.js"/>
   	 	<g:javascript src="d3.v3.js"/>
   	 	<style>
			/* tell the SVG path to be a thin blue line without any area fill */
			path {
				stroke: steelblue;
				stroke-width: 1;
				fill: none;
			}
			
			.axis {
			  shape-rendering: crispEdges;
			}

			.x.axis line {
			  stroke: lightgrey;
			}

			.x.axis .minor {
			  stroke-opacity: .5;
			}

			.x.axis path {
			  display: none;
			}

			.y.axis line, .y.axis path {
			  fill: none;
			  stroke: #000;
			}
		</style>
	</head>
	<body>
		<a href="#list-entry" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-entry" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>					
						<td>${message(code: 'entry.dag.label', default: 'Dag')}</td>
						<td>${message(code: 'entry.aantal.label', default: 'Aantal')}</td>					
					</tr>
				</thead>
				<tbody>
				<g:each in="${entryInstanceList}" status="i" var="entryInstance">
					<g:javascript>		
						$addItem(${i},${fieldValue(bean: entryInstance, field: "dag")},${fieldValue(bean: entryInstance, field: "aantal")});
					</g:javascript>
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${entryInstance.id}">${fieldValue(bean: entryInstance, field: "dag")}</g:link></td>
						<td>${fieldValue(bean: entryInstance, field: "aantal")}</td>					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${entryInstanceTotal}" />
			</div>
		
			<!-- FLOT CHART GOES HERE -->
			<H1>FLOT grafiek</H1>
			<div id="placeholder_flot" style="width:600px;height:300px"></div>
			
			<!-- D3 CHART GOES HERE -->
			<H1>D3 grafiek</H1>
			<!--<div id="placeholder_d3" style="width:600px;height:300px">-->
			<div id="graph" class="aGraph"></div>
				<g:javascript src="d3_script.js"/>
			</div>
		</div>
	
		<g:javascript>
			$displayFlot();
		</g:javascript>
	</body>
</html>
