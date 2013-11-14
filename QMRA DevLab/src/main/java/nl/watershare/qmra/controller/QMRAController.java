package nl.watershare.qmra.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import nl.watershare.entity.Country;
import nl.watershare.qmra.entity.CriticalCondition;
import nl.watershare.qmra.entity.ResearchData;
import nl.watershare.qmra.form.ChlorinationType;
import nl.watershare.qmra.form.ChlorineDisinfectionResult;
import nl.watershare.qmra.form.CriticalConditionResult;
import nl.watershare.qmra.form.CriticalConditionResultCondition;
import nl.watershare.qmra.form.DisinfectionType;
import nl.watershare.qmra.form.FiltrationType;
import nl.watershare.qmra.form.GraphResult;
import nl.watershare.qmra.form.MainForm;
import nl.watershare.qmra.form.OrganismType;
import nl.watershare.qmra.form.OutputType;
import nl.watershare.qmra.form.PercentileException;
import nl.watershare.qmra.form.ProcessType;
import nl.watershare.qmra.form.ResearchDataResult;
import nl.watershare.qmra.form.SlowSandFiltrationResult;
import nl.watershare.qmra.form.YesNoType;
import nl.watershare.qmra.service.ChlorineConstantService;
import nl.watershare.qmra.service.ChlorineDisinfectionModel;
import nl.watershare.qmra.service.CriticalConditionService;
import nl.watershare.qmra.service.ResearchDataService;
import nl.watershare.qmra.service.SelectionCriteria;
import nl.watershare.qmra.service.SlowSandFiltrationModel;
import nl.watershare.service.CountryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
/**
 * @author Marco Kortooms - Atos
 *
 */
