package dev.lab.qmra

class ResearchData {

	long researchId
	long year
	String organismType
	String orgainsm
	long organismTarget
	String processType
	String filtrationType
	String disinfectionType
	String publicationType
	String publicationDescription
	String publicationAuthor
	String publicationYear
	double avg_reduction
	double avg_stddev
	long sampleCount
	long virus_studyCount
	long virus_sampleCount
	String virus_uvType
	long virus_uvFluence
	double virus_inctmax
	double virus_kValue
	double virus_cl95
	double virus_r2
	
	static constraints = {
		researchId(blank:false)
		year(blank:false)
		organismType(nullable:false,blank:false)
		orgainsm()
		organismTarget(blank:false)
		processType(nullable:false,blank:false)
		filtrationType()
		disinfectionType()
		publicationType(nullable:false,blank:false)
		publicationDescription(nullable:false,blank:false)
		publicationAuthor(nullable:false,blank:false)
		publicationYear(nullable:false,blank:false)
		
		avg_reduction()
		avg_stddev()
		sampleCount()
		virus_studyCount()
		virus_sampleCount()
		virus_uvType()
		virus_uvFluence()
		virus_inctmax()
		virus_kValue()
		virus_cl95()
		virus_r2()
	}

}
