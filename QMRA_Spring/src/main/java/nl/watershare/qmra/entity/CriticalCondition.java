package nl.watershare.qmra.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import nl.watershare.qmra.form.types.CriticalConditionType;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Entity
@Table(name="QMRA_CRITICAL_CONDITION")
public class CriticalCondition implements Serializable {
	private static final long serialVersionUID = -7827289980509006493L;
	
	@Id
	@GeneratedValue
	@Column(name="CONDITIONID")
	private Integer conditionId;

	@Column(name="CONDITIONTYPE")
	private String conditionType;
	@Column(name="ORGANISMTYPE")
	private String organismType;
	@Column(name="ORGANISM")
	private String organism;
	@Column(name="ORGANISMTARGET")
	private Boolean organismTarget;
	@Column(name="PROCESSTYPE")
	private String processType;
	@Column(name="FILTRATIONTYPE")
	private String filtrationType;
	@Column(name="DISINFECTIONTYPE")
	private String disinfectionType;
	
	@Column(name="SUBJECT")
	private String subject;
	@Column(name="EFFECT")
	private String effect;
	@Column(name="REFERENCEINFO")
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