public class QMRAController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(QMRAController.class);

	@Autowired
	private CountryService countryService;
    @Autowired
    private ResearchDataService researchDataService;
    @Autowired
    private CriticalConditionService criticalConditionService;
    @Autowired
    private ChlorineConstantService chlorineConstantService;
	
	/**
	 * Prepare QMRA Application for initial use
	 * 
	 * @param statisticsForm
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("/start")
	public String start(
			@RequestParam(value = "external-session-id", required=false) String externalSessionId,
			@RequestParam(value = "user-id", required=false) String user_Id,
			@RequestParam(value = "country-id", required=false) String country_Id,
			Map<String, Object> model,
			HttpSession session) {
	
		// Store country in session
		Country country = (Country) session.getAttribute("country");
		if (country == null || !country.getCountryCode().equals(country_Id)) {
			String countryCode = country_Id.trim().toUpperCase();
			if (countryCode.equals("XX") && user_Id.equals("xxxxxxxx") &&
					externalSessionId.equals("xxxxxxxxxxxxxxxxxxxxxxxx")) {
				country = countryService.getCountryByCode("nl");
			} else {
				country = countryService.getCountryByCode(countryCode);
			}
			session.setAttribute("country", country);
		}
		
		// Store userId in session
		String userId = (String) session.getAttribute("userId");
		if (userId == null || !userId.equals(user_Id)) {
			session.setAttribute("userId", user_Id);
		}

		// Check if country and userId are in session else throw error
		country = (Country) session.getAttribute("country");
		userId = (String) session.getAttribute("userId");
		if (country == null || userId == null) {
			return "error";
		}
		
		return "redirect:/main.do";
	}
	
	/**
	 * Show main form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String main(
		@RequestParam(value = "organismType", required=false) String organismStr,
		@RequestParam(value = "processType", required=false) String processStr,
		@RequestParam(value = "filtrationType", required=false) String filtrationStr,
		@RequestParam(value = "disinfectionType", required=false) String disinfectionStr,
		@RequestParam(value = "outputType", required=false) String outputTypeStr,
		Map<String, Object> model,
		HttpSession session) {

		MainForm mainForm = (MainForm)session.getAttribute("mainForm");
		if (mainForm == null) {
			mainForm = new MainForm();
			mainForm.setOrganismType(OrganismType.CRYPTOSPORIDIUM);
			mainForm.setProcessType(ProcessType.CONVENTIONAL);
			mainForm.setOutputType(OutputType.TABLE);
		}

		try {
			OrganismType organismType = OrganismType.valueOf(organismStr);
			mainForm.setOrganismType(organismType);
		} catch (Exception e) {
		}
		try {
			ProcessType processType = ProcessType.valueOf(processStr);
			mainForm.setProcessType(processType);
		} catch (Exception e) {
		}
		try {
			FiltrationType filtrationType = FiltrationType.valueOf(filtrationStr);
			mainForm.setFiltrationType(filtrationType);
		} catch (Exception e) {
		}
		try {
			DisinfectionType disinfectionType = DisinfectionType.valueOf(disinfectionStr);
			mainForm.setDisinfectionType(disinfectionType);
		} catch (Exception e) {
		}
		try {
			OutputType outputType = OutputType.valueOf(outputTypeStr);
			mainForm.setOutputType(outputType);
		} catch (Exception e) {
		}
		
//		mainForm = new MainForm();
//
//		mainForm.setOrganismType(OrganismType.CRYPTOSPORIDIUM);
//		mainForm.setProcessType(ProcessType.CONVENTIONAL);
//		mainForm.setTargetType(TargetType.BOTH);
//		mainForm.setOutputType(OutputType.TABLE);

		// *** Cryptosperium & Conventions processing ***
//		mainForm.setOrganismType(OrganismType.CRYPTOSPORIDIUM);
//		mainForm.setProcessType(ProcessType.CONVENTIONAL);
//		mainForm.setTargetType(TargetType.BOTH);
	
		// *** Virus & UV disinfection ***
//		mainForm.setOrganismType(OrganismType.VIRUS);
//		mainForm.setProcessType(ProcessType.DISINFECTION);
//		mainForm.setDisinfectionType(DisinfectionType.UV);
//		mainForm.setOutputType(OutputType.MODEL);
//		mainForm.setUvType(UvType.BOTH);
	
		// *** Cryptosperidium & GAC Filtration ***
//		mainForm.setOrganismType(OrganismType.CRYPTOSPORIDIUM);
//		mainForm.setProcessType(ProcessType.FILTRATION);
//		mainForm.setFiltrationType(FiltrationType.GAC);
//		mainForm.setTargetType(TargetType.BOTH);

		// *** Virus & SSF Filtration ***
//		mainForm.setOrganismType(OrganismType.VIRUS);
//		mainForm.setProcessType(ProcessType.FILTRATION);
//		mainForm.setFiltrationType(FiltrationType.SSF);
//		mainForm.setTargetType(TargetType.BOTH);
	
		// *** Bateria & SSF Filtration ***
//		mainForm.setOrganismType(OrganismType.BACTERIA);
//		mainForm.setProcessType(ProcessType.FILTRATION);
//		mainForm.setFiltrationType(FiltrationType.SSF);
//		mainForm.setOutputType(OutputType.MODEL);
//		mainForm.setTargetType(TargetType.BOTH);
//		
//		mainForm.setSchmutzdeckeAge(217);
//		mainForm.setTemperature(19.5);

		// *** Virus & SSF Filtration ***
//		mainForm.setOrganismType(OrganismType.VIRUS);
//		mainForm.setProcessType(ProcessType.FILTRATION);
//		mainForm.setFiltrationType(FiltrationType.SSF);
//		mainForm.setOutputType(OutputType.MODEL);
//		mainForm.setTargetType(TargetType.BOTH);
//		
//		mainForm.setSchmutzdeckeAge(217);
//		mainForm.setTemperature(19.5);
			
		// *** Giardia & Chlorine disinfection ***
//		mainForm.setOrganismType(OrganismType.GIARDIA);
//		mainForm.setProcessType(ProcessType.DISINFECTION);
//		mainForm.setDisinfectionType(DisinfectionType.CHLORINE);
//		mainForm.setOutputType(OutputType.MODEL);
//		mainForm.setTargetType(TargetType.BOTH);
//			
//		mainForm.setChlorinationType(ChlorinationType.CSTR);
//		mainForm.setHrt(5);
//		mainForm.setResidualC(1);
//		mainForm.setCstr(3);

		// *** Virus & Chlorine disinfection ***
//		mainForm.setOrganismType(OrganismType.VIRUS);
//		mainForm.setProcessType(ProcessType.DISINFECTION);
//		mainForm.setDisinfectionType(DisinfectionType.CHLORINE);
//		mainForm.setOutputType(OutputType.MODEL);
//		mainForm.setTargetType(TargetType.BOTH);
//		
//		mainForm.setChlorinationType(ChlorinationType.PLUGFLOW);
//		mainForm.setHrt(5);
//		mainForm.setResidualC(1);
//		mainForm.setCstr(3);
				
		model.put("mainForm", mainForm);
		
		return "main";
	}

	/**
	 * Submit the step1AForm page. Processing user input.
	 * 
	 * @param step1Form
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/submitMainForm", method = RequestMethod.POST)
	public String submitStep1AForm_next(
			@ModelAttribute("mainForm") @Validated MainForm mainForm,
			BindingResult result,
			Map<String, Object> model,
			HttpSession session) {
		
		mainForm.validate(result);
		if (result.hasErrors()) {
			return "main";
		}
		session.setAttribute("mainForm", mainForm);

		// *** Set selection criteria ***
		SelectionCriteria selectionCriteria = new SelectionCriteria();
		selectionCriteria.setOrganismType(mainForm.getOrganismType());
		selectionCriteria.setProcessType(mainForm.getProcessType());
		selectionCriteria.setFiltrationType(mainForm.getFiltrationType());
		selectionCriteria.setDisinfectionType(mainForm.getDisinfectionType());
		selectionCriteria.setTargetType(mainForm.getTargetType());
		selectionCriteria.setUvType(mainForm.getUvType());
		model.put("output", mainForm.getOutputType());
		
		// *** Create critical condition list ***
		List<CriticalCondition> criticalConditionList =
				criticalConditionService.getCriticalConditions(selectionCriteria);
		CriticalConditionResult criticalConditionResult =
				new CriticalConditionResult(selectionCriteria, criticalConditionList);
		List<CriticalConditionResultCondition> criticalConditionResultList =
				criticalConditionResult.getConditionTypeList();
		
		if (!criticalConditionResultList.isEmpty()) {
			model.put("criticalConditionResultList", criticalConditionResultList);
		}

		OutputType outputType = null;
		if ((mainForm.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
				mainForm.getProcessType() == ProcessType.CONVENTIONAL) ||
				
			(mainForm.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
				mainForm.getProcessType() == ProcessType.FILTRATION &&
				mainForm.getFiltrationType() == FiltrationType.GAC)	
			) {
			
			outputType = OutputType.TABLE;
			
		} else if ((mainForm.getOrganismType() == OrganismType.GIARDIA &&
				mainForm.getProcessType() == ProcessType.DISINFECTION &&
				mainForm.getDisinfectionType() == DisinfectionType.CHLORINE) ||
				
			(mainForm.getOrganismType() == OrganismType.VIRUS &&
				mainForm.getProcessType() == ProcessType.DISINFECTION &&
				mainForm.getDisinfectionType() == DisinfectionType.UV) ||
			
			(mainForm.getOrganismType() == OrganismType.VIRUS &&
				mainForm.getProcessType() == ProcessType.DISINFECTION &&
				mainForm.getDisinfectionType() == DisinfectionType.CHLORINE)
				
			) {

			outputType = OutputType.MODEL;
			
		} else {
			outputType = mainForm.getOutputType();
		}
		
		// *** Output using table data ***
		if (outputType == OutputType.TABLE) {
			
			List<ResearchData> researchDataList = researchDataService.getResearchData(selectionCriteria);
			
			if (!researchDataList.isEmpty()) {
				ResearchDataResult rdr = new ResearchDataResult(selectionCriteria, researchDataList);
				model.put("researchDataResult", rdr);
				
				try {
					logger.info("P10: " + new Double(rdr.getPercentileYear(10)).toString());
				} catch (PercentileException pe) {
					logger.info("P10: n/a");
				}
				try {
					logger.info("P50: " + new Double(rdr.getPercentileYear(50)).toString());
				} catch (PercentileException pe) {
					logger.info("P50: n/a");
				}
				try {
					logger.info("P90: " + new Double(rdr.getPercentileYear(90)).toString());
				} catch (PercentileException pe) {
					logger.info("P90: n/a");
				}
				
				logger.info("Count studies: " + new Double(rdr.getStudyCount()).toString());
				logger.info("Count data: "+ new Double(rdr.getStudySampleCount()).toString());
				
				logger.info("DEC avg: " + new Double(rdr.getAverageElimination()).toString());
				logger.info("Std dev: " + new Double(rdr.getStandardDeviationElimination()).toString());
				logger.info("Minimum: " + new Double(rdr.getMinimumEliminitation()).toString());
				logger.info("Maximum: " + new Double(rdr.getMaximumEliminitation()).toString());
				
				try {
					logger.info("Elimination P50: " + new Double(rdr.getPercentileElimination(50)).toString());
				} catch (PercentileException pe) {
					logger.info("Elimination P50: n/a");
				}
				try {
					logger.info("Elimination P10: " + new Double(rdr.getPercentileElimination(10)).toString());
				} catch (PercentileException pe) {
					logger.info("Elimination P10: n/a");
				}
				try {
					logger.info("Elimination P25: " + new Double(rdr.getPercentileElimination(25)).toString());
				} catch (PercentileException pe) {
					logger.info("Elimination P25: n/a");
				}
				
				GraphResult graphResult = new GraphResult(selectionCriteria, researchDataList);
				model.put("graphList", graphResult.getGraphList());
				
				if (selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
					selectionCriteria.getProcessType() == ProcessType.CONVENTIONAL) {		
					
					return "result1";
					
				} else if (selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
					selectionCriteria.getFiltrationType() == FiltrationType.SSF)	{
					
					return "result1";
								
				} else if (selectionCriteria.getOrganismType() == OrganismType.CRYPTOSPORIDIUM &&
					selectionCriteria.getFiltrationType() == FiltrationType.GAC) {
	
					return "result3";

				} else if (selectionCriteria.getOrganismType() == OrganismType.BACTERIA &&
					selectionCriteria.getFiltrationType() == FiltrationType.SSF)	{
		
					return "result3";
				}
			}
		}	
		
		// *** Output using Model data ***
		if (outputType == OutputType.MODEL) {
			
			if (selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
				selectionCriteria.getDisinfectionType() == DisinfectionType.UV) {
			
				List<ResearchData> researchDataList = researchDataService.getResearchData(selectionCriteria);
				if (!researchDataList.isEmpty()) {
					ResearchDataResult rdr = new ResearchDataResult(selectionCriteria, researchDataList);
					model.put("researchDataResult", rdr);
					
					GraphResult graphResult = new GraphResult(selectionCriteria, researchDataList);
					model.put("graphList", graphResult.getGraphList());
				}
				
				return "result2";

			} else if (selectionCriteria.getFiltrationType() == FiltrationType.SSF) {
				SlowSandFiltrationModel ssfModel = new SlowSandFiltrationModel(
						mainForm.getOrganismType(),
						mainForm.getLocationType(),
						mainForm.getSchmutzdeckeAge(),
						mainForm.getTemperature()
				);
				
				SlowSandFiltrationResult ssfResult = new SlowSandFiltrationResult(selectionCriteria, ssfModel);
				
				model.put("ssfResult", ssfResult);
				
				return "result4";
				
			} else if ((selectionCriteria.getOrganismType() == OrganismType.GIARDIA &&
				selectionCriteria.getDisinfectionType() == DisinfectionType.CHLORINE) ||
				(selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
				selectionCriteria.getDisinfectionType() == DisinfectionType.CHLORINE)){
				
				
				ChlorineDisinfectionModel cdModel = new ChlorineDisinfectionModel(
					chlorineConstantService,
					mainForm.getOrganismType(),
					mainForm.getChlorinationType());
				
				if (mainForm.getShowInactivation() == YesNoType.YES) {
					cdModel.setHrt(mainForm.getHrt());
					cdModel.setResidualC(mainForm.getResidualC());
					cdModel.setCstr(mainForm.getCstr());
				}
				
				if (mainForm.getShowCTRequirements() == YesNoType.YES) {
					if (mainForm.getChlorinationType() == ChlorinationType.CSTR) {
						cdModel.setCstr(mainForm.getCstr());
					}
				}
				
				ChlorineDisinfectionResult cdResult = new ChlorineDisinfectionResult(
					selectionCriteria,
					cdModel,
					(mainForm.getShowInactivation() == YesNoType.YES)?true:false,
					(mainForm.getShowCTRequirements() == YesNoType.YES)?true:false
				);
				
				model.put("cdResult", cdResult);
												
				List<Double> temperatureList = new ArrayList<Double>();
				temperatureList.add(new Double(0.5));
				temperatureList.add(new Double(5.0));
				temperatureList.add(new Double(10.0));
				temperatureList.add(new Double(15.0));
				temperatureList.add(new Double(20.0));
				model.put("temperatureList", temperatureList);
				
				List<Double> phList = new ArrayList<Double>();
				phList.add(new Double(6.5));
				phList.add(new Double(7.0));
				phList.add(new Double(7.5));
				phList.add(new Double(8.0));
				phList.add(new Double(8.5));
				model.put("phList", phList);
				
				List<Double> doseList = new ArrayList<Double>();
				doseList.add(new Double(1.0));
				doseList.add(new Double(0.6));
				doseList.add(new Double(1.2));
				doseList.add(new Double(2.0));
				model.put("doseList", doseList);
				
				if (selectionCriteria.getOrganismType() == OrganismType.GIARDIA &&
					selectionCriteria.getDisinfectionType() == DisinfectionType.CHLORINE) {

					List<Double> logList = new ArrayList<Double>();
					logList.add(3.0);
					logList.add(2.0);
					logList.add(1.0);
					model.put("logList", logList);
				
					return "result5";
					
				} else if (selectionCriteria.getOrganismType() == OrganismType.VIRUS &&
					selectionCriteria.getDisinfectionType() == DisinfectionType.CHLORINE) {

					List<Double> logList = new ArrayList<Double>();
					logList.add(4.0);
					logList.add(3.0);
					logList.add(2.0);
					model.put("logList", logList);

					return "result6";
					
				}
			}
		}
		
		model.put("selectionCriteria", selectionCriteria);
		return "resultEmpty";
	}
	
}

