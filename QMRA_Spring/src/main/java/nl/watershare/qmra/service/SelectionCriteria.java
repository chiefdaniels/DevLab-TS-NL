package nl.watershare.qmra.service;

import nl.watershare.qmra.form.types.DisinfectionType;
import nl.watershare.qmra.form.types.FiltrationType;
import nl.watershare.qmra.form.types.OrganismType;
import nl.watershare.qmra.form.types.ProcessType;
import nl.watershare.qmra.form.types.TargetType;
import nl.watershare.qmra.form.types.UvType;

public class SelectionCriteria {
	
	private Integer year;
	
	private OrganismType organismType;
	private ProcessType processType;
	private FiltrationType filtrationType;
	private DisinfectionType disinfectionType;
	
	private UvType uvType;

	private TargetType targetType;
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public OrganismType getOrganismType() {
		return organismType;
	}
	public void setOrganismType(OrganismType organismType) {
		this.organismType = organismType;
	}
	public TargetType getTargetType() {
		return targetType;
	}
	public void setTargetType(TargetType targetType) {
		this.targetType = targetType;
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
	public UvType getUvType() {
		return uvType;
	}
	public void setUvType(UvType uvType) {
		this.uvType = uvType;
	}
}
