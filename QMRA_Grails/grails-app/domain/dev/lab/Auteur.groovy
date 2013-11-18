package dev.lab

class Auteur {

	String achternaam
	String voornaam
	
    static constraints = {
    }
	
	public String toString(){
		return "${achternaam} (${voornaam})"
	}
}
