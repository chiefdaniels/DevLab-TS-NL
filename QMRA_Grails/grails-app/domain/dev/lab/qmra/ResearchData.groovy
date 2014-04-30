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
		orgainsm(nullable:true,blank:true) /*changed*/
		organismTarget(blank:false)
		processType(nullable:false,blank:false)
		filtrationType(nullable:true,blank:true) /*changed*/
		disinfectionType(nullable:true,blank:true) /*changed*/
		publicationType(nullable:false,blank:false)
		publicationDescription(nullable:false,blank:false)
		publicationAuthor(nullable:false,blank:false)
		publicationYear(nullable:false,blank:false)
		
		avg_reduction(nullable:true,blank:true) /*changed*/
		avg_stddev(nullable:true,blank:true) /*changed*/
		sampleCount(nullable:true,blank:true) /*changed*/
		virus_studyCount(nullable:true,blank:true) /*changed*/
		virus_sampleCount(nullable:true,blank:true) /*changed*/
		virus_uvType(nullable:true,blank:true) /*changed*/
		virus_uvFluence(nullable:true,blank:true) /*changed*/
		virus_inctmax(nullable:true,blank:true) /*changed*/
		virus_kValue(nullable:true,blank:true) /*changed*/
		virus_cl95(nullable:true,blank:true) /*changed*/
		virus_r2(nullable:true,blank:true) /*changed*/
	}

}
