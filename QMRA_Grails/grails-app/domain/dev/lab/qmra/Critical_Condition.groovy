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
	String testveldMK2
	String testveldMK4
	String testveldTJ1
	String testveldTJ2
	String testveldTJ6
	
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
		
		testveldMK1(nullable:true,blank:true)
		testveldMK2(nullable:true,blank:true)
		testveldMK4(nullable:true,blank:true)
		testveldTJ1(nullable:true,blank:true)
		testveldTJ2(nullable:true,blank:true)
		testveldTJ6(nullable:true,blank:true)
		
    }
	public String condition() {
		return "$conditionType [organism: ${organism}, organisnTarget: $organisnTarget]"
    }
}
