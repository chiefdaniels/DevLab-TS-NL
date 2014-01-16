package dev.lab.tutorial

class Auteur {

	String achternaam
	String voornaam
	
    static constraints = {
        achternaam(nullable:false,blank:false)
        voornaam()
    }
	
	public String toString(){
		return "${achternaam} (${voornaam})"
	}
}
