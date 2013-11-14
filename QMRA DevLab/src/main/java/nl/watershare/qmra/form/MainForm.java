package nl.watershare.qmra.form;

import javax.validation.constraints.NotNull;

import org.springframework.validation.BindingResult;

/**
 * @author Marco Kortooms - Atos
 *
 */
public class MainForm {
	
	@NotNull
	private OrganismType organismType;
	@NotNull
	private ProcessType processType;
	private FiltrationType filtrationType;
	private DisinfectionType disinfectionType;
	private OutputType outputType;
	private TargetType targetType;
	
	// *** UV table parameters
	private UvType uvType;
	
	// *** SSF Model parameter
	private LocationType locationType;
	private int schmutzdeckeAge;
	private double temperature;
	
	// *** Chlorine Model Parameters
	private ChlorinationType ChlorinationType;
	private YesNoType showInactivation;
	private YesNoType showCTRequirements;
	private double hrt;
	private double residualC;
	
	// *** Additional CSTR Chlorine Model parameter
	private int cstr;
	
	public OrganismType getOrganismType() {
		return organismType;
	}
	public void setOrganismType(OrganismType organismType) {
		this.organismType = organismType;
	}
	public ProcessType getProcessType() {
		return processType;
	}
	public void setProcessType(ProcessType processType) {
		this.processType = processType;
	}
	public FiltrationType getFiltrationType() {
		return filtrationType;
	}
	public void setFiltrationType(FiltrationType filtrationType) {
		this.filtrationType = filtrationType;
	}
	public DisinfectionType getDisinfectionType() {
		return disinfectionType;
	}
	public void setDisinfectionType(DisinfectionType disinfectionType) {
		this.disinfectionType = disinfectionType;
	}
	public TargetType getTargetType() {
		return targetType;
	}
	public void setTargetType(TargetType targetType) {
		this.targetType = targetType;
	}
	public OutputType getOutputType() {
		return outputType;
	}
	public void setOutputType(OutputType outputType) {
		this.outputType = outputType;
	}

	// *** UV Table paramters
	public UvType getUvType() {
		return uvType;
	}
	public void setUvType(UvType uvType) {
		this.uvType = uvType;
	}	
	
	// *** SSF Model parameters
	public LocationType getLocationType() {
		return locationType;
	}
	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}
	public int getSchmutzdeckeAge() {
		return schmutzdeckeAge;
	}
	public void setSchmutzdeckeAge(int schmutzdeckeAge) {
		this.schmutzdeckeAge = schmutzdeckeAge;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}	
	
	// *** Cholorine Model parameters
	public double getHrt() {
		return hrt;
	}
	public void setHrt(double hrt) {
		this.hrt = hrt;
	}
	public double getResidualC() {
		return residualC;
	}
	public void setResidualC(double residualC) {
		this.residualC = residualC;
	}
	public ChlorinationType getChlorinationType() {
		return ChlorinationType;
	}
	public void setChlorinationType(ChlorinationType chlorinationType) {
		ChlorinationType = chlorinationType;
	}
	public int getCstr() {
		return cstr;
	}
	public void setCstr(int cstr) {
		this.cstr = cstr;
	}
	public YesNoType getShowInactivation() {
		return showInactivation;
	}
	public void setShowInactivation(YesNoType showInactivation) {
		this.showInactivation = showInactivation;
	}
	public YesNoType getShowCTRequirements() {
		return showCTRequirements;
	}
	public void setShowCTRequirements(YesNoType showCTRequirements) {
		this.showCTRequirements = showCTRequirements;
	}
	
	public BindingResult validate(BindingResult result) {
		
//		if (organismType == OrganismType.VIRUS && processType == ProcessType.FILTRATION && filtrationType == FiltrationType.SSF && outputType == OutputType.MODEL) {
//			if (schmutzdeckeAge == null || schmutzdeckeAge.equals("")) {
//				result.rejectValue("schmutzdeckeAge", "error.invalidInput");
//			}
//		}
		
		return result;
	}

}
