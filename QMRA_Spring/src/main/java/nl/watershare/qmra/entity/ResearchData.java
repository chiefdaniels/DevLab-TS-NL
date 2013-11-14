package nl.watershare.qmra.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import nl.watershare.qmra.form.DisinfectionType;
import nl.watershare.qmra.form.FiltrationType;
import nl.watershare.qmra.form.OrganismType;
import nl.watershare.qmra.form.ProcessType;
import nl.watershare.qmra.form.PublicationType;
import nl.watershare.qmra.form.UvType;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Entity
@Table(name="qmra_research_data")
public class ResearchData implements Serializable {
	private static final long serialVersionUID = -7827289980509006493L;
	
	@Id
	@GeneratedValue
	@Column(name="researchId")
	private Integer researchId;
	
	@Column(name="year")
	private Integer year;
	
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
	
	@Column(name="publicationType")
	private String publicationType;
	@Column(name="publicationDescription")
	private String publicationDescription;
	@Column(name="publicationAuthor")
	private String publicationAuthor;
	@Column(name="publicationYear")
	private Integer publicationYear;
	
	@Column(name="avg")
	private Double avg;
	@Column(name="avg_stdDev")
	private Double avg_stdDev;
	@Column(name="sampleCount")
	private Integer sampleCount;

	@Column(name="virus_studyCount")
	private Integer virus_studyCount;
	@Column(name="virus_sampleCount")
	private Integer virus_sampleCount;
	@Column(name="virus_uvType")
	private String virus_uvType;
	@Column(name="virus_uvFluence")
	private Double virus_uvFluence;
	@Column(name="virus_inctMax")
	private Double virus_inctMax;
	@Column(name="virus_kValue")
	private Double virus_kValue;
	@Column(name="virus_cl95")
	private Double virus_cl95;
	@Column(name="virus_r2")
	private Double virus_r2;
	
	public Integer getResearchId() {
		return researchId;
	}
	public void setResearchId(Integer researchId) {
		this.researchId = researchId;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public OrganismType getOrganismType() {
		return OrganismType.valueOf(this.organismType);
	}
	public void setOrganismType(OrganismType organismType) {
		this.organismType = organismType.toString();
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
	public ProcessType getProcessType() {
		return ProcessType.valueOf(processType);
	}
	public void setProcessType(ProcessType processType) {
		this.processType = processType.toString();
	}
	public FiltrationType getFiltrationType() {
		return FiltrationType.valueOf(filtrationType);
	}
	public void setFiltrationType(FiltrationType filtrationType) {
		this.filtrationType = filtrationType.toString();
	}
	public DisinfectionType getDisinfectionType() {
		return DisinfectionType.valueOf(disinfectionType);
	}
	public void setDisinfectionType(DisinfectionType disinfectionType) {
		this.disinfectionType = disinfectionType.toString();
	}
	public PublicationType getPublicationType() {
		return PublicationType.valueOf(publicationType);
	}
	public void setPublicationType(PublicationType publicationType) {
		this.publicationType = publicationType.toString();
	}
	public String getPublicationDescription() {
		return publicationDescription;
	}
	public void setPublicationDescription(String publicationDescription) {
		this.publicationDescription = publicationDescription;
	}
	public String getPublicationAuthor() {
		return publicationAuthor;
	}
	public void setPublicationAuthor(String publicationAuthor) {
		this.publicationAuthor = publicationAuthor;
	}
	public Integer getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	public Double getAvg_stdDev() {
		return avg_stdDev;
	}
	public void setAvg_stdDev(Double avg_stdDev) {
		this.avg_stdDev = avg_stdDev;
	}
	public Integer getSampleCount() {
		return sampleCount;
	}
	public void setSampleCount(Integer sampleCount) {
		this.sampleCount = sampleCount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getVirus_studyCount() {
		return virus_studyCount;
	}
	public void setVirus_studyCount(Integer virus_studyCount) {
		this.virus_studyCount = virus_studyCount;
	}
	public Integer getVirus_sampleCount() {
		return virus_sampleCount;
	}
	public void setVirus_sampleCount(Integer virus_sampleCount) {
		this.virus_sampleCount = virus_sampleCount;
	}
	public UvType getVirus_uvType() {
		return UvType.valueOf(virus_uvType);
	}
	public void setVirus_uvType(UvType uvType) {
		this.virus_uvType = uvType.toString();
	}
	public Double getVirus_uvFluence() {
		return virus_uvFluence;
	}
	public void setVirus_uvFluence(Double virus_uvFluence) {
		this.virus_uvFluence = virus_uvFluence;
	}
	public Double getVirus_inctMax() {
		return virus_inctMax;
	}
	public void setVirus_inctMax(Double virus_inctMax) {
		this.virus_inctMax = virus_inctMax;
	}
	public Double getVirus_kValue() {
		return virus_kValue;
	}
	public void setVirus_kValue(Double virus_kValue) {
		this.virus_kValue = virus_kValue;
	}
	public Double getVirus_cl95() {
		return virus_cl95;
	}
	public void setVirus_cl95(Double virus_cl95) {
		this.virus_cl95 = virus_cl95;
	}
	public Double getVirus_r2() {
		return virus_r2;
	}
	public void setVirus_r2(Double virus_r2) {
		this.virus_r2 = virus_r2;
	}
}
