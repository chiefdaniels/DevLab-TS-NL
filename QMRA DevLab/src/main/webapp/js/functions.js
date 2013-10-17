$(document).ready(function() {

	$('#formBlock, #formBlock2, #uvTableParameters, #ssfModelParameters, #chlorineModelParameters').fancyfields({
		customScrollBar: true, cleanOnFocus: false
	});
	
	$("#organismType").fancyfields("bind","onSelectChange", function (input,text,val){
		refreshForm();
	});
	$("#processType").fancyfields("bind","onSelectChange", function (input,text,val){
		refreshForm();
	});
	$("#disinfectionType").fancyfields("bind","onSelectChange", function (input,text,val){
		refreshForm();
	});
	$("#filtrationType").fancyfields("bind","onSelectChange", function (input,text,val){
		refreshForm();
	});
	$("#chlorinationType").fancyfields("bind","onSelectChange", function (input,text,val){
		refreshForm();
	});
	$("#outputType").fancyfields("bind","onSelectChange", function (input,text,val){
		refreshForm();
	});
	$("#showInactivation").fancyfields("bind","onSelectChange", function (input,text,val){
		refreshForm();
	});

	function refreshForm() {
		
		var organismType = $("#organismType").val();
		var processType = $("#processType").val();
		var disinfectionType = $("#disinfectionType").val();
		var filtrationType = $("#filtrationType").val();
		var outputType = $("#outputType").val();
		var chlorinationType = $("#chlorinationType").val();
		var inactivationYesNoType = $("#showInactivation").val();

		$("#chlorineModelParameters").hide();
		$("#ssfModelParameters").hide();
		$("#uvTableParameters").hide();

		$("#filtrationRow").hide();
		$("#filtrationType").fancyfields("disable");
		$("#disinfectionRow").hide();
		$("#disinfectionType").fancyfields("disable");
		
		if ((organismType == 'CRYPTOSPORIDIUM' && processType == 'CONVENTIONAL') ||
			(organismType == 'CRYPTOSPORIDIUM' && processType == 'FILTRATION' && filtrationType == 'GAC') ||
			(organismType == 'GIARDIA' && processType == 'DISINFECTION' && disinfectionType == 'CHLORINE') ||
			(organismType == 'VIRUS' && processType == 'DISINFECTION' && disinfectionType == 'UV') ||
			(organismType == 'VIRUS' && processType == 'DISINFECTION' && disinfectionType == 'CHLORINE')
			) {
			$("#outputRow").hide();
			$("#outputType").fancyfields("disable");
		} else {
			$("#outputType").fancyfields("enable");
			$("#outputRow").show();
		}
		
		if ((organismType == 'VIRUS' && processType == 'FILTRATION' && filtrationType == 'SSF' && outputType == 'MODEL') || 
			(organismType == 'BACTERIA' && processType == 'FILTRATION' && filtrationType == 'SSF' && outputType == 'MODEL') || 
			(organismType == 'GIARDIA' && processType == 'DISINFECTION' && disinfectionType == 'CHLORINE') ||
			(organismType == 'VIRUS' && processType == 'DISINFECTION' && disinfectionType == 'CHLORINE')
			) {
			$("#targetRow").hide();
			$("#targetType").fancyfields("disable");
		} else {
			$("#targetType").fancyfields("enable");
			$("#targetRow").show();
		}
		
		$("#formBlock2").show();
		if ($("#targetRow").is(':hidden') && $("#outputRow").is(":hidden")) {
			$("#formBlock2").hide();
		}
		
		if (processType == 'DISINFECTION') {
		
			$("#disinfectionType").fancyfields("enable");
			$("#disinfectionRow").show();
			
			if (disinfectionType == 'UV') {
				
				$("#uvTableParameters").show();
				
			} else if (disinfectionType == 'CHLORINE') {
				
				$("#chlorineModelParameters").show();

				if (inactivationYesNoType == 'YES') {
					$("#residualCRow").show();
					$("#hrtRow").show();
				} else {
					$("#hrtRow").hide();
					$("#hrt").val("0.0");
					$("#residualCRow").hide();
					$("#residualC").val("0.0");
				}
				
				if (chlorinationType == 'CSTR') {
					$("#cstrRow").show();
				} else {
					$("#cstrRow").hide();					
					$("#cstr").val("0");
				}
			}
			
		} else if (processType == 'FILTRATION') {

			$("#filtrationType").fancyfields("enable");
			$("#filtrationRow").show();

			if (filtrationType == 'SSF') {
				$("#ssfModelParameters").show();
			}
		} else {
			$("#hrt").val("0.0");
			$("#residualC").val("0.0");
			$("#cstr").val("0");			
		}
	}
	
	refreshForm();

	$("#searchButton").click(function() {
		$("#mainForm").submit();
	});
	
	
});
