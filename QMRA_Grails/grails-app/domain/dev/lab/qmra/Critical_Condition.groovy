package dev.lab.qmra

class Critical_Condition {
    Integer conditionId
	String conditionType
	String organismType
	String organism
	Integer organismTarget
	String processType
	String filtrationType
	String desinfectionType
	String subject
	String effect
	String referenceInfo
	String list
	
	String testveldMK1
	String testveldTJ1
	
    static constraints = {
		conditionId(nullable:false,blank:false)
		conditionType()
		organismType()
		organism()
		organismTarget()
		processType()
		filtrationType()
		desinfectionType()
		subject()
		effect()
		referenceInfo()
		list()
		
		testveldMK1()
		testveldTJ1()
    }
	public String condition() {
		return "$conditionType [organism: ${organism}, organisnTarget: $organisnTarget]"
    }
}
