package nl.watershare.qmra.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import nl.watershare.qmra.form.CriticalConditionType;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Entity
@Table(name="qmra_critical_condition")
public class CriticalCondition implements Serializable {
	private static final long serialVersionUID = -7827289980509006493L;
	
	@Id
	@GeneratedValue
	@Column(name="conditionId")
	private Integer conditionId;

	@Column(name="conditionType")
	private String conditionType;
	@Column(name="organismType")
	private String organismType;
	@Column(name="organism")
	private String organism;
	@Column(name="organismTarget")
	private Boolean organismTarget;
	@Column(name="processType")
	private String processType;
	@Column(name="filtrationType")
	private String filtrationType;
	@Column(name="disinfectionType")
	private String disinfectionType;
	
	@Column(name="subject")
	private String subject;
	@Column(name="effect")
	private String effect;
	@Column(name="references")
	private String references;
	
	public Integer getConditionId() {
		return conditionId;
	}
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
	
	public String getOrganismType() {
		return organismType;
	}
	public void setOrganismType(String organismType) {
		this.organismType = organismType;
	}
	public String getOrganism() {
		return organism;
	}
	public void setOrganism(String organism) {
		this.organism = organism;
	}
	public Boolean getOrganismTarget() {
		return organismTarget;
	}
	public void setOrganismTarget(Boolean organismTarget) {
		this.organismTarget = organismTarget;
	}
	public String getProcessType() {
		return processType;
	}
	public void setProcessType(String processType) {
		this.processType = processType;
	}
	public String getFiltrationType() {
		return filtrationType;
	}
	public void setFiltrationType(String filtrationType) {
		this.filtrationType = filtrationType;
	}
	public String getDisinfectionType() {
		return disinfectionType;
	}
	public void setDisinfectionType(String disinfectionType) {
		this.disinfectionType = disinfectionType;
	}
	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}
	public CriticalConditionType getConditionType() {
		return CriticalConditionType.valueOf(this.conditionType);		
	}
	public void setConditionType(CriticalConditionType conditionType) {
		this.conditionType = conditionType.toString();
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getReferences() {
		return references;
	}
	public void setReferences(String references) {
		this.references = references;
	}
}
